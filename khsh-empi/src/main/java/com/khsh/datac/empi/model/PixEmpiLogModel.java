package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
public class PixEmpiLogModel extends CoBaseVO {

	/**    */
 	private Integer id;
	/**  日志级别, 1：debug，2：info 3：warn 4：error  */
 	private Integer logLevel;
	/**  日志简述  */
 	private String logSubject;
	/**  结果：1：成功 0：失败  */
 	private Integer logResult;
	/**  开始业务id  */
 	private String beforeBussId;
	/**  最后业务id  */
 	private String afterBussId;
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
 	private String ext1;
	/**  日志详情  */
 	private String logDetail;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setLogLevel(Integer logLevel) {
		this.logLevel=logLevel;
	}

	public Integer getLogLevel(){
		return logLevel;
	}

	public void setLogSubject(String logSubject) {
		this.logSubject=logSubject;
	}

	public String getLogSubject(){
		return logSubject;
	}

	public void setLogResult(Integer logResult) {
		this.logResult=logResult;
	}

	public Integer getLogResult(){
		return logResult;
	}

	public void setBeforeBussId(String beforeBussId) {
		this.beforeBussId=beforeBussId;
	}

	public String getBeforeBussId(){
		return beforeBussId;
	}

	public void setAfterBussId(String afterBussId) {
		this.afterBussId=afterBussId;
	}

	public String getAfterBussId(){
		return afterBussId;
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

	public void setExt1(String ext1) {
		this.ext1=ext1;
	}

	public String getExt1(){
		return ext1;
	}

	public void setLogDetail(String logDetail) {
		this.logDetail=logDetail;
	}

	public String getLogDetail(){
		return logDetail;
	}


}
