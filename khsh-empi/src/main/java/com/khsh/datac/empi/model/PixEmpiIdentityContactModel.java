package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
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
	/**  扩展  */
 	private String ext;

}
