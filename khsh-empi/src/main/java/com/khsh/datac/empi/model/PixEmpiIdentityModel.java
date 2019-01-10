package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiIdentityModel extends CoBaseVO {

	/**    */
 	private Integer id;
	/**  注册uuid号  */
 	private String regUuid;
	/**  患者empi  */
 	private String empi;
	/**  身份识别类型id  */
 	private Integer idType;
	/**  身份识别号码  */
 	private String idName;
	/**  身份识别编码  */
 	private String idCode;
	/**  身份识别号码  */
 	private String idNo;
	/**  缺省标识  */
 	private String idFlag;
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

	public void setIdType(Integer idType) {
		this.idType=idType;
	}

	public Integer getIdType(){
		return idType;
	}

	public void setIdName(String idName) {
		this.idName=idName;
	}

	public String getIdName(){
		return idName;
	}

	public void setIdCode(String idCode) {
		this.idCode=idCode;
	}

	public String getIdCode(){
		return idCode;
	}

	public void setIdNo(String idNo) {
		this.idNo=idNo;
	}

	public String getIdNo(){
		return idNo;
	}

	public void setIdFlag(String idFlag) {
		this.idFlag=idFlag;
	}

	public String getIdFlag(){
		return idFlag;
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
