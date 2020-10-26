/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : 127.0.0.1:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 26/10/2020 14:25:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for biz_category
-- ----------------------------
DROP TABLE IF EXISTS `biz_category`;
CREATE TABLE `biz_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_marchant
-- ----------------------------
DROP TABLE IF EXISTS `biz_marchant`;
CREATE TABLE `biz_marchant`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_product
-- ----------------------------
DROP TABLE IF EXISTS `biz_product`;
CREATE TABLE `biz_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bar_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `product_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_category_product`(`supplier_id`) USING BTREE,
  INDEX `fk_supplier_product`(`category_id`) USING BTREE,
  CONSTRAINT `fk_category_product` FOREIGN KEY (`supplier_id`) REFERENCES `biz_supplier` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplier_product` FOREIGN KEY (`category_id`) REFERENCES `biz_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_product_sepc_map
-- ----------------------------
DROP TABLE IF EXISTS `biz_product_sepc_map`;
CREATE TABLE `biz_product_sepc_map`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `sepc_id` int(11) NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_product_product_sepc_map`(`product_id`) USING BTREE,
  INDEX `fk_sepc_product_sepc_map`(`sepc_id`) USING BTREE,
  CONSTRAINT `fk_product_product_sepc_map` FOREIGN KEY (`product_id`) REFERENCES `biz_product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sepc_product_sepc_map` FOREIGN KEY (`sepc_id`) REFERENCES `biz_spec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_purchase
-- ----------------------------
DROP TABLE IF EXISTS `biz_purchase`;
CREATE TABLE `biz_purchase`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `purchase_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pro_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `exp_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purchase_price` decimal(10, 2) NOT NULL,
  `count` int(11) NOT NULL,
  `amount` decimal(10, 2) NOT NULL,
  `receipt_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_product_purchase`(`product_id`) USING BTREE,
  CONSTRAINT `fk_product_purchase` FOREIGN KEY (`product_id`) REFERENCES `biz_product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_sale
-- ----------------------------
DROP TABLE IF EXISTS `biz_sale`;
CREATE TABLE `biz_sale`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_bar_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sale_price` decimal(10, 2) NOT NULL,
  `sale_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sale_count` int(11) NOT NULL,
  `sale_amount` decimal(10, 2) NOT NULL,
  `gross_profit` decimal(10, 2) NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_spec
-- ----------------------------
DROP TABLE IF EXISTS `biz_spec`;
CREATE TABLE `biz_spec`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `spec_val` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_stock
-- ----------------------------
DROP TABLE IF EXISTS `biz_stock`;
CREATE TABLE `biz_stock`  (
  `product_bar_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stock_count` int(11) NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `lock_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_bar_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_stock_modify_record
-- ----------------------------
DROP TABLE IF EXISTS `biz_stock_modify_record`;
CREATE TABLE `biz_stock_modify_record`  (
  `product_bar_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operator_id` int(11) NOT NULL,
  `modify_count` int(11) NOT NULL,
  `modify_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_stock_modify_record`(`operator_id`) USING BTREE,
  CONSTRAINT `fk_user_stock_modify_record` FOREIGN KEY (`operator_id`) REFERENCES `sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_supplier
-- ----------------------------
DROP TABLE IF EXISTS `biz_supplier`;
CREATE TABLE `biz_supplier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contacts_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creat_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `updat_time` datetime(0) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `wx_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_role_user`(`role_id`) USING BTREE,
  CONSTRAINT `fk_role_user` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for a
-- ----------------------------
DROP VIEW IF EXISTS `a`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `a` AS select `biz_product`.`id` AS `id`,`biz_product`.`product_name` AS `product_name` from `biz_product`;

SET FOREIGN_KEY_CHECKS = 1;
