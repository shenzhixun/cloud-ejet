CREATE TABLE `pix_empi_identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empi` varchar(100) NOT NULL COMMENT '患者主id，empi',
  `sys_id` varchar(100) DEFAULT NULL COMMENT '业务系统id',
  `patient_id` varchar(100) DEFAULT NULL COMMENT '病人id',
  `name` varchar(16) DEFAULT NULL COMMENT '诊断数据',
  `sex` tinyint(2) DEFAULT '0' COMMENT '性别 1：男 2：女',
  `birthday` varchar(16) DEFAULT NULL COMMENT '出生日期yyyy.MM.dd',
  `birthplace` varchar(512) DEFAULT NULL COMMENT '出生地',
  `nation` varchar(32) DEFAULT NULL COMMENT '民族',
  `mother_name` varchar(16) DEFAULT NULL COMMENT '母亲姓名',
  `marital_status` tinyint(2) DEFAULT NULL COMMENT '婚姻状况 1: 未婚 2:已婚 3:合法分居 4:离婚 5:丧偶 6:订婚 7:婚姻无效',
  PRIMARY KEY (`id`),
  KEY `patient_doc_id` (`empi`,`sys_id`) USING BTREE,
  KEY `status` (`nation`) USING BTREE,
  KEY `patient_id` (`empi`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





-- -----------------------------------------------
-- empi患者主索引 `empi_index`
-- -----------------------------------------------
DROP TABLE IF EXISTS `empi_index`;
CREATE TABLE `empi_index` (
       `id`          		  int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `empi`  			      varchar(100)		NOT NULL  					      COMMENT '患者empi号' ,
       `nickname`  			  varchar(64)		  NOT NULL  					      COMMENT '昵称' ,
       `password`  	      varchar(100) 		NOT NULL                  COMMENT '密码',
       `account_type`     int(2)          DEFAULT NULL              COMMENT '账号类型 0：super管理员   1：管理员 2：普通用户',
       `account_state`    int(2)          DEFAULT NULL              COMMENT '账号状态 1:为启用   0:停用',
       `effect_start`     varchar(32)     DEFAULT NULL              COMMENT '有效期限开始时间',
       `effect_end`       varchar(32)     DEFAULT NULL              COMMENT '有效期限结束时间',
       `last_login`       varchar(32)     DEFAULT NULL              COMMENT '最后登录时间',
       `login_state`      tinyint(1) 			NOT NULL  DEFAULT '1'     COMMENT '登录状态, 1: 在线，0：未登录',
       `status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				  varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `create_time`  		varchar(32) 		NULL DEFAULT NULL  			  COMMENT '创建时间',
       `create_by`  		  varchar(100) 		NULL DEFAULT NULL  			  COMMENT '创建人' ,
       `modify_time`  		varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_by`  		  varchar(100) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					  varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `name` (`name`) USING BTREE,
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE
)  comment='登录账号信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

