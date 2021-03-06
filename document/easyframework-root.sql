/*
Navicat MySQL Data Transfer

Source Server         : ±¾µØ
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : easyframework-root

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2014-02-11 07:45:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(100) NOT NULL COMMENT 'èååç§°',
  `action_url` varchar(200) NOT NULL COMMENT 'èåé¾æ¥',
  `lft` int(11) DEFAULT NULL COMMENT 'å·¦',
  `rgt` int(11) DEFAULT NULL COMMENT 'å³',
  `priority` int(11) DEFAULT NULL COMMENT 'æåº',
  `create_date` date DEFAULT NULL COMMENT 'åå»ºæ¥æ',
  `update_date` date DEFAULT NULL COMMENT 'ä¿®æ¹æ¥æ',
  `perm_prefix` varchar(100) DEFAULT NULL COMMENT 'æéåç¼',
  `is_leaf` tinyint(1) DEFAULT NULL COMMENT 'æ¯å¦å¶å­',
  `is_display` tinyint(1) DEFAULT NULL COMMENT 'æ¯å¦æ¾ç¤º',
  `parent_id` int(11) DEFAULT NULL COMMENT 'ç¶èç¹',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='èåè¡¨';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', 'å¹³å°é¦é¡µ', '1', '1', '8', '1', '2013-09-29', '2013-09-29', '1', '0', '1', null);
INSERT INTO `t_menu` VALUES ('2', 'ç³»ç»ç®¡ç', '1', '8', '19', '3', '2013-09-29', '2013-09-29', '1', '0', '1', null);
INSERT INTO `t_menu` VALUES ('3', 'ä¼åç®¡ç', '1', '19', '20', '3', '2013-09-29', '2013-09-29', '1', '0', '1', null);
INSERT INTO `t_menu` VALUES ('4', 'æéè®¾ç½®', '1', '1', '8', '1', '2013-09-29', '2013-09-29', '1', '1', '1', '2');
INSERT INTO `t_menu` VALUES ('5', 'ç³»ç»è®¾ç½®', '1', '9', '18', '10', '2013-12-13', '2013-12-13', null, null, '1', '2');
INSERT INTO `t_menu` VALUES ('6', 'ç®¡çå', '1222', '6', '7', '10', '2013-12-13', '2013-12-13', '13323332', null, '1', '4');
INSERT INTO `t_menu` VALUES ('7', 'è§è²ç®¡ç', '22', '2', '3', '10', '2013-12-13', '2013-12-13', '22', null, '1', '4');
INSERT INTO `t_menu` VALUES ('8', 'é¨é¨ç®¡ç', '1', '4', '5', '11', '2013-12-13', '2013-12-13', '11', null, '1', '4');
INSERT INTO `t_menu` VALUES ('9', 'å¨å±è®¾ç½®', '1', '10', '11', '10', '2013-12-15', '2013-12-15', '11', null, '1', '5');
INSERT INTO `t_menu` VALUES ('10', 'æ°æ®å­å¸', '1', '12', '13', '10', '2013-12-15', '2013-12-15', '1', null, '1', '5');
INSERT INTO `t_menu` VALUES ('11', 'FTPè®¾ç½®', '22', '14', '15', '10', '2013-12-15', '2013-12-15', '33', null, '1', '5');
INSERT INTO `t_menu` VALUES ('12', 'å·¥ä½æµè®¾ç½®', '22', '16', '17', '10', '2013-12-15', '2013-12-15', '33', null, '1', '5');
INSERT INTO `t_menu` VALUES ('13', 'åå®¹ç®¡ç', '11', '21', '22', '2', '2013-12-23', '2013-12-23', '11', null, '1', null);

-- ----------------------------
-- Table structure for `t_movie`
-- ----------------------------
DROP TABLE IF EXISTS `t_movie`;
CREATE TABLE `t_movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT 'åå',
  `simple_name` varchar(32) DEFAULT NULL COMMENT 'ç®ä½ä¸­æå',
  `alias_name1` varchar(32) DEFAULT NULL COMMENT 'å«å1',
  `alias_name2` varchar(32) DEFAULT NULL COMMENT 'å«å2',
  `title` varchar(100) NOT NULL COMMENT 'æ é¢',
  `imdb_no` varchar(32) DEFAULT NULL COMMENT 'IMDbç¼å·',
  `director` varchar(32) DEFAULT NULL COMMENT 'å¯¼æ¼',
  `scenarist` varchar(32) DEFAULT NULL COMMENT 'ç¼å§',
  `area` varchar(32) DEFAULT NULL COMMENT 'å¶çå½å®¶/å°åº',
  `publish_year` varchar(32) DEFAULT NULL COMMENT 'å¹´ä»½',
  `screening_date` varchar(32) DEFAULT NULL COMMENT 'ä¸æ æ¥æ',
  `leng` int(11) DEFAULT NULL COMMENT 'çé¿',
  `remark` text COMMENT 'IMDbç¼å·',
  `create_date` date DEFAULT NULL COMMENT 'åå»ºæ¥æ',
  `update_date` date DEFAULT NULL COMMENT 'ä¿®æ¹æ¥æ',
  `is_recommend` tinyint(1) DEFAULT NULL COMMENT 'æ¯å¦æ¨è',
  `cover` varchar(32) DEFAULT NULL COMMENT 'å°é¢',
  `download_url` varchar(200) DEFAULT NULL COMMENT 'åå§å°å',
  `download_urlxl` varchar(300) DEFAULT NULL COMMENT 'è¿é·ä¸è½½å°å',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'æ¯å¦ç¦ç¨',
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='çµå½±ä¿¡æ¯è¡¨';

-- ----------------------------
-- Records of t_movie
-- ----------------------------
INSERT INTO `t_movie` VALUES ('1', 'ç§äººè®¢å¶', 'ç§äººè®¢å¶', '', '', 'ç§äººè®¢å¶ç§äººè®¢å¶ç§äººè®¢å¶', null, 'å¯å°å', 'çæ', 'ä¸­å½å¤§é', '2013', '2013-12-19 00:00:00', '120', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">&nbsp; &nbsp; æ¿æè§åå¸æ¨éï¼èä¼ é¥°ï¼ãæå¢è®¾è®¡å¸å°ç½ï¼ç½ç¾ä½ é¥°ï¼ãæ¢¦å¢éå»ºå¸å°çï¼æå°ç é¥°ï¼ä¸å¿çµéº»éå¸é©¬éï¼éæº é¥°ï¼åäººç»æçå¬å¸&ldquo;ç§äººè®¢å¶&rdquo;ï¼ä»¥&ldquo;æ¿ä»äººåæ¢¦&rdquo;ä¸ºèªèº«ä¸å¡ï¼ä¸é¨ä¸ºä¸åå®¢æ·éèº«è®¢å¶&ldquo;åæ¢¦æ¹æ¡&rdquo;ï¼æ è®ºå®¢æ·çç½æ¥æ¢¦å¤å¥è©ãè¦æ±å¤ä¸¥æ ¼ï¼&ldquo;åæ¢¦åäººç»&rdquo;ç»ç»æ¥èä¸æï¼çæ¿æ»¡è¶³å®¢æ·çä»»ä½éæ±ï¼æ­£å¦å&ldquo;ç§äººè®¢å¶&rdquo;å¬å¸çå£å·&mdash;&mdash;&ldquo;æå¨å«äººï¼æ¶å¿èªå·±&rdquo;ã&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">ããä¸æ¶é´ï¼è®¸å¤ææ£ç&ldquo;å¥è©æ¢¦&rdquo;çå®¢æ·çº·çº·æ¾ä¸é¨ï¼ç§äººè®¢å¶å¬å¸ä¹æ¥è¿é¢ä¸´åç§ææï¼ä¸å¿æ³è¿&ldquo;çå£«ç¾&rdquo;çéè¥¿å¥³éå¹´ï¼èå é¥°ï¼ãç«å¿è¿½æ±é«éè·ä¿&ldquo;ä¸åä¸¤æ­&rdquo;çå¨çæ&ldquo;ä¿&rdquo;å¯¼æ¼ï¼æè¯å é¥°ï¼ãæ³è¦å½æ¸å®&ldquo;èªæ¿&rdquo;æ¥åé±è²è¯±æçå¸æºå¸åï¼èä¼ é¥°ï¼ãçæ¥æ¿ææ¯æ³åæ&ldquo;æé±äºº&rdquo;çæ²³éæ¸æ´å·¥äººä¸¹å§ï¼å®ä¸¹ä¸¹ é¥°ï¼&hellip;&hellip;&ldquo;å¯»æ¢¦è&rdquo;ç»ç»ä¸ç»ï¼&ldquo;åæ¢¦åäººç»&rdquo;ä¹ç»å°½èæ±ä¸ºæ¯ä¸ä½å®¢æ·ç§äººè®¢å¶åæ¢¦æ¹æ¡ï¼è¿ç¨ä¸­åçäºè®¸è®¸å¤å¤ä»¤äººæ§è¹çèè¯äºå¿ï¼æ¯ä¸ä½å®¢æ·ä¹é½å¨æå&ldquo;æ¢¦æ³æç&rdquo;ã</span></p>\n', '2013-12-23', '2013-12-23', '1', '/u/201401/15165333mpxr.jpg', '', '', '0');
INSERT INTO `t_movie` VALUES ('2', 'è­¦å¯æäº', 'è­¦å¯æäº', '', '', '', null, 'ä¸æ', 'ä¸æ', 'ä¸­å½å¤§é', '2013', '2013-12-19 00:00:00', '120', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">å¤ï¼ç¹åè¡åºä¸åº§å¤§åéå§åï¼ææå®¢äººè¢«å«æä¸ºäººè´¨ãå¶ä¸­åæ¬åè­¦éæåå¥³å¿èèï¼ä»¥åä¸ç¾¤ä¼¼æ¾ç¸è¯çéçäºº&hellip;&hellip;å«åªæ¯éå§èæ¿æ­¦æ±ï¼ä»¥äººè´¨å¨èè¦æ±éæ¾ä¸åå¨æ¼å¤å¹´çç½ªç¯ï¼å°åºæ¯ææ ·çå¨æºï¼å¼å¾ä»é¤èèµ°é©ï¼&nbsp;</span></p>\r\n', '2013-12-23', '2013-12-23', '0', null, null, null, '0');
INSERT INTO `t_movie` VALUES ('3', 'é¢¨æ´', 'é¢¨æ´', 'Firestorm', '', 'åå¾·å/å§æ¨2013å¹´å¨ä½ãé£æ´ãHDå½è¯­ä¸­å­', null, 'è¢é¦éº', 'è¢é¦éº', 'é¦æ¸¯ / ä¸­å½å¤§é', '2013', '2013-12-12(ä¸­å½å¤§é) / 2013-12-19', '120', '<p><img alt=\"\" src=\"/u/201401/19161104ktxn.jpg\" style=\"width: 414px; height: 580px;\" /></p>\n<p><span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">åæå²ï¼åå¾·å é¥°ï¼æ¯é¦æ¸¯å±¡ç ´å¤§æ¡çé«çº§ç£å¯ï¼é¶æé¦ï¼æå®¶æ  é¥°ï¼æ¯å±¡æä¸æ¹ååºç±çè¡å¤´æ··æ··ãåæå²å¨ä¸æ¬¡è¡å¤´å¯¹å³æåªå¤´ç®æ¹æ¥ ï¼è¡åé¥°ï¼å·²å ä¸é£æ¶ï¼è¢«å¿æ¶çå¥½åé¶æé¦æå±ãé¢å¯¹ç¯ç½ªå¢ä¼çä¸æ­æè¡ï¼åæå²èªè¨ä¸æä¸åä»£ä»·å°å¶ä¸éç«¯ï¼è­¦åªåæ¹çææ®æ¸¸ææ­£å¼å¼å§ã</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ããæ­¤æ¶ä¸é¶æé¦ç¸æå¤å¹´çå¥³åçå°ï¼å§æ¨ é¥°ï¼åç°äºç·åçå¼å¸¸ï¼ä¸ºèµ¢åå¯¹èªå·±å¤±æçå¥³åï¼é¶æé¦ååæå²è¾¾æäºä¸ç¬äº¤æ&hellip;&hellip;</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ããé£æ´è¿å¢ï¼ä¸è§¦å³åï¼æ¯ä¸ªäººé½è¢«è¿åºé«åçæ¼©æ¶¡æ°æµé¼è³èº«ä»½æ¨¡ç³çç°è²å°å¸¦ã&nbsp;</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">å¹åå¶ä½</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ããåå¾·åä¸ºæ&ldquo;å¤§å¼ææ&rdquo;</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ãã&ldquo;ãé£æ´ãéï¼åå¾·åå¨èº«ä»½ä¸æ­£éªé¾å¤ï¼æä»½ä¸ææ­¦åå¨ï¼äººæ§ä¸ææ³çº ç¼ ï¼å°¤å¶é¥±åæ­£éªå²çªä¸åå¿çç¾æç£¨åï¼ä»çæä½æä¸ºæç»ä»¤èªå·±çä¸¤ç§èº«ä»½é­éåè£åå¯¹ç«ï¼ä¸æ¹é¢ä½ä¸ºæ§æ³èçè­¦å¯ï¼çæ§ä¸æ æ³è¢«å®½å®¹ï¼ä½å¦ä¸æ¹é¢ä½ä¸ºæ¥æææçæ­£å¸¸äººï¼ææ§ä¸å®¹æè·å¾è°è§£ãå³ï¼ä½ä¸ºè­¦å¯æ¶ï¼ä»æ&lsquo;é­é¬¼&rsquo;çä¸é¢ï¼ä½ä¸ºä¸ä¸ªå¸¸äººæ¶ï¼æ&lsquo;å¤©ä½¿&rsquo;çä¸é¢ã&rdquo;å¯¼æ¼è¢é¦éºè§£ééã&ldquo;è½ç¶çµå½±éï¼åå¾·åæ²¡æç±ææï¼ä½æ¯å´å æååº&lsquo;ä¸åæ³&rsquo;çè¡ä¸ºï¼çè³æåå¤§å¼ææï¼è¿æ¯çµå½±æå·è½¬ææ§çä¸å¹ã&rdquo;</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ããèå¯¹äºå§æ¨ä¸æå®¶æ å¨ãé£æ´ãéçä½ç¨ï¼å¯¼æ¼è¢é¦éºè¯´éï¼&ldquo;ãé£æ´ãéï¼åå¾·åæ¯ä¸ºæ­£ä¹æ§çå°åºï¼èå§æ¨ä¸æå®¶æ åæ¯ä¸ºç±ææ§çå°åºï¼ä¸ºäºè¿ä»½ç±æï¼ä¿©äººä¸æ&lsquo;ç¸äºçºç²&rsquo;ï¼å§æ¨å¯¹æå®¶æ ä¸å¿åå¿ï¼æå®¶æ åå¯¹å§æ¨æåå³å¤´ååºæå¤©å¨å°çäºï¼ç¸äºçºç²é½ä¸å°ãè¿ç±»ç±æä¹æ¯æææ³è¡¨è¾¾çä¸é¨åï¼ææ³å¨ä¸é¨è­¦åªçéåç°ä¹åä¸è¢«éè§çé¨åã&rdquo;</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ããä¸­ç¯å®ææªæå¤§æ</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ããä½ä¸ºä¸é¨&ldquo;ä»è­¦åªå°æäºï¼åä»æäºå°ç¾é¾&rdquo;çå½±çï¼ãé£æ´ãå¯¹é£åºåæ å¤äººçä¸­ç¯å¤§æï¼æ´æ¯å¨ç¨å§ç»ä¸ä¸ä¹åæå¥å¶ä¸­ï¼å¹¶ä¸ºæ­¤èå°½äºåæåå¿è¡ï¼ç»æä¹æ­£å¦èæ¿æ±å¿å¼ºæè¨ï¼è¾¾å°äº&ldquo;éæ°æä¸­ç¯æ­åºæ¥ï¼æååæå®ç¸æ&rdquo;çå°æ­¥ã</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ããäºå®ä¸ï¼ä¸­ç¯å¤§æå¨ä»»ä½ä¸ä¸ªææç¯èé½å¯è°é¾åº¦æå¤§ï¼æ¢å¨äºå¯¼æ¼è¢é¦éºè¦æ±å®å¨è§æ¨¡ä¸&ldquo;æ¯ä¸åºæäº&rdquo;ï¼ä¹å¨äºå¨ä½æå¯¼é±åä¹ä¸ºæ±æåºçå®èéæ¼çè§è§ææï¼å¿é¡»å°å¯¹åç§ç»èçè®¡ç®é½æåè³&ldquo;ç²¾ç¡®ä¸­æ´ç²¾ç¡®&rdquo;çé¶æ®µï¼èåå¾·åæ´ç§°è¿åºæ&ldquo;æ¬æ¥æ¯æåå¤©ï¼æä»¬å´éè¦äºåå¤©æå¯ä»¥å®æ&rdquo;ãæä»¥ï¼å¨å°åå¹åå¦æ­¤ä¸ä¸ä¸ä¸¥è°¨çåä½ä¸ï¼ãé£æ´ãä»¥åå¸æäºå¼åç«çå·å³°çææï¼å¿å°å¤§è·å¨èã</span><br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<br style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\" />\n	<span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ãã&ldquo;ãé£æ´ãçåå¸æäºç»éçº¯ç²¹ä»¥æªæå¼¹é¨è¥é æå®åºæ¿é£ä¹ç®åï¼èæ¯æ¿è½½çäººæ§çä¸å¤§ç»æé¢åï¼åè­¦åªå¯¹å³ä»£è¡¨&lsquo;å¥½ä¸å&rsquo;ï¼ä»¥æ®é·æäºæ¼ç»&lsquo;åä¸æ¶&rsquo;ï¼åå­ç¾é¾åºé¢è±¡å¾&lsquo;äººä¸é­&rsquo;ï¼å½¼æ­¤ç¸äºæ¨è¿ï¼æç»èä¸ºä¸ä½ã&rdquo;å¯¼æ¼è¢é¦éºè¯´éã</span></p>\n', '2013-12-23', '2013-12-23', '1', '/u/201401/19143953hbze.jpg', 'ftp://ygdy8:ygdy8@d201.dygod.org:9114/[é³åçµå½±www.ygdy8.com].é£æ´.HD.720p.å½è¯­ä¸­å­.rmvb', 'thunder://QUFmdHA6Ly95Z2R5ODp5Z2R5OEBkMjAxLmR5Z29kLm9yZzo5MTE0L1vR9LnitefTsHd3dy55Z2R5OC5jb21dLrfnsakuSEQuNzIwcC65+tPv1tDX1i5ybXZiWlo=', '0');
INSERT INTO `t_movie` VALUES ('4', 'æ äººåº', 'æ äººåº', '', '', 'æ äººåº', null, 'å®æµ©', 'ççº¢å«', 'ä¸­å½å¤§é', '2013', '2013-12-19', '120', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">å°æåæ°ä½å©æ¬²çå¿çå¾å¸æ½èï¼å¾å³¥ é¥°ï¼ï¼å­åæå®çæ³å¾ç¥è¯åå·§èå¦ç°§çåº­è¾©æå·§ï¼æåå¸®çæå½å®¶çç¦½é¿ææ³°é¼å¹¶æ®å¿æå®³ä¸åè­¦å¯çè¥¿åççå¢ä¼èå¤§ï¼å¤å¸æ° é¥°ï¼æ´è±ç½ªåãèå¤§æ¿è¯ºåå¤©åä»æ¸ä½æ¬¾ï¼æ½èåè¦æ±å¯¹æ¹ç¨ä¸è¾çº¢è²è½¿è½¦æµæ¼ãå¨æ­¤ä¹åï¼ä»é©¾é©¶çæ°è½¦è¸ä¸ä»è¥¿åèæ¼ è¿åå¤§é½ä¼çè·¯ç¨ãè°ç¥è·¯ä¸é©æä¸æ­ï¼åæ¯åä¸å¯¹å¼å¡è½¦æèèçå¥ä¿©ï¼çåå® &amp; å·´å¤ é¥°ï¼åçæ©æ¦ï¼å¯¼è´äººä¼¤è½¦æï¼æ¥çåä¸ææé£ä¸ä¸ªä¼¼ä¹æ¦è½¦æ±å©çç·å­ï¼é»æ¸¤ é¥°ï¼ãèªç¥æä¸äººå½çæ½èè¾è½¬æ¥å°ä¸å®¶ä¸äºä¸æ³å¾å½çé»åºï¼å¹¶å¨æ­¤ç»è¯äºåå°äºæ­¤çå¦å¥³ï¼ä½ç· é¥°ï¼ãä¸æ­¤åæ¶ï¼ççèå¤§å°¾éå¶åï¼ä¼¼ä¹å¦æå¶é©è®¡åã&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">ããæ­¤æ¶æ½èè¿æ²¡çæ­£æè¯å°ï¼ä»åæ¹æ¯ææ ·ä¸æ¡åæ»¡å¶é©çæé&hellip;&hellip;</span></p>\r\n', '2013-12-23', '2013-12-23', '0', null, null, null, '0');
INSERT INTO `t_movie` VALUES ('5', 'è´æä»¬ç»å°éå»çéæ¥', 'è´æä»¬ç»å°éå»çéæ¥', '', '', 'è´æä»¬ç»å°éå»çéæ¥2013', null, 'èµµè', 'ææ¨¯', 'ä¸­å½å¤§é', '2013', '2013-04-26(ä¸­å½å¤§é)', '132', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">18å²çéå¾®ï¼æ¨å­å§ é¥°ï¼ç»äºå¦æ¿èä¸éæ¢ç«¹é©¬é»å®¶å¤§å¥å¥æéï¼é©åº é¥°ï¼æå¨å­¦æ ¡çé»æ ¡ï¼ç­å¥¹æ»¡ææåå°æ­¥å¥å¤§å­¦æ ¡å­ï¼å´é­éæå»&mdash;&mdash;æéåºå½çå­¦ï¼æ³æ é³ä¿¡ãéå¾®åæå¤±è½ï¼æ£é¾æ¶å»ä¸å®¤åé®èï¼æ±çå½± é¥°ï¼ãæ±å°åï¼åéç é¥°ï¼ãé»ç»´å¨ï¼å¼ ç¶ é¥°ï¼åå¸å¥èå¼ -å¼ å¼ï¼åè´å° é¥°ï¼ç» ä¸æ·±ååè°ï¼åæ¶å¯å®¶å¬å­è®¸å¼é³ï¼éæº é¥°ï¼å¯¹éå¾®å±å¼äºç¯ççè¿½æ±ï¼èå¤åç·çæ¬¢è¿çé®èç¨å¥¹ç¹æçæ¸å·å®æ¤çå¯¹äºå¿ç±äººèµµä¸æ°¸ï¼é»æ é¥°ï¼çå¿ è´ãä¸æ¬¡å¶ç¶çè¯¯ä¼ä½¿éå¾®ä¸èå¼ å®¤åéå­æ­£ï¼èµµåå»· é¥°ï¼ç»ä¸ºæ­»æï¼å¨ä¸æ¬¡æ¬¡å°åå»ä¸­ï¼éå¾®åç°èªå·±ç±ä¸äºè¿ä¸ªè¡¨é¢å·é·ãåå¿åè¯çé«æçï¼äºæ¯ç¯çå°åå»æ¼åä¸ºæ­»ç¼ çæå°è¿½æ±ï¼èéå­æ­£ä¹ç»äºå¨å¼ºæ»ä¹ä¸ç¼´æ¢°æéï¼æ¬¢åå¤å®¶ç»æçèæäººãå¤§åæ¯ä¸ä¹ééå¾®ççæ´»åæ¬¡ç»åèéªï¼éå­æ­£å¾å°æ¾æ¯ï¼çåä½³ é¥°ï¼çåºå½çå­¦åé¢ï¼å´è¿è¿ä¸æ¢åè¯éå¾®ï¼æè§åæ¬¡è¢«æ¬ºéªçéå¾®çè¦å°ç¦»å¼éå­æ­£&hellip;&hellip;&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">ããå¤å¹´åï¼éå¾®å·²èåä¸ºèåºä¸çç½é¢ä¸½äººï¼ç«åæ¬¡åå°å½è¿çæ å¸¸ï¼å¸¦çææåç±æçæéåéå­æ­£åæ¶åå°å¥¹ççæ´»éï¼éå¾®ï¼è¿ä¸ªææ¥ççé¢å°é£é¾ï¼å°ææ ·é¢å¯¹çæ´»åéæ¥èµäºå¥¹çè¿·é¾åææ©&hellip;&hellip;&nbsp;</span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\r\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">ããæ¬çæ¹ç¼èªè¾å¤·åååçéå°è¯´ãèµµèçé¦é¨å¯¼æ¼ä½åï¼ä¹æ¯å¶å¨åäº¬çµå½±å­¦é¢å¯¼æ¼ç³»ç ç©¶çä¸ä¸çæ¯ä¸ä½åã</span></p>\r\n', '2013-12-23', '2013-12-23', '0', null, null, null, '0');
INSERT INTO `t_movie` VALUES ('6', 'ç­é£æ¥ ', 'ç­é£æ¥ ', '', '', 'ç­é£æ¥ (2013)', null, 'æ»åæ¶', 'é²é²¸é²¸', 'ä¸­å½å¤§é', '2013', '2013-12-31(ä¸­å½å¤§é)', '130', '', '2013-12-23', '2013-12-23', '0', '/u/201401/131715130cc3.jpg', null, null, '0');
INSERT INTO `t_movie` VALUES ('7', 'æç«è±é', 'æç«è±é', '', '', 'æç«è±é (2014)', null, 'é­å­å¥', 'æ¢ç¤¼å½¦ / ç¿å­å / é­å­å¥', 'ä¸­å½å¤§é', '2014', '2013-12-12(ä¸­å½å¤§é) / 2013-12-19', '130', '', '2014-01-08', '2014-01-08', '0', '/u/201401/12120453fcsv.jpg', null, null, '0');
INSERT INTO `t_movie` VALUES ('8', 'å®å¾·çæ¸¸æ', 'å®å¾·çæ¸¸æ', '1', '2', 'å®å¾·çæ¸¸æ Ender\'s Game (2013)', null, 'å æÂ·è¡å¾·', 'å æÂ·è¡å¾· / å¥¥æ£®Â·æ¯ç§ç¹Â·å¡å¾·', 'ä¸­å½å¤§é', '2013', '2013-12-12(ä¸­å½å¤§é) / 2013-12-19', '130', '', '2014-01-08', '2014-01-08', '1', '/u/201401/13171440csjl.jpg', null, null, '0');
INSERT INTO `t_movie` VALUES ('9', 'ä¸ä»£å®å¸', 'ä¸ä»£å®å¸', '1', '2', 'ä¸ä»£å®å¸ä¸ä»£å®å¸2013', null, ' çå®¶å«', ' çå®¶å«', 'ä¸­å½å¤§é', '2013', '2013-12-12(ä¸­å½å¤§é) / 2013-12-19', '150', 'aaa', '2014-01-08', '2014-01-08', '1', '/u/201401/13171410jrud.jpg', null, null, '0');
INSERT INTO `t_movie` VALUES ('11', 'ç¥å·å¥¶ç¸2', 'ç¥å·å¥¶ç¸2', 'ç¥å·å¥¶ç¸2', 'ç¥å·å¥¶ç¸2', 'ç¥å·å¥¶ç¸2 Despicable Me 2 (2013)', null, 'ç®åå°Â·ç§è¬ / åéæ¯Â·é·çº³å¾·', 'è¾ç§Â·ä¿ç½ / è¯Â·è¾¾éå¥¥', 'ç¾å½', '2014', '2014-01-10(ä¸­å½å¤§é) / 2013-07-03', '99', '<p><span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">èªä»ä¸çæï¼ç±³å°è¾¾Â·å¡æ¯æ ¼æå¤« Miranda Cosgrove éé³ï¼ãä¼è¿ªä¸ï¼è¾¾å¨Â·çä¼ Dana Gaier éé³ï¼åé¿æ ¼è¾ä¸ï¼åå°å¸Â·è´¹è Elsie Fisher éé³ï¼ä¸ä¸ªå¯ç±çå°å¥³å­©å®ç°å®¿å½çééï¼æ¾ç»çå¤§åèæ ¼é²ï¼å²èå¤«Â·å¡çå° Steve Carell éé³ï¼å¯çå½»åºè½¬åäºï¼ä»éçæ´æï¼è½¬èåèº«ä¸ºæç¥¥å¯äº²çç¸ç¸ååå¾ä¸æçå£å³å¸ä¸æå»çåäººãå½ç¶å¡äºæ²¡æå°½åå°½ç¾çï¼å¨æ­¤æé´ï¼æ§æ¬å¤§åèä¼ å¥äººççèæ­æ¡£çº³æ³å©æ¬§åå£«ï¼æå¡å°Â·å¸å°å¾· Russell Brand éé³ï¼ç¦»ä»èå»ï¼å¦è°é«å°±ãæå¤©ï¼æ ¼é²è¢«èº«æç»æå´é²è½çç¹å·¥é²è¥¿Â·çå°å¾·ï¼åéæ¯æ±Â·é¦æ ¼ Kristen Wiig éé³ï¼ç»æ¶ï¼åæ¥é²è¥¿æå¨çéå¢ç å¶åºå¯ä»¥æ¹åçç©åºå çè¯ç©ï¼å¯ä»ä»¬ä½äºåæçå®éªå®¤è¢«ç¥ç§çªè´¼å·èµ°ï¼å æ­¤æå§ææè¿åèç»éªçæ ¼é²åå§åºãÂ </span><br style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\" />\n	<span style=\"color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19px;\">ããç»è¿ä¸çªèèï¼æ ¼é²æ¥åäºè¿é¡¹ä»»å¡ï¼å¸¦çè¶èçå°é»äººä»¬ï¼åé²è¥¿ç»æäºçç¬è¿è¿çè¿½å¶æ­æ¡£â¦â¦</span></p>\n', '2014-01-14', '2014-01-14', '1', '/u/201401/14143332ga27.jpg', null, null, '0');
INSERT INTO `t_movie` VALUES ('12', 'ç½å®«ç®¡å®¶', 'ç½å®«ç®¡å®¶', 'ç½å®«ç®¡å®¶', 'ç½å®«ç®¡å®¶', 'ç½å®«ç®¡å®¶ The Butler (2013)', null, 'æÂ·ä¸¹å°¼å°æ¯', 'å¨å°Â·æµ·å¤å¾· / æÂ·ä¸¹å°¼å°æ¯ / ä¸¹å°¼Â·æ¯ç¹æ', 'ç¾å½', '2013', '2013-08-16(ç¾å½)', '132', '', '2014-01-15', '2014-01-15', '1', '/u/201401/15170455x507.jpg', null, null, '0');
INSERT INTO `t_movie` VALUES ('13', 'æ¶ç©ºææäºº', 'æ¶ç©ºææäºº', 'æ¶ç©ºææäºº', 'æ¶ç©ºææäºº', 'æ¶ç©ºææäºº About Time (2013)', null, 'çæ¥å¾·Â·æ¯èæ¯', 'çæ¥å¾·Â·æ¯èæ¯', 'è±å½', '2013', '2013-09-04(è±å½)', '123', '', '2014-01-15', '2014-01-15', '0', '/u/201401/15170730hqqe.jpg', null, null, '0');
INSERT INTO `t_movie` VALUES ('14', 'æçç·ç·ç·ç·æå', 'æçç·ç·ç·ç·æå', 'æçç·ç·ç·ç·æå', 'æçç·ç·ç·ç·æå', 'æçç·ç·ç·ç·æå (2013)', null, 'èµµå´åº', 'éä¸æ  / æèæ', 'ä¸­å½å¤§é', '2013', '2013-11-15(ä¸­å½å¤§é)', '95', '<p>22saaaaaaaaaaa</p>\n', '2014-01-15', '2014-01-15', '1', '/u/201401/15171338xc4t.jpg', '', '', '0');
INSERT INTO `t_movie` VALUES ('15', 'Battle of the Year: The Dream Team', '', '', '', '2013å¹´æ­èãå¹´åº¦è¡èå¤§æã720p.BDä¸­è±åå­å¹', null, 'æ¬æ£®Â·æ Benson Lee', '', 'ç¾å½', '2013', '', '109', '<p><img alt=\"\" src=\"/u/201401/19161132luq0.jpg\" style=\"width: 364px; height: 580px;\" /></p>\n<p><span style=\"color: rgb(24, 55, 120); font-family: Verdana, Arial, Helvetica, sans-serif;\">ç±ãè¿·å¤±ãç·æä¹ä»&middot;åæ´å¨é¢è¡ä¸»æ¼çbreakingç«èµçãå¹´åº¦ä¹æï¼æ¢¦ä¹éãæ ¹æ®2005å¹´ä¸ç¾¤ç·å­©åå å¥¥æå¹åå¤§èµè¡è&quot;å¹´åº¦ä¹æ&quot;çç»åæ¹ç¼ï¼è®²è¿°äºä¹ä»&middot;åæ´å¨é¥°æ¼çæç»å¦ä½å¸¦é¢ä»çéä¼å¤ºé­çæäºãå½±çè¡èæ®µè½ç²¾å½©çº·åï¼åç§é«æè½å¨ä½è½®çªç»åºï¼çµå­ä¹ç«ç®ç¯åå°èå°èå¿çæçæ·æ¼å°½è´ï¼åå ä¸æ¬çå°ä»¥3Då½¢å¼ä¸æ ï¼å±æ¶è§ä¼å°å¦ä¸´æ¯èµç°åºè¬ä½éªçµå½±ä¸­çå¨æè·³è·ã</span></p>\n', '2014-01-18', '2014-01-18', '0', '/u/201401/19153452q9h9.jpg', '', '', '0');

-- ----------------------------
-- Table structure for `t_movie_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_movie_tag`;
CREATE TABLE `t_movie_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(32) NOT NULL COMMENT 'çµå½±æ ç­¾å',
  `type_id` int(11) NOT NULL COMMENT 'æ ç­¾ç±»å',
  `ref_counter` int(11) NOT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `ak_tag_name` (`tag_name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='çµå½±æ ç­¾è¡¨';

-- ----------------------------
-- Records of t_movie_tag
-- ----------------------------
INSERT INTO `t_movie_tag` VALUES ('1', 'å§æ', '1', '3');
INSERT INTO `t_movie_tag` VALUES ('2', 'åå§', '1', '4');
INSERT INTO `t_movie_tag` VALUES ('3', 'å¨ä½', '1', '2');
INSERT INTO `t_movie_tag` VALUES ('4', 'ç±æ', '1', '1');
INSERT INTO `t_movie_tag` VALUES ('5', 'ç¾å½', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('6', 'ä¸­å½å¤§é', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('7', 'é¦æ¸¯', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('8', 'å°æ¹¾', '2', '0');
INSERT INTO `t_movie_tag` VALUES ('9', '2013', '3', '0');
INSERT INTO `t_movie_tag` VALUES ('10', '2012', '3', '0');
INSERT INTO `t_movie_tag` VALUES ('11', 'ç§å¹»', '1', '2');
INSERT INTO `t_movie_tag` VALUES ('13', 'æ¬ç', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('14', 'ææ', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('15', 'ææ', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('16', 'çºªå½ç', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('17', 'ç­ç', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('18', 'æè²', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('19', 'åæ§', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('20', 'é³ä¹', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('21', 'æ­è', '1', '0');
INSERT INTO `t_movie_tag` VALUES ('22', 'å¨ç»', '1', '1');
INSERT INTO `t_movie_tag` VALUES ('23', 'ä¼ è®°', '1', '1');
INSERT INTO `t_movie_tag` VALUES ('24', 'ç¯ç½ª', '1', '1');

-- ----------------------------
-- Table structure for `t_movietag`
-- ----------------------------
DROP TABLE IF EXISTS `t_movietag`;
CREATE TABLE `t_movietag` (
  `movie_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `priority` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='çµå½±æ ç­¾å³èè¡¨';

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
INSERT INTO `t_movietag` VALUES ('3', '3', '0');
INSERT INTO `t_movietag` VALUES ('3', '24', '1');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL COMMENT 'è§è²åç§°',
  `priority` int(11) NOT NULL COMMENT 'æåé¡ºåº',
  `is_super` tinyint(1) DEFAULT NULL COMMENT 'é®ç®±',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='è§è²è¡¨';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'ç®¡çå', '1', '0');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL COMMENT 'ç¨æ·å',
  `password` char(32) NOT NULL COMMENT 'å¯ç ',
  `email` varchar(100) DEFAULT NULL COMMENT 'é®ç®±',
  `register_time` datetime NOT NULL COMMENT 'æ³¨åæ¶é´',
  `register_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT 'æ³¨åIP',
  `last_login_time` datetime NOT NULL COMMENT 'æåç»å½æ¶é´',
  `last_login_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT 'æåç»å½IP',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT 'ç»å½æ¬¡æ°',
  `rank` int(11) NOT NULL DEFAULT '0' COMMENT 'ç®¡çåçº§å«',
  `upload_total` bigint(20) NOT NULL DEFAULT '0' COMMENT 'ä¸ä¼ æ»å¤§å°',
  `upload_size` int(11) NOT NULL DEFAULT '0' COMMENT 'ä¸ä¼ å¤§å°',
  `upload_date` date DEFAULT NULL COMMENT 'ä¸ä¼ æ¥æ',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'æ¯å¦ç®¡çå',
  `is_viewonly_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'æ¯å¦åªè¯»ç®¡çå',
  `is_self_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'æ¯å¦åªç®¡çèªå·±çæ°æ®',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'æ¯å¦ç¦ç¨',
  `group_id` int(11) NOT NULL,
  `reset_key` char(32) DEFAULT NULL COMMENT 'éç½®å¯ç KEY',
  `reset_pwd` varchar(10) DEFAULT NULL COMMENT 'éç½®å¯ç VALUE',
  `error_time` datetime DEFAULT NULL COMMENT 'ç»å½éè¯¯æ¶é´',
  `error_count` int(11) NOT NULL DEFAULT '0' COMMENT 'ç»å½éè¯¯æ¬¡æ°',
  `error_ip` varchar(50) DEFAULT NULL COMMENT 'ç»å½éè¯¯IP',
  `activation` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'æ¿æ´»ç¶æ',
  `activation_code` char(32) DEFAULT NULL COMMENT 'æ¿æ´»ç ',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `ak_username` (`username`),
  KEY `fk_e_user_group` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='CMSç¨æ·è¡¨';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '5f4dcc3b5aa765d61d8327deb882cf99', 'admin@yahoo.com', '2011-01-03 00:00:00', '127.0.0.1', '2014-02-10 15:38:50', '0:0:0:0:0:0:0:1', '445', '6', '63', '63', '2013-07-10', '1', '0', '0', '0', '1', null, null, null, '0', null, '1', null);
