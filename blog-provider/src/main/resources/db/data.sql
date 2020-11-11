/*mock data***/
-- 主题数据
INSERT INTO theme (name, description)
VALUES
('旅游', '这是旅游专栏'),
('活动', '大家一起嗨');

-- 景区数据
INSERT INTO attractions (name, keywords, image, description, theme_id, user_id, longitude, latitude, province, city)
VALUES
('凤凰岭一日游', '#凤凰岭#，#一日游#', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，有好多树', 1, 1, 80, 124, '北京市', '北京市'),
('慕田峪长城一日游', '#慕田峪#，#一日游#', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，有好多树', 1, 1, 80, 124, '北京市', '北京市'),
('凤凰岭一日游', '#凤凰岭#，#一日游#', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，有好多树', 1, 1, 80, 124, '北京市', '北京市'),
('慕田峪长城一日游', '#慕田峪#，#一日游#', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，有好多树', 1, 1, 80, 124, '北京市', '北京市'),
('凤凰岭一日游', '#凤凰岭#，#一日游#', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，有好多树', 1, 1, 80, 124, '北京市', '北京市'),
('慕田峪长城一日游', '#慕田峪#，#一日游#', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，有好多树', 1, 1, 80, 124, '北京市', '北京市');

-- 景区图文介绍

INSERT INTO attractions_detail (name, image, description, attractions_id)
VALUES
('图1', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，图1', 1),
('图2', 'http://154.8.146.181:8082/img/2.jpg', '凤凰岭是一座山，图2', 1),
('图1', 'http://154.8.146.181:8082/img/1.jpg', '慕田峪长城很好玩，图1', 2),
('图2', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，图2', 2);

-- 活动列表
INSERT INTO activity (name, keywords, image, description, theme_id, user_id, longitude, latitude, province, city, create_time, begin_time, end_time, star)
VALUES
('凤凰岭一日游', '#凤凰岭#，#一日游#', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，有好多树', 1, 1, 80, 124, '北京市', '北京市', now(), now(), now(), 1),
('慕田峪长城一日游', '#慕田峪#，#一日游#', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，有好多树', 1, 1, 80, 124, '北京市', '北京市', now(), now(), now(), 1),
('凤凰岭一日游', '#凤凰岭#，#一日游#', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，有好多树', 1, 1, 80, 124, '北京市', '北京市', now(), now(), now(), 1),
('慕田峪长城一日游', '#慕田峪#，#一日游#', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，有好多树', 1, 1, 80, 124, '北京市', '北京市', now(), now(), now(), 2),
('凤凰岭一日游', '#凤凰岭#，#一日游#', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，有好多树', 1, 1, 80, 124, '北京市', '北京市', now(), now(), now(), 2),
('慕田峪长城一日游', '#慕田峪#，#一日游#', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，有好多树', 1, 1, 80, 124, '北京市', '北京市', now(), now(), now(), 2);

-- 景区图文介绍
INSERT INTO activity_detail (name, image, description, activity_id)
VALUES
('图1', 'http://154.8.146.181:8082/img/1.jpg', '凤凰岭是一座山，图1', 1),
('图2', 'http://154.8.146.181:8082/img/2.jpg', '凤凰岭是一座山，图2', 1),
('图1', 'http://154.8.146.181:8082/img/1.jpg', '慕田峪长城很好玩，图1', 2),
('图2', 'http://154.8.146.181:8082/img/2.jpg', '慕田峪长城很好玩，图2', 2);

-- 景区图文介绍
INSERT INTO tutorial_tv (name, image, tv, description, theme_id)
VALUES
('凤凰岭是一座山，图1', 'http://154.8.146.181:8082/img/1.jpg', '//player.bilibili.com/player.html?aid=968656710&bvid=BV1kp4y1U7AJ&cid=208861000&page=1', '凤凰岭是一座山，图1', 1),
('凤凰岭是一座山，图2', 'http://154.8.146.181:8082/img/2.jpg', '//player.bilibili.com/player.html?aid=286773884&bvid=BV1mf4y197tc&cid=226002527&page=1', '凤凰岭是一座山，图2', 1),
('慕田峪长城很好玩，图1', 'http://154.8.146.181:8082/img/1.jpg', '//player.bilibili.com/player.html?aid=968656710&bvid=BV1kp4y1U7AJ&cid=208861000&page=1', '慕田峪长城很好玩，图1', 2),
('慕田峪长城很好玩，图2', 'http://154.8.146.181:8082/img/2.jpg', '//player.bilibili.com/player.html?aid=968656710&bvid=BV1kp4y1U7AJ&cid=208861000&page=1', '慕田峪长城很好玩，图2', 2);

-- 视频分类
INSERT INTO tv_classification (name, description, image, level, pid)
VALUES
('java', '这是旅游专栏', 'http://154.8.146.181:8082/img/1.jpg', 1, 0),
('java基础', '这是旅游专栏', 'http://154.8.146.181:8082/img/1.jpg', 2, 1),
('java晋级', '这是旅游专栏', 'http://154.8.146.181:8082/img/1.jpg', 2, 1),
('mysql', '大家一起嗨', 'http://154.8.146.181:8082/img/1.jpg', 1, 0),
('mysql基础', '大家一起嗨', 'http://154.8.146.181:8082/img/1.jpg', 2, 4),
('mysql晋级', '大家一起嗨', 'http://154.8.146.181:8082/img/1.jpg', 2, 4);
