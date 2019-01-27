package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
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
	/**  扩展  */
 	private String ext;

}
