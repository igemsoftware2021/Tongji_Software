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

 Date: 18/10/2021 23:57:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `content` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `firstname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `lastname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (15, '和小姐妹👭逛吃的一天🌸 那我走 今天去IGEMPhageMap 冲鸭 嘿嘿嘿 这PhageMap太牛了！！！这家的奶茶也奶里奶气？？？啥也不是 我都惊了 呜呜呜 也是在逃公主的一天', '绝绝子', '扣jiojio', '2021-09-07 14:16');
INSERT INTO `comment` VALUES (17, 'ohhhhhh，cooooooool', 'D', 'mmmmm', '2021-09-07 14:19');
INSERT INTO `comment` VALUES (19, 'This page is so f*** beautiful!', 'efinition', 'r', '2021-09-12 20:25');
INSERT INTO `comment` VALUES (20, 'Awesome Project! PhageMAP is such a distinguished  database and I really hope it will not close later. (〃>_<;〃)', 'Pei', 'Tian', '2021-09-07 14:53');
INSERT INTO `comment` VALUES (25, '看上去很棒！！！\n感觉知识在咕咚咕咚的灌进我的脑子~', '峻', '汪', '2021-09-15 20:08');
INSERT INTO `comment` VALUES (29, '溶酶体在细胞中到底能发挥什么作用鸭', '一个什么都不懂的', '萌新', '2021-09-28 19:22');
INSERT INTO `comment` VALUES (34, 'I like your super website!', 'Try', 'Again', '2021-10-01 12:21');
INSERT INTO `comment` VALUES (35, 'I like your super website!', 'Love', 'agin', '2021-10-01 12:21');
INSERT INTO `comment` VALUES (38, 'It will be better if you give a default example in searching condition .', 'base', 'Wang', '2021-10-08 17:38');
INSERT INTO `comment` VALUES (39, 'The map is so interesting that you can treat it as a game for killing time.', 'base', 'Wang', '2021-10-08 17:50');
INSERT INTO `comment` VALUES (40, 'good\n', 'tiew on', 'ting', '2021-10-08 21:58');
INSERT INTO `comment` VALUES (41, 'I love your software', 'Jack', 'Benjamin.R', '2021-10-08 22:08');
INSERT INTO `comment` VALUES (42, 'I love TJU', 'Mi', 'Mi', '2021-10-10 16:17');
INSERT INTO `comment` VALUES (43, 'I like the Phage Map!', 'Igem', 'Runner', '2021-10-13 19:29');
INSERT INTO `comment` VALUES (45, '游戏的画风很新颖！！！玩法也很独特！', '梁', '乔', '2021-10-14 19:47');
INSERT INTO `comment` VALUES (46, '一个很有趣的点子，感觉会很有价值', 'Joe', 'Redefi', '2021-10-14 19:48');
INSERT INTO `comment` VALUES (47, '画风很赞👍', 'llleoy', 'W', '2021-10-14 20:12');
INSERT INTO `comment` VALUES (48, '非常有趣，美工水准媲美顶级独立游戏工作室！', 'Wong', 'Passon', '2021-10-14 20:14');
INSERT INTO `comment` VALUES (50, '感觉...远超原神...🤤🤤', 'Golden', 'Chain', '2021-10-16 16:57');
INSERT INTO `comment` VALUES (51, '非常不错的一个网页，也期待后续带来的更新o(￣▽￣)ｄ', '唐九洲', '的女友粉', '2021-10-16 16:58');
INSERT INTO `comment` VALUES (53, 'When I saw that you have \'Interactive MAP\'  module, I knew you really want to apply this project to clinic. Come on! ', 'Carry', 'Liu', '2021-09-14 22:03');
INSERT INTO `comment` VALUES (54, 'The design of the whole page is very user-friendly. The function of recommending search terms in the Phare finder is great! \n', 'Rong', 'Li', '2021-09-19 18:52');
INSERT INTO `comment` VALUES (55, 'On this website, I can get all your data. But can you provide a data statement so that I can understand and use them faster?\n', 'Songyang', 'Wang', '2021-10-02 09:55');
INSERT INTO `comment` VALUES (56, 'Can you add fuzzy search or recommendation items to your shrink bar? I think it will be much more convenient\n', 'Jun', 'Zhao', '2021-10-05 12:49');
INSERT INTO `comment` VALUES (57, 'I\'ve been interested in your project since I last experienced your game. After reading your home page, I think you are doing something meaningful.\n', 'Xujie', 'Lin', '2021-09-25 23:05');
INSERT INTO `comment` VALUES (58, 'In the ‘interactive MAP’ module, sometimes when I click the same ball(phage cluster) several times, some repeated balls (phage) will pop up', 'dongdong', 'Wang', '2021-10-06 15:56');
INSERT INTO `comment` VALUES (59, 'It would be better id you give a default example in searching condition', 'base', 'Wang', '2021-10-08 17:38');
INSERT INTO `comment` VALUES (60, 'Thank you for liking our website❤️', 'Zhengyi', 'Zhuo', '2021-10-17 19:53');

SET FOREIGN_KEY_CHECKS = 1;
