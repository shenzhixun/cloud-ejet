package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiHisRModel extends CoBaseVO {

	/**    */
 	private Long id;
	/**  患者empi  */
 	private String empi;
	/**  注册机构id  */
 	private String regCorpId;
	/**  患者id  */
 	private String patientId;
	/**  患者住院id  */
 	private String inpatientId;
	/**  住院号  */
 	private String inHospitalId;
	/**  住院日期  */
 	private String inHospitalDate;
	/**  床位号  */
 	private String bedId;
	/**  入院科室  */
 	private String inDeptName;
	/**  转出科室  */
 	private String outDeptName;
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

	public void setId(Long id) {
		this.id=id;
	}

	public Long getId(){
		return id;
	}

	public void setEmpi(String empi) {
		this.empi=empi;
	}

	public String getEmpi(){
		return empi;
	}

	public void setRegCorpId(String regCorpId) {
		this.regCorpId=regCorpId;
	}

	public String getRegCorpId(){
		return regCorpId;
	}

	public void setPatientId(String patientId) {
		this.patientId=patientId;
	}

	public String getPatientId(){
		return patientId;
	}

	public void setInpatientId(String inpatientId) {
		this.inpatientId=inpatientId;
	}

	public String getInpatientId(){
		return inpatientId;
	}

	public void setInHospitalId(String inHospitalId) {
		this.inHospitalId=inHospitalId;
	}

	public String getInHospitalId(){
		return inHospitalId;
	}

	public void setInHospitalDate(String inHospitalDate) {
		this.inHospitalDate=inHospitalDate;
	}

	public String getInHospitalDate(){
		return inHospitalDate;
	}

	public void setBedId(String bedId) {
		this.bedId=bedId;
	}

	public String getBedId(){
		return bedId;
	}

	public void setInDeptName(String inDeptName) {
		this.inDeptName=inDeptName;
	}

	public String getInDeptName(){
		return inDeptName;
	}

	public void setOutDeptName(String outDeptName) {
		this.outDeptName=outDeptName;
	}

	public String getOutDeptName(){
		return outDeptName;
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
