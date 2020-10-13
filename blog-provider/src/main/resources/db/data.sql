/*mock data***/
-- 主题数据
INSERT INTO theme (name, description)
VALUES
('旅游', '这是旅游专栏'),
('活动', '大家一起嗨');

-- 景区数据
INSERT INTO attractions (name, keywords, image, description, theme_id, longitude, latitude, province, city)
VALUES
('凤凰岭一日游', '#凤凰岭#，#一日游#', '/haha/haha.jpn', '凤凰岭是一座山，有好多树', 1, 80, 124, '北京市', '北京市'),
('慕田峪长城一日游', '#慕田峪#，#一日游#', '/lalala/lala.jpn', '慕田峪长城很好玩，有好多树', 1, 80, 124, '北京市', '北京市');

-- 景区图文介绍

INSERT INTO attractions_detail (image, description, attractions_id)
VALUES
('/haha/haha.jpn', '凤凰岭是一座山，图1', 1),
('/haha/haha.jpn', '凤凰岭是一座山，图2', 1),
('/lalala/lala.jpn', '慕田峪长城很好玩，图1', 2),
('/lalala/lala.jpn', '慕田峪长城很好玩，图2', 2);

