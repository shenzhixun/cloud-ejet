package com.khsh.datac.empi.utils;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.collect.BeanUtils;
import com.ejet.comm.utils.time.TimeUtils;
import com.khsh.datac.empi.comm.CardTypeEnum;
import com.khsh.datac.empi.comm.Constant;
import com.khsh.datac.empi.vo.EmpiVO;
import com.khsh.datac.empi.vo.PixEmpiIdentityContactVO;
import com.khsh.datac.empi.vo.PixEmpiIdentityVO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ValidateUtils {
    /**
     * 校验患者基本信息
     * @param model
     * @throws CoBusinessException
     */
    public static void checkPatientBaseInfo(EmpiVO model) throws CoBusinessException {
        if(StringUtils.isBlank(model.getName())) {//姓名为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "姓名为空");
        }
        if(StringUtils.isBlank(model.getBirthday())) {//出生年月不能为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "出生年月不能为空");
        }
        //格式化出生年月
        model.setExt(model.getBirthday());
        model.setBirthday(TimeUtils.formatDate3("yyyy/MM/dd HH:mm:ss.000000000", "yyyy/MM/dd HH:mm:ss", model.getBirthday()));

        if(model.getSex()==null) {//性别不能为空
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "性别不能为空");
        }
        if(StringUtils.isBlank(model.getRegCorpId())) {//注册机构
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "注册机构为空");
        }
        if(StringUtils.isBlank(model.getRegSysId())) {//注册系统
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "注册系统为空");
        }
        model.setEmpiFlag(Constant.EMPI_FLAG_DISABLE);

    }


    /**
     * 校验 生成EMPI数据信息
     * @param model
     * @throws CoBusinessException
     */
    public static void checkPatientHisRInfo(EmpiVO model) throws CoBusinessException {
        if(StringUtils.isBlank(model.getInpatientId()) && StringUtils.isBlank(model.getPatientId())) { //非空才更新
            throw new CoBusinessException("患者patientId和InpatientId都为空!");
        }
        if(StringUtils.isBlank(model.getInHospitalId())) {
            throw new CoBusinessException("门诊号、住院号为空!");
        }
        if(model.getInHospitalDate()==null) {
            throw new CoBusinessException("入院时间为空!");
        }
        if(StringUtils.isBlank(model.getVisitDoctorName())) {
            throw new CoBusinessException("诊断医生工号为空!");
        }
        if(StringUtils.isBlank(model.getDiagName())) {
            throw new CoBusinessException("诊断名称为空!");
        }
    }


    /**
     *
     * 校验身份证信息合法性，并根据身份证信息，设置生日和性别
     *
     * @param model
     */
    public static void validateIdCardAndSet(EmpiVO model) {
        if(!StringUtils.isBlank(model.getIdCard())) {
            try {
                String[] tmp = IDCardUtils.validateIDCard(model.getIdCard(), "/");
                if(tmp!=null && tmp.length==2) {//校验合法
                    model.setExt(model.getBirthday());
                    model.setBirthday(tmp[0]);
                    if(model.getSex()==null) {
                        model.setSex(Integer.valueOf((tmp[1]))%2);
                    }
                }
            } catch (CoBusinessException e) {
                log.error("", e);
            }
        }
        if(!StringUtils.isBlank(model.getBirthday())) {
            model.setAge(IDCardUtils.getAgeByBirth(TimeUtils.format2Date(model.getBirthday(), "yyyy/MM/dd")));
        }
    }


    /**
     * 设置 卡 信息
     * @param model
     */
    public static void setIdentityCard(EmpiVO model) {
        if(!StringUtils.isBlank(model.getHuzhaoCard())) { //护照
            PixEmpiIdentityVO vo = wrap(CardTypeEnum.HUZHAO_CARD, model.getHuzhaoCard());
            vo.setRegUuid(model.getRegUuid());
            vo.setEmpi(model.getEmpi());
            model.getIdentityList().add(vo);
        }

        if(!StringUtils.isBlank(model.getShebaoCard())) { //社保
            PixEmpiIdentityVO vo = wrap(CardTypeEnum.SHEBAO_CARD, model.getShebaoCard());
            vo.setRegUuid(model.getRegUuid());
            vo.setEmpi(model.getEmpi());
            model.getIdentityList().add(vo);
        }

        if(!StringUtils.isBlank(model.getJunguanCard())) { //军官证
            PixEmpiIdentityVO vo = wrap(CardTypeEnum.JUNGUAN_CARD, model.getJunguanCard());
            vo.setRegUuid(model.getRegUuid());
            vo.setEmpi(model.getEmpi());
            model.getIdentityList().add(vo);
        }
    }

    /**
     *  设置 卡信息、联系人信息
     */
    public static List<PixEmpiIdentityContactVO> setIdentityContact(EmpiVO model) {
        List<PixEmpiIdentityContactVO> list = new ArrayList<>();
        if(model.getRelation()!=null &&
                (!StringUtils.isBlank(model.getRelName()) || !StringUtils.isBlank(model.getRelPhone())) ) {
            PixEmpiIdentityContactVO vo = new PixEmpiIdentityContactVO();
            BeanUtils.copyProperties(model, vo);
            list.add(vo);
        }
        return list;
    }

    public static PixEmpiIdentityVO wrap(CardTypeEnum type, String number) {
        PixEmpiIdentityVO item = new PixEmpiIdentityVO();
        item.setIdType(type.ordinal());
        item.setIdCode(type.getName());
        item.setIdName(type.getDesc());
        item.setIdNo(number);
        return item;
    }


    public static int visitTypeFormat(String visitTypeName) {
        int visitType = 2;
        try {
            if(!StringUtils.isBlank(visitTypeName)) {
                visitType = Integer.parseInt(visitTypeName);
            }
        }catch (Exception e) {

        }
        return visitType;
    }


}
