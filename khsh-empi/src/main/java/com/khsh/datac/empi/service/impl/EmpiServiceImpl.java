package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.UuidUtils;
import com.ejet.comm.utils.collect.BeanUtils;
import com.ejet.comm.utils.time.TimeUtils;
import com.ejet.core.global.CoConstant;
import com.khsh.datac.empi.comm.Constant;
import com.khsh.datac.empi.mapper.EmpiDao;
import com.khsh.datac.empi.model.PixEmpiHisRModel;
import com.khsh.datac.empi.model.PixEmpiModel;
import com.khsh.datac.empi.service.IEmpiService;
import com.khsh.datac.empi.vo.EmpiVO;
import com.khsh.datac.empi.vo.PixEmpiRegisterExtVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.khsh.datac.empi.comm.Constant.DEFAULT_PASSWORD;
import static com.khsh.datac.empi.utils.ValidateUtils.*;

@Service("empiService")
public class EmpiServiceImpl implements IEmpiService {

	private final Logger log = LoggerFactory.getLogger(EmpiServiceImpl.class);

	@Autowired
	PixEmpiServiceImpl empiService;
    @Autowired
	PixEmpiRegisterServiceImpl empiRegisterService;
    @Autowired
    PixEmpiRegisterExtServiceImpl empiRegisterExtService;

    @Autowired
    PixEmpiIdentityServiceImpl empiIdentityService;
    @Autowired
    PixEmpiIdentityContactServiceImpl empiIdentityContactService;

    @Autowired
    PixEmpiHisRServiceImpl empiHisRService;

    @Autowired
    EmpiExtServiceImpl extService;

    @Autowired
    private EmpiDao mDao;

    /**
     * 根据 患者patient_id或者inpatient_id查询患者empi信息
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO queryEmpiByPatientInfo(EmpiVO model) throws CoBusinessException {
        if(StringUtils.isBlank(model.getPatientId()) && StringUtils.isBlank(model.getInpatientId())) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "患者patient_id、inpatient_id为空!");
        }
        //查询empi信息
        EmpiVO result = extService.queryEmpiByPatient(model);
        if(result!=null && !StringUtils.isBlank(result.getEmpi())) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "患者empi未生成，先从HIS取数据生成EMPI，再调用!");
        }
//        //创建empi信息, 电子病历接口
//        if(model.getChannelId()!=null && model.getChannelId().equalsIgnoreCase(CHANNEL_EMR)) {
//            result = createEmpi(model);
//        }
        return result;
    }

    /** ============================================================================================================================== */
    /**
     * 生成EMPI
     * @param model
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO generateEmpi(EmpiVO model) throws CoBusinessException {

        //生成注册uuid和患者主索引
        String regUuid = UuidUtils.getUUID();
        model.setUuid(regUuid);
        model.setRegUuid(regUuid);
        //生成主索引
        String empiNo = model.getRegCorpId() + "-" + UuidUtils.getUUID();
        model.setEmpi(empiNo);

        String time = TimeUtils.getCurrentTime();
        model.setRegTime(time);
        model.setCreateTime(time);

        /**   校验患者基本信息是否完整   */
        checkPatientBaseInfo(model);

        EmpiVO empi = null;
        /**
          1、首先pix_empi_his_r表中查询是否存在记录（每条记录生成一个empi）
          2、 不存在： 直接生成。
          3、 存在： 直接返回
         **/
        /**   根据 patientId，inpatientId （ 患者唯一标识 ） */
        empi = extService.queryEmpiByPatient(model);
        if(empi!=null) {
            return empi;
        }

        // 防止 身份证、医保卡、就诊卡、护照等唯一标识信息都为空，无法生成主索引查询，设置医保为empiNo
        if(StringUtils.isBlank(model.getIdCard()) && StringUtils.isBlank(model.getYibaoCard()) &&
                StringUtils.isBlank(model.getJiuzhenCard()) && StringUtils.isBlank(model.getHuzhaoCard()) ) {
            model.setHuzhaoCard(model.getEmpi());
        }

        /** 查询患者唯一标识是否存在 */
        List<EmpiVO> result = extService.queryEMPIByCard(model);
        if(result==null || result.size()==0) {
            model.setEmpiFlag(Constant.EMPI_FLAG_ENABLE); //设置主索引
        }

        empi = createEmpi(model);

        /** 自动合并empi */
        extService.mergeEmpiAuto(model);

        return empi;
    }

    /**
     * 创建empi信息
     *
     * @return
     * @throws CoBusinessException
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            timeout=36000, rollbackFor={Exception.class,CoBusinessException.class})
    public EmpiVO createEmpi(EmpiVO model) throws CoBusinessException {
        /** 验证EMPI生成基本信息 */
        checkPatientHisRInfo(model);

        /** 身份证校验及设置 */
        validateIdCardAndSet(model);

        //插入到主索引表
        PixEmpiModel empi = new PixEmpiModel();
        empi.setEmpi(model.getEmpi());
        empi.setRegUuid(model.getUuid());
        empi.setUsername(model.getName());
        empi.setPassowrd(DEFAULT_PASSWORD);
        empi.setStatus(CoConstant.STATUS_NORMAL);
        empiService.insertAutoKey(empi);

        //插入注册信息表
        empiRegisterService.insertAutoKey(model);

        //插入his关联信息表
        PixEmpiHisRModel hisRVO = new PixEmpiHisRModel();
        BeanUtils.copyProperties(model, hisRVO);
        empiHisRService.insertAutoKey(hisRVO);

        //插入注册信息扩展表(婚姻、学历等信息)
        PixEmpiRegisterExtVO empiRegisterExtVO = new PixEmpiRegisterExtVO();
        BeanUtils.copyProperties(model, empiRegisterExtVO);
        empiRegisterExtVO.setRegUuid(model.getUuid());
        empiRegisterExtService.insertAutoKey(empiRegisterExtVO);

        //插入卡扩展表
        setIdentityCard(model);
        empiIdentityService.insertBatch(model);

        //插入到联系人信息表
        empiIdentityContactService.insertBatch(setIdentityContact(model));
        return model;
    }



}
