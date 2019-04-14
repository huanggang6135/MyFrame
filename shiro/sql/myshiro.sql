/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : myshiro

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-04-14 15:41:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_log_operate`
-- ----------------------------
DROP TABLE IF EXISTS `tb_log_operate`;
CREATE TABLE `tb_log_operate` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `args` varchar(255) DEFAULT NULL,
  `exception` varchar(255) DEFAULT NULL,
  `http_method` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `operate_type` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `result_code` int(11) DEFAULT NULL,
  `result_message` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_log_operate
-- ----------------------------
INSERT INTO `tb_log_operate` VALUES ('00c248f66e6a446389e1422499993bcd', '2019-04-14 13:56:18', '2019-04-14 13:56:18', '[admin, admin]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.UserController.addUser', 'null', '0', null, 'http://localhost:8080/shiro/user/addUser');
INSERT INTO `tb_log_operate` VALUES ('119ac981fbb14485a138f2bba118003a', '2019-04-14 15:29:33', '2019-04-14 15:29:33', '[c2b8732a62614faebd3b6977f24ab58b]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.deleteRole', 'admin', '0', null, 'http://localhost:8080/shiro/admin/deleteRole');
INSERT INTO `tb_log_operate` VALUES ('1841dcefa5414b7a99bff9955d69b7fd', '2019-04-14 14:43:44', '2019-04-14 14:43:44', '[]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.toLogin', 'null', '600', '请登录', 'http://localhost:8080/shiro/toLogin');
INSERT INTO `tb_log_operate` VALUES ('1a4c625b5cbc4fbc887563790cb8eab1', '2019-04-14 14:37:31', '2019-04-14 14:37:31', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('275f9289fc354bdeb56e356b74587bf5', '2019-04-14 14:02:46', '2019-04-14 14:02:46', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('2fa124e9730c4e1aa3c43e60ee74bf4b', '2019-04-14 15:30:33', '2019-04-14 15:30:33', '[c2b8732a62614faebd3b6977f24ab58b]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.deleteRole', 'admin', '0', null, 'http://localhost:8080/shiro/admin/deleteRole');
INSERT INTO `tb_log_operate` VALUES ('34060a0763ff4ef090c8f6a73e100fef', '2019-04-14 15:26:17', '2019-04-14 15:26:17', '[c2b8732a62614faebd3b6977f24ab58b]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.deleteRole', 'admin', '0', null, 'http://localhost:8080/shiro/admin/deleteRole');
INSERT INTO `tb_log_operate` VALUES ('377eb6143e6a4a77b2ca213e527db9a2', '2019-04-14 15:29:18', '2019-04-14 15:29:18', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('44796ec39d934262be14c1cb155d7452', '2019-04-14 15:03:42', '2019-04-14 15:03:42', '[user, user, null]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleContorller.addRole', 'admin', '200', null, 'http://localhost:8080/shiro/admin/addRole');
INSERT INTO `tb_log_operate` VALUES ('521e3f97337843a7bc513f6420ac5820', '2019-04-14 14:35:27', '2019-04-14 14:35:27', '[admin, admin, null]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleContorller.addRole', 'null', '200', null, 'http://localhost:8080/shiro/admin/addRole');
INSERT INTO `tb_log_operate` VALUES ('53304d1cfede40748079881450c6f46e', '2019-04-14 14:27:08', '2019-04-14 14:27:08', '[]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.toLogin', 'null', '600', '请登录', 'http://localhost:8080/shiro/toLogin');
INSERT INTO `tb_log_operate` VALUES ('53a83738b9254a1baaaf710da769db3f', '2019-04-14 14:47:59', '2019-04-14 14:47:59', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('58c2622a9f894739a0ad49860e0dcd44', '2019-04-14 15:04:09', '2019-04-14 15:04:09', '[6ab33f398cde4834acf95cd1eb91698c, [Ljava.lang.String;@6c3139b6]', 'No EntityManager with actual transaction available for current thread - cannot reliably process \'remove\' call; nested exception is javax.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cann', 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleContorller.grantRole', 'admin', '0', null, 'http://localhost:8080/shiro/admin/grantRole');
INSERT INTO `tb_log_operate` VALUES ('5f5178a7d3414323b24fd52d85af1ad0', '2019-04-14 14:27:48', '2019-04-14 14:27:48', '[]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.unauthorized', 'admin', '500', '未授权', 'http://localhost:8080/shiro/unauthorized');
INSERT INTO `tb_log_operate` VALUES ('65bd7db8440b4fd0b8b2082dbaec65dd', '2019-04-14 15:22:47', '2019-04-14 15:22:47', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('6b2bf54d49fd46f2b7e338eaf3f1ee82', '2019-04-14 15:23:48', '2019-04-14 15:23:48', '[c2b8732a62614faebd3b6977f24ab58b]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.deleteRole', 'admin', '0', null, 'http://localhost:8080/shiro/admin/deleteRole');
INSERT INTO `tb_log_operate` VALUES ('887cbc0b178e4c68bc283d25c457d3ab', '2019-04-14 14:27:29', '2019-04-14 14:27:29', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('95db95d8ad90487da1c691cdfd60308a', '2019-04-14 14:18:53', '2019-04-14 14:18:53', '[]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.toLogin', 'null', '500', '登录页', 'http://localhost:8080/shiro/toLogin');
INSERT INTO `tb_log_operate` VALUES ('a34982f6ac0c4c2c9e882dc2572367cb', '2019-04-14 14:37:13', '2019-04-14 14:37:13', '[]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.toLogin', 'null', '600', '请登录', 'http://localhost:8080/shiro/toLogin');
INSERT INTO `tb_log_operate` VALUES ('adc0b951ddeb49938509f78782f04ed2', '2019-04-14 15:37:00', '2019-04-14 15:37:00', '[guest, guest, null]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.addRole', 'admin', '500', 'key已存在', 'http://localhost:8080/shiro/admin/addRole');
INSERT INTO `tb_log_operate` VALUES ('b3a521f3d7ce4e8d938f2c93293bad44', '2019-04-14 15:03:17', '2019-04-14 15:03:17', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('b9b3d4a602f948b9829ce43d15434b19', '2019-04-14 14:52:34', '2019-04-14 14:52:34', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('bb7fb6d91ae74013b385de3d59320520', '2019-04-14 14:43:53', '2019-04-14 14:43:53', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('cc0046a2c3c3482186d339db9995b47b', '2019-04-14 13:57:50', '2019-04-14 13:57:50', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('cf0351e614744a20b98b93f594e6d6c1', '2019-04-14 15:24:12', '2019-04-14 15:24:12', '[user, user, null]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.addRole', 'admin', '200', null, 'http://localhost:8080/shiro/admin/addRole');
INSERT INTO `tb_log_operate` VALUES ('d35821387a9249eba0ee5095a1bb6637', '2019-04-14 15:26:00', '2019-04-14 15:26:00', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('d76f1b9c0e0844b0bcdcd73f0cdc2211', '2019-04-14 15:37:09', '2019-04-14 15:37:09', '[c2b8732a62614faebd3b6977f24ab58b]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.deleteRole', 'admin', '0', null, 'http://localhost:8080/shiro/admin/deleteRole');
INSERT INTO `tb_log_operate` VALUES ('db37e33da5184bbe918610ff3199323f', '2019-04-14 15:25:25', '2019-04-14 15:25:25', '[guest, guest, null]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleController.addRole', 'admin', '200', null, 'http://localhost:8080/shiro/admin/addRole');
INSERT INTO `tb_log_operate` VALUES ('e95dd24b5d534fea8e5f21e96da81ff8', '2019-04-14 14:36:31', '2019-04-14 14:36:31', '[6ab33f398cde4834acf95cd1eb91698c, [Ljava.lang.String;@1bed7a88]', null, 'POST', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.RoleContorller.grantRole', 'null', '200', null, 'http://localhost:8080/shiro/admin/grantRole');
INSERT INTO `tb_log_operate` VALUES ('ea8300521f14497f9fae9248742610c5', '2019-04-14 15:36:46', '2019-04-14 15:36:46', '[admin, admin]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.login', 'admin', '0', null, 'http://localhost:8080/shiro/login');
INSERT INTO `tb_log_operate` VALUES ('efbd42656c354e2da11d938e2c2ee4da', '2019-04-14 14:20:57', '2019-04-14 14:20:57', '[]', null, 'GET', '0:0:0:0:0:0:0:1', 'org.hg.shiro.rest.LoginController.toLogin', 'null', '500', '登录页', 'http://localhost:8080/shiro/toLogin');

-- ----------------------------
-- Table structure for `tb_shiro_resource`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shiro_resource`;
CREATE TABLE `tb_shiro_resource` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `resource_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shiro_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_shiro_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shiro_role`;
CREATE TABLE `tb_shiro_role` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `role_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shiro_role
-- ----------------------------
INSERT INTO `tb_shiro_role` VALUES ('22c2a214f0644d4da5f84e25962e8ed0', '2019-04-14 14:35:27', '2019-04-14 14:35:27', 'admin', 'admin', null);
INSERT INTO `tb_shiro_role` VALUES ('62c8fc1ce1b9498ab77e0d999767f0bb', '2019-04-14 15:25:25', '2019-04-14 15:25:25', 'guest', 'guest', null);
INSERT INTO `tb_shiro_role` VALUES ('fcbc851d7e1e44d099da8c3a4d658672', '2019-04-14 15:24:12', '2019-04-14 15:24:12', 'user', 'user', null);

-- ----------------------------
-- Table structure for `tb_shiro_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shiro_role_resource`;
CREATE TABLE `tb_shiro_role_resource` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `resource_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shiro_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_shiro_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shiro_user`;
CREATE TABLE `tb_shiro_user` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shiro_user
-- ----------------------------
INSERT INTO `tb_shiro_user` VALUES ('6ab33f398cde4834acf95cd1eb91698c', '2019-04-14 13:56:18', '2019-04-14 13:56:18', 'admin', '�ke���ɏ~�]�(4�', '1156726222');

-- ----------------------------
-- Table structure for `tb_shiro_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shiro_user_role`;
CREATE TABLE `tb_shiro_user_role` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shiro_user_role
-- ----------------------------
INSERT INTO `tb_shiro_user_role` VALUES ('c13b90a4dffc4851b570f058a312dff0', '2019-04-14 14:36:31', '2019-04-14 14:36:31', '22c2a214f0644d4da5f84e25962e8ed0', '6ab33f398cde4834acf95cd1eb91698c');
