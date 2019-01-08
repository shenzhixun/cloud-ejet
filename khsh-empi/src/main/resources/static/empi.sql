-- -----------------------------------------------
-- empi注册信息表 `pix_empi_register`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_register`;
CREATE TABLE `pix_empi_register` (
  `id`                  int(11)           NOT NULL AUTO_INCREMENT,
  `uuid`                varchar(100)      NOT NULL COMMENT      '注册uuid号',
  `empi`                varchar(100)      NOT NULL COMMENT      '患者主索引empi',
  `reg_corp_id`         varchar(200)      DEFAULT NULL COMMENT  '注册机构id',
  `reg_sys_id`          varchar(200)      DEFAULT NULL COMMENT  '注册应用系统id',
  `reg_time`            varchar(32)       DEFAULT NULL COMMENT  '注册时间',
  `name`                varchar(100)      DEFAULT NULL COMMENT  '患者姓名',
  `name_pin`            varchar(100)      DEFAULT NULL COMMENT  '名字拼音',
  `sex`                 tinyint(2)        DEFAULT NULL COMMENT  '性别 1：男 2：女',
  `birthday`            varchar(16)       DEFAULT NULL COMMENT  '出生日期yyyy.MM.dd',

  `patient_id`          varchar(100)      DEFAULT NULL COMMENT  '患者id',
  `empi_flag`           tinyint(2)        DEFAULT NULL COMMENT  '是否主索引标志 1：是 2：否',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',

   PRIMARY KEY (`id`)
) comment='empi注册信息表'
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

   PRIMARY KEY (`id`)
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
  `id_type`             varchar(100)      DEFAULT NULL COMMENT  '身份识别类型id',
  `id_code`             varchar(100)      DEFAULT NULL COMMENT  '身份识别编码',
  `id_no`               varchar(32)       DEFAULT NULL COMMENT  '身份识别号码',
  `id_flag`             varchar(32)       DEFAULT NULL COMMENT  '缺省标识',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',

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
  `relation`            varchar(100)      DEFAULT NULL COMMENT  '与患者关系 1: 父亲  2：母亲 3：儿子  4：女儿  ',

  `rel_name`            varchar(100)      DEFAULT NULL COMMENT  '联系人 姓名',
  `rel_name_pin`        varchar(100)      DEFAULT NULL COMMENT  '联系人 名字拼音',
  `rel_sex`             tinyint(2)        DEFAULT NULL COMMENT  '联系人 性别 1：男 2：女',
  `rel_phone`           varchar(100)      DEFAULT NULL COMMENT  '联系人 电话',
  `addr_province`       varchar(100)      DEFAULT NULL COMMENT  '联系人 省',
  `addr_city`           varchar(100)      DEFAULT NULL COMMENT  '联系人 地市',
  `addr_area`           varchar(100)      DEFAULT NULL COMMENT  '联系人 区域（县）',
  `addr_detail`         varchar(1000)     DEFAULT NULL COMMENT  '联系人 详细地址',
  `zip_code`            varchar(20)       DEFAULT NULL COMMENT  '邮政编码',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',

   PRIMARY KEY (`id`)
) comment='empi身份识别联系人信息表'
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

  `country`             varchar(100)      DEFAULT NULL COMMENT  '国家',
  `nation`              varchar(100)      DEFAULT NULL COMMENT  '民族',
  `edu_degree`          varchar(32)       DEFAULT NULL COMMENT  '文化程度',
  `job`                 varchar(100)      DEFAULT NULL COMMENT  '职业',
  `phone`               varchar(100)      DEFAULT NULL COMMENT  '联系电话',
  `email`               varchar(100)      DEFAULT NULL COMMENT  '邮箱',

  `marriage_state`      varchar(100)      DEFAULT NULL COMMENT  '婚姻状况',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',

   PRIMARY KEY (`id`)
) comment='注册扩展信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- empi权重配置 `pix_empi_weight_config`
-- -----------------------------------------------
DROP TABLE IF EXISTS `pix_empi_weight_config`;
CREATE TABLE `pix_empi_weight_config` (
  `id`                  int(11)           NOT NULL AUTO_INCREMENT,

  `name`                varchar(100)      DEFAULT NULL COMMENT  '配置名称',
  `weight_code`         varchar(100)      DEFAULT NULL COMMENT  '配置编码',
  `priority`            int(11)           DEFAULT NULL COMMENT  '优先级',
  `weight_value`        int(11)           DEFAULT NULL COMMENT  '权重值, 小1',

  `status`              tinyint(2)        DEFAULT NULL COMMENT  '状态标识 1：正常 0：禁用',
  `remark`              varchar(200)      DEFAULT NULL COMMENT  '备注',
  `create_by`           varchar(32)       DEFAULT NULL COMMENT '创建人',
  `create_time`         varchar(32)       DEFAULT NULL COMMENT '创建时间',
  `update_time`         varchar(32)       DEFAULT NULL COMMENT '修改时间',

   PRIMARY KEY (`id`)
) comment='empi权重配置'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;
