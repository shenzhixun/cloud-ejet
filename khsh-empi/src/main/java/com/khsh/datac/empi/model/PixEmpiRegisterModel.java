package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiRegisterModel extends CoBaseVO {

	/**    */
 	private Integer id;
	/**  注册uuid号  */
 	private String uuid;
	/**  患者主索引empi  */
 	private String empi;
	/**  注册机构id  */
 	private String regCorpId;
	/**  注册机构名称  */
 	private String regCorpName;
	/**  注册应用系统id  */
 	private String regSysId;
	/**  注册时间  */
 	private String regTime;
	/**  患者姓名  */
 	private String name;
	/**  名字拼音  */
 	private String namePin;
	/**  性别 1：男 2：女  */
 	private Integer sex;
	/**  年龄  */
 	private Integer age;
	/**  出生日期yyyy.MM.dd  */
 	private String birthday;
	/**  身份证  */
 	private String idCard;
	/**  医保卡  */
 	private String yibaoCard;
	/**  就诊卡  */
 	private String jiuzhenCard;
	/**  患者id  */
 	private String patientId;
	/**  患者住院id  */
 	private String inpatientId;
	/**  护照  */
 	private String huzhaoCard;
	/**  是否主索引标志 1：是 2：否  */
 	private Integer empiFlag;
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

	public void setUuid(String uuid) {
		this.uuid=uuid;
	}

	public String getUuid(){
		return uuid;
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

	public void setRegCorpName(String regCorpName) {
		this.regCorpName=regCorpName;
	}

	public String getRegCorpName(){
		return regCorpName;
	}

	public void setRegSysId(String regSysId) {
		this.regSysId=regSysId;
	}

	public String getRegSysId(){
		return regSysId;
	}

	public void setRegTime(String regTime) {
		this.regTime=regTime;
	}

	public String getRegTime(){
		return regTime;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setNamePin(String namePin) {
		this.namePin=namePin;
	}

	public String getNamePin(){
		return namePin;
	}

	public void setSex(Integer sex) {
		this.sex=sex;
	}

	public Integer getSex(){
		return sex;
	}

	public void setAge(Integer age) {
		this.age=age;
	}

	public Integer getAge(){
		return age;
	}

	public void setBirthday(String birthday) {
		this.birthday=birthday;
	}

	public String getBirthday(){
		return birthday;
	}

	public void setIdCard(String idCard) {
		this.idCard=idCard;
	}

	public String getIdCard(){
		return idCard;
	}

	public void setYibaoCard(String yibaoCard) {
		this.yibaoCard=yibaoCard;
	}

	public String getYibaoCard(){
		return yibaoCard;
	}

	public void setJiuzhenCard(String jiuzhenCard) {
		this.jiuzhenCard=jiuzhenCard;
	}

	public String getJiuzhenCard(){
		return jiuzhenCard;
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

	public void setHuzhaoCard(String huzhaoCard) {
		this.huzhaoCard=huzhaoCard;
	}

	public String getHuzhaoCard(){
		return huzhaoCard;
	}

	public void setEmpiFlag(Integer empiFlag) {
		this.empiFlag=empiFlag;
	}

	public Integer getEmpiFlag(){
		return empiFlag;
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
