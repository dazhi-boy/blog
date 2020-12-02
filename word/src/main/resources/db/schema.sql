-- 主题表
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '主题名',
 `description` varchar(255) NOT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '主题表';


-- 单词表
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `term` varchar(30) NOT NULL UNIQUE COMMENT '词',
 `status` varchar(10) COMMENT '状态',
 `frequency` integer COMMENT '出现次数',
 `grade` varchar(10) COMMENT '级别',
 `user_id` bigint(20) COMMENT '所属用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '单词表';
