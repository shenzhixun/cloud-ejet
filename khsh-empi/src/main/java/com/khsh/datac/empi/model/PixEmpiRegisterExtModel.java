package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiRegisterExtModel extends CoBaseVO {
	/**    */
 	private Long id;
	/**  注册uuid号  */
 	private String regUuid;
	/**  患者empi  */
 	private String empi;
	/**  国家  */
 	private String country;
	/**  国家  */
 	private String countryName;
	/**  民族  */
 	private String nation;
	/**  民族  */
 	private String nationName;
	/**  文化程度  */
 	private String eduDegree;
	/**  职业  */
 	private String job;
	/**  职业  */
 	private String jobName;
	/**  婚姻状况  */
 	private String marriageState;
	/**  婚姻状况  */
 	private String marriageStateName;
	/**  联系电话  */
 	private String phone;
	/**  联系人 省  */
 	private String addrProvince;
	/**  联系人 地市  */
 	private String addrCity;
	/**  联系人 区域（县）  */
 	private String addrArea;
	/**  联系人 详细地址  */
 	private String addrDetail;
	/**  邮政编码  */
 	private String zipCode;
	/**  邮箱  */
 	private String email;
	/**  工作单位  */
 	private String workDept;
	/**  工作单位地址  */
 	private String workAddress;
	/**  状态标识 1：正常 0：禁用  */
 	private Integer status;
	/**  备注  */
 	private String remark;
	/**  创建人  */
 	private String createBy;
	/**  创建时间  */
 	private String createTime;
	/**  修改时间  */
 	private String updateTime;
	/**  扩展  */
 	private String ext;
	/**  扩展  */
 	private String gsonExt;


}
