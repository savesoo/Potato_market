set sql_safe_updates=0;

delete from potato_trade;
delete from potato_board;
delete from potato_user;

INSERT INTO `potato_user` 
VALUES ('himedia','njFw/qXzmMvBcXw4qNeTtA==','2022-10-25 08:22:05','서울','bb',0),
('son','mkSFhV4aem7Fc6NnbTZnsQ==','2022-10-25 07:34:54','서울','son',0),
('ting','rGYqGCsZRcP8fJ971MwMnQ==','2022-10-25 01:42:47','서울','ting',0),
('vip','njFw/qXzmMvBcXw4qNeTtA==','2022-10-26 01:52:58','인천','왕',0);

INSERT INTO `project`.`potato_board`
(`userid`, `category`, `product`, `writedate`, `saleprice`, `salestatus`, `tradeloc`) 
VALUES ('ting',1,'휴지','2022-10-25 01:46:41',100,1,'서울'),
('ting',3,'태블릿','2022-10-25 03:27:35',200000,1,'속초'),
('ting',1,'세제','2022-10-25 03:30:52',500,1,'서울'),
('ting',2,'도자기','2022-10-25 06:07:57',5000,1,'양양'),
('son',2,'양말','2022-10-25 08:02:57',500,1,'서울'),
('son',5,'목줄','2022-10-26 01:01:34',1000,1,'서울'),
('ting',1,'수저통','2022-10-26 02:02:35',2000,1,'하남'),
('ting',2,'장갑','2022-10-26 02:03:44',1000,1,'세종');