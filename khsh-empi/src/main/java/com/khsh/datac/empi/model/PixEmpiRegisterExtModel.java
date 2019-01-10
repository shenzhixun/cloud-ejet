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
	/**  民族  */
 	private String nation;
	/**  文化程度  */
 	private String eduDegree;
	/**  职业  */
 	private String job;
	/**  联系电话  */
 	private String phone;
	/**  邮箱  */
 	private String email;
	/**  婚姻状况  */
 	private String marriageState;
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

	public void setNation(String nation) {
		this.nation=nation;
	}

	public String getNation(){
		return nation;
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

	public void setPhone(String phone) {
		this.phone=phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getEmail(){
		return email;
	}

	public void setMarriageState(String marriageState) {
		this.marriageState=marriageState;
	}

	public String getMarriageState(){
		return marriageState;
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


}
