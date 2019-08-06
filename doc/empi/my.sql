CREATE TABLE `om_orders_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empi` varchar(100) NOT NULL COMMENT '患者主索引',
  `visit_corp` varchar(100) DEFAULT NULL COMMENT '就诊医疗机构代码',
  `visit_corp_name` varchar(255) DEFAULT NULL COMMENT '就诊医疗机构名称',
  `visit_type` varchar(16) DEFAULT NULL COMMENT '就诊类型->门诊、住院',
  `visit_type_code` tinyint(2) DEFAULT '1' COMMENT ' 就诊类型标识 1：门诊 2：住院',
  `orders_no` varchar(100) DEFAULT NULL COMMENT '医嘱号',
  `in_hospital_date` datetime DEFAULT NULL COMMENT '就诊时间or入院时间',
  `in_hospital_id` varchar(100) DEFAULT NULL COMMENT '门诊号or住院号',
  `inhosp_num` int(11) DEFAULT NULL COMMENT '住院次数',
  `bed_id` varchar(100) DEFAULT NULL COMMENT '床位号',
  `in_dept_name` varchar(100) DEFAULT NULL COMMENT '入院科室',
  `out_dept_name` varchar(100) DEFAULT NULL COMMENT '转出科室',
  `out_hospital_date` datetime DEFAULT NULL COMMENT '出院时间',

  `orders_item_code` varchar(100) DEFAULT NULL COMMENT '医嘱项目代码',
  `orders_item_name` varchar(100) DEFAULT NULL COMMENT '医嘱项目名称',
  `orders_categ_code` varchar(100) DEFAULT NULL COMMENT '医嘱类别代码',
  `orders_categ_name` varchar(100) DEFAULT NULL COMMENT '医嘱类别名称',
  `orders_content` text DEFAULT NULL COMMENT '医嘱内容',
  `long_once_flag`  varchar(128) DEFAULT NULL COMMENT '长期临时标志',

  `orders_execute_status_code` varchar(32) DEFAULT NULL COMMENT '医嘱执行状态代码',
  `orders_begin_date` datetime DEFAULT NULL COMMENT '医嘱开始日期',
  `orders_end_date` datetime DEFAULT NULL COMMENT '医嘱结束日期',

  `orders_open_dr_code` varchar(128) DEFAULT NULL COMMENT '医嘱开立医生工号',
  `orders_open_dr_name` varchar(128) DEFAULT NULL COMMENT '医嘱开立医生姓名',
  `orders_open_dept_name` varchar(128) DEFAULT NULL COMMENT '医嘱开立科室名称',

  `orders_date` datetime DEFAULT NULL COMMENT '医嘱开立日期',
  `orders_plan_begin_date` datetime DEFAULT NULL COMMENT '医嘱计划开始日期',
  `orders_plan_end_date` datetime DEFAULT NULL COMMENT '医嘱计划结束日期',
  `orders_proof_dr_code` varchar(128) DEFAULT NULL COMMENT '医嘱审核医生工号',
  `orders_proof_dr_name` varchar(128) DEFAULT NULL COMMENT '医嘱审核医生姓名',
  `orders_audit_nurse_code` varchar(128) DEFAULT NULL COMMENT '医嘱核对护士工号',
  `orders_audit_nurse_name` varchar(128) DEFAULT NULL COMMENT '医嘱核对护士姓名',

  `orders_audit_date` datetime DEFAULT NULL COMMENT '医嘱核对日期',
  `orders_proof_date` datetime DEFAULT NULL COMMENT '医嘱审核日期',
  `orders_execut_dept_name` varchar(128) DEFAULT NULL COMMENT '医嘱执行科室名称',
  `orders_execut_nurse_code` varchar(128) DEFAULT NULL COMMENT '医嘱执行护士工号',
  `orders_execut_nurse_name` varchar(128) DEFAULT NULL COMMENT '医嘱执行护士姓名',

  `orders_execut_begin_date` varchar(128) DEFAULT NULL COMMENT '医嘱执行开始日期',
  `orders_execut_finish_date` varchar(128) DEFAULT NULL COMMENT '医嘱执行完成日期',

  `orders_stop_dr_code` varchar(128) DEFAULT NULL COMMENT '医嘱停止医生工号',
  `orders_stop_dr_name` varchar(128) DEFAULT NULL COMMENT '医嘱停止医生姓名',
  `orders_stop_date` varchar(128) DEFAULT NULL COMMENT '医嘱停止日期',
  `orders_cancel_dr_code` varchar(128) DEFAULT NULL COMMENT '医嘱取消医生工号',
  `orders_cancel_dr_name` varchar(128) DEFAULT NULL COMMENT '医嘱取消医生姓名',
  `orders_cancel_date` varchar(128) DEFAULT NULL COMMENT '医嘱取消日期',
  `record_date` varchar(128) DEFAULT NULL COMMENT '录入日期',

  PRIMARY KEY (`id`)
) comment='医嘱明细表' ENGINE=InnoDB DEFAULT CHARSET=utf8;

