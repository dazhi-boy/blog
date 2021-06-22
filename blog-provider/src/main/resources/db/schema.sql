-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `username` varchar(30) NOT NULL COMMENT '账号',
 `nickname` varchar(30) NOT NULL COMMENT '昵称',
 `password` varchar(30) NOT NULL COMMENT '密码',
 `phone` varchar (30) COMMENT '手机号',
 `email` varchar (30) COMMENT '邮箱'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

-- 主题表
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '主题名',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `image` varchar(128) NOT NULL COMMENT '图片路径'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '主题表';

-- 景区列表
-- DROP TABLE IF EXISTS `attractions`;
-- CREATE TABLE `attractions` (
--  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
--  `version` bigint(20) NOT NULL DEFAULT 0,
--  `del_time` varchar(30),
--  `name` varchar(30) NOT NULL COMMENT '标题',
--  `keywords` varchar(255) NOT NULL COMMENT '关键字',
--  `image` varchar(128) NOT NULL COMMENT '图片路径',
--  `description` varchar(255) NOT NULL COMMENT '描述',
--  `theme_id` bigint(20) NOT NULL COMMENT '主题id',
--  `user_id` bigint(20) NOT NULL COMMENT '所属用户id',
--  `longitude` bigint(20) NOT NULL COMMENT '经度',
--  `latitude` bigint(20) NOT NULL COMMENT '纬度',
--  `province` varchar(20) NOT NULL COMMENT '省',
--  `city` varchar(20) NOT NULL COMMENT '市'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '景区列表';

-- 景区图文介绍
-- DROP TABLE IF EXISTS `attractions_detail`;
-- CREATE TABLE `attractions_detail` (
--  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
--  `version` bigint(20) NOT NULL DEFAULT 0,
--  `del_time` varchar(30),
--  `name` varchar(128) NOT NULL COMMENT '标题',
--  `image` varchar(128) NOT NULL COMMENT '图片路径',
--  `description` varchar(255) NOT NULL COMMENT '描述',
--  `attractions_id` bigint(20) NOT NULL COMMENT '景区id'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '景区图文介绍';

-- 活动列表
-- DROP TABLE IF EXISTS `activity`;
-- CREATE TABLE `activity` (
--  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
--  `version` bigint(20) NOT NULL DEFAULT 0,
--  `del_time` varchar(30),
--  `name` varchar(30) NOT NULL COMMENT '标题',
--  `keywords` varchar(255) NOT NULL COMMENT '关键字',
--  `image` varchar(128) NOT NULL COMMENT '图片路径',
--  `description` varchar(255) NOT NULL COMMENT '描述',
--  `theme_id` bigint(20) NOT NULL COMMENT '主题id',
--  `user_id` bigint(20) NOT NULL COMMENT '所属用户id',
--  `longitude` bigint(20) NOT NULL COMMENT '经度',
--  `latitude` bigint(20) NOT NULL COMMENT '纬度',
--  `province` varchar(20) NOT NULL COMMENT '省',
--  `city` varchar(20) NOT NULL COMMENT '市',
--  `create_time` varchar(20) COMMENT '创建时间',
--  `begin_time` varchar(20) COMMENT '活动开始时间',
--  `end_time` varchar(20) COMMENT '活动结束时间',
--  `star` bigint(20) COMMENT '是否推荐'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '景区列表';

-- 景区图文介绍
-- DROP TABLE IF EXISTS `activity_detail`;
-- CREATE TABLE `activity_detail` (
--  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
--  `version` bigint(20) NOT NULL DEFAULT 0,
--  `del_time` varchar(30),
--  `name` varchar(128) NOT NULL COMMENT '标题',
--  `image` varchar(128) NOT NULL COMMENT '图片路径',
--  `description` varchar(255) NOT NULL COMMENT '描述',
--  `activity_id` bigint(20) NOT NULL COMMENT '活动id'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '活动图文介绍';

-- 景区列表
DROP TABLE IF EXISTS `attractions`;
CREATE TABLE `attractions` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '标题',
 `keywords` varchar(255) COMMENT '关键字',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `theme_id` bigint(20) COMMENT '主题id',
 `user_id` bigint(20) COMMENT '所属用户id',
 `longitude` bigint(20) COMMENT '经度',
 `latitude` bigint(20) COMMENT '纬度',
 `province` varchar(20) COMMENT '省',
 `city` varchar(20) COMMENT '市'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '景区列表';

-- 景区图文介绍
DROP TABLE IF EXISTS `attractions_detail`;
CREATE TABLE `attractions_detail` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(128) NOT NULL COMMENT '标题',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `attractions_id` bigint(20) NOT NULL COMMENT '景区id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '景区图文介绍';

-- 活动列表
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '标题',
 `keywords` varchar(255) COMMENT '关键字',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `theme_id` bigint(20) COMMENT '主题id',
 `user_id` bigint(20) COMMENT '所属用户id',
 `longitude` bigint(20) COMMENT '经度',
 `latitude` bigint(20) COMMENT '纬度',
 `province` varchar(20) COMMENT '省',
 `city` varchar(20) COMMENT '市',
 `create_time` varchar(20) COMMENT '创建时间',
 `begin_time` varchar(20) COMMENT '活动开始时间',
 `end_time` varchar(20) COMMENT '活动结束时间',
 `star` bigint(20) COMMENT '是否推荐'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '景区列表';

-- 景区图文介绍
DROP TABLE IF EXISTS `activity_detail`;
CREATE TABLE `activity_detail` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(128) NOT NULL COMMENT '标题',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `activity_id` bigint(20) NOT NULL COMMENT '活动id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '活动图文介绍';

-- 教学视频
-- DROP TABLE IF EXISTS `tutorial_tv`;
CREATE TABLE IF NOT EXISTS `tutorial_tv` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(128) NOT NULL COMMENT '标题',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `tv` varchar(1024) NOT NULL COMMENT '视频路径',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `pid` bigint(20) NOT NULL COMMENT '视频分类id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '教学视频';

-- 视频分类
-- DROP TABLE IF EXISTS `tv_classification`;
CREATE TABLE IF NOT EXISTS `tv_classification` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '主题名',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `level` bigint(20) NOT NULL COMMENT '层级',
 `pid` bigint(20) COMMENT '父标签'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '视频分类';

-- 美食列表
-- CREATE TABLE IF NOT EXISTS `food` (
-- DROP TABLE IF EXISTS `food`;
CREATE TABLE IF NOT EXISTS `food` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '食物名',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `type` bigint(20) NOT NULL COMMENT '分类：外卖，大餐，自己做',
 `open_id` varchar(50) COMMENT '所属用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '美食列表';

-- 单词表
CREATE TABLE IF NOT EXISTS `word` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `term` varchar(30) NOT NULL UNIQUE COMMENT '词',
 `translate` varchar(30) NOT NULL UNIQUE COMMENT '翻译',
 `status` varchar(10) COMMENT '状态',
 `frequency` integer COMMENT '出现次数',
 `grade` varchar(10) COMMENT '级别',
 `user_id` bigint(20) COMMENT '所属用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '单词表';

-- 单词等级
CREATE TABLE IF NOT EXISTS `word_grade` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `code` varchar(30) NOT NULL UNIQUE COMMENT '级别key',
 `grade` varchar(30) NOT NULL UNIQUE COMMENT '级别',
 `image` varchar(128) NOT NULL COMMENT '图片路径'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '单词等级';
