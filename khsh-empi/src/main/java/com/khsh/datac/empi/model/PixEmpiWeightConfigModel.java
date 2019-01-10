package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiWeightConfigModel extends CoBaseVO {

	/**    */
 	private Integer id;
	/**  配置名称  */
 	private String confName;
	/**  配置类型  */
 	private String confType;
	/**  配置编码  */
 	private String confCode;
	/**  优先级  */
 	private Integer priority;
	/**  权重值, 小1  */
 	private Integer weightValue;
	/**  是否允许为空, 1: 允许为空  0：不允许为空  */
 	private Integer nullable;
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

	public void setConfName(String confName) {
		this.confName=confName;
	}

	public String getConfName(){
		return confName;
	}

	public void setConfType(String confType) {
		this.confType=confType;
	}

	public String getConfType(){
		return confType;
	}

	public void setConfCode(String confCode) {
		this.confCode=confCode;
	}

	public String getConfCode(){
		return confCode;
	}

	public void setPriority(Integer priority) {
		this.priority=priority;
	}

	public Integer getPriority(){
		return priority;
	}

	public void setWeightValue(Integer weightValue) {
		this.weightValue=weightValue;
	}

	public Integer getWeightValue(){
		return weightValue;
	}

	public void setNullable(Integer nullable) {
		this.nullable=nullable;
	}

	public Integer getNullable(){
		return nullable;
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
