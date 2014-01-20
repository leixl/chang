/*
Navicat MySQL Data Transfer

Source Server         : ����
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : easyframework-root

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2014-01-16 14:17:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `action_url` varchar(200) NOT NULL COMMENT '菜单链接',
  `lft` int(11) DEFAULT NULL COMMENT '左',
  `rgt` int(11) DEFAULT NULL COMMENT '右',
  `priority` int(11) DEFAULT NULL COMMENT '排序',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_date` date DEFAULT NULL COMMENT '修改日期',
  `perm_prefix` varchar(100) DEFAULT NULL COMMENT '权限前缀',
  `is_leaf` tinyint(1) DEFAULT NULL COMMENT '是否叶子',
  `is_display` tinyint(1) DEFAULT NULL COMMENT '是否显示',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '平台首页', '1', '1', '8', '1', '2013-09-29', '2013-09-29', '1', '0', '1', null);
INSERT INTO `t_menu` VALUES ('2', '系统管理', '1', '8', '19', '3', '2013-09-29', '2013-09-29', '1', '0', '1', null);
INSERT INTO `t_menu` VALUES ('3', '会员管理', '1', '19', '20', '3', '2013-09-29', '2013-09-29', '1', '0', '1', null);
INSERT INTO `t_menu` VALUES ('4', '权限设置', '1', '1', '8', '1', '2013-09-29', '2013-09-29', '1', '1', '1', '2');
INSERT INTO `t_menu` VALUES ('5', '系统设置', '1', '9', '18', '10', '2013-12-13', '2013-12-13', null, null, '1', '2');
INSERT INTO `t_menu` VALUES ('6', '管理员', '1222', '6', '7', '10', '2013-12-13', '2013-12-13', '13323332', null, '1', '4');
INSERT INTO `t_menu` VALUES ('7', '角色管理', '22', '2', '3', '10', '2013-12-13', '2013-12-13', '22', null, '1', '4');
INSERT INTO `t_menu` VALUES ('8', '部门管理', '1', '4', '5', '11', '2013-12-13', '2013-12-13', '11', null, '1', '4');
INSERT INTO `t_menu` VALUES ('9', '全局设置', '1', '10', '11', '10', '2013-12-15', '2013-12-15', '11', null, '1', '5');
INSERT INTO `t_menu` VALUES ('10', '数据字典', '1', '12', '13', '10', '2013-12-15', '2013-12-15', '1', null, '1', '5');
INSERT INTO `t_menu` VALUES ('11', 'FTP设置', '22', '14', '15', '10', '2013-12-15', '2013-12-15', '33', null, '1', '5');
INSERT INTO `t_menu` VALUES ('12', '工作流设置', '22', '16', '17', '10', '2013-12-15', '2013-12-15', '33', null, '1', '5');
INSERT INTO `t_menu` VALUES ('13', '内容管理', '11', '21', '22', '2', '2013-12-23', '2013-12-23', '11', null, '1', null);

-- ----------------------------
-- Table structure for `t_movie`
-- ----------------------------
DROP TABLE IF EXISTS `t_movie`;
CREATE TABLE `t_movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '原名',
  `simple_name` varchar(32) DEFAULT NULL COMMENT '简体中文名',
  `alias_name1` varchar(32) DEFAULT NULL COMMENT '别名1',
  `alias_name2` varchar(32) DEFAULT NULL COMMENT '别名2',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `imdb_no` varchar(32) DEFAULT NULL COMMENT 'IMDb编号',
  `director` varchar(32) DEFAULT NULL COMMENT '导演',
  `scenarist` varchar(32) DEFAULT NULL COMMENT '编剧',
  `area` varchar(32) DEFAULT NULL COMMENT '制片国家/地区',
  `publish_year` varchar(32) DEFAULT NULL COMMENT '年份',
  `screening_date` varchar(32) DEFAULT NULL COMMENT '上映日期',
  `leng` int(11) DEFAULT NULL COMMENT '片长',
  `remark` text COMMENT 'IMDb编号',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_date` date DEFAULT NULL COMMENT '修改日期',
  `is_recommend` tinyint(1) DEFAULT NULL COMMENT '是否推荐',
  `cover` varchar(32) DEFAULT NULL COMMENT '封面',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用',
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='电影信息表';

-- ----------------------------
-- Records of t_movie
-- ----------------------------
INSERT INTO `t_movie` VALUES ('1', '私人订制', '私人订制', '', '', '', null, '冯小刚', '王朔', '中国大陆', '2013', '2013-12-19 00:00:00', '120', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">    愿望规划师杨重（葛优 饰）、情境设计师小白（白百何 饰）、梦境重建师小璐（李小璐 饰）与心灵麻醉师马青（郑恺 饰）四人组成的公司“私人订制”，以“替他人圆梦”为自身业务，专门为不同客户量身订制“圆梦方案”，无论客户的白日梦多奇葩、要求多严格，“圆梦四人组”统统来者不拒，甘愿满足客户的任何需求，正如同“私人订制”公司的口号——“成全别人，恶心自己”。 </span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">　　一时间，许多怀揣着“奇葩梦”的客户纷纷找上门，私人订制公司也接连面临各种挑战：一心想过“烈士瘾”的陕西女青年（苗圃 饰）、立志追求高雅跟俗“一刀两断”的全球最“俗”导演（李诚儒 饰）、想要当清官“自愿”接受钱色诱惑的司机师傅（范伟 饰）、生日愿望是想变成“有钱人”的河道清洁工人丹姐（宋丹丹 饰）……“寻梦者”络绎不绝，“圆梦四人组”也绞尽脑汁为每一位客户私人订制圆梦方案，过程中发生了许许多多令人捧腹的荒诞事儿，每一位客户也都在最后“梦想成真”。</span></p>\n', '2013-12-23', '2013-12-23', '1', '/u/201401/15165333mpxr.jpg', '0');
INSERT INTO `t_movie` VALUES ('2', '警察故事', '警察故事', '', '', '', null, '丁晟', '丁晟', '中国大陆', '2013', '2013-12-19 00:00:00', '120', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">夜，繁华街区一座大型酒吧内，所有客人被劫持为人质。其中包括刑警钟文和女儿苗苗，以及一群似曾相识的陌生人&hellip;&hellip;劫匪是酒吧老板武江，以人质威胁要求释放一名在押多年的罪犯，到底是怎样的动机，值得他铤而走险？&nbsp;</span></p>\r\n', '2013-12-23', '2013-12-23', '0', null, '0');
INSERT INTO `t_movie` VALUES ('3', '風暴', '風暴', '', '', '風暴', null, '袁锦麟', '袁锦麟', '香港 / 中国大陆', '2013', '2013-12-12(中国大陆) / 2013-12-19', '120', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">吕明哲（刘德华 饰）是香港屡破大案的高级督察，陶成邦（林家栋 饰）是屡教不改刚出狱的街头混混。吕明哲在一次街头对峙悍匪头目曹楠（胡军 饰）已占上风时，被儿时的好友陶成邦搅局。面对犯罪团伙的不断挑衅，吕明哲誓言不惜一切代价将其一锅端，警匪双方的杀戮游戏正式开始。&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">　　此时与陶成邦相恋多年的女友燕冰（姚晨 饰）发现了男友的异常，为赢回对自己失望的女友，陶成邦和吕明哲达成了一笔交易&hellip;&hellip;&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">　　风暴过境，一触即发，每个人都被这场高压的漩涡气流逼至身份模糊的灰色地带。&nbsp;</span></p>\r\n', '2013-12-23', '2013-12-23', '0', null, '0');
INSERT INTO `t_movie` VALUES ('4', '无人区', '无人区', '', '', '无人区', null, '宁浩', '王红卫', '中国大陆', '2013', '2013-12-19', '120', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">小有名气但利欲熏心的律师潘肖（徐峥 饰），凭借扎实的法律知识和巧舌如簧的庭辩技巧，成功帮盗捕国家珍禽阿拉泰隼并残忍杀害一名警察的西北盗猎团伙老大（多布杰 饰）洗脱罪名。老大承诺十天后付清余款，潘肖则要求对方用一辆红色轿车抵押。在此之后，他驾驶着新车踏上从西北荒漠返回大都会的路程。谁知路上险情不断，先是和一对开卡车拉茅草的哥俩（王双宝 &amp; 巴多 饰）发生摩擦，导致人伤车损，接着又不慎撞飞一个似乎拦车求助的男子（黄渤 饰）。自知摊上人命的潘肖辗转来到一家专事不法勾当的黑店，并在此结识了受困于此的妓女（余男 饰）。与此同时，盗猎老大尾随其后，似乎另有凶险计划。&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">　　此时潘肖还没真正意识到，他前方是怎样一条充满凶险的旅途&hellip;&hellip;</span></p>\r\n', '2013-12-23', '2013-12-23', '0', null, '0');
INSERT INTO `t_movie` VALUES ('5', '致我们终将逝去的青春', '致我们终将逝去的青春', '', '', '致我们终将逝去的青春2013', null, '赵薇', '李樯', '中国大陆', '2013', '2013-04-26(中国大陆)', '132', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">18岁的郑微（杨子姗 饰）终于如愿考上青梅竹马邻家大哥哥林静（韩庚 饰）所在学校的邻校，等她满怀期冀地步入大学校园，却遭遇打击&mdash;&mdash;林静出国留学，杳无音信。郑微倍感失落，患难时刻与室友阮莞（江疏影 饰）、朱小北（刘雅瑟 饰）、黎维娟（张瑶 饰）及师哥老张-张开（包贝尔 饰）结 下深厚友谊，同时富家公子许开阳（郑恺 饰）对郑微展开了疯狂的追求，而备受男生欢迎的阮莞用她特有的清冷守护着对于心爱人赵世永（黄明 饰）的忠贞。一次偶然的误会使郑微与老张室友陈孝正（赵又廷 饰）结为死敌，在一次次地反击中，郑微发现自己爱上了这个表面冷酷、内心善良的高材生，于是疯狂地反击演变为死缠烂打地追求，而陈孝正也终于在强攻之下缴械投降，欢喜冤家终成甜蜜恋人。大四毕业之际郑微的生活再次经受考验：陈孝正得到曾毓（王嘉佳 饰）的出国留学名额，却迟迟不敢告诉郑微，感觉再次被欺骗的郑微痛苦地离开陈孝正&hellip;&hellip;&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">　　多年后，郑微已蜕变为职场上的白领丽人，竟再次品尝命运的无常：带着悔意和爱意的林静和陈孝正同时回到她的生活里！郑微，这个昔日的玉面小飞龙，将怎样面对生活和青春赐予她的迷雾和抉择&hellip;&hellip;&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">　　本片改编自辛夷坞同名畅销小说。赵薇的首部导演作品，也是其在北京电影学院导演系研究生专业的毕业作品。</span></p>\r\n', '2013-12-23', '2013-12-23', '0', null, '0');
INSERT INTO `t_movie` VALUES ('6', '等风来 ', '等风来 ', '', '', '等风来 (2013)', null, '滕华涛', '鲍鲸鲸', '中国大陆', '2013', '2013-12-31(中国大陆)', '130', '', '2013-12-23', '2013-12-23', '0', '/u/201401/131715130cc3.jpg', '0');
INSERT INTO `t_movie` VALUES ('7', '救火英雄', '救火英雄', '', '', '救火英雄 (2014)', null, '郭子健', '梁礼彦 / 翁子光 / 郭子健', '中国大陆', '2014', '2013-12-12(中国大陆) / 2013-12-19', '130', '', '2014-01-08', '2014-01-08', '0', '/u/201401/12120453fcsv.jpg', '0');
INSERT INTO `t_movie` VALUES ('8', '安德的游戏', '安德的游戏', '1', '2', '安德的游戏 Ender\'s Game (2013)', null, '加文·胡德', '加文·胡德 / 奥森·斯科特·卡德', '中国大陆', '2013', '2013-12-12(中国大陆) / 2013-12-19', '130', '', '2014-01-08', '2014-01-08', '1', '/u/201401/13171440csjl.jpg', '0');
INSERT INTO `t_movie` VALUES ('9', '一代宗师', '一代宗师', '1', '2', '一代宗师一代宗师2013', null, ' 王家卫', ' 王家卫', '中国大陆', '2013', '2013-12-12(中国大陆) / 2013-12-19', '150', 'aaa', '2014-01-08', '2014-01-08', '1', '/u/201401/13171410jrud.jpg', '0');
INSERT INTO `t_movie` VALUES ('11', '神偷奶爸2', '神偷奶爸2', '神偷奶爸2', '神偷奶爸2', '神偷奶爸2 Despicable Me 2 (2013)', null, '皮埃尔·科芬 / 克里斯·雷纳德', '辛科·保罗 / 肯·达里奥', '美国', '2014', '2014-01-10(中国大陆) / 2013-07-03', '99', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">自从与玛戈（米兰达·卡斯格拉夫 Miranda Cosgrove 配音）、伊迪丝（达娜·盖伊 Dana Gaier 配音）和阿格蕾丝（埃尔希·费舍 Elsie Fisher 配音）三个可爱的小女孩实现宿命的邂逅，曾经的大坏蛋格鲁（史蒂夫·卡瑞尔 Steve Carell 配音）可真彻底转型了，他金盆洗手，转而化身为慈祥可亲的爸爸和做得一手烂口味布丁果冻的商人。当然凡事没有尽善尽美的，在此期间，憧憬大坏蛋传奇人生的老搭档纳法利欧博士（拉塞尔·布兰德 Russell Brand 配音）离他而去，另谋高就。某天，格鲁被身怀绝技却鲁莽的特工露西·王尔德（克里斯汀·韦格 Kristen Wiig 配音）绑架，原来露西所在的集团研制出可以改变生物基因的药物，可他们位于南极的实验室被神秘窃贼偷走，因此才委托有过坏蛋经验的格鲁做卧底。 </span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">　　经过一番考虑，格鲁接受了这项任务，带着超萌的小黄人们，和露西组成了爆笑连连的追凶搭档……</span></p>\n', '2014-01-14', '2014-01-14', '1', '/u/201401/14143332ga27.jpg', '0');
INSERT INTO `t_movie` VALUES ('12', '白宫管家', '白宫管家', '白宫管家', '白宫管家', '白宫管家 The Butler (2013)', null, '李·丹尼尔斯', '威尔·海古德 / 李·丹尼尔斯 / 丹尼·斯特朗', '美国', '2013', '2013-08-16(美国)', '132', '', '2014-01-15', '2014-01-15', '1', '/u/201401/15170455x507.jpg', '0');
INSERT INTO `t_movie` VALUES ('13', '时空恋旅人', '时空恋旅人', '时空恋旅人', '时空恋旅人', '时空恋旅人 About Time (2013)', null, '理查德·柯蒂斯', '理查德·柯蒂斯', '英国', '2013', '2013-09-04(英国)', '123', '', '2014-01-15', '2014-01-15', '0', '/u/201401/15170730hqqe.jpg', '0');
INSERT INTO `t_movie` VALUES ('14', '我的男男男男朋友', '我的男男男男朋友', '我的男男男男朋友', '我的男男男男朋友', '我的男男男男朋友 (2013)', null, '赵崇基', '郑东树 / 李蔚思', '中国大陆', '2013', '2013-11-15(中国大陆)', '95', '', '2014-01-15', '2014-01-15', '1', '/u/201401/15171338xc4t.jpg', '0');

-- ----------------------------
-- Table structure for `t_movie_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_movie_tag`;
CREATE TABLE `t_movie_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(32) NOT NULL COMMENT '电影标签名',
  `type_id` int(11) NOT NULL COMMENT '标签类型',
  `ref_counter` int(11) NOT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `ak_tag_name` (`tag_name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='电影标签表';

-- ----------------------------
-- Records of t_movie_tag
-- ----------------------------
INSERT INTO `t_movie_tag` VALUES ('1', '剧情', '1', '3');
INSERT INTO `t_movie_tag` VALUES ('2', '喜剧', '1', '4');
INSERT INTO `t_movie_tag` VALUES ('3', '动作', '1', '1');
INSERT INTO `t_movie_tag` VALUES ('4', '爱情', '1', '1');
INSERT INTO `t_movie_tag` VALUES ('5', '美国', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('6', '中国大陆', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('7', '香港', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('8', '台湾', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('9', '2013', '3', '0');
INSERT INTO `t_movie_tag` VALUES ('10', '2012', '3', '0');
INSERT INTO `t_movie_tag` VALUES ('11', '科幻', '1', '2');
INSERT INTO `t_movie_tag` VALUES ('13', '悬疑', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('14', '惊悚', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('15', '恐怖', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('16', '纪录片', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('17', '短片', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('18', '情色', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('19', '同性', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('20', '音乐', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('21', '歌舞', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('22', '动画', '1', '1');
INSERT INTO `t_movie_tag` VALUES ('23', '传记', '1', '1');

-- ----------------------------
-- Table structure for `t_movietag`
-- ----------------------------
DROP TABLE IF EXISTS `t_movietag`;
CREATE TABLE `t_movietag` (
  `movie_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `priority` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影标签关联表';

-- ----------------------------
-- Records of t_movietag
-- ----------------------------
INSERT INTO `t_movietag` VALUES ('11', '2', '0');
INSERT INTO `t_movietag` VALUES ('11', '11', '1');
INSERT INTO `t_movietag` VALUES ('9', '3', '0');
INSERT INTO `t_movietag` VALUES ('9', '1', '1');
INSERT INTO `t_movietag` VALUES ('11', '22', '2');
INSERT INTO `t_movietag` VALUES ('1', '2', '0');
INSERT INTO `t_movietag` VALUES ('12', '1', '0');
INSERT INTO `t_movietag` VALUES ('12', '23', '1');
INSERT INTO `t_movietag` VALUES ('13', '1', '0');
INSERT INTO `t_movietag` VALUES ('13', '2', '1');
INSERT INTO `t_movietag` VALUES ('13', '11', '2');
INSERT INTO `t_movietag` VALUES ('14', '2', '0');
INSERT INTO `t_movietag` VALUES ('14', '4', '1');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `priority` int(11) NOT NULL COMMENT '排列顺序',
  `is_super` tinyint(1) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '1', '0');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` char(32) NOT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `register_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT '注册IP',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT '最后登录IP',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `rank` int(11) NOT NULL DEFAULT '0' COMMENT '管理员级别',
  `upload_total` bigint(20) NOT NULL DEFAULT '0' COMMENT '上传总大小',
  `upload_size` int(11) NOT NULL DEFAULT '0' COMMENT '上传大小',
  `upload_date` date DEFAULT NULL COMMENT '上传日期',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否管理员',
  `is_viewonly_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否只读管理员',
  `is_self_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否只管理自己的数据',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用',
  `group_id` int(11) NOT NULL,
  `reset_key` char(32) DEFAULT NULL COMMENT '重置密码KEY',
  `reset_pwd` varchar(10) DEFAULT NULL COMMENT '重置密码VALUE',
  `error_time` datetime DEFAULT NULL COMMENT '登录错误时间',
  `error_count` int(11) NOT NULL DEFAULT '0' COMMENT '登录错误次数',
  `error_ip` varchar(50) DEFAULT NULL COMMENT '登录错误IP',
  `activation` tinyint(1) NOT NULL DEFAULT '1' COMMENT '激活状态',
  `activation_code` char(32) DEFAULT NULL COMMENT '激活码',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `ak_username` (`username`),
  KEY `fk_e_user_group` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='CMS用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '5f4dcc3b5aa765d61d8327deb882cf99', 'admin@yahoo.com', '2011-01-03 00:00:00', '127.0.0.1', '2013-09-29 14:23:53', '127.0.0.1', '434', '6', '63', '63', '2013-07-10', '1', '0', '0', '0', '1', null, null, null, '0', null, '1', null);
