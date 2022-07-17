-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: localhost    Database: recruiter
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `firm_info`
--

DROP TABLE IF EXISTS `firm_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `firm_info` (
  `number` varchar(33) NOT NULL COMMENT '唯一标识',
  `firm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作为其他表的标识',
  `firm_name` varchar(30) DEFAULT NULL COMMENT '公司名字',
  `firm_avatar` varchar(300) DEFAULT NULL COMMENT '公司头像',
  `financing_scale` varchar(30) DEFAULT NULL COMMENT '融资规模',
  `welfare` varchar(100) DEFAULT NULL COMMENT '福利,以,逗号做间隔',
  `firm_number` varchar(30) DEFAULT NULL COMMENT '企业人数',
  `address` varchar(30) DEFAULT NULL COMMENT '公司地址',
  `field` varchar(100) DEFAULT NULL COMMENT '企业领域',
  `official_URL` varchar(100) DEFAULT NULL COMMENT '企业官网',
  `introduction` text COMMENT '企业简介',
  `legal_person` varchar(11) DEFAULT NULL COMMENT '法人',
  `established` datetime DEFAULT NULL COMMENT '成立时间',
  `info_url` varchar(300) DEFAULT NULL COMMENT '公司信息链接',
  `registered_capital` varchar(11) DEFAULT NULL COMMENT '注册资本',
  `organization_type` varchar(11) DEFAULT NULL COMMENT '机构类型',
  `state` bit(1) DEFAULT NULL COMMENT '状态 0: 可使用 1: 失效',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`firm_id`),
  UNIQUE KEY `firm_info_pk` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='企业信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firm_info`
--

