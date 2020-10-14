-- 主题表
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '主题名',
 `description` varchar(255) NOT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '主题表';

-- 景区列表
DROP TABLE IF EXISTS `attractions`;
CREATE TABLE `attractions` (
 `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `version` bigint(20) NOT NULL DEFAULT 0,
 `del_time` varchar(30),
 `name` varchar(30) NOT NULL COMMENT '标题',
 `keywords` varchar(255) NOT NULL COMMENT '关键字',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `theme_id` bigint(20) NOT NULL COMMENT '主题id',
 `user_id` bigint(20) NOT NULL COMMENT '所属用户id',
 `longitude` bigint(20) NOT NULL COMMENT '经度',
 `latitude` bigint(20) NOT NULL COMMENT '纬度',
 `province` varchar(20) NOT NULL COMMENT '省',
 `city` varchar(20) NOT NULL COMMENT '市'
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
 `keywords` varchar(255) NOT NULL COMMENT '关键字',
 `image` varchar(128) NOT NULL COMMENT '图片路径',
 `description` varchar(255) NOT NULL COMMENT '描述',
 `theme_id` bigint(20) NOT NULL COMMENT '主题id',
 `user_id` bigint(20) NOT NULL COMMENT '所属用户id',
 `longitude` bigint(20) NOT NULL COMMENT '经度',
 `latitude` bigint(20) NOT NULL COMMENT '纬度',
 `province` varchar(20) NOT NULL COMMENT '省',
 `city` varchar(20) NOT NULL COMMENT '市',
 `create_time` varchar(20) NOT NULL COMMENT '创建时间',
 `begin_time` varchar(20) NOT NULL COMMENT '活动开始时间',
 `end_time` varchar(20) NOT NULL COMMENT '活动结束时间'
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