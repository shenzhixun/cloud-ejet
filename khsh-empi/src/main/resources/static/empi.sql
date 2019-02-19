-- -----------------------------------------------
-- empi注册信息表 `pix_empi_register`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_register`;
CREATE TABLE `pix_empi_register` (
  `id`                  int(11)           NOT NULL AUTO_INCREMENT,
  `uuid`                varchar(100)      NOT NULL COMMENT      '注册uuid号',
  `empi`                varchar(100)      NOT NULL COMMENT      '患者主索引empi',
  `reg_corp_id`         varchar(200)      DEFAULT NULL COMMENT  '注册机构id',
  `reg_corp_name`       varchar(200)      DEFAULT NULL COMMENT  '注册机构名称',
  `reg_sys_id`          varchar(200)      DEFAULT NULL COMMENT  '注册应用系统id',
  `reg_time`            varchar(32)       DEFAULT NULL COMMENT  '注册时间',
  `name`                varchar(100)      DEFAULT NULL COMMENT  '患者姓名',
  `name_pin`            varchar(100)      DEFAULT NULL COMMENT  '名字拼音',
  `sex`                 tinyint(2)        DEFAULT NULL COMMENT  '性别 1：男 2：女',
  `age`                 int(3)            DEFAULT NULL COMMENT  '年龄',
  `birthday`            varchar(50)       DEFAULT NULL COMMENT  '出生日期yyyy.MM.dd',

  `id_card`             varchar(20)      DEFAULT NULL COMMENT  '身份证',
  `yibao_card`          varchar(100)      DEFAULT NULL COMMENT  '医保卡',
  `jiuzhen_card`        varchar(100)      DEFAULT NULL COMMENT  '就诊卡',

  `patient_id`          varchar(100)      DEFAULT NULL COMMENT  '患者id',

  `huzhao_card`         varchar(100)      DEFAULT NULL COMMENT  '护照',

  `empi_flag`           tinyint(2)        DEFAULT NULL COMMENT  '是否主索引标志 1：是 2：否',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
   PRIMARY KEY (`id`),
   UNIQUE INDEX `empi` (`empi`) USING BTREE,
   UNIQUE INDEX `id_card_flag`  (`id_card`,`empi_flag`) USING BTREE,
   KEY `patient` (`reg_corp_id`,`patient_id`) USING BTREE
) comment='empi注册信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- 注册扩展信息表 `pix_empi_register_ext`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_register_ext`;
CREATE TABLE `pix_empi_register_ext` (
  `id`                  int(11)           NOT NULL AUTO_INCREMENT,
  `reg_uuid`            varchar(100)      NOT NULL COMMENT      '注册uuid号',
  `empi`                varchar(100)      NOT NULL COMMENT      '患者empi',

  `country`             varchar(10)      DEFAULT NULL COMMENT  '国家',
  `country_name`        varchar(100)      DEFAULT NULL COMMENT  '国家',
  `nation`              varchar(10)      DEFAULT NULL COMMENT  '民族',
  `nation_name`         varchar(100)      DEFAULT NULL COMMENT  '民族',
  `edu_degree`          varchar(32)       DEFAULT NULL COMMENT  '文化程度',
  `job`                 varchar(10)      DEFAULT NULL COMMENT  '职业',
  `job_name`            varchar(100)      DEFAULT NULL COMMENT  '职业',
  `marriage_state`      varchar(10)      DEFAULT NULL COMMENT  '婚姻状况',
  `marriage_state_name` varchar(100)      DEFAULT NULL COMMENT  '婚姻状况',
  `phone`               varchar(50)      DEFAULT NULL COMMENT  '联系电话',
  `addr_province`       varchar(100)      DEFAULT NULL COMMENT  '联系人 省',
  `addr_city`           varchar(100)      DEFAULT NULL COMMENT  '联系人 地市',
  `addr_area`           varchar(100)      DEFAULT NULL COMMENT  '联系人 区域（县）',
  `addr_detail`         varchar(1000)     DEFAULT NULL COMMENT  '联系人 详细地址',
  `zip_code`            varchar(20)       DEFAULT NULL COMMENT  '邮政编码',

  `email`               varchar(100)      DEFAULT NULL COMMENT  '邮箱',
  `work_dept`           varchar(200)      DEFAULT NULL COMMENT  '工作单位',
  `work_address`        varchar(200)      DEFAULT NULL COMMENT  '工作单位地址',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
  `gson_ext`             longtext        COMMENT '扩展',
   PRIMARY KEY (`id`),
   UNIQUE INDEX `empi` (`empi`) USING BTREE
) comment='注册扩展信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- -----------------------------------------------
-- empi信息表 `pix_empi`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi`;
CREATE TABLE `pix_empi` (
  `id`                  int(11)           NOT NULL AUTO_INCREMENT,
  `reg_uuid`            varchar(100)      NOT NULL COMMENT      '注册uuid号',
  `empi`                varchar(100)      NOT NULL COMMENT      '患者主索引empi',
  `username`            varchar(100)      DEFAULT NULL COMMENT  '用户姓名',
  `passowrd`            varchar(100)      DEFAULT NULL COMMENT  '用户密码，可以用户患者登录或者加密',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
   PRIMARY KEY (`id`),
   UNIQUE INDEX `empi` (`empi`) USING BTREE
) comment='empi信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- empi身份识别信息表 `pix_empi_identity`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_identity`;
CREATE TABLE `pix_empi_identity` (

  `id`                  int(11)           NOT NULL AUTO_INCREMENT,
  `reg_uuid`            varchar(100)      NOT NULL COMMENT      '注册uuid号',
  `empi`                varchar(100)      NOT NULL COMMENT      '患者empi',
  `id_type`             tinyint(2)        DEFAULT NULL COMMENT  '身份识别类型id',
  `id_name`             varchar(100)      DEFAULT NULL COMMENT  '身份识别号码',
  `id_code`             varchar(100)      DEFAULT NULL COMMENT  '身份识别编码',
  `id_no`               varchar(32)       DEFAULT NULL COMMENT  '身份识别号码',
  `id_flag`             varchar(32)       DEFAULT NULL COMMENT  '缺省标识',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
   PRIMARY KEY (`id`)
) comment='empi身份识别信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- -----------------------------------------------
-- empi身份识别联系人信息表 `pix_empi_identity_contact`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_identity_contact`;
CREATE TABLE `pix_empi_identity_contact` (

  `id`                  int(11)           NOT NULL AUTO_INCREMENT,
  `reg_uuid`            varchar(100)      NOT NULL COMMENT      '注册uuid号',
  `empi`                varchar(100)      NOT NULL COMMENT      '患者empi',
  `relation`            varchar(100)      DEFAULT NULL COMMENT  '与患者关系 1:本人 ',

  `rel_name`            varchar(100)      DEFAULT NULL COMMENT  '联系人 姓名',
  `rel_name_pin`        varchar(100)      DEFAULT NULL COMMENT  '联系人 名字拼音',
  `rel_sex`             tinyint(2)        DEFAULT NULL COMMENT  '联系人 性别 1：男 2：女',
  `rel_phone`           varchar(50)      DEFAULT NULL COMMENT  '联系人 电话',
  `rel_addr_province`   varchar(100)      DEFAULT NULL COMMENT  '联系人 省',
  `rel_addr_city`       varchar(100)      DEFAULT NULL COMMENT  '联系人 地市',
  `rel_addr_area`       varchar(100)      DEFAULT NULL COMMENT  '联系人 区域（县）',
  `rel_addr_detail`     varchar(1000)     DEFAULT NULL COMMENT  '联系人 详细地址',
  `rel_zip_code`        varchar(20)       DEFAULT NULL COMMENT  '邮政编码',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
   PRIMARY KEY (`id`)
) comment='empi身份识别联系人信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- empi权重配置 `pix_empi_weight_config`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_weight_config`;
CREATE TABLE `pix_empi_weight_config` (
  `id`                  int(11)           NOT NULL AUTO_INCREMENT,

  `conf_name`           varchar(100)      DEFAULT NULL COMMENT  '配置名称',
  `conf_type`           varchar(100)      DEFAULT NULL COMMENT  '配置类型',
  `conf_code`           varchar(100)      DEFAULT NULL COMMENT  '配置编码',
  `priority`            int(11)           DEFAULT NULL COMMENT  '优先级',
  `weight_value`        int(11)           DEFAULT NULL COMMENT  '权重值, 小1',
  `nullable`            int(1)            DEFAULT NULL COMMENT  '是否允许为空, 1: 允许为空  0：不允许为空',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
   PRIMARY KEY (`id`)
) comment='empi权重配置'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- empi日志信息 `pix_empi_log`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_log`;
CREATE TABLE `pix_empi_log` (
  `id`              int(11) NOT NULL AUTO_INCREMENT,
  `log_level`       int(11) NOT NULL DEFAULT '0'  COMMENT '日志级别, 1：debug，2：info 3：warn 4：error',
  `log_subject`     varchar(100) DEFAULT NULL     COMMENT '日志简述',
  `log_detail`      text                          COMMENT '日志详情',
  `log_result`      int(2) DEFAULT '-1'         COMMENT '结果：1：成功 0：失败',
  `before_buss_id`  varchar(100) DEFAULT NULL   COMMENT '开始业务id',
  `after_buss_id`   varchar(100) DEFAULT NULL   COMMENT '最后业务id',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
  `ext1`                varchar(100)       DEFAULT NULL COMMENT '扩展',
  PRIMARY KEY (`id`),
  KEY `log_level` (`log_level`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- -----------------------------------------------
-- empi交叉索引关联关系表 `pix_empi_r`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_r`;
CREATE TABLE `pix_empi_r` (
  `id`                  bigint(20) NOT NULL AUTO_INCREMENT,
  `empi`                varchar(100)      NOT NULL COMMENT      '患者empi',
  `rel_empi`            varchar(100)      NOT NULL COMMENT      '关联患者empi',
  `rel_flag`            varchar(100)      NOT NULL COMMENT      '关联关系 1： 被关联 2：',

  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `empi` (`empi`) USING BTREE,
  UNIQUE INDEX `rel_empi` (`rel_empi`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='empi交叉索引关联关系表';

-- -----------------------------------------------
-- empi与HIS关联信息表，患者住院、床位、patientId、inpatientId关联 `pix_empi_r`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_his_r`;
CREATE TABLE `pix_empi_his_r` (
  `id`                  bigint(20) NOT NULL AUTO_INCREMENT,
  `empi`                varchar(100)      NOT NULL COMMENT      '患者empi',
  `reg_corp_id`         varchar(200)      DEFAULT NULL COMMENT  '注册机构id',
  `patient_id`          varchar(100)      NOT NULL COMMENT  '患者id',
  `visit_type`          varchar(100)      NOT NULL COMMENT  '就诊类型',
  `visit_type_code`     varchar(100)      DEFAULT NULL COMMENT  '就诊类型标志',
  `inpatient_id`        varchar(100)      NOT NULL COMMENT  '患者住院id',
  `in_hospital_id`      varchar(100)      DEFAULT NULL COMMENT  '住院号',
  `in_hospital_date`    varchar(100)      DEFAULT NULL COMMENT  '住院日期',
  `bed_id`              varchar(100)      DEFAULT NULL COMMENT  '床位号',
  `in_dept_name`        varchar(100)      DEFAULT NULL COMMENT  '入院科室',
  `out_dept_name`       varchar(100)      DEFAULT NULL COMMENT  '转出科室',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',
  `ext`                 varchar(100)      DEFAULT NULL COMMENT '扩展',
  PRIMARY KEY (`id`),
  INDEX `empi` (`empi`) USING BTREE,
  UNIQUE INDEX `patient_id` (`patient_id`, `reg_corp_id`) USING BTREE,
  UNIQUE INDEX `inpatient_id` (`inpatient_id`, `reg_corp_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='empi与HIS关联信息表';