LOCK TABLES `firm_info` WRITE;
/*!40000 ALTER TABLE `firm_info` DISABLE KEYS */;
INSERT INTO `firm_info` VALUES ('c8f3082f7fab456e9c8fa4a382889111',1,'圣诞树巴拉巴拉股份有限公司','/src/assets/img/firm/img.png','融资6000万元','国企,五险一金,周末双休,早九晚六','5000~10000人','广州天河区星官路265号','器械生产','https://www.lagou.com/guangzhou-zhaopin/Java/?labelWords=label','总部位于广东广州，致力于成为全球领先的智慧城市物联网产品与服务提供商；自1997年成立起，创新研发基于物联网架构的感知、连接、平台层相关产品和技术，从下游物联网行业应用出发，以“全息智能”及“泛在通信”两大核心共性技术为科技中台，实现物联网“终端+应用”纵向一体化的战略布局和产业赋能，构筑智慧交通、智慧警务、汽车电子标识、车联网、工业模组、轨道交通、通信监控、金融、机器人等物联网大数据应用产业集群。 选择高新兴的三大理由 :\n（一）有底蕴 ·25年的积累，多个细分行业的领先地位。 ·12大研发中心体系，1400+项全球专利。 ·深度参与国家公共信息安全、车联网等多项国家和行业标准制定。 ·“吴文俊人工智能科学技术奖”、“智慧城市建设最具影响力广东企业”。 ·“国家企业技术中心”、“国家知识产权优势企业”、“广州市人工智能入库企业”。 ·中国人工智能学会常务理事单位、广州智能网联汽车示范区运营中心理事单位，业内最具影响力的高新技术企业之一。 \n（二）有温度 ·全面薪酬体系：具有竞争力的薪酬、年度专项奖金、持续股权激励和员工持股计划。 ·员工成长关怀：导师一对一辅导，180天5个阶段的在岗培养计划；与大咖面对面；内部轮岗机制。 ·员工生活关怀：集团本部提供温馨宿舍、健康美食及往返市区班车；年度体检、健身房、运动俱乐部活动；慈恩基金，帮助员工共渡难关，累计资助金额超百万。 ·承担社会责任：向教育机构及慈善事业捐款已逾百万；与多所著名高校开展校企合作，联合育人。\n（三）有未来 ·5G及新基建的主流赛道，发展前景广阔。 ·物联网、人工智能、大数据等热门技术加持，助力个人品牌实力增值。 ·“双通道”的职业发展路径，提供全方位发展平台。 ·遍布全国多个核心城市的工作机会，满足个人更多职业选择。','王6','2019-07-10 16:00:00','https://www.qcc.com/firm/f1c5372005e04ba99175d5fd3db7b8fc.html','100万元','责任有限公司',_binary '','1970-01-01 00:00:02','1970-01-01 00:00:02'),('a1932aca3344408091e80963c0b95a3e',2,'默默邮政','/src/assets/img/firm/img_1.png','无需融资','带薪年假,年度旅游,餐补','100~10000','广州番禺区19号','卫生,环保','https://www.lagou.com/wn/jobs/10052946.html?show=0344aa77a067484b8f3c6b216f54bc2d','成立于1995年,是广州人才集团控股子公司，拥有先进的心理学评价技术商用化技术及强大的服务能力。 测评中心专注于人力资源评价手段、工具以及体系方法的研究，以建立规范的人才评价体系、为客户提供高增值的人力资源服务为己任，为政府机关、事业单位、企业、高校提供基于创新理念的组织架构调整、定岗定编、绩效薪酬、员工激励及退出、持续培育和成长、薪酬福利调查报告、人力资源相关培训、人才测评、招聘考试、劳务派遣、题库建设、人事人才信息系统开发、档案数字化加工、人才大数据建设、数据分析、人才征信体系建设等多项人力资源服务。依托专业、专精、专注的服务精神，权威的专家顾问支持以及丰富的人力资源服务经验，获得业内好评，业务范围覆盖全国31个省、市、自治区。','李四四','2012-12-03 00:00:00','https://www.qcc.com/firm/9cce0780ab7644008b73bc2120479d31.html','200万元','责任有限公司',_binary '','2022-04-29 10:03:53','2022-04-24 02:08:11'),('57ba08fc1037486386df9e51ebf07fa6',3,'11房地产','/src/assets/img/firm/img_2.png','未融资','弹性上班,学习机会大,成长空间大','1020~10010','广州增城区6号','交换机,5G','https://www.lagou.com/wn/jobs/1638542.html?show=0344aa77a067484b8f3c6b216f54bc2d','致力于打造面向智能产线与智慧工厂***控制大脑的高科技公司。公司围绕“机器人视觉核心算法与单机器人工作站、多机器人群体共融、行业定制化应用”打造产品体系，面向智能制造、智慧物流等场景实现软件定义智能。创始团队在计算机视觉、机器人、3D图形、云计算大数据等领域拥有多年研究积累，多项研究成果达到国际领先水平，多次获得国家和省部级科技奖励。公司现有近200人团队，其中博士占15%，硕士以上60%，本科以上99%，来自于普林斯顿、瑞士联邦理工、德国波恩大学、慕尼黑理工大学、哥伦比亚大学、国防科技大学、中科院等知名高校与科研机构，技术力量雄厚。\n\n成立以来，已完成5轮融资，天使轮由图灵创投领投，A轮近亿元融资由和玉资本领投，A+轮过亿元融资由中金资本领投。公司在3D视觉算法、机器人柔性控制、手眼协同融合、产线级机器人协同、工厂级智能规划与调度等方面均有国际领先技术和行业落地应用，在重工业智能分拣产线、大尺寸高精度三维量测、智能物流搬运机器人等方面填补了国内空白。视比特的多个核心产品已经在工程机械、智慧物流、汽车工业量测等领域大面积交付使用，在行业中享有良好口碑。\n\n面向工程机械/重工行业智慧工厂，推出了基于“AI+3D视觉”的钢板切割下料全自动分拣系统等标准产品；\n面向汽车工业/一般工业，推出了超高精度尺寸测量及缺陷检测系统等标准产品；\n面向智慧物流行业，推出了3D视觉智能分拣机器人等标准产品。','王五','2002-12-03 00:00:00','https://www.qcc.com/firm/8c9f7ddc1a7bcee3d1f7676773fe9404.html','2100万元','其他',_binary '','2022-05-20 15:32:13','2022-04-24 02:30:28');
/*!40000 ALTER TABLE `firm_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_favorites`
--

DROP TABLE IF EXISTS `job_favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_favorites` (
  `number` varchar(33) NOT NULL COMMENT '唯一标识',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `job_number` varchar(33) DEFAULT NULL COMMENT '职位标识',
  `state` bit(1) DEFAULT NULL COMMENT '状态 0: 可使用 1: 失效',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`number`),
  KEY `job_favorites_user_info_id_fk` (`user_id`),
  KEY `job_favorites_job_list_number_fk` (`job_number`),
  CONSTRAINT `job_favorites_job_list_number_fk` FOREIGN KEY (`job_number`) REFERENCES `job_list` (`number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `job_favorites_user_info_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_favorites`
--

LOCK TABLES `job_favorites` WRITE;
/*!40000 ALTER TABLE `job_favorites` DISABLE KEYS */;
INSERT INTO `job_favorites` VALUES ('2c156bd625bf440cab299cf815ee963c',608690177,NULL,_binary '',NULL,'2022-05-20 07:29:58'),('4d0b046e850b4b818325c4794d07be83',-340623359,'459bb3b3f89a40359b2c59f1ecc9acd4',NULL,NULL,'2022-05-20 14:36:38'),('5912b187151c4a9c9d66ac3a49e7d8b8',1225252866,NULL,_binary '',NULL,'2022-05-20 07:31:22'),('798382553f9b4b729cd7583a29326dbe',1,'17827181e80841a080f50b670be7bb3c',NULL,NULL,'2022-04-27 07:27:38'),('932f644428094ef69e28fa140b2a0fa3',-340623359,'17927181e80841a080f50b670be7bb3c',NULL,NULL,'2022-05-09 07:44:03'),('9cf1402f741c44cbac39d55f8be8114d',-340623359,'17827181e80841a080f50b670be7bb3c',NULL,NULL,'2022-05-20 07:05:54'),('9fa2834f32894b379d4a31f75989783d',1,'17927181e80841a080f50b670be7bb3c',NULL,NULL,'2022-05-21 05:02:25');
/*!40000 ALTER TABLE `job_favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_hunting_info`
--

DROP TABLE IF EXISTS `job_hunting_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_hunting_info` (
  `number` varchar(33) NOT NULL COMMENT '唯一标识',
  `id` int(11) NOT NULL,
  `job_status` varchar(10) DEFAULT NULL COMMENT '求职状态',
  `position` varchar(20) DEFAULT NULL COMMENT '职位',
  `salary_min` int(11) DEFAULT NULL COMMENT '最低工资',
  `salary_max` int(11) DEFAULT NULL COMMENT '最高工资',
  `expect_city` varchar(30) DEFAULT NULL COMMENT '期望城市',
  `expect_industry` varchar(20) DEFAULT NULL COMMENT '期望行业',
  `job_nature` varchar(10) DEFAULT NULL COMMENT '工作性质',
  `colleges` varchar(30) DEFAULT NULL COMMENT '学校名称',
  `education` varchar(10) DEFAULT NULL COMMENT '学历',
  `profession` varchar(10) DEFAULT NULL COMMENT '专业',
  `academic_year` varchar(100) DEFAULT NULL COMMENT '学年',
  `appendix` varchar(500) DEFAULT NULL COMMENT '附件路径',
  `professional_skill` text COMMENT '专业技能',
  `works` text COMMENT '作品',
  `state` bit(1) DEFAULT b'1' COMMENT '状态: true 可用, false不可用',
  `update_time` date DEFAULT NULL COMMENT '更新事件',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`number`),
  KEY `job_hunting_info_user_info_id_fk` (`id`),
  CONSTRAINT `job_hunting_info_user_info_id_fk` FOREIGN KEY (`id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='求职信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_hunting_info`
--

LOCK TABLES `job_hunting_info` WRITE;
/*!40000 ALTER TABLE `job_hunting_info` DISABLE KEYS */;
INSERT INTO `job_hunting_info` VALUES ('17827180e80841a080f49b670be7bb3c',1,'在校','java开发',8000,10000,'武汉,杭州,南宁','互联网','实习','巴拉大学','本科','软件工程','1605196800000,1688140800000','/userPDF/Java开发_卓越.pdf','熟练掌握Java : 集合, Map, 线程, IO流, 反射等。\n熟练应用mysql数据库。\n熟练应用spring, springMVC, springboot, springcloud, Mybatis等主流框架。\n熟练掌握开发工具：idea。\n熟练掌握前端技术：Servlet, JavaScript, Ajax。\n会基础Linux命令。\n了解Redis, MongoDB非关系型数据库。\n了解常用的设计模式 : 如单例模式, 原型模式, 工厂模式, 适配器模式, 建造者模式。\n了解前端技术: vue(MVVM思想)。\n','图书馆管理系统\n项目简介 : 基于spring, springMVC, mybatis, jsp的图书管理系统, 有前端展示页面, 提供图书检索功能, 有后台,提供图书\n的增删改查功能。\n技术栈 : Spring, SpringMVC, Mybatis, Jsp, Mysql, Jquery。\n内容 :\n实现用户对书籍的借还, 及图书借出超时的提醒。\n使用Mysql对用户,书籍, 超级管理员的信息存储。\n使用Jsp,Boostrap进行前端主页书籍展示,。\n使用Jquery, 自己编辑正则表达式的规则, 对注册信息进行验证。\n提供AOP事务, 监控sql语句的执行。\n提供图片上传功能, 使图书有封面展示, 可在后台修改图书封面,及其他展示数据。\n负责模块: 个人独立完成整个项目。\n项目链接: 图书馆管理系统',_binary '','2022-06-05','2022-04-16'),('18059ebc242548978c80b1537549b443',1225252866,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '',NULL,'2022-05-20'),('6e6d17d674724276b688290c48391f9c',-340623359,'在校','Java架构师',10000,12000,'广州,深圳','互联网','全职','大学','本科','金融','1483459200000,1654790400000','/userPDF/Java开发_卓越2.pdf','专精word\nhahahahahahah','不清楚\n没有没有!!',_binary '','2022-06-05','2022-05-05'),('d1072e3caa3c4001a15c2a45d441fbb6',608690177,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '',NULL,'2022-05-20');
/*!40000 ALTER TABLE `job_hunting_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_list`
--

DROP TABLE IF EXISTS `job_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_list` (
  `number` varchar(33) NOT NULL COMMENT '唯一标识',
  `announcer_id` int(11) NOT NULL COMMENT '发布者id',
  `firm_id` int(11) DEFAULT NULL COMMENT '公司id',
  `position` varchar(30) DEFAULT NULL COMMENT '职位',
  `technology_stack` varchar(50) DEFAULT NULL COMMENT '技术栈,以逗号分隔',
  `address` varchar(30) DEFAULT NULL COMMENT '工作地址',
  `work_experience` varchar(10) DEFAULT NULL COMMENT '工作经验',
  `education` varchar(10) DEFAULT NULL COMMENT '学历要求',
  `applicant_count` varchar(30) DEFAULT NULL COMMENT '申请人数',
  `salary` varchar(50) DEFAULT NULL COMMENT '薪资',
  `require_count` varchar(30) DEFAULT NULL COMMENT '需求人数',
  `state` bit(1) DEFAULT NULL COMMENT '状态 0: 可使用 1: 失效',
  `nature` varchar(10) DEFAULT NULL COMMENT '工作性质',
  `application_conditions` text COMMENT '应聘条件',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`number`),
  KEY `job_list_firm_info_firm_id_fk` (`firm_id`),
  KEY `job_list_user_info_id_fk` (`announcer_id`),
  CONSTRAINT `job_list_firm_info_firm_id_fk` FOREIGN KEY (`firm_id`) REFERENCES `firm_info` (`firm_id`),
  CONSTRAINT `job_list_user_info_id_fk` FOREIGN KEY (`announcer_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_list`
--

LOCK TABLES `job_list` WRITE;
/*!40000 ALTER TABLE `job_list` DISABLE KEYS */;
INSERT INTO `job_list` VALUES ('17827181e80841a080f50b670be7bb3c',1,1,'java后端','github,Spring Boot,SpringCloud,MongoDB','广州','1年','本科','15','[\"8000\",\"14000\"]','11',_binary '\0','社会招聘','(1)SSM\n (2)springboot\n(3)微服务\n(4)负载均衡\n(5)mysql,sql调优','2022-04-21 15:58:01','2022-05-21 04:07:31'),('17927181e80841a080f50b670be7bb3c',1,1,'C++','数据结构,嵌入式','No. 190, Grove St, Los Angeles','3年','大专以上','15','[\"9000\",\"10000\"]','1',_binary '','实习','会嵌入式ssss','2022-04-21 16:00:22','2022-04-21 16:00:20'),('2ba29c50eecd4aa29f8bab28be4c1220',1,1,'Java开发','github,Java,Spring Boot,SpringCloud','深圳',NULL,NULL,'0','[\"7000\",\"8500\"]','2',_binary '',NULL,' 开发经验至少一年','2022-05-20 14:32:58','2022-05-20 14:31:58'),('315a30e97bf041398130a660da923b50',608690177,2,'UI设计','CSS,JS,Vue3','深圳',NULL,NULL,'0','[\"8020\",\"19000\"]','3',_binary '',NULL,' 一年开发经验','2022-05-20 08:48:15','2022-05-20 08:47:35'),('459bb3b3f89a40359b2c59f1ecc9acd4',608690177,2,'Mysql数据库架构师','MySQL,MongoDB','深圳',NULL,NULL,'0','[\"6000\",\"7000\"]','1',_binary '',NULL,' 精通Mysql数据库!','2022-05-20 09:13:18','2022-05-20 09:12:36'),('5e5f63254b42484691dcfb051224e389',608690177,2,'室内设计','做事认真','深圳',NULL,NULL,'0','[\"9000\",\"12000\"]','1',_binary '',NULL,' 一年工作经验','2022-05-20 08:55:10','2022-05-20 08:54:25'),('67698c42d7514366939619a550bd8b91',608690177,2,'游戏开发','C/C++,C#','深圳市',NULL,NULL,'0','[\"7500\",\"15000\"]','2',_binary '\0',NULL,' 有一年的开发经验','2022-05-20 08:15:34','2022-05-20 14:09:24'),('83dfb88862c749c9a856c7189c87028a',608690177,2,'java','Java','广州',NULL,NULL,'0','[\"5000\",\"6000\"]','0',_binary '',NULL,'一年','2022-05-20 09:18:03','2022-05-20 09:17:40'),('8ad3e96d6a284b50b1411099dd6722d8',608690177,2,'web','JS,Vue3','nan ',NULL,NULL,'0','[\"8000\",\"10000\"]','1',_binary '',NULL,' 一年开发经验!','2022-05-20 08:46:57','2022-05-20 08:46:16'),('eb153e0794f8409cb965a464e6c58742',1,1,'动画设计','CSS,英语专业8级,能说会做','深圳',NULL,NULL,'0','[\"9000\",\"12000\"]','1',_binary '',NULL,' 一年以上开发经验','2022-06-12 09:07:21','2022-06-12 09:06:18');
/*!40000 ALTER TABLE `job_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume_delivery`
--

DROP TABLE IF EXISTS `resume_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume_delivery` (
  `number` varchar(33) NOT NULL COMMENT '唯一标识',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `is_online_resume` bit(1) DEFAULT b'1' COMMENT '是否使用在线简历',
  `job_number` varchar(33) DEFAULT NULL COMMENT '职位标识',
  `firm_id` int(11) NOT NULL COMMENT '公司id',
  `state` bit(1) DEFAULT NULL COMMENT '状态 0: 可使用 1: 失效',
  `result` tinyint(4) DEFAULT '1' COMMENT '简历评估结果 1:未查看 2:已查看(正在评估) 3: 简历通过 4:简历拒绝',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`number`),
  KEY `resume_delivery_firm_info_firm_id_fk` (`firm_id`),
  KEY `resume_delivery_user_info_id_fk` (`user_id`),
  KEY `resume_delivery_job_list_number_fk` (`job_number`),
  CONSTRAINT `resume_delivery_firm_info_firm_id_fk` FOREIGN KEY (`firm_id`) REFERENCES `firm_info` (`firm_id`),
  CONSTRAINT `resume_delivery_job_list_number_fk` FOREIGN KEY (`job_number`) REFERENCES `job_list` (`number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resume_delivery_user_info_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位投递表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume_delivery`
--

LOCK TABLES `resume_delivery` WRITE;
/*!40000 ALTER TABLE `resume_delivery` DISABLE KEYS */;
INSERT INTO `resume_delivery` VALUES ('49dd5fa60cf048d79b01f3c04e07c429',1,_binary '','2ba29c50eecd4aa29f8bab28be4c1220',1,NULL,1,'2022-06-06 03:35:35',NULL),('56b2194a9756485993f2648d0a5aec45',1,_binary '','17927181e80841a080f50b670be7bb3c',1,NULL,1,'2022-06-06 03:35:15',NULL),('63de7a07caed4167a869e2d283e5b8ea',-340623359,_binary '','2ba29c50eecd4aa29f8bab28be4c1220',1,NULL,3,'2022-05-20 14:41:37','2022-05-20 14:42:00'),('cd3d4c90d8a44990902cbeeef3bf7aa2',1,_binary '\0','17827181e80841a080f50b670be7bb3c',1,_binary '',3,'2022-05-01 22:11:18','2022-05-21 05:01:13');
/*!40000 ALTER TABLE `resume_delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t1_user`
--

DROP TABLE IF EXISTS `t1_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t1_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passwd` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t1_user`
--

LOCK TABLES `t1_user` WRITE;
/*!40000 ALTER TABLE `t1_user` DISABLE KEYS */;
INSERT INTO `t1_user` VALUES (1,'1','xgx'),(2,'1','myn'),(3,'1','xhz');
/*!40000 ALTER TABLE `t1_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_dialogue`
--

DROP TABLE IF EXISTS `user_dialogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_dialogue` (
  `number` varchar(33) NOT NULL COMMENT '唯一标识',
  `id` int(11) NOT NULL,
  `contact_user_id` int(11) NOT NULL COMMENT '联系对象id',
  `record_path` varchar(500) DEFAULT NULL COMMENT '对话记录路径',
  PRIMARY KEY (`number`),
  KEY `user_dialogue_user_info_id_fk` (`id`),
  KEY `user_dialogue_user_info_id_fk_2` (`contact_user_id`),
  CONSTRAINT `user_dialogue_user_info_id_fk` FOREIGN KEY (`id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_dialogue_user_info_id_fk_2` FOREIGN KEY (`contact_user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户对话表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_dialogue`
--

LOCK TABLES `user_dialogue` WRITE;
/*!40000 ALTER TABLE `user_dialogue` DISABLE KEYS */;
INSERT INTO `user_dialogue` VALUES ('3fc84283f9f54489892130c0e3a63691',-340623359,1,NULL),('b5b49dec110a463dbe04003a6ce7ca84',1,-340623359,NULL),('f0cf188cd1be4f53a28cca4fb0458899',608690177,1,NULL),('f127eff44fab4f519af1e386aa1d175a',1,608690177,NULL);
/*!40000 ALTER TABLE `user_dialogue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_id`
--

DROP TABLE IF EXISTS `user_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `number` varchar(32) NOT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`),
  KEY `user_id_id_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1225252867 DEFAULT CHARSET=utf8 COMMENT='用户id表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_id`
--

LOCK TABLES `user_id` WRITE;
/*!40000 ALTER TABLE `user_id` DISABLE KEYS */;
INSERT INTO `user_id` VALUES (-340623359,'c303ec5df9494837824f76b3a7b46ebd'),(1,'aa54a6e69aca449c9bbbee24be69d91e'),(608690177,'aaa7db3a439f499698e9251844f66543'),(1225252866,'931d943cc69242daa2853a8422b4a009');
/*!40000 ALTER TABLE `user_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `number` varchar(32) NOT NULL COMMENT '唯一标识',
  `name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `iphone` varchar(20) DEFAULT NULL COMMENT '电话',
  `vx` varchar(100) DEFAULT NULL COMMENT '微信号',
  `img_path` varchar(500) DEFAULT NULL COMMENT ' 图片路径',
  `introduction` text COMMENT '简介',
  `position` varchar(15) DEFAULT NULL COMMENT '职位',
  `firm_id` int(11) DEFAULT NULL COMMENT '公司id号',
  `state` bit(1) DEFAULT NULL COMMENT '状态 0: 可使用 1: 失效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`number`),
  KEY `user_info_fk` (`id`),
  KEY `user_info_firm_info_firm_id_fk` (`firm_id`),
  CONSTRAINT `user_info_firm_info_firm_id_fk` FOREIGN KEY (`firm_id`) REFERENCES `firm_info` (`firm_id`),
  CONSTRAINT `user_info_fk` FOREIGN KEY (`id`) REFERENCES `user_id` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (608690177,'7fbcdb7df41c4f29b78c6835ebbf2c03','HR_1',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,_binary '',NULL,NULL),(1,'9583AA651B36CD2020B5E97111941557','life-1',21,0,'天津','1421559135@QQ.COM','13159165749411','13515965111','/userAvatar/1579071293_364552.jpg','      小时候，总常常幻想着自己可以长大，可以独自一人去领略更多优美的风光。 \n我们这一生，会有太多太多的梦想，要么就是用尽全力去实现他，要么就是永远沉积在自己的心中。\n 我喜欢旅行，向往美丽的山、美丽的水，一见到大海和草原我就会心旷神怡，深陷其中。\n 我期盼可以带着自己最爱的人去遨游世界，让他给自己拍上几张美美的照片。\n 我期盼可以带着自己最爱的人去遨游世界，让他给自己拍上几张美美的照片。\n 我期盼可以带着自己最爱的人去遨游世界，让他给自己拍上几张美美的照片。\n 我期盼可以带着自己最爱的人去遨游世界，让他给自己拍上几张美美的照片。\n 我期盼可以带着自己最爱的人去遨游世界，让他给自己拍上几张美美的照片。\n (2)小时候，总常常幻想着自己可以长大，可以独自一人去领略更多优美的风光。\n (3)我们这一生，会有太多太多的梦想，要么就是用尽全力去实现他，要么就是永远沉积在自己的心中。 我喜欢旅行，向往美丽的山、美丽的水，一见到大海和草原我就会心旷神怡，深陷其中。 我期盼可以带着自己最爱的人去遨游世界，让他给自己拍上几张美美的照片。','人事HR',1,_binary '','2021-11-20 18:47:22','2022-04-19 17:52:19'),(-340623359,'b73d6febdfd54eba98ed439af9f11091','第二用户',23,0,'北京','863388883@qq.com','195468135921','195468135921','/userAvatar/u=2240731441,2000065326&fm=26&gp=0.jpg',NULL,NULL,NULL,_binary '\0',NULL,NULL),(1225252866,'b76a373c2fc64dfe8dc5d24afd3a362c','HR_2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,_binary '',NULL,NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `number` varchar(32) NOT NULL COMMENT '唯一标识',
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`number`),
  KEY `user_login_fk` (`id`),
  CONSTRAINT `user_login_fk` FOREIGN KEY (`id`) REFERENCES `user_id` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (1225252866,'07856ceb34904883a40cfb6850c29dff','4','444'),(608690177,'2fecbd96bf60439e8d20136fc3862e13','3','333'),(-340623359,'98b72005b9844feebf2c623df1d9a609','2','222'),(1,'99CAD9639C9EE9954690F52BABE82F35','1','111');
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rank`
--

DROP TABLE IF EXISTS `user_rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_rank` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `number` varchar(32) NOT NULL COMMENT '唯一标识',
  `identity` varchar(255) DEFAULT NULL COMMENT '身份',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`number`),
  KEY `user_rank_fk` (`id`),
  CONSTRAINT `user_rank_fk` FOREIGN KEY (`id`) REFERENCES `user_id` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rank`
--

LOCK TABLES `user_rank` WRITE;
/*!40000 ALTER TABLE `user_rank` DISABLE KEYS */;
INSERT INTO `user_rank` VALUES (1,'09aa7faf0c59bf416f14e917d3f6fad9','admin','user;role;page;firm;client;admin;editor'),(-340623359,'22d74c5ce54545b990219ecc73c1bffd','user','client'),(1225252866,'69a8e52d84c749a687704db50de40049','user','client'),(608690177,'a009495adb1749b696cfb9a16ac68975','user','client');
/*!40000 ALTER TABLE `user_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_resource`
--

DROP TABLE IF EXISTS `user_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_resource` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `number` varchar(32) NOT NULL COMMENT '唯一标识',
  `imgPath` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `appendix` varchar(255) DEFAULT NULL COMMENT '附件路径',
  PRIMARY KEY (`number`),
  KEY `user_resource_fk` (`id`),
  CONSTRAINT `user_resource_fk` FOREIGN KEY (`id`) REFERENCES `user_id` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_resource`
--

LOCK TABLES `user_resource` WRITE;
/*!40000 ALTER TABLE `user_resource` DISABLE KEYS */;
INSERT INTO `user_resource` VALUES (1,'d19d3f6e6f705cb6410b7aa00d3bcaef','/','/');
/*!40000 ALTER TABLE `user_resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17 15:39:20
