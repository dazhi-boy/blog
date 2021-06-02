/*mock data***/
-- 主题数据
INSERT INTO theme (name, description, image)
VALUES
('英语', '英语学习专栏', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg'),
('编程', '编程交流专栏', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg');

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
INSERT INTO tutorial_tv (name, image, tv, description, pid)
VALUES
-- ('大学单词A1-01', 'http://154.8.146.181:8082/img/1.jpg', 'https://upos-sz-mirrorkodo.bilivideo.com/upgcxcode/04/05/314950504/314950504-1-16.mp4?e=ig8euxZM2rNcNbdlhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1622614592&gen=playurlv2&os=kodobv&oi=3720859620&trid=cf3f127bfc8f474aae77a44c22cae1bfh&platform=html5&upsig=d84ff2356b466138e5a50ce4a41b994a&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,platform&mid=85274987&logo=80000000', '图1', 1),
('大学单词A1-01', 'http://154.8.146.181:8082/img/1.jpg', 'https://player.bilibili.com/player.html?aid=972059561&bvid=BV1Ap4y1h7n5&cid=307742622&page=1', '图1', 1),
-- ('大学单词A1-02', 'http://154.8.146.181:8082/img/2.jpg', 'https://www.bilibili.com/video/BV11y4y1a7eA?share_source=copy_web', '图1', 1),
('大学单词A1-02', 'http://154.8.146.181:8082/img/2.jpg', 'https://player.bilibili.com/player.html?aid=799524174&bvid=BV11y4y1a7eA&cid=308009198&page=1', '图1', 1),
('大学单词A1-03', 'http://154.8.146.181:8082/img/1.jpg', 'https://player.bilibili.com/player.html?aid=459510986&bvid=BV1t5411K7BJ&cid=308500353&page=1', '图1', 1),
('大学单词A1-04', 'http://154.8.146.181:8082/img/2.jpg', 'https://player.bilibili.com/player.html?aid=204567171&bvid=BV1Jh411Q7i5&cid=308743138&page=1', '图2', 1),

('大学单词B1-01', 'http://154.8.146.181:8082/img/1.jpg', 'https://player.bilibili.com/player.html?aid=887228770&bvid=BV1bK4y1T7fT&cid=311004798&page=1', '图1', 2),
('大学单词B1-02', 'http://154.8.146.181:8082/img/2.jpg', 'https://player.bilibili.com/player.html?aid=972226742&bvid=BV1Pp4y1a72J&cid=311504234&page=1', '图1', 2),
('大学单词B1-03', 'http://154.8.146.181:8082/img/1.jpg', 'https://player.bilibili.com/player.html?aid=714734361&bvid=BV1QX4y137kr&cid=311883535&page=1', '图1', 2),
('大学单词B1-04', 'http://154.8.146.181:8082/img/2.jpg', 'https://player.bilibili.com/player.html?aid=204686773&bvid=BV1dh411Q7aY&cid=312363230&page=1', '图2', 2),

('大学单词C1-01', 'http://154.8.146.181:8082/img/1.jpg', 'https://player.bilibili.com/player.html?aid=502344908&bvid=BV1NK411w73R&cid=314497748&page=1', '图1', 3),
('大学单词C1-02', 'http://154.8.146.181:8082/img/2.jpg', 'https://player.bilibili.com/player.html?aid=929855718&bvid=BV11K4y127YN&cid=314950504&page=1', '图1', 3),
('大学单词C1-03', 'http://154.8.146.181:8082/img/1.jpg', 'https://player.bilibili.com/player.html?aid=887270123&bvid=BV1kK4y1T73p&cid=315789507&page=1', '图1', 3),
('大学单词C1-04', 'http://154.8.146.181:8082/img/2.jpg', 'https://player.bilibili.com/player.html?aid=714798831&bvid=BV1GX4y1G7ps&cid=316279794&page=1', '图2', 3);
-- 视频分类
INSERT INTO tv_classification (name, description, image, level, pid)
VALUES
-- ('小学1', '小学1专题', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 0),
('大学单词A1', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 1),
('大学单词B1', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 1),
('大学单词C1', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 1);
