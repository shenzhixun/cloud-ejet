package com.khsh.datacent.patientview.model;

import com.ejet.comm.base.CoBaseVO;
import com.ejet.comm.utils.time.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class PixEmpiHisRModel extends CoBaseVO { 
	/**    */
 	private java.lang.Long id; 
	/**  患者empi  */ 
 	private java.lang.String empi; 
	/**  注册机构id(就诊医疗机构代码)  */ 
 	private java.lang.String regCorpId; 
	/**  就诊医疗机构名称  */ 
 	private java.lang.String regCorpName; 
	/**  患者id  */ 
 	private java.lang.String patientId; 
	/**  患者id  */ 
 	private java.lang.String inpatientId; 
	/**  就诊类型 1：门诊 2：住院  */ 
 	private java.lang.Integer visitType; 
	/**  就诊类型标志  */ 
 	private java.lang.String visitTypeCode; 
	/**  住院号、门诊号  */ 
 	private java.lang.String inHospitalId; 
	/**  入院时间  */
	@JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
	@DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
 	private LocalDateTime inHospitalDate;
	/**  出院时间  */
	@JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
	@DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
 	private LocalDateTime outHospitalDate;
	/**  入院次数  */ 
 	private java.lang.Integer hospitalNum; 
	/**  入院科室  */ 
 	private java.lang.String inDeptName; 
	/**  转出科室  */ 
 	private java.lang.String outDeptName; 
	/**  床位号  */ 
 	private java.lang.String bedId; 
	/**  诊断类别代码:门诊诊断、入院诊断、主要诊断、次要诊断等  */ 
 	private java.lang.String diagCategCode; 
	/**  诊断代码  */ 
 	private java.lang.String diagCode; 
	/**  诊断名称  */ 
 	private java.lang.String diagName; 
	/**  诊断依据  */ 
 	private java.lang.String diagBasic;
	/**  诊断描述  */
	private java.lang.String diagDesc;
	/**  诊断结果  */
	private java.lang.String diagResult;
	/**  诊断日期  */
 	private java.util.Date diagDate;
	/**  诊断医生姓名  */
	private java.lang.String visitDoctorName;
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