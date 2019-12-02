package com.khsh.datacent.patientview.util;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.khsh.datacent.patientview.dto.PatientParam;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ValidateUtil {
    /**
     * 校验患者基本信息
     */
    public static boolean checkPatientParam(PatientParam param) throws CoBusinessException {
        if( StringUtils.isBlank(param.getIdCard()) && StringUtils.isBlank(param.getPatientId())
                && StringUtils.isBlank(param.getInpatientId()) && StringUtils.isBlank(param.getInHospitalId())
        ) { //检索项缺失
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING, "检索必填参数缺失!");
        }
        return true;
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
