-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `username` varchar(30) NOT NULL COMMENT '用户名',
 `password` varchar(30) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

