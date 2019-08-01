package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiRegisterModel extends CoBaseVO {
	/**    */
	private java.lang.Integer id;
	/**  注册uuid号  */
	private java.lang.String uuid;
	/**  患者主索引empi  */
	private java.lang.String empi;
	/**  注册机构id  */
	private java.lang.String regCorpId;
	/**  注册机构名称  */
	private java.lang.String regCorpName;
	/**  注册应用系统id  */
	private java.lang.String regSysId;
	/**  患者id  */
	private java.lang.String patientId;
	/**  注册时间  */
	private java.lang.String regTime;
	/**  患者姓名  */
	private java.lang.String name;
	/**  名字拼音  */
	private java.lang.String namePin;
	/**  性别 1：男 2：女  */
	private java.lang.Integer sex;
	/**  年龄  */
	private java.lang.Integer age;
	/**  出生日期yyyy.MM.dd  */
	private java.lang.String birthday;
	/**    */
	private java.lang.String address;
	/**  身份证  */
	private java.lang.String idCard;
	/**  医保卡  */
	private java.lang.String yibaoCard;
	/**  医保卡名称  */
	private java.lang.String yibaoCardName;
	/**  就诊卡  */
	private java.lang.String jiuzhenCard;
	/**  护照  */
	private java.lang.String huzhaoCard;
	/**  是否主索引标志 1：是 2：否  */
	private java.lang.Integer empiFlag;
	/**  状态标识 1：正常 0：禁用  */
	private java.lang.Integer status;
	/**  备注  */
	private java.lang.String remark;
	/**  创建人  */
	private java.lang.String createBy;
	/**  创建时间  */
	private java.lang.String createTime;
	/**  修改时间  */
	private java.lang.String updateTime;
	/**  扩展  */
	private java.lang.String ext;


}
