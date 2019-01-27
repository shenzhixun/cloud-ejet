package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiModel extends CoBaseVO {
	/**    */
 	private Integer id;
	/**  注册uuid号  */
 	private String regUuid;
	/**  患者主索引empi  */
 	private String empi;
	/**  用户姓名  */
 	private String username;
	/**  用户密码，可以用户患者登录或者加密  */
 	private String passowrd;
	/**  状态标识 1：正常 0：禁用  */
 	private Integer status;
	/**  备注  */
 	private String remark;
	/**  扩展  */
 	private String ext;

}
