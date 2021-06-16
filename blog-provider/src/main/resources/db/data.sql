/*mock data***/
INSERT INTO user (username, nickname, password)
VALUES
('admin', '张三', '123'),
('password', '李四', '123');

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
('大学单词A1-01', 'http://154.8.146.181:8082/img/1.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/A1_bilibili.mp4?sign=d4a7c3f22cbc943890cfe6de0fb25452&t=1623297325', '图1', 1),
('大学单词A1-02', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/A2_bilibili.mp4?sign=ecd6eaebd78ff4f751344cd7bd9bec17&t=1623297365', '图1', 1),
('大学单词A1-03', 'http://154.8.146.181:8082/img/1.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/A3_bilibili.mp4?sign=392746aa91d3e6b15b7858c3f2b0cde0&t=1623297386', '图1', 1),
('大学单词A1-04', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/A4_bilibili.mp4?sign=03f6fd22a5c1f5ed3866d9aa55a4ff5c&t=1623297397', '图2', 1),

('大学单词B1-01', 'http://154.8.146.181:8082/img/1.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/B1_bilibili.mp4?sign=d8efb1dd4588a014d7ae036b3ce4946b&t=1623308421', '图1', 2),
('大学单词B1-02', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/B2_bilibili.mp4?sign=c8afdbf53fdafb3c7733c043cf5b8638&t=1623308470', '图1', 2),
('大学单词B1-03', 'http://154.8.146.181:8082/img/1.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/B3_bilibili.mp4?sign=3e0d475de5fc7cc15e406d95a71a551d&t=1623308484', '图1', 2),
('大学单词B1-04', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/B4_bilibili.mp4?sign=7d6106694dad65240d4d0a19adb274d7&t=1623308494', '图2', 2),

('大学单词C1-01', 'http://154.8.146.181:8082/img/1.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/English/university/C1_bilibili.mp4?sign=726f7cc5be5f8af628898610a67bb87b&t=1623310831', '图1', 3),
('大学单词C1-02', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/English/university/C2_bilibili.mp4?sign=dd77e16ed63df713890733cf9c30f198&t=1623310858', '图1', 3),
('大学单词C1-03', 'http://154.8.146.181:8082/img/1.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/English/university/C3_bilibili.mp4?sign=f6845926ccfe65d07df8bb70fa4f6169&t=1623310869', '图1', 3),
('大学单词C1-04', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/English/university/C4_bilibili.mp4?sign=78ee943f1c4497dc0bcabed9e315a325&t=1623310881', '图2', 3),
('大学单词C1-05', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/English/university/C5_bilibili.mp4?sign=de14cfa6e1ff214808eaab924261bb68&t=1623310894', '图2', 3),
('大学单词C1-06', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/English/university/C6_bilibili.mp4?sign=d7742fe81fdc98e651ad11e55af110ca&t=1623310910', '图2', 3),
('大学单词C1-07', 'http://154.8.146.181:8082/img/2.jpg', 'https://7765-weekend-party-1302306220.tcb.qcloud.la/English/university/C7_bilibili.mp4?sign=494a3a629ca8dd405da3e5ce5a0430ab&t=1623310923', '图2', 3);
-- 视频分类
INSERT INTO tv_classification (name, description, image, level, pid)
VALUES
-- ('小学1', '小学1专题', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 0),
('大学单词A1', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 1),
('大学单词B1', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 1),
('大学单词C1', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 1);

-- 美食列表
INSERT INTO food (name, description, image, type)
VALUES
('锅包肉', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1),
('麻辣烫', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1),
('水煮鱼', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1),
('肉丝盖饭', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 2),
('烤肉拌饭', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 2),
('肯德基汉堡', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 2),
('炒土豆', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 3),
('手撕包菜', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 3),
('炒鸡蛋', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 3);

INSERT INTO food (name, description, image, type, open_id)
VALUES
('锅包肉', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('麻辣烫', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('水煮鱼', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 1, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('肉丝盖饭', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 2, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('烤肉拌饭', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 2, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('肯德基汉堡', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 2, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('炒土豆', '大学单词A1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 3, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('手撕包菜', '大学单词B1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 3, 'oaonk5BsCyJ333H3sgy-CZWPjGGw'),
('炒鸡蛋', '大学单词C1', 'https://res.wx.qq.com/wxdoc/dist/assets/img/0.4cb08bb4.jpg', 3, 'oaonk5BsCyJ333H3sgy-CZWPjGGw');
