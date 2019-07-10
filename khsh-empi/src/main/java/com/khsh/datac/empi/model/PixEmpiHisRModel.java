package com.khsh.datac.empi.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

@Data
public class PixEmpiHisRModel extends CoBaseVO {

	/**    */
	private java.lang.Long id;
	/**  患者empi  */
	private java.lang.String empi;
	/**  注册机构id  */
	private java.lang.String regCorpId;
	/**  患者id  */
	private java.lang.String patientId;
	/**    */
	private java.lang.Integer visitType;
	/**    */
	private java.lang.String visitTypeCode;
	/**  患者住院id  */
	private java.lang.String inpatientId;
	/**  住院号  */
	private java.lang.String inHospitalId;
	/**  住院日期  */
	private java.lang.String inHospitalDate;
	/**  床位号  */
	private java.lang.String bedId;
	/**  入院科室  */
	private java.lang.String inDeptName;
	/**  转出科室  */
	private java.lang.String outDeptName;
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
