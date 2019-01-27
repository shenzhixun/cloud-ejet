package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiHisRModel extends CoBaseVO {

	/**    */
 	private Long id;
	/**  患者empi  */
 	private String empi;
	/**  注册机构id  */
 	private String regCorpId;
	/**  患者id  */
 	private String patientId;
	/**  患者住院id  */
 	private String inpatientId;
	/**  住院号  */
 	private String inHospitalId;
	/**  住院日期  */
 	private String inHospitalDate;
	/**  床位号  */
 	private String bedId;
	/**  入院科室  */
 	private String inDeptName;
	/**  转出科室  */
 	private String outDeptName;
	/**  状态标识 1：正常 0：禁用  */
 	private Integer status;
	/**  备注  */
 	private String remark;
	/**  扩展  */
 	private String ext;

}
