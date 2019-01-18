package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiIdentityContactModel extends CoBaseVO {

	/**    */
 	private Integer id;
	/**  注册uuid号  */
 	private String regUuid;
	/**  患者empi  */
 	private String empi;
	/**  与患者关系 1:本人   */
 	private String relation;
	/**  联系人 姓名  */
 	private String relName;
	/**  联系人 名字拼音  */
 	private String relNamePin;
	/**  联系人 性别 1：男 2：女  */
 	private Integer relSex;
	/**  联系人 电话  */
 	private String relPhone;
	/**  联系人 省  */
 	private String relAddrProvince;
	/**  联系人 地市  */
 	private String relAddrCity;
	/**  联系人 区域（县）  */
 	private String relAddrArea;
	/**  联系人 详细地址  */
 	private String relAddrDetail;
	/**  邮政编码  */
 	private String relZipCode;
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

	public void setRelation(String relation) {
		this.relation=relation;
	}

	public String getRelation(){
		return relation;
	}

	public void setRelName(String relName) {
		this.relName=relName;
	}

	public String getRelName(){
		return relName;
	}

	public void setRelNamePin(String relNamePin) {
		this.relNamePin=relNamePin;
	}

	public String getRelNamePin(){
		return relNamePin;
	}

	public void setRelSex(Integer relSex) {
		this.relSex=relSex;
	}

	public Integer getRelSex(){
		return relSex;
	}

	public void setRelPhone(String relPhone) {
		this.relPhone=relPhone;
	}

	public String getRelPhone(){
		return relPhone;
	}

	public void setRelAddrProvince(String relAddrProvince) {
		this.relAddrProvince=relAddrProvince;
	}

	public String getRelAddrProvince(){
		return relAddrProvince;
	}

	public void setRelAddrCity(String relAddrCity) {
		this.relAddrCity=relAddrCity;
	}

	public String getRelAddrCity(){
		return relAddrCity;
	}

	public void setRelAddrArea(String relAddrArea) {
		this.relAddrArea=relAddrArea;
	}

	public String getRelAddrArea(){
		return relAddrArea;
	}

	public void setRelAddrDetail(String relAddrDetail) {
		this.relAddrDetail=relAddrDetail;
	}

	public String getRelAddrDetail(){
		return relAddrDetail;
	}

	public void setRelZipCode(String relZipCode) {
		this.relZipCode=relZipCode;
	}

	public String getRelZipCode(){
		return relZipCode;
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
