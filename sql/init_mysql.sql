create database gdupi;
use gdupi;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT '编号',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `password` varchar(256) NOT NULL COMMENT '名称',
  `role` int(11) NOT NULL COMMENT '权限',
    `create_date` datetime NOT NULL COMMENT '创建时间',
    `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
   KEY `sys_role_name` (`name`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
