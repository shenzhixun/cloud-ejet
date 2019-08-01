package com.khsh.datac.empi.vo;

import com.khsh.datac.empi.model.PixEmpiRegisterModel;
import lombok.Data;

@Data
public class PixEmpiRegisterVO extends PixEmpiRegisterModel {
    //============ 扩展信息=====
    /**  注册uuid号  */
    private java.lang.String regUuid;
    /**  国家  */
    private java.lang.String country;
    /**  国家  */
    private java.lang.String countryName;
    /**  民族  */
    private java.lang.String nation;
    /**  民族  */
    private java.lang.String nationName;
    /**  文化程度  */
    private java.lang.String eduDegree;
    /**  职业  */
    private java.lang.String job;
    /**  职业  */
    private java.lang.String jobName;
    /**  婚姻状况  */
    private java.lang.String marriageState;
    /**  婚姻状况  */
    private java.lang.String marriageStateName;
    /**  联系电话  */
    private java.lang.String phone;
    /**  联系人 省  */
    private java.lang.String addrProvince;
    /**  联系人 地市  */
    private java.lang.String addrCity;
    /**  联系人 区域（县）  */
    private java.lang.String addrArea;
    /**  联系人 详细地址  */
    private java.lang.String addrDetail;
    /**  邮政编码  */
    private java.lang.String zipCode;
    /**  邮箱  */
    private java.lang.String email;
    /**  工作单位  */
    private java.lang.String workDept;
    /**  工作单位地址  */
    private java.lang.String workAddress;

}