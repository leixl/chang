#
# Source for table t_user
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(32) NOT NULL,
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` char(32) NOT NULL COMMENT '密码',
  `email` varchar(100)  COMMENT '邮箱',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `register_ip` varchar(50) NOT NULL default '127.0.0.1' COMMENT '注册IP',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) NOT NULL default '127.0.0.1' COMMENT '最后登录IP',
  `login_count` int(11) NOT NULL default '0' COMMENT '登录次数',
  `rank` int(11) NOT NULL default '0' COMMENT '管理员级别',
  `upload_total` bigint(20) NOT NULL default '0' COMMENT '上传总大小',
  `upload_size` int(11) NOT NULL default '0' COMMENT '上传大小',
  `upload_date` date  COMMENT '上传日期',
  `is_admin` tinyint(1) NOT NULL default '0' COMMENT '是否管理员',
  `is_viewonly_admin` tinyint(1) NOT NULL default '0' COMMENT '是否只读管理员',
  `is_self_admin` tinyint(1) NOT NULL default '0' COMMENT '是否只管理自己的数据',
  `is_disabled` tinyint(1) NOT NULL default '0' COMMENT '是否禁用',
  `group_id` int(11) NOT NULL,
  `reset_key` char(32)  COMMENT '重置密码KEY',
  `reset_pwd` varchar(10)  COMMENT '重置密码VALUE',
  `error_time` datetime  COMMENT '登录错误时间',
  `error_count` int(11) NOT NULL default '0' COMMENT '登录错误次数',
  `error_ip` varchar(50)  COMMENT '登录错误IP',
  `activation` tinyint(1) NOT NULL default '1' COMMENT '激活状态',
  `activation_code` char(32)  COMMENT '激活码',
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `ak_username` (`username`),
  KEY `fk_e_user_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Dumping data for table t_user
#

LOCK TABLES `t_user` WRITE;
INSERT INTO `t_user` VALUES (1,'admin','5f4dcc3b5aa765d61d8327deb882cf99',
'admin@yahoo.com','2011-01-03','127.0.0.1',
'2013-09-29 14:23:53','127.0.0.1',434,
6,63,63,
'2013-07-10',1,0,
0,0,1,NULL,
NULL,NULL,0,
NULL,1,NULL);
UNLOCK TABLES;


#
# Source for table t_role
#

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `priority` INT(11) NOT NULL COMMENT '排列顺序',
  `is_super` TINYINT(1)  COMMENT '是否超级管理员',
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


#
# Source for table t_menu
#

DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `action_url` varchar(200) NOT NULL COMMENT '菜单链接',
  `lft` INT(11)  COMMENT '左',
  `rgt` INT(11)  COMMENT '右',
  `priority` INT(11)  COMMENT '排序',
  `create_date` date  COMMENT '创建日期',
  `update_date` date  COMMENT '修改日期',
  `perm_prefix` varchar(100)  COMMENT '权限前缀',
  `is_leaf` TINYINT(1)  COMMENT '是否叶子',
  `is_display` TINYINT(1)  COMMENT '是否显示',
  `parent_id` INT(11)  COMMENT '父节点',
  PRIMARY KEY  (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';


DROP TABLE IF EXISTS `t_movie`;
CREATE TABLE `t_movie` (
  `movie_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '原名',
  `simple_name` varchar(32) COMMENT '简体中文名',
  `alias_name1` varchar(32) COMMENT '别名1',
  `alias_name2` varchar(32) COMMENT '别名2',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `imdb_no` varchar(32) COMMENT 'IMDb编号',
  `director` varchar(32) COMMENT '导演',
  `scenarist` varchar(32) COMMENT '编剧',
  `area` varchar(32) COMMENT '制片国家/地区',
  `publish_year` varchar(32) COMMENT '年份',
  `screening_date` DATE COMMENT '上映日期',
  `leng` int(11) COMMENT '片长',
  `remark` varchar(32) COMMENT 'IMDb编号',
  `create_date` date  COMMENT '创建日期',
  `update_date` date  COMMENT '修改日期',
  `cover` varchar(32) COMMENT '封面',
  `is_disabled` tinyint(1) NOT NULL default '0' COMMENT '是否禁用',
  PRIMARY KEY  (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影信息表';

DROP TABLE IF EXISTS `t_movie_tag`;
CREATE TABLE `t_movie_tag` (
  `tag_id` int(11) NOT NULL,
  `tag_name` varchar(32) NOT NULL COMMENT '电影标签名',
  `ref_counter` int(11) NOT NULL COMMENT '引用次数',
  PRIMARY KEY  (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影标签表';

DROP TABLE IF EXISTS `t_movietag`;
CREATE TABLE `t_movietag` (
  `movie_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL ,
  `priority` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影标签关联表';