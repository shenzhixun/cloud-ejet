package com.khsh.datacent.patientview.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: OMOrdersDetailModel
 * Author:   ShenYijie
 * CreateDate:     2019-02-17 19:43
 * Description: 医嘱明细
 * History:
 * Version: 1.0
 */
@Data
public class OMOrdersDetailModel extends CoBaseVO {
    /** 就诊医疗机构代码 */
    private String visitCorp;
    /** 就诊医疗机构名称 */
    private String visitCorpName;
    /**  患者id  */
    private java.lang.String patientId;
    /**  患者id  */
    private java.lang.String inpatientId;
    /**  就诊类型  */
    private String visitType;
    /**  就诊类型标识  */
    private String visitTypeCode;
    /**  医嘱号  */
    private String ordersNo;
    /**  医嘱组号  */
    private String ordersGroupNo;
    /** 就诊时间or入院时间  */
    private String inHospitalDate;
    /**  门诊号or住院号 */
    private String inHospitalId;
    /**  住院次数  */
    private String hospitalNum;
    /**  床位号  */
    private String bedId;
    /** 入院科室 */
    private String inDeptName;
    /**  转出科室  */
    private String outDeptName;
    /** 出院时间 */
    private String outHospitalDate;
    /**  医嘱项目代码  */
    private String ordersItemCode;
    /**  医嘱项目名称  */
    private String ordersItemName;
    /** 医嘱类别代码   */
    private String ordersCategCode;
    /** 医嘱类别名称   */
    private String ordersCategName;
    /**  医嘱内容  */
    private String ordersContent;
    /** 长期临时标志   */
    private String longOnceFlag;
    /** 医嘱执行状态代码   */
    private String ordersExecutStatusCode;
    /**  医嘱开始日期  */
    private String ordersBeginDate;
    /** 医嘱结束日期   */
    private String ordersEndDate;
    /** 医嘱开立医生工号   */
    private String ordersOpenDrCode;
    /** 医嘱开立医生姓名   */
    private String ordersOpenDrName;
    /** 医嘱开立科室名称   */
    private String ordersOpenDeptName;
    /**  医嘱开立日期  */
    private String ordersDate;
    /**  医嘱计划开始日期  */
    private String ordersPlanBeginDate;
    /**  医嘱计划结束日期  */
    private String ordersPlanEndDate;
    /**  医嘱审核医生工号  */
    private String ordersProofDrCode;
    /** 医嘱审核医生姓名   */
    private String ordersProofDrName;
    /** 医嘱核对护士工号   */
    private String ordersAuditNurseCode;
    /** 医嘱核对护士姓名   */
    private String ordersAuditNurseName;
    /** 医嘱核对日期   */
    private String ordersAuditDate;
    /**  医嘱审核日期  */
    private String ordersProofDate;
    /** 医嘱执行科室名称   */
    private String ordersExecutDeptName;
    /** 医嘱执行护士工号   */
    private String ordersExecutNurseCode;
    /** 医嘱执行护士姓名   */
    private String ordersExecutNurseName;
    /** 医嘱执行开始日期   */
    private String ordersExecutBeginDate;
    /** 医嘱执行完成日期   */
    private String ordersExecutFinishDate;
    /** 医嘱停止医生工号   */
    private String ordersStopDrCode;
    /** 医嘱停止医生姓名   */
    private String ordersStopDrName;
    /** 医嘱停止日期   */
    private String ordersStopDate;
    /** 医嘱取消医生工号 */
    private String ordersCancelDrCode;
    /** 医嘱取消医生姓名   */
    private String ordersCancelDrName;
    /** 医嘱取消日期   */
    private String ordersCancelDate;
    /** 录入日期   */
    private String recordDate;

}
