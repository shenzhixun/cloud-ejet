package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiWeightConfigModel extends CoBaseVO {

	/**    */
 	private Integer id;
	/**  配置名称  */
 	private String name;
	/**  配置编码  */
 	private String weightCode;
	/**  优先级  */
 	private Integer priority;
	/**  权重值, 小1  */
 	private Integer weightValue;
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

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setWeightCode(String weightCode) {
		this.weightCode=weightCode;
	}

	public String getWeightCode(){
		return weightCode;
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


}
