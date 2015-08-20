/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-08-03 21:08:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_department
-- ----------------------------
DROP TABLE IF EXISTS `s_department`;
CREATE TABLE `s_department` (
  `did` varchar(32) CHARACTER SET utf8 NOT NULL,
  `deptName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_department
-- ----------------------------
INSERT INTO `s_department` VALUES ('1', '信科大厦', '重庆邮电大学', '12346789');
INSERT INTO `s_department` VALUES ('bfabb917d6cf46eabbae2ce81e674f6a', '二教', '重庆邮电大学', '55555');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `uid` varchar(50) CHARACTER SET utf8 NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `loginname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `loginpass` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `fulture` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `education` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `cellphone` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `hobby` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `filepath` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `filename` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('04a624c58ff04782959eea02c55cd442', '骆潇龙', 'luoxiaolong', '123456', '男', '', '', '', '研二', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('12e0e97933594ac68d020e836ded19c2', '杨方方', 'yangfang', '123456', '男', '', '', '', '研一', '15340528767', '', null, null, '');
INSERT INTO `s_user` VALUES ('1ef08896b82a4f1a88572bfbc6be0ac7', '高红宇', 'gaohongyu', '123456', '男', '', '', '', '研二', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('283b9322f145471a8dfebe3745ac30eb', 'admin', 'admin', 'admin', '男', '2015-05-06', '', '中国 河南 南阳 方城县', '工作', '', '看电影, 看书, 旅游', '', '', '123455576689');
INSERT INTO `s_user` VALUES ('3124b1e4fef04d3ca5247b3f5c9822e9', '马金勇', 'majinyong', '123456', '男', '', '', '', '研三', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('361f4c8cce934ae48547f5f0341a3e39', '赵志成', 'zhaozhicheng', '123456', '男', '', '', '', '研三', '18174600880', '', '', '', '');
INSERT INTO `s_user` VALUES ('36b026ddc7df4def93b2c5b849d435fc', '冯浩', 'fenghao', '123456', '女', '', '', '', '研二', '13637828641', '', null, null, '');
INSERT INTO `s_user` VALUES ('37092dd68a4f4632b07d39a3712d1e61', '秦恒', 'qinheng', '123456', '男', '', '', '', '研二', '15320683355', '', null, null, '');
INSERT INTO `s_user` VALUES ('43d2fe6032994f43b905d3ca0bdaf707', '林钟婧', 'linzhongjin', '123456', '女', '', '', '', '研三', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('524bbe5ecd934ea29f21b632917f7083', '刘杰', 'liujie', '123456', '男', '', '', '', '研一', '18559252795', '', null, null, '');
INSERT INTO `s_user` VALUES ('5a1fac2beae54e609362ced75ab15acd', '刘雨龙', 'liuyulong', '123456', '男', '', '', '', '研二', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('5a7aa50fc37644a382b55ad882f5bc42', '汤婷婷', 'tangtingting', '123456', '女', '', '', '', '研一', '18166451436', '', null, null, '');
INSERT INTO `s_user` VALUES ('65b49568791541bbbd90547d3ae2282e', '张成', 'zhangcheng', '123456', '男', '', '', '', '本科', '18883282594', '', '', '', '');
INSERT INTO `s_user` VALUES ('6629d17d34b34cd09914ccfeb8ce8647', '熊风波', 'xiongfengbo', '123456', '男', '', '', '', '研三', '18696560718', '', null, null, '');
INSERT INTO `s_user` VALUES ('68bfb79cbeba4a44b045d7aa891d3804', '冯超政', 'fengchaozheng', '123456', '男', '', '', '', '研二', '13983832051', '', null, null, '');
INSERT INTO `s_user` VALUES ('71ec42c0c9a24e50a7aaeedbaaa1062f', '马原龙', 'mayuanlong', '123456', '男', '', '', '', '研二', '18623144929', '', '', '', '');
INSERT INTO `s_user` VALUES ('74be98c9514641b3bed5be4b0ea73762', '夏玉冲', 'xiayuchong', '123456', '男', '2015-05-13', 'QQ', '中国 河南 南阳 新野县', '研一', '13752852983', '看电影, 看书, 睡觉', '/WEB-INF/resumes\\11ac99b17b49440d97538668dd0fcfb4_四川电信收入分成及政企协议管理系统 安全手册V1.0.doc', '四川电信收入分成及政企协议管理系统 安全手册V1.0.doc', '123456788888');
INSERT INTO `s_user` VALUES ('7e546d15ae624b4e8c1e7cf14201d538', '邹姣', 'zoujiao', '123456', '女', '', '', '', '研三', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('7f893bad64354e61ad60c11d3ad10519', '梁云柯', 'lingyunke', '123456', '男', '', '', '', '研二', '15213340895', '', null, null, '');
INSERT INTO `s_user` VALUES ('801c05528137490091b4b6982eb78834', '陈丰', 'chenfeng', '123456', '男', '', '', '', '研三', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('8bfa80d0895244f7b6bfdbe872ea5748', '王浪', 'wanglang', '123456', '男', '1988-06-23', '', '', '研一', '15123357630', '看电影, 看书, 旅游, 睡觉', '', '', '');
INSERT INTO `s_user` VALUES ('8d3a2a7d1eb342f1853c60fcf2a9218f', '邓旻', 'dengmin', '123456', '女', '', '', '', '研三', '', '', '', '', '');
INSERT INTO `s_user` VALUES ('8f454fe35648408daf181325dfb969d8', '朱恒伟', 'zhuhengwei', '123456', '男', '', '', '', '研一', '18716321170', '', '', '', '');
INSERT INTO `s_user` VALUES ('95abb6d1f37b410fb4dc9a225da71860', '小明', 'xiaoming', '123456', '男', '2015-06-24', 'QQ', '中国--北京--东城--无', '本科', '18749667591', '看电影, 看书, 购物', '/WEB-INF/resumes\\2b44cc97a020457dba26beb572a106aa_Activiti工作流课程.doc', 'Activiti工作流课程.doc', '0987654321');
INSERT INTO `s_user` VALUES ('a4100105d3ed46d99c27899ae98cb3f2', '王志迁', 'wangzhiqian', '123456', '男', '', '', '', '研一', '15922724796', '', '', '', '');
INSERT INTO `s_user` VALUES ('be362b84278c4a7999b362d9b8ff2472', '罗宇豪', 'luoyuhao', '123456', '男', '', '', '', '研一', '15215042388', '', null, null, '');
INSERT INTO `s_user` VALUES ('c0cbb027eaa24269980deb14e10590de', '黎海青', 'lihaiqing', '123456', '男', '', '', '', '研一', '15696072763', '', null, null, '');
INSERT INTO `s_user` VALUES ('c0ff1be9dbf94c75b8f79b6edfc04f71', '曾宏', 'zenghong', '123456', '男', '', '', '', '本科', '', '', null, null, '');
INSERT INTO `s_user` VALUES ('d0e1194d316f410f99c3667513577aad', '印振宇', 'yinzhenyu', '123456', '男', '', '', '', '研一', '13638330400', '', null, null, '');
INSERT INTO `s_user` VALUES ('d3f0d69c7754453fb7a7fe48d66bb89f', '王英豪', 'wangyinghao', '123456', '男', '', '', '', '研一', '15223135527', '', null, null, '');
INSERT INTO `s_user` VALUES ('e5ed850c30e24884abc2523151762d56', '王运萍', 'wangyunping', '123456', '女', '', '', '', '研二', '15310625445', '', null, null, '');
INSERT INTO `s_user` VALUES ('e6c09d1bbd244cbb800b2046079a6dd8', '成哲', 'chengzhe', '123456', '男', '', '', '', '研二', '15310627743', '', null, null, '');
INSERT INTO `s_user` VALUES ('e71ea7787694471fb60be738f00fd3df', '王俊霞', 'wangjunxia', '123456', '女', '', '', '', '研一', '18716319589', '', null, null, '');
INSERT INTO `s_user` VALUES ('f200cf4f4f7e404bbf1e7b36d6a3079f', '赵全', 'zhaoquan', '123456', '男', '', '', '', '研三', '', '', null, null, '');
