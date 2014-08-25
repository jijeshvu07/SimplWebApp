CREATE DATABASE  IF NOT EXISTS `assignment_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `assignment_db`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: assignment_db
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `IS_DELETE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'JAVA','2014-07-21',0),(2,'.NET','2014-07-21',0),(3,'PHP','2014-07-21',0),(4,'IOS','2014-07-21',0);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `IS_DELETE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,'Beginner','2014-07-21',0),(2,'Intermediate','2014-07-21',0),(3,'Expert','2014-07-21',0);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skillfactor`
--

DROP TABLE IF EXISTS `skillfactor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skillfactor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FACTOR_NAME` varchar(45) NOT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `IS_DELETE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skillfactor`
--

LOCK TABLES `skillfactor` WRITE;
/*!40000 ALTER TABLE `skillfactor` DISABLE KEYS */;
INSERT INTO `skillfactor` VALUES (1,'Training','2014-07-31',0),(2,'R&D','2014-07-31',0),(3,'Presentation','2014-07-31',0),(4,'Coding','2014-07-31',0);
/*!40000 ALTER TABLE `skillfactor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technology`
--

DROP TABLE IF EXISTS `technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `technology` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DEPARTMENT_ID` int(11) NOT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `IS_DELETE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_dept_id_idx` (`DEPARTMENT_ID`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technology`
--

LOCK TABLES `technology` WRITE;
/*!40000 ALTER TABLE `technology` DISABLE KEYS */;
INSERT INTO `technology` VALUES (1,'core java',1,'2014-07-21','0'),(2,'swing',1,'2014-07-21','0'),(3,'javafx',1,'2014-07-21','0'),(4,'spring.net',2,'2014-07-21','0'),(5,'joomla',3,'2014-07-21','0'),(6,'codeignitor',3,'2014-07-21','0');
/*!40000 ALTER TABLE `technology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(128) NOT NULL,
  `department_id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `authority` varchar(12) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dept_id_idx` (`department_id`),
  CONSTRAINT `fk_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','user',1,'user','ROLE_NORMAL'),(2,'admin','admin',1,'admin','ROLE_ADMIN'),(3,'arathy','arathy@gmail.com',3,'123','ROLE_NORMAL');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrating`
--

DROP TABLE IF EXISTS `userrating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrating` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `TECHNOLOGICAL_ID` int(11) NOT NULL,
  `SKILL_FACTORS_ID` int(11) NOT NULL,
  `RATING_ID` int(11) NOT NULL,
  `ATTEND_DATE` date DEFAULT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `IS_DELETE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_user_id_idx` (`USER_ID`),
  KEY `fk_tech_id_idx` (`TECHNOLOGICAL_ID`),
  KEY `fk_skill_id_idx` (`SKILL_FACTORS_ID`),
  KEY `fk_rating_id_idx` (`RATING_ID`),
  CONSTRAINT `fk_rating_id` FOREIGN KEY (`RATING_ID`) REFERENCES `rating` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill_id` FOREIGN KEY (`SKILL_FACTORS_ID`) REFERENCES `skillfactor` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tech_id` FOREIGN KEY (`TECHNOLOGICAL_ID`) REFERENCES `technology` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrating`
--

LOCK TABLES `userrating` WRITE;
/*!40000 ALTER TABLE `userrating` DISABLE KEYS */;
INSERT INTO `userrating` VALUES (1,1,1,1,1,'2014-07-31',NULL,0),(2,1,1,1,3,'2014-07-31',NULL,0),(3,1,1,2,3,'2014-07-31',NULL,0),(4,1,1,3,2,'2014-07-31',NULL,0),(5,1,1,4,3,'2014-07-31',NULL,0),(6,1,2,4,3,'2014-07-31',NULL,0),(7,1,2,3,2,'2014-07-31',NULL,0),(8,1,2,2,2,'2014-07-31',NULL,0),(9,1,2,1,2,'2014-07-31',NULL,0),(10,1,3,1,1,'2014-07-31',NULL,0),(11,1,3,2,1,'2014-07-31',NULL,0),(12,1,3,3,1,'2014-07-31',NULL,0),(13,1,3,4,2,'2014-07-31',NULL,0),(14,3,5,1,3,'2014-07-31',NULL,0),(15,3,5,2,3,'2014-07-31',NULL,0),(16,3,5,3,3,'2014-07-31',NULL,0),(17,3,5,4,3,'2014-07-31',NULL,0),(18,3,6,1,2,'2014-07-31',NULL,0),(19,3,6,2,2,'2014-07-31',NULL,0),(20,3,6,3,2,'2014-07-31',NULL,0),(21,3,6,4,2,'2014-07-31',NULL,0);
/*!40000 ALTER TABLE `userrating` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-31 14:23:12
