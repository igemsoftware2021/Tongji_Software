/*
 Navicat Premium Data Transfer

 Source Server         : iGEM-db
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 47.100.225.207:13306
 Source Schema         : iGEM_database

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 18/10/2021 23:58:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for super_bug
-- ----------------------------
DROP TABLE IF EXISTS `super_bug`;
CREATE TABLE `super_bug`  (
  `bug_seq_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bug_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `txid` int(0) NULL DEFAULT NULL,
  `txid_rank` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(4095) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bug_seq_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of super_bug
-- ----------------------------
INSERT INTO `super_bug` VALUES ('NC_000913.3', 'GCF_000157115.2', 562, 'species', 'Escherichia coli');
INSERT INTO `super_bug` VALUES ('NC_002516.2', 'GCF_000233495.1', 287, 'species', 'Pseudomonas aeruginosa');
INSERT INTO `super_bug` VALUES ('NC_003197.2', 'GCF_000006945.2', 59201, 'subspecies', 'Salmonella enterica subsp. enterica');
INSERT INTO `super_bug` VALUES ('NC_010554.1', 'GCF_000755485.1', 584, 'species', 'Proteus mirabilis');
INSERT INTO `super_bug` VALUES ('NC_021670.1', 'GCF_000418345.1', 1280, 'species', 'Staphylococcus aureus');
INSERT INTO `super_bug` VALUES ('NZ_AP023069.1', 'GCF_013030075.1', 485, 'species', 'Neisseria gonorrhoeae');
INSERT INTO `super_bug` VALUES ('NZ_CP006659.2', 'GCF_000364385.3', 573, 'species', 'Klebsiella Pneumoniae');
INSERT INTO `super_bug` VALUES ('NZ_CP009467.1', 'GCF_000770115.1', 669, 'species', 'Vibrio harveyi');
INSERT INTO `super_bug` VALUES ('NZ_CP009468.1', 'GCF_000770115.1', 669, 'species', 'Vibrio harveyi');
INSERT INTO `super_bug` VALUES ('NZ_CP012480.1', 'GCF_001552035.1', 1311, 'species', 'Streptococcus agalactiae');
INSERT INTO `super_bug` VALUES ('NZ_CP020549.1', 'GCF_002076835.1', 1313, 'species', 'Streptococcus pneumoniae');
INSERT INTO `super_bug` VALUES ('NZ_CP034181.1', 'GCF_004028015.1', 36809, 'species', 'Mycobacteroides abscessus');
INSERT INTO `super_bug` VALUES ('NZ_CP035288.1', 'GCF_006094375.1', 1282, 'species', 'Staphylococcus epidermidis');
INSERT INTO `super_bug` VALUES ('NZ_CP038996.1', 'GCF_009734005.1', 1352, 'species', 'Enterococcus Faecium');
INSERT INTO `super_bug` VALUES ('NZ_CP043953.1', 'GCF_008632635.1', 470, 'species', 'Acinetobacter baumannii');
INSERT INTO `super_bug` VALUES ('NZ_CP045235.1', 'GCF_009586235.1', 292, 'species', 'Burkholderia cepacia');
INSERT INTO `super_bug` VALUES ('NZ_CP045236.1', 'GCF_009586235.1', 292, 'species', 'Burkholderia cepacia');
INSERT INTO `super_bug` VALUES ('NZ_CP045237.1', 'GCF_009586235.1', 292, 'species', 'Burkholderia cepacia');
INSERT INTO `super_bug` VALUES ('NZ_CP071982.1', 'GCF_017821535.1', 210, 'species', 'Helicobacter pylori');

SET FOREIGN_KEY_CHECKS = 1;
