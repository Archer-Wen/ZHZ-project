CREATE DATABASE  IF NOT EXISTS `new_zhz233` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `new_zhz233`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: new_zhz233
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tab_account`
--

DROP TABLE IF EXISTS `tab_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_account` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `account_no` varchar(16) NOT NULL COMMENT '账号编号',
  `certification` int(1) NOT NULL DEFAULT '0' COMMENT '实名认证(0 /未实名认证 1/实名认证)',
  `available` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '可用资金',
  `frozen` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '冻结资金',
  `credit_level` int(1) NOT NULL DEFAULT '0' COMMENT '信用等级(0 /基础会员 1/1-99 2/100-999 3/ 1000-9999 4/ 10000-99999 5 /100000-999999 9/超级会员 )',
  `traders_password` varchar(45) NOT NULL DEFAULT '123456' COMMENT '交易密码',
  `traders_alipay` varchar(45) NOT NULL DEFAULT '123456' COMMENT '支付宝交易 绑定账号',
  `traders_wechat_pay` varchar(45) NOT NULL DEFAULT '123456' COMMENT '微信交易 绑定账号',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `account_no_UNIQUE` (`account_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户帐户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_account`
--

LOCK TABLES `tab_account` WRITE;
/*!40000 ALTER TABLE `tab_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_admin_game`
--

DROP TABLE IF EXISTS `tab_admin_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_admin_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_no` int(11) DEFAULT NULL COMMENT '管理员编号',
  `game_no` int(11) DEFAULT NULL COMMENT '游戏编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理员游戏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_admin_game`
--

