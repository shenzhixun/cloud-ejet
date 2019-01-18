package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiRegisterExtModel extends CoBaseVO {

	/**    */
 	private Integer id;
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

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setRegUuid(String regUuid) {
		this.regUuid=regUuid;
	}

	public String getRegUuid(){
		return regUuid;
	}

	public void setEmpi(String empi) {
		this.empi=empi;
	}

	public String getEmpi(){
		return empi;
	}

	public void setCountry(String country) {
		this.country=country;
	}

	public String getCountry(){
		return country;
	}

	public void setCountryName(String countryName) {
		this.countryName=countryName;
	}

	public String getCountryName(){
		return countryName;
	}

	public void setNation(String nation) {
		this.nation=nation;
	}

	public String getNation(){
		return nation;
	}

	public void setNationName(String nationName) {
		this.nationName=nationName;
	}

	public String getNationName(){
		return nationName;
	}

	public void setEduDegree(String eduDegree) {
		this.eduDegree=eduDegree;
	}

	public String getEduDegree(){
		return eduDegree;
	}

	public void setJob(String job) {
		this.job=job;
	}

	public String getJob(){
		return job;
	}

	public void setJobName(String jobName) {
		this.jobName=jobName;
	}

	public String getJobName(){
		return jobName;
	}

	public void setMarriageState(String marriageState) {
		this.marriageState=marriageState;
	}

	public String getMarriageState(){
		return marriageState;
	}

	public void setMarriageStateName(String marriageStateName) {
		this.marriageStateName=marriageStateName;
	}

	public String getMarriageStateName(){
		return marriageStateName;
	}

	public void setPhone(String phone) {
		this.phone=phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setAddrProvince(String addrProvince) {
		this.addrProvince=addrProvince;
	}

	public String getAddrProvince(){
		return addrProvince;
	}

	public void setAddrCity(String addrCity) {
		this.addrCity=addrCity;
	}

	public String getAddrCity(){
		return addrCity;
	}

	public void setAddrArea(String addrArea) {
		this.addrArea=addrArea;
	}

	public String getAddrArea(){
		return addrArea;
	}

	public void setAddrDetail(String addrDetail) {
		this.addrDetail=addrDetail;
	}

	public String getAddrDetail(){
		return addrDetail;
	}

	public void setZipCode(String zipCode) {
		this.zipCode=zipCode;
	}

	public String getZipCode(){
		return zipCode;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getEmail(){
		return email;
	}

	public void setWorkDept(String workDept) {
		this.workDept=workDept;
	}

	public String getWorkDept(){
		return workDept;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress=workAddress;
	}

	public String getWorkAddress(){
		return workAddress;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus(){
		return status;
	}

	public void setRemark(String remark) {
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}

	public void setCreateBy(String createBy) {
		this.createBy=createBy;
	}

	public String getCreateBy(){
		return createBy;
	}

	public void setCreateTime(String createTime) {
		this.createTime=createTime;
	}

	public String getCreateTime(){
		return createTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime=updateTime;
	}

	public String getUpdateTime(){
		return updateTime;
	}

	public void setExt(String ext) {
		this.ext=ext;
	}

	public String getExt(){
		return ext;
	}

	public void setGsonExt(String gsonExt) {
		this.gsonExt=gsonExt;
	}

	public String getGsonExt(){
		return gsonExt;
	}


}
