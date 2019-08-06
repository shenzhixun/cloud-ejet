package com.khsh.datac.empi.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.collect.BeanUtils;
import com.ejet.comm.utils.time.TimeUtils;
import com.khsh.datac.empi.mapper.EmpiDao;
import com.khsh.datac.empi.model.PixEmpiHisRModel;
import com.khsh.datac.empi.model.PixEmpiRModel;
import com.khsh.datac.empi.vo.EmpiMergeVO;
import com.khsh.datac.empi.vo.EmpiVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("empiExtServiceImpl")
public class EmpiExtServiceImpl {

	private final Logger log = LoggerFactory.getLogger(EmpiExtServiceImpl.class);

    @Autowired
    PixEmpiHisRServiceImpl empiHisRService;

    @Autowired
    PixEmpiRServiceImpl empiRService;

    @Autowired
    private EmpiDao mDao;

    /**
     *
     * 根据卡唯一标识获取
     *
     * @return
     * @throws CoBusinessException
     */
    public List<EmpiVO> queryEMPIByCard(EmpiVO model) throws CoBusinessException {
        List<EmpiVO> list = null;
        //根据 身份证、医保卡、就诊卡、护照等唯一标识信息查询
        if(!StringUtils.isBlank(model.getIdCard()) ||
                !StringUtils.isBlank(model.getYibaoCard()) || !StringUtils.isBlank(model.getJiuzhenCard()) ||
                !StringUtils.isBlank(model.getHuzhaoCard())
        ) {
//            EmpiVO query = new EmpiVO();
//            query.setIdCard(model.getIdCard());
//            query.setYibaoCard(model.getYibaoCard());
//            query.setJiuzhenCard(model.getJiuzhenCard());
//            query.setHuzhaoCard(model.getHuzhaoCard());
            list = mDao.queryEmpiMainByCard(model);
        }

        if(list!=null && list.size()>0)
            return list;

//        //除（身份证、医保卡、就诊卡、护照）等外 唯一标识信息查询
//        List<PixEmpiIdentityVO> identityList = new ArrayList<>();
//        if(!StringUtils.isBlank(model.getJiashiCard())) {
//            identityList.add(wrap(CardTypeEnum.JIASHI_CARD, model.getIdCard()));//驾驶证
//        }
//        if(!StringUtils.isBlank(model.getJunguanCard())) {
//            identityList.add(wrap(CardTypeEnum.JUNGUAN_CARD, model.getYibaoCard()));//军官证
//        }
//        if(!StringUtils.isBlank(model.getShebaoCard())) {
//            identityList.add(wrap(CardTypeEnum.SHEBAO_CARD, model.getYibaoCard()));//社保卡
//        }
//        if(identityList.size()>0) {
//            model.setIdentityList(identityList);
//            empiVO = mDao.queryEmpiByExtCard(model);
//        }

        return list;
    }


    /**
     * 根据 患者信息查询
     * @return
     * @throws CoBusinessException
     */
    public EmpiVO queryEmpiByPatient(EmpiVO model) throws CoBusinessException {
        EmpiVO empiVO = null;
        //根据patientId查询
        EmpiVO query = new EmpiVO();
        if(!StringUtils.isBlank(model.getPatientId())) {
            query.setPatientId(model.getPatientId());
            empiVO = mDao.queryEmpiByPatientId(query);
        }
        if(empiVO!=null)
            return empiVO;

        //根据InpatientId查询
        if(!StringUtils.isBlank(model.getInpatientId()) ) {
            query.setPatientId(null);
            query.setInpatientId(model.getInpatientId());
            empiVO = mDao.queryEmpiByPatientId(model);
        }
        return empiVO;
    }

    /**
     *
     * 创建或者更新empi与his对应关联关系(patientId\inpatientId\)
     *
     * @return
     */
    public EmpiVO createEmpiHisRelation(EmpiVO empi, EmpiVO model) throws CoBusinessException {
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

    /** ============================================================================================================================== */
    /**
     * 获取相似empi信息
     */
    public List<EmpiVO> getEmpiSimilar(EmpiVO model) throws CoBusinessException {



        return null;
    }



    /**
     * 自动合并empi
     */
    public void mergeEmpiAuto(EmpiVO model) throws CoBusinessException {
        // 首先查询 唯一号码标示信息
        List<EmpiVO> result = queryEMPIByCard(model);
        if(result==null || result.size()==0) {
            return;
        }

        List<PixEmpiRModel> list = new ArrayList<>();
        //执行合并操作
        for(EmpiVO item : result) {
            //去掉自有
            if(item.getEmpi().equalsIgnoreCase(model.getEmpi())) {
                continue;
            }
            PixEmpiRModel  r = new PixEmpiRModel();
            r.setEmpi(item.getEmpi());
            r.setRelEmpi(model.getEmpi());
            r.setCreateTime(TimeUtils.getCurrentTime());
            list.add(r);
        }
        empiRService.queryAndInsert(list);
    }

    /**
     * 拆分empi
     */
    public void divideEmpi(EmpiMergeVO model) throws CoBusinessException {
        if(model.getMergeList()==null || model.getMergeList().size()<2) {
            return;
        }


    }


}
