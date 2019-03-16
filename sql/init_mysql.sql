create database dev;
use dev;

DROP TABLE IF EXISTS `base`;
CREATE TABLE `base` (
  `id` int(11) NOT NULL COMMENT '编号',
  `name` varchar(64) NOT NULL COMMENT '名称',
    `createdate` datetime NOT NULL COMMENT '创建时间',
    `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
   KEY `sys_role_name` (`name`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='base表';
