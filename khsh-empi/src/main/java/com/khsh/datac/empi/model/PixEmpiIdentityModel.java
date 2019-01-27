package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
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
	/**  扩展  */
 	private String ext;

}
