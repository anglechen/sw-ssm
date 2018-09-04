/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50509
Source Host           : localhost:3306
Source Database       : sw-ssm

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2018-09-04 17:39:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `seria` varchar(50) DEFAULT NULL,
  `produce_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `prices` float DEFAULT NULL,
  `user_people` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '台式电脑', '电脑', '001', '2018-09-04 09:44:04', null, '1.3', '张三');
INSERT INTO `product` VALUES ('2', 'test', ' ', null, null, '0', null, null);
INSERT INTO `product` VALUES ('3', 'admin', null, null, null, '0', null, null);
INSERT INTO `product` VALUES ('4', '笔记本电脑', null, null, null, '0', null, null);
INSERT INTO `product` VALUES ('5', '笔记本电脑', null, null, null, '0', null, null);
INSERT INTO `product` VALUES ('6', 'test', null, null, null, '0', null, null);
INSERT INTO `product` VALUES ('7', 'test1', 'test1', '12345', null, '1', null, 'test1');
INSERT INTO `product` VALUES ('8', 'test1', 'test1', '12345', null, '1', '1.2', 'test1');
INSERT INTO `product` VALUES ('9', 'test1', 'test1', '12345', '2018-09-04 17:04:01', '1', '1.2', 'test1');
INSERT INTO `product` VALUES ('10', '电脑', '电脑', '12345', '2018-09-04 17:05:33', '1', '1.2', 'test1');
INSERT INTO `product` VALUES ('11', '电脑', '电脑', '12345', '2018-09-04 17:05:33', '1', '1.2', 'test1');
INSERT INTO `product` VALUES ('12', '电脑', '电脑', '12345', '2018-09-04 17:05:33', '1', '1.2', 'test1');
INSERT INTO `product` VALUES ('13', '电脑', '电脑', '12345', '2018-09-04 17:05:33', '1', '1.2', 'test1');
INSERT INTO `product` VALUES ('14', '电脑', '电脑', '12345', '2018-09-04 17:05:33', '1', '1.2', 'test1');
INSERT INTO `product` VALUES ('15', '电脑', '电脑', '12345', '2018-09-04 17:05:33', '1', '1.2', 'test1');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '有效', '1');
INSERT INTO `status` VALUES ('2', '无效', '0');