LOCK TABLES `tab_admin_game` WRITE;
/*!40000 ALTER TABLE `tab_admin_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_admin_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_article_image`
--

DROP TABLE IF EXISTS `tab_article_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_article_image` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `img_no` varchar(12) DEFAULT NULL COMMENT '图片编号',
  `img_name` varchar(255) DEFAULT NULL COMMENT '图片名',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `img_recomm` varchar(255) DEFAULT '1' COMMENT '是否显示（1/是，0/否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='轮播图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_article_image`
--

LOCK TABLES `tab_article_image` WRITE;
/*!40000 ALTER TABLE `tab_article_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_article_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_bbs`
--

DROP TABLE IF EXISTS `tab_bbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_bbs` (
  `bbs_id` bigint(12) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `account_no` varchar(12) NOT NULL COMMENT '作者编号',
  `bbs_title` varchar(50) NOT NULL DEFAULT '空白主题' COMMENT '帖子标题',
  `bbs_count` text NOT NULL COMMENT '帖子内容',
  `board_id` int(6) unsigned NOT NULL DEFAULT '0' COMMENT '板块id',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`bbs_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='帖子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_bbs`
--

LOCK TABLES `tab_bbs` WRITE;
/*!40000 ALTER TABLE `tab_bbs` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_bbs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_blacklist`
--

DROP TABLE IF EXISTS `tab_blacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_blacklist` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `blacklist_no` varchar(20) NOT NULL,
  `account_no` varchar(12) NOT NULL,
  `link_account_no` varchar(12) NOT NULL COMMENT '关联拉黑账号',
  `blacklist_reasons` varchar(200) NOT NULL DEFAULT '无' COMMENT '拉黑原因',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='黑名单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_blacklist`
--

LOCK TABLES `tab_blacklist` WRITE;
/*!40000 ALTER TABLE `tab_blacklist` DISABLE KEYS */;
INSERT INTO `tab_blacklist` VALUES (000000000001,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17'),(000000000002,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17'),(000000000003,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17'),(000000000004,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17'),(000000000005,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17'),(000000000006,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17'),(000000000007,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17'),(000000000008,'20180425000000000001','qweqweqwe','201800000001','外挂','2018-05-15 10:24:17','2018-05-15 02:24:17');
/*!40000 ALTER TABLE `tab_blacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_board`
--

DROP TABLE IF EXISTS `tab_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_board` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `board_name` varchar(50) NOT NULL COMMENT '板块名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='板块表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_board`
--

LOCK TABLES `tab_board` WRITE;
/*!40000 ALTER TABLE `tab_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_camplaint_order`
--

DROP TABLE IF EXISTS `tab_camplaint_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_camplaint_order` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `order_no` varchar(22) NOT NULL COMMENT '投诉流水号\n20180000+(04/投诉流水)+12位自增',
  `link_order_no` varchar(22) NOT NULL COMMENT '关联交易号',
  `order_role` int(1) NOT NULL DEFAULT '0' COMMENT '维权投诉角色（0/系统测试 1/买家 2/卖家）',
  `order_reasons` varchar(200) NOT NULL DEFAULT '无' COMMENT '投诉原因',
  `order_handle` varchar(200) NOT NULL DEFAULT '无' COMMENT '处理结果',
  `order_state` int(1) NOT NULL DEFAULT '0' COMMENT '状态（0/处理中 1/处理失败 2/处理成功）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `order_no_UNIQUE` (`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='投诉流水表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_camplaint_order`
--

LOCK TABLES `tab_camplaint_order` WRITE;
/*!40000 ALTER TABLE `tab_camplaint_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_camplaint_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_certification`
--

DROP TABLE IF EXISTS `tab_certification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_certification` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `certification_no` varchar(12) NOT NULL,
  `account_no` varchar(16) NOT NULL COMMENT '账号',
  `real_name` varchar(15) NOT NULL COMMENT '真实姓名',
  `id_number` varchar(25) NOT NULL COMMENT '身份证号',
  `front_face_url` varchar(45) NOT NULL COMMENT '正面照',
  `reverse_face_url` varchar(45) NOT NULL COMMENT '反面照',
  `handheld_face_url` varchar(45) NOT NULL COMMENT '手持照',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idtab_certification_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `certification_no_UNIQUE` (`certification_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='实名认证信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_certification`
--

LOCK TABLES `tab_certification` WRITE;
/*!40000 ALTER TABLE `tab_certification` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_certification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_db_backup`
--

DROP TABLE IF EXISTS `tab_db_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_db_backup` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `admin_no` varchar(200) NOT NULL COMMENT '管理员编号',
  `db_no` varchar(12) NOT NULL COMMENT '数据库编号',
  `db_content` text COMMENT '数据库描述',
  `db_version` varchar(50) NOT NULL COMMENT '数据库版本',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `db_url` varchar(200) NOT NULL DEFAULT 'static/myfile/database' COMMENT '数据库保存地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='数据库备份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_db_backup`
--

LOCK TABLES `tab_db_backup` WRITE;
/*!40000 ALTER TABLE `tab_db_backup` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_db_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_deal_order`
--

DROP TABLE IF EXISTS `tab_deal_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_deal_order` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `order_no` varchar(22) NOT NULL COMMENT '出租订单号\n20180000+(03/出租流水)+12位自增',
  `goods_no` varchar(20) NOT NULL COMMENT '商品编号',
  `account_no` varchar(16) DEFAULT NULL,
  `buyer_no` varchar(16) NOT NULL COMMENT '购买用户',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  `order_state` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态（0/等待 1/失败 2/成功 ）',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `lease_no_UNIQUE` (`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='出租订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_deal_order`
--

LOCK TABLES `tab_deal_order` WRITE;
/*!40000 ALTER TABLE `tab_deal_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_deal_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_games`
--

DROP TABLE IF EXISTS `tab_games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_games` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `games_no` varchar(12) NOT NULL,
  `games_type` int(1) NOT NULL DEFAULT '0' COMMENT '0/测试 1/端游 2/页游 3/手游 4/其他',
  `games_name` varchar(45) NOT NULL,
  `games_recomm` int(1) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `game_no_UNIQUE` (`games_no`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='游戏详细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_games`
--

LOCK TABLES `tab_games` WRITE;
/*!40000 ALTER TABLE `tab_games` DISABLE KEYS */;
INSERT INTO `tab_games` VALUES (000000000001,'201800000001',1,'英雄联盟',4),(000000000002,'201800000002',1,'穿越火线',4),(000000000003,'201800000003',1,'地下城与勇士',4),(000000000004,'201800000004',1,'魔兽世界',4),(000000000005,'201800000005',1,'梦幻西游2',3),(000000000006,'201800000006',1,'剑网3',4),(000000000007,'201800000007',1,'炉石传说',3),(000000000008,'201800000008',1,'剑灵',3),(000000000009,'201800000009',1,'坦克世界',3),(000000000010,'201800000010',1,'逆战',3),(000000000011,'201800000011',1,'绝地求生',5),(000000000012,'201800000012',2,'传奇1.76',1),(000000000013,'201800000013',2,'七龙珠',1),(000000000014,'201800000014',2,'奇迹重生',1),(000000000015,'201800000015',2,'4D新世界OL',2),(000000000016,'201800000016',2,'天威传说',1),(000000000017,'201800000017',2,'传奇世界',1),(000000000018,'201800000018',2,'逃跑少年',0),(000000000019,'201800000019',2,'横扫天界',0),(000000000020,'201800000020',2,'逆天邪神',0),(000000000021,'201800000021',2,'龙腾传世',0),(000000000049,'201800000022',3,'无限法则',0),(000000000050,'201800000023',3,'使命召唤',2),(000000000051,'201800000024',3,'穿越火线：荒岛特训',3),(000000000052,'201800000025',3,'终结者2',4),(000000000053,'201800000026',3,'荒野行动',4),(000000000054,'201800000027',3,'全军出击',2),(000000000055,'201800000028',3,'刺激战场',4),(000000000056,'201800000029',3,'王者荣耀',4),(000000000057,'201800000030',3,'今晚吃鸡：绝地求生',4),(000000000058,'201800000031',3,'堡垒之夜',4);
/*!40000 ALTER TABLE `tab_games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_games_node`
--

DROP TABLE IF EXISTS `tab_games_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_games_node` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `node_name` varchar(50) NOT NULL,
  `node_no` int(6) NOT NULL DEFAULT '0',
  `node_level` int(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='游戏级联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_games_node`
--

LOCK TABLES `tab_games_node` WRITE;
/*!40000 ALTER TABLE `tab_games_node` DISABLE KEYS */;
INSERT INTO `tab_games_node` VALUES (1,'英雄联盟',0,1),(2,'绝地求生',0,1),(3,'全区（服）',2,2),(4,'电信',1,2),(5,'网通',1,2),(6,'其他',1,2),(7,'穿越火线',0,1),(8,'艾欧尼亚',4,3),(9,'诺克萨斯',4,3),(10,'电信',7,2),(11,'德玛西亚',5,3),(12,'无畏先锋',5,3),(13,'黑暗峡谷',5,3);
/*!40000 ALTER TABLE `tab_games_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods`
--

DROP TABLE IF EXISTS `tab_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `goods_no` varchar(20) NOT NULL COMMENT '商品编号',
  `account_no` varchar(12) NOT NULL COMMENT '商品发布人',
  `goods_type` int(1) NOT NULL DEFAULT '0' COMMENT '商品类型（0/测试商品 1/出租商品 2/买卖商品 3/代练商品 4/其他商品）',
  `goods_game` varchar(200) NOT NULL DEFAULT '无',
  `goods_theme` varchar(200) NOT NULL DEFAULT '无' COMMENT '商品主题',
  `goods_content` text NOT NULL COMMENT '商品描述',
  `goods_amount` decimal(10,2) NOT NULL DEFAULT '1.00' COMMENT '单价',
  `goods_recomm` int(1) NOT NULL DEFAULT '0' COMMENT '商品推荐等级( /0 个人认证/ 1 商家认证/ 2 个人商家认证 /3 特价商品 /4 测试认证)',
  `goods_status` int(1) NOT NULL DEFAULT '0' COMMENT '商品状态( 0 审核中/ 1已审核/ 2审核不通过/ 3已出租/ 4已预约/ 5已下架)',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `goods_no_UNIQUE` (`goods_no`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='商品基础信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods`
--

LOCK TABLES `tab_goods` WRITE;
/*!40000 ALTER TABLE `tab_goods` DISABLE KEYS */;
INSERT INTO `tab_goods` VALUES (000000000034,'20180520000000000001','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000035,'20180520000000000002','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000036,'20180520000000000003','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000037,'20180520000000000004','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000038,'20180520000000000005','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-10 15:28:44','2018-05-16 02:32:50'),(000000000039,'20180520000000000006','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000040,'20180520000000000007','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000041,'20180520000000000008','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000042,'20180520000000000009','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000043,'20180520000000000010','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,3,1,'2018-04-10 15:28:44','2018-05-16 02:32:50'),(000000000044,'20180520000000000011','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000045,'20180520000000000012','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000046,'20180520000000000013','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000047,'20180520000000000014','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000048,'20180520000000000015','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000049,'20180520000000000016','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-10 15:28:44','2018-05-16 02:32:50'),(000000000050,'20180520000000000017','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000051,'20180520000000000018','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,1,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000052,'20180520000000000019','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,1,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000053,'20180520000000000020','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,1,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000054,'20180520000000000021','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,1,1,'2018-04-10 15:28:44','2018-05-16 02:32:50'),(000000000055,'20180520000000000022','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000056,'20180520000000000023','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000057,'20180520000000000024','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000058,'20180520000000000025','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000059,'20180520000000000026','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000060,'20180520000000000027','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',1.00,2,1,'2018-04-10 15:28:44','2018-05-16 02:32:50'),(000000000061,'20180520000000000028','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',100.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000062,'20180520000000000029','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',100.00,1,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000063,'20180520000000000030','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',100.00,1,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000064,'20180520000000000031','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',100.00,1,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000065,'20180520000000000032','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',100.00,1,1,'2018-04-10 15:28:44','2018-05-16 02:32:50'),(000000000066,'20180520000000000033','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',100.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000067,'20180520000000000034','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',100.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000068,'20180520000000000035','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',10.00,1,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000069,'20180520000000000036','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',10.00,1,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000070,'20180520000000000037','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',10.00,1,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000071,'20180520000000000038','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',10.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000072,'20180520000000000039','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',10.00,1,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000073,'20180520000000000040','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',10.00,2,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000074,'20180520000000000041','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',5.00,2,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000075,'20180520000000000042','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',5.00,2,1,'2018-04-10 15:28:44','2018-05-16 02:32:50'),(000000000076,'20180520000000000043','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',5.00,1,1,'2018-04-23 14:10:46','2018-05-16 02:32:50'),(000000000077,'20180520000000000044','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',5.00,1,1,'2018-04-23 14:12:31','2018-05-16 02:32:50'),(000000000078,'20180520000000000045','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',5.00,1,1,'2018-04-23 14:12:34','2018-05-16 02:32:50'),(000000000079,'20180520000000000046','201800000002',1,'英雄联盟','租号体验，英雄联盟','租号体验，英雄联盟',5.00,1,1,'2018-04-23 14:13:50','2018-05-16 02:32:50'),(000000000080,'20180520000000000047','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',10.00,1,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000081,'20180520000000000048','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',10.00,1,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000082,'20180520000000000049','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',10.00,1,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000083,'20180520000000000050','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',5.00,1,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000084,'20180520000000000051','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',5.00,1,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000085,'20180520000000000052','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',5.00,1,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000086,'20180520000000000053','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',40.00,2,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000087,'20180520000000000054','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',23.00,2,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000088,'20180520000000000055','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',4.00,2,1,'2018-05-21 22:35:47','2018-05-21 14:35:47'),(000000000089,'20180520000000000056','201800000001',1,'绝地求生','绝地求生,租号玩吧','绝地求生,租号玩吧',1.00,1,1,'2018-05-21 22:35:47','2018-05-21 14:35:47');
/*!40000 ALTER TABLE `tab_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods_deal`
--

DROP TABLE IF EXISTS `tab_goods_deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods_deal` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `goods_no` varchar(20) NOT NULL COMMENT '商品编号',
  `goods_game` varchar(12) NOT NULL COMMENT '游戏编号 名称',
  `goods_amount` decimal(10,2) NOT NULL COMMENT '商品价格',
  `goods_access` varchar(45) NOT NULL COMMENT '账号',
  `goods_password` varchar(45) NOT NULL COMMENT '商品密码',
  `goods_compensate` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '投保金额',
  `goods_credit_level` int(1) NOT NULL DEFAULT '0' COMMENT '信用等级',
  `goods_view_count` bigint(10) NOT NULL DEFAULT '0' COMMENT '浏览数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idtab_goods_more_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `goods_no_UNIQUE` (`goods_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='买卖商品详细信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods_deal`
--

LOCK TABLES `tab_goods_deal` WRITE;
/*!40000 ALTER TABLE `tab_goods_deal` DISABLE KEYS */;
INSERT INTO `tab_goods_deal` VALUES (000000000001,'20180520000000000001','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000002,'20180520000000000002','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000003,'20180520000000000003','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000004,'20180520000000000004','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000005,'20180520000000000005','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000006,'20180520000000000006','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000007,'20180520000000000007','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000008,'20180520000000000008','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000009,'20180520000000000009','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000010,'20180520000000000010','英雄联盟',2.00,'9999932124','123456',100.00,1,0),(000000000011,'20180520000000000011','英雄联盟',2.00,'9999932124','123456',100.00,1,0);
/*!40000 ALTER TABLE `tab_goods_deal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods_more`
--

DROP TABLE IF EXISTS `tab_goods_more`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods_more` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `goods_no` varchar(20) NOT NULL,
  `game_name` varchar(25) NOT NULL COMMENT '游戏名称',
  `goods_role` varchar(45) NOT NULL COMMENT '角色名',
  `goods_area` varchar(45) NOT NULL COMMENT '大区',
  `goods_server` varchar(45) NOT NULL COMMENT '服务器',
  `goods_grade` int(4) NOT NULL DEFAULT '0' COMMENT '等级（最大999）',
  `goods_rank` int(1) NOT NULL DEFAULT '0' COMMENT '段位（0/无 1/青铜 2/白银 3/黄金 4/铂金 5/钻石 6/大师 7/最强王者）',
  `goods_access` int(11) NOT NULL DEFAULT '0' COMMENT '排位（0/允许 1/ 不允许）',
  `goods_case` int(1) NOT NULL DEFAULT '0' COMMENT '框（0/无 1/青铜 2/白银 3/黄金 4/铂金 5/钻石 6/大师 7/最强王者）',
  `goods__skin` text NOT NULL COMMENT '皮肤 , 隔开',
  `goods_hero` text NOT NULL COMMENT '英雄 ,隔开',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `goods_no_UNIQUE` (`goods_no`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='交易 信息附加表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods_more`
--

LOCK TABLES `tab_goods_more` WRITE;
/*!40000 ALTER TABLE `tab_goods_more` DISABLE KEYS */;
INSERT INTO `tab_goods_more` VALUES (000000000001,'20180520000000000001','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000002,'20180520000000000002','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000003,'20180520000000000003','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000004,'20180520000000000004','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000005,'20180520000000000005','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000006,'20180520000000000006','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000007,'20180520000000000007','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000008,'20180520000000000008','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000009,'20180520000000000009','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000010,'20180520000000000010','英雄联盟','adasdfhqwas','艾欧尼亚','电信',10,1,0,1,'无','无'),(000000000011,'20180520000000000011','英雄联盟','adasdfhqwas','德玛西亚','电信',10,1,0,1,'无','无'),(000000000045,'20180520000000000012','英雄联盟','zxczczxcq213','德玛西亚','网通',120,1,0,2,'无','无'),(000000000046,'20180520000000000013','绝地求生','zxczczxcq213','德玛西亚','网通',120,1,0,2,'无','无'),(000000000047,'20180520000000000014','英雄联盟','zxczczxcq213','德玛西亚','网通',120,1,0,2,'无','无'),(000000000048,'20180520000000000015','绝地求生','zxczczxcq213','德玛西亚','网通',120,1,0,2,'无','无'),(000000000049,'20180520000000000016','英雄联盟','zxczczxcq213','德玛西亚','网通',120,1,0,2,'无','无'),(000000000050,'20180520000000000017','绝地求生','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000051,'20180520000000000018','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000052,'20180520000000000019','绝地求生','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000053,'20180520000000000020','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000054,'20180520000000000021','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000055,'20180520000000000022','绝地求生','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000056,'20180520000000000023','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,2,'无','无'),(000000000057,'20180520000000000024','绝地求生','adasdfhqwas','德玛西亚','网通',120,1,0,2,'无','无'),(000000000058,'20180520000000000025','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,2,'无','无'),(000000000059,'20180520000000000026','英雄联盟','zxczczxcq213','德玛西亚','网通',120,1,0,2,'无','无'),(000000000060,'20180520000000000027','英雄联盟','zxczczxcq213','德玛西亚','网通',120,1,0,2,'无','无'),(000000000061,'20180520000000000028','英雄联盟','zxczczxcq213','德玛西亚','其他',120,1,0,1,'无','无'),(000000000062,'20180520000000000029','英雄联盟','zxczczxcq213','德玛西亚','其他',120,1,0,1,'无','无'),(000000000063,'20180520000000000030','英雄联盟','zxczczxcq213','德玛西亚','其他',120,1,0,1,'无','无'),(000000000064,'20180520000000000031','英雄联盟','adasdfhqwas','德玛西亚','其他',120,1,0,1,'无','无'),(000000000065,'20180520000000000032','英雄联盟','adasdfhqwas','德玛西亚','其他',120,1,0,1,'无','无'),(000000000066,'20180520000000000033','英雄联盟','adasdfhqwas','德玛西亚','其他',120,1,0,1,'无','无'),(000000000067,'20180520000000000034','英雄联盟','adasdfhqwas','德玛西亚','其他',120,1,0,2,'无','无'),(000000000068,'20180520000000000035','英雄联盟','adasdfhqwas','德玛西亚','其他',120,1,0,2,'无','无'),(000000000069,'20180520000000000036','英雄联盟','adasdfhqwas','德玛西亚','其他',120,1,0,2,'无','无'),(000000000070,'20180520000000000037','绝地求生','adasdfhqwas','德玛西亚','其他',120,1,0,2,'无','无'),(000000000071,'20180520000000000038','英雄联盟','adasdfhqwas','德玛西亚','其他',120,1,0,2,'无','无'),(000000000072,'20180520000000000039','绝地求生','adasdfhqwas','德玛西亚','网通',120,1,0,2,'无','无'),(000000000073,'20180520000000000040','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,2,'无','无'),(000000000074,'20180520000000000041','绝地求生','adasdfhqwas','德玛西亚','网通',120,1,0,2,'无','无'),(000000000075,'20180520000000000042','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,2,'无','无'),(000000000076,'20180520000000000043','绝地求生','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000077,'20180520000000000044','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000078,'20180520000000000045','英雄联盟','adasdfhqwas','德玛西亚','网通',120,1,0,1,'无','无'),(000000000079,'20180520000000000046','绝地求生','zxczczxcq213','德玛西亚','网通',120,1,0,1,'无','无'),(000000000080,'20180520000000000047','绝地求生','312312312','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000081,'20180520000000000048','绝地求生','122112333','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000082,'20180520000000000049','绝地求生','123123','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000083,'20180520000000000050','绝地求生','12gSdag','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000084,'20180520000000000051','绝地求生','afadsfad12','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000085,'20180520000000000052','绝地求生','adasdfhqwas','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000086,'20180520000000000053','绝地求生','werwrqwr','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000087,'20180520000000000054','绝地求生','faafafasd','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000088,'20180520000000000055','绝地求生','tqqqqrqerfFSD','全区（服）','全区（服）',0,1,0,2,'无','无'),(000000000089,'20180520000000000056','绝地求生','adasdfhqwas','全区（服）','全区（服）',0,1,0,2,'无','无');
/*!40000 ALTER TABLE `tab_goods_more` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods_practice`
--

DROP TABLE IF EXISTS `tab_goods_practice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods_practice` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `goods_no` varchar(20) NOT NULL COMMENT '商品编号',
  `goods_game` varchar(12) NOT NULL COMMENT '游戏编号 名称',
  `goods_amount` decimal(10,2) NOT NULL COMMENT '商品价格',
  `goods_access` varchar(45) NOT NULL COMMENT '账号',
  `goods_password` varchar(45) NOT NULL COMMENT '商品密码',
  `goods_compensate` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '投保金额',
  `goods_credit_level` int(1) NOT NULL DEFAULT '0' COMMENT '信用等级',
  `goods_view_count` bigint(10) NOT NULL DEFAULT '0' COMMENT '浏览数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idtab_goods_more_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `goods_no_UNIQUE` (`goods_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='买卖商品详细信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods_practice`
--

LOCK TABLES `tab_goods_practice` WRITE;
/*!40000 ALTER TABLE `tab_goods_practice` DISABLE KEYS */;
INSERT INTO `tab_goods_practice` VALUES (000000000001,'20180404000000000001','英雄联盟',1.00,'9120123','123456',0.00,0,0),(000000000002,'20180404000000000002','绝地求生',1.00,'123214fsd','123456',0.00,0,0),(000000000003,'20180410000000000003','英雄联盟',1.00,'9120123','123456',0.00,0,0),(000000000004,'20180410000000000004','绝地求生',1.00,'9120123','123456',0.00,0,0),(000000000005,'20180410000000000005','英雄联盟',1.00,'9120123','123456',0.00,0,0),(000000000006,'20180410000000000006','绝地求生',1.00,'9120123','123456',0.00,0,0),(000000000007,'20180410000000000007','英雄联盟',1.00,'9120123','123456',0.00,0,0),(000000000008,'20180410000000000008','绝地求生',1.00,'9120123','123456',0.00,0,0),(000000000009,'20180410000000000009','英雄联盟',1.00,'9120123','123456',0.00,0,0),(000000000010,'20180410000000000010','英雄联盟',1.00,'9120123','123456',0.00,0,0),(000000000011,'20180410000000000011','绝地求生',1.00,'9120123','123456',0.00,0,0),(000000000012,'20180410000000000012','英雄联盟',1.00,'9120123','123456',0.00,0,0),(000000000023,'20180423000000000001','绝地求生',1.00,'9120123','123456',0.00,0,0);
/*!40000 ALTER TABLE `tab_goods_practice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods_rent`
--

DROP TABLE IF EXISTS `tab_goods_rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods_rent` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `goods_no` varchar(20) NOT NULL COMMENT '商品编号',
  `goods_game` varchar(12) NOT NULL COMMENT '游戏编号 名称',
  `goods_hour` decimal(10,2) NOT NULL DEFAULT '1.00',
  `goods_night` decimal(10,2) NOT NULL DEFAULT '8.00',
  `goods_day` decimal(10,2) NOT NULL DEFAULT '20.00',
  `goods_week` decimal(10,2) NOT NULL DEFAULT '120.00',
  `goods_month` decimal(10,2) NOT NULL DEFAULT '420.00',
  `goods_year` decimal(10,2) NOT NULL DEFAULT '2500.00',
  `goods_access` varchar(45) NOT NULL COMMENT '账号',
  `goods_password` varchar(45) NOT NULL COMMENT '商品密码',
  `goods_logon_style` int(1) NOT NULL DEFAULT '0' COMMENT '登录方式（0/ 账号密码 1/上号器）',
  `goods_compensate` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '投保金额',
  `goods_beforehand` int(1) NOT NULL DEFAULT '0' COMMENT '预约方式',
  `goods_delay` int(4) NOT NULL DEFAULT '0' COMMENT '延迟时间（最多9999）',
  `goods_short_time` int(4) NOT NULL DEFAULT '1' COMMENT '最短租用时间（最大9999）',
  `goods_credit_level` int(1) NOT NULL DEFAULT '0' COMMENT '信用等级',
  `goods_view_count` bigint(10) NOT NULL DEFAULT '0' COMMENT '浏览数',
  `goods_rent_count` bigint(10) NOT NULL DEFAULT '0' COMMENT '出租次数',
  `goods_recomm_count` bigint(10) NOT NULL DEFAULT '0' COMMENT '推荐次数',
  `goods_complaint_count` bigint(10) NOT NULL DEFAULT '0' COMMENT '投诉次数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idtab_goods_more_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `goods_no_UNIQUE` (`goods_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品详细信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods_rent`
--

LOCK TABLES `tab_goods_rent` WRITE;
/*!40000 ALTER TABLE `tab_goods_rent` DISABLE KEYS */;
INSERT INTO `tab_goods_rent` VALUES (000000000021,'20180520000000000001','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000022,'20180520000000000002','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000023,'20180520000000000003','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000024,'20180520000000000004','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,0.00,0,0,1,0,0,0,0,0),(000000000025,'20180520000000000005','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,6.00,0,0,1,0,0,0,0,0),(000000000026,'20180520000000000006','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,0.00,0,0,1,0,0,0,0,0),(000000000027,'20180520000000000007','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,2.00,0,0,1,0,0,0,0,0),(000000000028,'20180520000000000008','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,0.00,0,0,1,0,0,0,0,0),(000000000029,'20180520000000000009','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,21.00,0,0,1,0,0,0,0,0),(000000000030,'20180520000000000010','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,0.00,0,0,1,0,0,0,0,0),(000000000031,'20180520000000000011','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'sadqwexgfnk','qweqweqwe',0,124.00,0,0,1,0,0,0,0,0),(000000000045,'20180520000000000012','英雄联盟',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,0.00,0,0,1,0,0,0,0,0),(000000000046,'20180520000000000013','绝地求生',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,2.00,0,0,1,0,0,0,0,0),(000000000047,'20180520000000000014','英雄联盟',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000048,'20180520000000000015','绝地求生',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000049,'20180520000000000016','英雄联盟',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000050,'20180520000000000017','绝地求生',1.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000051,'20180520000000000018','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000052,'20180520000000000019','绝地求生',1.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000053,'20180520000000000020','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,1.00,0,0,1,0,0,0,0,0),(000000000054,'20180520000000000021','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,0.00,0,0,1,0,0,0,0,0),(000000000055,'20180520000000000022','绝地求生',1.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,7.00,0,0,1,0,0,0,0,0),(000000000056,'20180520000000000023','英雄联盟',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,0.00,0,0,1,0,0,0,0,0),(000000000057,'20180520000000000024','绝地求生',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,7.00,0,0,1,0,0,0,0,0),(000000000058,'20180520000000000025','英雄联盟',1.00,8.00,20.00,120.00,1.00,2.00,'qweqweqwe','qweqweqwe',0,0.00,0,0,1,0,0,0,0,0),(000000000059,'20180520000000000026','英雄联盟',1.00,8.00,20.00,120.00,1.00,2.00,'qweqweqwe','qweqweqwe',0,1.00,0,0,1,0,0,0,0,0),(000000000060,'20180520000000000027','英雄联盟',1.00,8.00,20.00,120.00,1.00,2.00,'qweqweqwe','qweqweqwe',0,0.00,0,0,1,0,0,0,0,0),(000000000061,'20180520000000000028','英雄联盟',1.00,8.00,20.00,120.00,1.00,1.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000062,'20180520000000000029','英雄联盟',100.00,8.00,20.00,120.00,1.00,1.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000063,'20180520000000000030','英雄联盟',100.00,8.00,20.00,120.00,1.00,1.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000064,'20180520000000000031','英雄联盟',100.00,8.00,20.00,120.00,1.00,1.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000065,'20180520000000000032','英雄联盟',100.00,8.00,20.00,120.00,1.00,1.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000066,'20180520000000000033','英雄联盟',100.00,8.00,20.00,120.00,1.00,1.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000067,'20180520000000000034','英雄联盟',100.00,8.00,20.00,120.00,1.00,2.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000068,'20180520000000000035','英雄联盟',100.00,8.00,20.00,120.00,1.00,2.00,'qweqweqwe','qweqweqwe',0,100.00,0,0,1,0,0,0,0,0),(000000000069,'20180520000000000036','英雄联盟',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000070,'20180520000000000037','绝地求生',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,7,0,1,0,0,0,0,0),(000000000071,'20180520000000000038','英雄联盟',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000072,'20180520000000000039','绝地求生',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000073,'20180520000000000040','英雄联盟',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000074,'20180520000000000041','绝地求生',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000075,'20180520000000000042','英雄联盟',5.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000076,'20180520000000000043','绝地求生',5.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000077,'20180520000000000044','英雄联盟',5.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000078,'20180520000000000045','英雄联盟',5.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000079,'20180520000000000046','绝地求生',5.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000080,'20180520000000000047','绝地求生',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',1,100.00,0,0,1,0,0,0,0,0),(000000000081,'20180520000000000048','绝地求生',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',1,100.00,0,0,1,0,0,0,0,0),(000000000082,'20180520000000000049','绝地求生',10.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000083,'20180520000000000050','绝地求生',5.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000084,'20180520000000000051','绝地求生',5.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',1,100.00,0,0,1,0,0,0,0,0),(000000000085,'20180520000000000052','绝地求生',5.00,8.00,20.00,120.00,1.00,1.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000086,'20180520000000000053','绝地求生',40.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000087,'20180520000000000054','绝地求生',23.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',1,100.00,0,0,1,0,0,0,0,0),(000000000088,'20180520000000000055','绝地求生',4.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0),(000000000089,'20180520000000000056','绝地求生',1.00,8.00,20.00,120.00,1.00,2.00,'123456','123456',0,100.00,0,0,1,0,0,0,0,0);
/*!40000 ALTER TABLE `tab_goods_rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_heros_node`
--

DROP TABLE IF EXISTS `tab_heros_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_heros_node` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `node_name` varchar(50) NOT NULL COMMENT '节点名',
  `node_no` int(6) NOT NULL DEFAULT '0' COMMENT '父级编号',
  `node_level` int(6) NOT NULL DEFAULT '0' COMMENT '等级',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `hero_no_UNIQUE` (`node_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='英雄节点列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_heros_node`
--

LOCK TABLES `tab_heros_node` WRITE;
/*!40000 ALTER TABLE `tab_heros_node` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_heros_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_invla`
--

DROP TABLE IF EXISTS `tab_invla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_invla` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `order_no` varchar(22) NOT NULL COMMENT '交易订单号\n20180000+(00/账户流水)+12位自增',
  `account_no` varchar(12) NOT NULL,
  `order_operate_type` int(1) NOT NULL DEFAULT '0' COMMENT '订单类型（0/消费 1/收入 2/充值 3/提现）',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idtab_invla_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `order_no_UNIQUE` (`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='账户资金交易流水表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_invla`
--

LOCK TABLES `tab_invla` WRITE;
/*!40000 ALTER TABLE `tab_invla` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_invla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_lease_order`
--

DROP TABLE IF EXISTS `tab_lease_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_lease_order` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `order_no` varchar(22) NOT NULL COMMENT '出租订单号\n20180000+(03/出租流水)+12位自增',
  `goods_no` varchar(20) NOT NULL COMMENT '商品编号',
  `account_no` varchar(16) DEFAULT NULL,
  `buyer_no` varchar(16) NOT NULL COMMENT '购买用户',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  `order_start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单开始时间',
  `order_end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单结束时间',
  `order_state` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态（0/等待付款 1/订单失败 2/完成订单 3/订单失效 4/订单进行中）',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `lease_no_UNIQUE` (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='出租订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_lease_order`
--

LOCK TABLES `tab_lease_order` WRITE;
/*!40000 ALTER TABLE `tab_lease_order` DISABLE KEYS */;
INSERT INTO `tab_lease_order` VALUES (000000000001,'2018040403000000000001','20180404000000000001','201800000001','201800000002',8.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000002,'2018040403000000000002','20180404000000000001','201800000001','201800000002',5.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000003,'2018040403000000000003','20180404000000000001','201800000001','201800000002',10.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000004,'2018040403000000000004','20180404000000000001','201800000001','201800000002',23.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000005,'2018040403000000000005','20180404000000000001','201800000001','201800000002',6.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000006,'2018040403000000000006','20180404000000000001','201800000001','201800000002',12.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000007,'2018040403000000000007','20180404000000000001','201800000001','201800000002',4.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000008,'2018040403000000000008','20180404000000000001','201800000001','201800000002',1.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000009,'2018040403000000000009','20180404000000000001','201800000001','201800000002',2.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000010,'2018040403000000000010','20180404000000000001','201800000001','201800000002',12.00,'2018-05-15 11:30:06','2018-05-15 15:30:06',3,'2018-05-15 11:30:06','2018-05-15 03:30:06'),(000000000011,'2018040403000000000011','20180404000000000001','201800000001','201800000002',0.00,'2018-05-23 20:40:15','2018-05-23 20:40:15',3,'2018-05-23 20:40:15','2018-05-23 12:40:15'),(000000000013,'2018040403000000000012','20180404000000000001','201800000001','201800000002',0.00,'2018-05-23 20:59:36','2018-05-23 20:59:36',3,'2018-05-23 20:59:36','2018-05-23 12:59:36'),(000000000014,'2018052403000000000001','20180520000000000001','201800000002','201800000002',0.00,'2018-05-24 10:24:36','2018-05-24 11:24:36',0,'2018-05-24 10:24:36','2018-05-24 02:24:36');
/*!40000 ALTER TABLE `tab_lease_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_notice`
--

DROP TABLE IF EXISTS `tab_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_notice` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `notice_no` varchar(15) NOT NULL,
  `notice_type` int(1) NOT NULL,
  `notice_theme` varchar(45) NOT NULL,
  `notice_content` text NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `notice_viewcount` bigint(10) NOT NULL DEFAULT '0',
  `notice_recomm` int(1) NOT NULL DEFAULT '1' COMMENT '是否显示（0/否  1/是）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `notice_no_UNIQUE` (`notice_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统信息公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_notice`
--

LOCK TABLES `tab_notice` WRITE;
/*!40000 ALTER TABLE `tab_notice` DISABLE KEYS */;
INSERT INTO `tab_notice` VALUES (000000000001,'201804020001',1,'最新租号体验活动','活动内容公告如下：1、租号体验，0元租等...','2018-04-02 00:00:00','2018-04-19 01:23:58',1,1),(000000000002,'201804020002',1,'最新发布租号流程','新的发布机制...','2018-04-02 00:00:00','2018-04-19 01:23:58',20,1),(000000000003,'201804020003',1,'最新交易使用公告','最新的交易公告发布...','2018-04-02 00:00:00','2018-04-19 01:23:58',30,1),(000000000004,'201804020004',1,'账号上下架操作流程','流程....','2018-04-02 00:00:00','2018-04-19 01:23:58',50,1),(000000000005,'201804020005',1,'免责声明','以下免责声明事项：1、...','2018-04-02 00:00:00','2018-04-19 01:23:58',100,1),(000000000006,'201804020006',2,'注册及认证','个人资料：当您在本平台进行用户注册登记、网上购物、参加网上拍卖或公共论坛等活动时，在您的同意及确认下，租号玩将通过注册表格、订单等形式要求您提供一些个人资料。在未经您同意及确认之前，本平台不会将您为参加本网站之特定活动所提供的资料利用于其它目的。将对您所提供的资料进行严格的管理及保护，本平台将使用相应的技术，防止您的个人资料丢失、被盗用或遭篡改。您在注册时即默认同意本平台协议，您提交的手机与姓名将影响到您的后续操作，如找回密码，提现等.请认真填写，提现时提现账户名必须与注册名一致方可提现。','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000007,'201804020007',2,'卖家、买家等级介绍','卖家与买家身份分别适用与等级系统，相应的等级系统细则将即刻发布，请注意阅读和了解相关事项。','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000008,'201804020008',2,'关于租号玩封号规则','1、试图开启第三方软件。隐藏进程软件，键盘记录软件，修改游戏客户端等。2、号主设置不允许排位，租方强制排位。3、租用账号，发布不良言论，诈骗信息。4、恶意投诉.没有挤号说挤号，各种奇葩投诉。','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000009,'201804020009',2,'如何注册账号','材料上传中整理中，请稍等...','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000010,'201804020010',2,'新手必读','新手必读协议以及事项：1、出租账号须知。2、租用账号须知。3、收费标准。4、提现充值。','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000011,'201804020011',3,'0.0.1版本测试','0.0.1版本上线测试须知','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000012,'201804020012',3,'0.0.2版本测试','0.0.2版本上线测试须知','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000013,'201804020013',3,'0.1.0版本测试','0.1.0版本上线测试须知','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000014,'201804020014',3,'0.2.0版本测试','0.2.0版本上线测试须知','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1),(000000000015,'201804020015',3,'1.0.0版本测试','1.0.0版本上线测试须知','2018-04-02 00:00:00','2018-04-09 02:35:29',0,1);
/*!40000 ALTER TABLE `tab_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_practice_order`
--

DROP TABLE IF EXISTS `tab_practice_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_practice_order` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `order_no` varchar(22) NOT NULL COMMENT '出租订单号\n20180000+(03/出租流水)+12位自增',
  `goods_no` varchar(20) NOT NULL COMMENT '商品编号',
  `account_no` varchar(16) DEFAULT NULL,
  `buyer_no` varchar(16) NOT NULL COMMENT '购买用户',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  `order_start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单开始时间',
  `order_end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单结束时间',
  `order_state` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态（0/等待 1/失败 2/成功 ）',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `lease_no_UNIQUE` (`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='代练订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_practice_order`
--

LOCK TABLES `tab_practice_order` WRITE;
/*!40000 ALTER TABLE `tab_practice_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_practice_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_recharge_order`
--

DROP TABLE IF EXISTS `tab_recharge_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_recharge_order` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `order_no` varchar(22) NOT NULL COMMENT '交易订单号\n20180000+(01/充值流水)+12位自增',
  `account_no` varchar(12) NOT NULL,
  `order_pay_method` int(1) NOT NULL DEFAULT '0' COMMENT '订单充值方式(0/系统测试 1/支付宝 2/微信 3/其他)',
  `order_pay_number` varchar(45) NOT NULL DEFAULT '无' COMMENT '充值账号信息',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '充值金额',
  `order_state` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态（0/等待 1/失败 2/成功 ）',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单产生时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `recharge_no_UNIQUE` (`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='充值订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_recharge_order`
--

LOCK TABLES `tab_recharge_order` WRITE;
/*!40000 ALTER TABLE `tab_recharge_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_recharge_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_reply`
--

DROP TABLE IF EXISTS `tab_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_reply` (
  `id` bigint(12) NOT NULL,
  `reply_count` text NOT NULL COMMENT '回复内容',
  `account_no` bigint(12) NOT NULL COMMENT '作者编号',
  `bbs_id` bigint(12) NOT NULL COMMENT '帖子编号',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='回帖表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_reply`
--

LOCK TABLES `tab_reply` WRITE;
/*!40000 ALTER TABLE `tab_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_skins`
--

DROP TABLE IF EXISTS `tab_skins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_skins` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `skins_no` varchar(12) NOT NULL COMMENT '皮肤编号',
  `skins_heros_no` varchar(12) NOT NULL COMMENT '英雄编号',
  `skins_name` varchar(45) NOT NULL COMMENT '皮肤名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `skin_no_UNIQUE` (`skins_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='lol 皮肤列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_skins`
--

LOCK TABLES `tab_skins` WRITE;
/*!40000 ALTER TABLE `tab_skins` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_skins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_upper_device`
--

DROP TABLE IF EXISTS `tab_upper_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_upper_device` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `upper_device_no` varchar(12) NOT NULL COMMENT '上号器编号',
  `upper_device_name` varchar(45) NOT NULL COMMENT '上号器名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `upper_device_no_UNIQUE` (`upper_device_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='UpperDevice 上号器列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_upper_device`
--

LOCK TABLES `tab_upper_device` WRITE;
/*!40000 ALTER TABLE `tab_upper_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_upper_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_user`
--

DROP TABLE IF EXISTS `tab_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_user` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `account_no` varchar(12) NOT NULL COMMENT '用户编号',
  `account` varchar(15) NOT NULL COMMENT '用户名',
  `cell_phone` varchar(15) NOT NULL COMMENT '手机号',
  `password` varchar(15) NOT NULL DEFAULT '123456' COMMENT '密码',
  `update_time` datetime NOT NULL DEFAULT '2018-02-01 00:00:00' COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `access` int(1) unsigned NOT NULL DEFAULT '1' COMMENT '登录身份权限',
  `img_url` varchar(200) NOT NULL DEFAULT 'img/auto_user.png' COMMENT '用户头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `account_no_UNIQUE` (`account_no`),
  UNIQUE KEY `account_UNIQUE` (`account`),
  UNIQUE KEY `cell_phone_UNIQUE` (`cell_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户登录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_user`
--

LOCK TABLES `tab_user` WRITE;
/*!40000 ALTER TABLE `tab_user` DISABLE KEYS */;
INSERT INTO `tab_user` VALUES (000000000002,'201800000001','binbin2017','15123328419','123456','2018-02-01 00:00:00','2018-05-13 15:33:22',1,'img/auto_user.png'),(000000000018,'201800000002','binbin2018','15123328418','123456','2018-02-01 00:00:00','2018-05-14 15:10:21',1,'img/auto_user.png'),(000000000026,'201800000003','zumeng2018','15123328417','123456','2018-02-01 00:00:00','2018-05-14 15:30:34',1,'img/auto_user.png'),(000000000027,'201800000004','qweeeeeeeeee','15123328415','123456','2018-02-01 00:00:00','2018-05-16 14:16:42',1,'img/auto_user.png'),(000000000028,'201800000005','qweqweweq','15123328416','123456','2018-02-01 00:00:00','2018-05-16 14:36:13',1,'img/auto_user.png'),(000000000029,'201800000006','qweqw122','15123328420','123456','2018-02-01 00:00:00','2018-05-16 14:39:51',1,'img/auto_user.png'),(000000000030,'201800000007','qweqw123','15123328421','123456','2018-02-01 00:00:00','2018-05-16 14:48:33',1,'img/auto_user.png');
/*!40000 ALTER TABLE `tab_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_user_record`
--

DROP TABLE IF EXISTS `tab_user_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_user_record` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `account_no` varchar(12) DEFAULT NULL COMMENT '用户编号',
  `operate_type` varchar(50) DEFAULT NULL COMMENT '操作类型(0/登陆  1/增  2/删  3/改)',
  `operate_content` varchar(255) DEFAULT NULL COMMENT '操作描述',
  `operate_time` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户操作记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_user_record`
--

LOCK TABLES `tab_user_record` WRITE;
/*!40000 ALTER TABLE `tab_user_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_user_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_withdraw_order`
--

DROP TABLE IF EXISTS `tab_withdraw_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_withdraw_order` (
  `id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `order_no` varchar(22) NOT NULL COMMENT '交易订单号\n20180000+(02/提现流水)+12位自增',
  `account_no` varchar(12) NOT NULL,
  `order_pay_method` int(1) NOT NULL DEFAULT '0' COMMENT '订单充值方式(0/系统测试 1/支付宝 2/微信 3/其他)',
  `order_pay_number` varchar(45) NOT NULL DEFAULT '无' COMMENT '支付信息',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  `order_service_charge` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '手续费用',
  `order_remark` varchar(200) NOT NULL DEFAULT '无' COMMENT '计算方式',
  `order_state` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态（0/等待 1/失败 2/成功 ）',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE,
  UNIQUE KEY `withdraw_no_UNIQUE` (`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='提现流水表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_withdraw_order`
--

LOCK TABLES `tab_withdraw_order` WRITE;
/*!40000 ALTER TABLE `tab_withdraw_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_withdraw_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-24 10:41:53
