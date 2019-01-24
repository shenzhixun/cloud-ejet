package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiRegisterModel extends CoBaseVO {

	/**    */
 	private Long id;
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


}
