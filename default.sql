/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : default

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 04/01/2021 21:58:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('369ed438-d0d6-49f2-b6d2-34aa978681aa', 'hangocanh', '$2b$12$x1yT9B6RYNKa5U6VI33FOeFXrjYvODvwVzHKjHAtyOOBTisAZ/QVS', 'USER');
INSERT INTO `account` VALUES ('574e337a-d4ab-49fb-9a5a-5ae69fc29f3a', 'leducthang', '$2b$12$ILCtjd5aWy8bflDigX0bZOGTgRzUk9PqwluRKCS2NxCVyPCO8/g7u', 'USER');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
