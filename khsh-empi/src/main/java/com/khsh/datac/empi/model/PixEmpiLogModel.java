package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
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
	/**  扩展  */
 	private String ext;
	/**  扩展  */
 	private String ext1;
	/**  日志详情  */
 	private String logDetail;

}
