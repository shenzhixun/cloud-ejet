package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.UuidUtils;
import com.ejet.comm.utils.collect.BeanUtils;
import com.ejet.comm.utils.time.TimeUtils;
import com.ejet.core.global.CoConstant;
import com.khsh.datac.empi.comm.CardTypeEnum;
import com.khsh.datac.empi.comm.Constant;
import com.khsh.datac.empi.mapper.EmpiDao;
import com.khsh.datac.empi.model.PixEmpiHisRModel;
import com.khsh.datac.empi.service.IEmpiService;
import com.khsh.datac.empi.utils.IDCardUtils;
import com.khsh.datac.empi.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.khsh.datac.empi.comm.Constant.CHANNEL_EMR;
import static com.khsh.datac.empi.comm.Constant.EMPI_PASSWORD;

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
    private EmpiDao mDao;

    /**
     * 校验必填信息
     * @param model
     * @throws CoBusinessException
     */
    public void checkRegInfo(EmpiVO model) throws CoBusinessException {
        if(StringUtils.isBlank(model.getName())) {//姓名为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "姓名为空");
        }
        if(StringUtils.isBlank(model.getBirthday())) {//出生年月不能为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "出生年月不能为空");
        }
        if(model.getSex()==null) {//性别不能为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "性别不能为空");
        }
        if(StringUtils.isBlank(model.getRegCorpId())) {//注册机构
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "注册机构为空");
        }
        if(StringUtils.isBlank(model.getRegSysId())) {//注册系统
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "注册系统为空");
        }
        model.setEmpiFlag(null);
        model.setEmpi(null);
        model.setUuid(null);

    }

    public PixEmpiIdentityVO wrap(CardTypeEnum type, String number) {
        PixEmpiIdentityVO item = new PixEmpiIdentityVO();
        item.setIdType(type.ordinal());
        item.setIdCode(type.getName());
        item.setIdName(type.getDesc());
        item.setIdNo(number);
        return item;
    }


    /**
     * 根据唯一标识获取
     * @return
     * @throws CoBusinessException
     */
    public List<PixEmpiIdentityVO> queryIdentity(EmpiVO model) throws CoBusinessException {
        //除（身份证、医保卡、就诊卡、护照）等外 唯一标识信息查询
        List<PixEmpiIdentityVO> identityList = new ArrayList<>();
        if(!StringUtils.isBlank(model.getIdCard())) {
            //校验身份是否合法
            identityList.add(wrap(CardTypeEnum.ID_CARD, model.getIdCard()));
        }
        if(!StringUtils.isBlank(model.getYibaoCard())) {
            identityList.add(wrap(CardTypeEnum.YIBAO_CARD, model.getYibaoCard()));
        }
        if(!StringUtils.isBlank(model.getJiuzhenCard())) {
            identityList.add(wrap(CardTypeEnum.JIUZHEN_CARD, model.getJiuzhenCard()));
        }
        if(!StringUtils.isBlank(model.getHuzhaoCard())) {
            identityList.add(wrap(CardTypeEnum.HUZHAO_CARD, model.getHuzhaoCard()));
        }
        model.setIdentityList(identityList);

        List<PixEmpiIdentityVO> result = mDao.queryIdentity(identityList);
        return result;
    }

    /**
     * 根据唯一标识获取
     * @return
     * @throws CoBusinessException
     */
    private void setRegUuid(EmpiVO model, String regUuid, String empi) throws CoBusinessException {
        if(model.getIdentityList()!=null) {
            for(PixEmpiIdentityVO item : model.getIdentityList()) {
                item.setRegUuid(regUuid);
                item.setEmpi(empi);
            }
        }
    }

    /**
     *  设置联系人信息
     */
    public PixEmpiIdentityContactVO setEmpiIdentityContact(EmpiVO model) {
        //联系人名字或者电话号码不为空
        if(model.getRelation()!=null &&
                (!StringUtils.isBlank(model.getRelName()) || !StringUtils.isBlank(model.getRelPhone())) ) {

            PixEmpiIdentityContactVO vo = new PixEmpiIdentityContactVO();
            BeanUtils.copyProperties(model, vo);
            vo.setRegUuid(model.getUuid());
        }
        return null;
    }
    /**
     * 根据卡唯一标识获取
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO queryEmpiByCard(EmpiVO model) throws CoBusinessException {
        //根据 身份证、医保卡、就诊卡、护照等唯一标识信息查询
        if(!StringUtils.isBlank(model.getIdCard()) ||
                !StringUtils.isBlank(model.getYibaoCard()) || !StringUtils.isBlank(model.getJiuzhenCard()) ||
                !StringUtils.isBlank(model.getHuzhaoCard())
        ) {
            return mDao.queryEmpiByCard(model);
        }
        return null;
    }

    /**
     * 根据扩展卡进行获取
     *
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO queryEmpiByCardExt(EmpiVO model) throws CoBusinessException {
        //除（身份证、医保卡、就诊卡、护照）等外 唯一标识信息查询
        List<PixEmpiIdentityVO> identityList = new ArrayList<>();
        if(!StringUtils.isBlank(model.getJiashiCard())) {
            identityList.add(wrap(CardTypeEnum.JIASHI_CARD, model.getIdCard()));//驾驶证
        }
        if(!StringUtils.isBlank(model.getJunguanCard())) {
            identityList.add(wrap(CardTypeEnum.JUNGUAN_CARD, model.getYibaoCard()));//军官证
        }
        if(!StringUtils.isBlank(model.getShebaoCard())) {
            identityList.add(wrap(CardTypeEnum.SHEBAO_CARD, model.getYibaoCard()));//社保卡
        }
        if(identityList.size()>0) {
            model.setIdentityList(identityList);
            return mDao.queryEmpiByCardExt(model);
        }
        return null;
    }


    /**
     * 根据 患者信息
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO queryEmpiByPatientId(EmpiVO model) throws CoBusinessException {
        //根据 身份证、医保卡、就诊卡、护照等唯一标识信息查询
        if(!StringUtils.isBlank(model.getPatientId())) {
            return mDao.queryEmpiByPatientId(model);
        }
        return null;
    }

    /**
     * 根据 患者信息
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO queryEmpiByInpatientId(EmpiVO model) throws CoBusinessException {
        //根据 身份证、医保卡、就诊卡、护照等唯一标识信息查询
        if(!StringUtils.isBlank(model.getInpatientId()) ) {
            return mDao.queryEmpiByInpatientId(model);
        }
        return null;
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
        //验证基本信息后
        checkRegInfo(model);

        //根据 身份证、医保卡、就诊卡、护照等唯一标识信息标识
        if(!StringUtils.isBlank(model.getIdCard())) {
            try {
                String[] tmp = IDCardUtils.validateIDCard(model.getIdCard(), "/");
                if(tmp!=null && tmp.length==2) {//校验合法
                    model.setExt(model.getBirthday());
                    model.setBirthday(tmp[0]);
                    //model.setSex(Integer.valueOf((tmp[1]))%2);
                    model.setEmpiFlag(Constant.EMPI_FLAG_ENABLE);
                }
            } catch (CoBusinessException e) {
            }
        }
        model.setAge(IDCardUtils.getAgeByBirth(TimeUtils.format2Date(model.getBirthday(), "yyyy/MM/dd")));
        //生成注册uuid和患者主索引
        model.setUuid(UuidUtils.getUUID());
        //生成主索引
        model.setEmpi(model.getRegCorpId() + "-" + UuidUtils.getUUID());

        setRegUuid(model, model.getUuid(), model.getEmpi());

        //插入到主索引表
        PixEmpiVO empi = new PixEmpiVO();
        empi.setEmpi(model.getEmpi());
        empi.setRegUuid(model.getUuid());
        empi.setUsername(model.getName());
        empi.setPassowrd(EMPI_PASSWORD);
        empi.setStatus(CoConstant.STATUS_NORMAL);
        empiService.insertAutoKey(empi);

        //插入注册信息表
        model.setRegTime(TimeUtils.getCurrentTime());
        empiRegisterService.insertAutoKey(model);

        //插入his关联信息表
        model.setRegTime(TimeUtils.getCurrentTime());
        PixEmpiHisRModel hisRVO = new PixEmpiHisRModel();
        BeanUtils.copyProperties(model, hisRVO);
        empiHisRService.insertAutoKey(hisRVO);

        //插入注册信息扩展表(婚姻、学历等信息)
        PixEmpiRegisterExtVO empiRegisterExtVO = new PixEmpiRegisterExtVO();
        BeanUtils.copyProperties(model, empiRegisterExtVO);
        empiRegisterExtVO.setRegUuid(model.getUuid());
        empiRegisterExtService.insertAutoKey(empiRegisterExtVO);

        //插入卡扩展表
        empiIdentityService.insertBatch(model);

        //插入到联系人信息表
        PixEmpiIdentityContactVO empiIdentityContactVO = setEmpiIdentityContact(model);
        if(empiIdentityContactVO!=null) {
            empiIdentityContactService.insertAutoKey(empiIdentityContactVO);
        }
        return model;
    }







    //获取empi信息
    @Override
    public EmpiVO getEmpi(EmpiVO model) throws CoBusinessException {
        //检查必须输入项
        checkRegInfo(model);

        //查询能唯一标识信息
        EmpiVO empi = queryEmpiByCard(model);
        if(empi!=null) {
            return updateEmpiHisRelation(empi, model);
        }
        //查询能唯一标识信息(根据扩展卡进行获取)
        empi = queryEmpiByCardExt(model);
        if(empi!=null) {
            return updateEmpiHisRelation(empi, model);
        }

        //查询能唯一标识信息(patientId，inpatientId患者)
        empi = queryEmpiByPatientId(model);
        if(empi!=null) {
            return empi;
        }

        //查询能唯一标识信息(patientId，inpatientId患者)
        empi = queryEmpiByInpatientId(model);
        if(empi!=null) {
            return empi;
        }
        //不存在，入库新数据，则生成新的，提供给调用方
        return createEmpi(model);
    }

    //获取empi信息
    public List<EmpiVO> getEmpiSimilar(EmpiVO model) throws CoBusinessException {


        return null;
    }

    /**
     * 获取empi信息(根据patient_id)
     */
    public EmpiVO getEmpiByPatientId(EmpiVO model) throws CoBusinessException {
        if(StringUtils.isBlank(model.getPatientId()) && StringUtils.isBlank(model.getInpatientId())) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "患者patient_id、inpatient_id为空!");
        }
        //查询empi信息
        EmpiVO result = queryEmpiByPatientId(model);
        if(result!=null && !StringUtils.isBlank(result.getEmpi())) {
            return result;
        }

        result = queryEmpiByInpatientId(model);
        if(result!=null && !StringUtils.isBlank(result.getEmpi())) {
            return result;
        }

        //创建empi信息, 如果是
        if(model.getChannelId()!=null && model.getChannelId().equalsIgnoreCase(CHANNEL_EMR)) {
            result = createEmpi(model);
        }
        return result;
    }


    /**
     * 更新患者信息
     *
     * @param model
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO updateEmpiByPatientInfo(EmpiVO model) throws CoBusinessException {
        if(StringUtils.isBlank(model.getIdCard()) ) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "患者patient_id为空!");
        }
        return queryEmpiByPatientId(model);
    }

    /**
     * 更新empi与his对应关联关系(patientId\inpatientId\)
     * @return
     */
    public EmpiVO updateEmpiHisRelation(EmpiVO empi, EmpiVO model) throws CoBusinessException {
       //首先查询是否存在，如果存在，则更新
        model.setEmpi(empi.getEmpi());
        model.setRegCorpId(empi.getRegCorpId());
        model.setRegCorpName(empi.getRegCorpName());
        model.setRegSysId(empi.getRegSysId());
        if(!StringUtils.isBlank(model.getInpatientId()) && !StringUtils.isBlank(model.getPatientId())) { //非空才更新
            PixEmpiHisRModel query = new PixEmpiHisRModel();
            query.setPatientId(model.getPatientId());
            query.setInpatientId(model.getInpatientId());
            List<PixEmpiHisRModel> result = empiHisRService.queryByCond(query);
            if(result==null || result.size()==0) { //无记录，则需要插入
                BeanUtils.copyProperties(model, query);
                empiHisRService.insertAutoKey(query);
            }
        }
        return model;
    }


}
