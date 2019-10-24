-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookmyparking
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `area_name` varchar(100) NOT NULL,
  PRIMARY KEY (`area_id`,`city_id`),
  KEY `city_id_fk_idx` (`city_id`),
  CONSTRAINT `city_id_fk` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,1,'Katraj'),(1,2,'Bandra'),(2,1,'Kothrud'),(2,2,'Malabar Hills'),(3,1,'Karvenagar'),(3,2,'Worli'),(4,1,'Bavdhan'),(4,2,'Powai'),(5,1,'Aundh'),(5,2,'Pali Hill'),(6,1,'Pashan'),(6,2,'Versova'),(7,1,'Hadapsar'),(7,2,'Breach Candy'),(8,1,'Dhankawdi'),(8,2,'Juhu'),(9,1,'Shivajinagar'),(9,2,'Lower Parel'),(10,1,'Vimannagar'),(10,2,'Lokhandwala');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Pune'),(2,'Mumbai'),(3,'Nagpur'),(4,'Nashik'),(5,'Thane'),(6,'Dombivli'),(7,'Kolhapur'),(8,'Satara'),(9,'Sangli'),(10,'Amravti');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fw_slots`
--

DROP TABLE IF EXISTS `fw_slots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fw_slots` (
  `fw_slots_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `area_id` int(11) NOT NULL,
  `is_available` tinyint(4) NOT NULL,
  `reservation_time` int(11) NOT NULL,
  PRIMARY KEY (`fw_slots_id`,`city_id`,`area_id`),
  KEY `city_id_fw_fk_idx` (`city_id`),
  KEY `area_id_fw_fk_idx` (`area_id`),
  CONSTRAINT `area_id_fw_fk` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`),
  CONSTRAINT `city_id_fw_fk` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fw_slots`
--

LOCK TABLES `fw_slots` WRITE;
/*!40000 ALTER TABLE `fw_slots` DISABLE KEYS */;
INSERT INTO `fw_slots` VALUES (1,1,1,1,0),(1,1,2,1,0),(1,1,3,1,0),(1,1,4,1,0),(1,1,5,1,0),(1,1,6,1,0),(1,1,7,1,0),(1,1,8,1,0),(1,1,9,1,0),(1,1,10,1,0),(1,2,1,1,0),(1,2,2,1,0),(1,2,3,1,0),(1,2,4,1,0),(1,2,5,1,0),(1,2,6,1,0),(1,2,7,1,0),(1,2,8,1,0),(1,2,9,1,0),(1,2,10,1,0),(2,1,1,0,0),(2,1,2,1,0),(2,1,3,1,0),(2,1,4,1,0),(2,1,5,1,0),(2,1,6,1,0),(2,1,7,1,0),(2,1,8,1,0),(2,1,9,1,0),(2,1,10,1,0),(2,2,1,1,0),(2,2,2,1,0),(2,2,3,1,0),(2,2,4,1,0),(2,2,5,1,0),(2,2,6,1,0),(2,2,7,1,0),(2,2,8,1,0),(2,2,9,1,0),(2,2,10,1,0),(3,1,1,1,0),(3,1,2,1,0),(3,1,3,1,0),(3,1,4,1,0),(3,1,5,1,0),(3,1,6,1,0),(3,1,7,1,0),(3,1,8,1,0),(3,1,9,1,0),(3,1,10,1,0),(3,2,1,1,0),(3,2,2,1,0),(3,2,3,1,0),(3,2,4,1,0),(3,2,5,1,0),(3,2,6,1,0),(3,2,7,1,0),(3,2,8,1,0),(3,2,9,1,0),(3,2,10,1,0),(4,1,1,1,0),(4,1,2,1,0),(4,1,3,1,0),(4,1,4,1,0),(4,1,5,1,0),(4,1,6,1,0),(4,1,7,1,0),(4,1,8,1,0),(4,1,9,1,0),(4,1,10,1,0),(4,2,1,1,0),(4,2,2,1,0),(4,2,3,1,0),(4,2,4,1,0),(4,2,5,1,0),(4,2,6,1,0),(4,2,7,1,0),(4,2,8,1,0),(4,2,9,1,0),(4,2,10,1,0),(5,1,1,1,0),(5,1,2,1,0),(5,1,3,1,0),(5,1,4,1,0),(5,1,5,1,0),(5,1,6,1,0),(5,1,7,1,0),(5,1,8,1,0),(5,1,9,1,0),(5,1,10,1,0),(5,2,1,1,0),(5,2,2,1,0),(5,2,3,1,0),(5,2,4,1,0),(5,2,5,1,0),(5,2,6,1,0),(5,2,7,1,0),(5,2,8,1,0),(5,2,9,1,0),(5,2,10,1,0),(6,1,1,1,0),(6,1,2,1,0),(6,1,3,1,0),(6,1,4,1,0),(6,1,5,1,0),(6,1,6,1,0),(6,1,7,1,0),(6,1,8,1,0),(6,1,9,1,0),(6,1,10,1,0),(6,2,1,1,0),(6,2,2,1,0),(6,2,3,1,0),(6,2,4,1,0),(6,2,5,1,0),(6,2,6,1,0),(6,2,7,1,0),(6,2,8,1,0),(6,2,9,1,0),(6,2,10,1,0),(7,1,1,1,0),(7,1,2,1,0),(7,1,3,1,0),(7,1,4,1,0),(7,1,5,1,0),(7,1,6,1,0),(7,1,7,1,0),(7,1,8,1,0),(7,1,9,1,0),(7,1,10,1,0),(7,2,1,1,0),(7,2,2,1,0),(7,2,3,1,0),(7,2,4,1,0),(7,2,5,1,0),(7,2,6,1,0),(7,2,7,1,0),(7,2,8,1,0),(7,2,9,1,0),(7,2,10,1,0),(8,1,1,1,0),(8,1,2,1,0),(8,1,3,1,0),(8,1,4,1,0),(8,1,5,1,0),(8,1,6,1,0),(8,1,7,1,0),(8,1,8,1,0),(8,1,9,1,0),(8,1,10,1,0),(8,2,1,1,0),(8,2,2,1,0),(8,2,3,1,0),(8,2,4,1,0),(8,2,5,1,0),(8,2,6,1,0),(8,2,7,1,0),(8,2,8,1,0),(8,2,9,1,0),(8,2,10,1,0),(9,1,1,1,0),(9,1,2,1,0),(9,1,3,1,0),(9,1,4,1,0),(9,1,5,1,0),(9,1,6,1,0),(9,1,7,1,0),(9,1,8,1,0),(9,1,9,1,0),(9,1,10,1,0),(9,2,1,1,0),(9,2,2,1,0),(9,2,3,1,0),(9,2,4,1,0),(9,2,5,1,0),(9,2,6,1,0),(9,2,7,1,0),(9,2,8,1,0),(9,2,9,1,0),(9,2,10,1,0),(10,1,1,1,0),(10,1,2,1,0),(10,1,3,1,0),(10,1,4,1,0),(10,1,5,1,0),(10,1,6,1,0),(10,1,7,1,0),(10,1,8,1,0),(10,1,9,1,0),(10,1,10,1,0),(10,2,1,1,0),(10,2,2,1,0),(10,2,3,1,0),(10,2,4,1,0),(10,2,5,1,0),(10,2,6,1,0),(10,2,7,1,0),(10,2,8,1,0),(10,2,9,1,0),(10,2,10,1,0);
/*!40000 ALTER TABLE `fw_slots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tw_slots`
--

DROP TABLE IF EXISTS `tw_slots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tw_slots` (
  `tw_slots_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `area_id` int(11) NOT NULL,
  `is_available` tinyint(4) NOT NULL DEFAULT '1',
  `reservation_time` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tw_slots_id`,`city_id`,`area_id`),
  KEY `city_id_fk_idx` (`city_id`),
  KEY `area_id_fk_idx` (`area_id`),
  CONSTRAINT `area_id_fk` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`),
  CONSTRAINT `city_id_fk1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tw_slots`
--

LOCK TABLES `tw_slots` WRITE;
/*!40000 ALTER TABLE `tw_slots` DISABLE KEYS */;
INSERT INTO `tw_slots` VALUES (1,1,1,0,0),(1,1,2,1,0),(1,1,3,1,0),(1,1,4,1,0),(1,1,5,1,0),(1,1,6,1,0),(1,1,7,1,0),(1,1,8,1,0),(1,1,9,1,0),(1,1,10,1,0),(1,2,1,1,0),(1,2,2,1,0),(1,2,3,1,0),(1,2,4,1,0),(1,2,5,1,0),(1,2,6,1,0),(1,2,7,1,0),(1,2,8,1,0),(1,2,9,1,0),(1,2,10,1,0),(2,1,1,1,0),(2,1,2,1,0),(2,1,3,1,0),(2,1,4,1,0),(2,1,5,1,0),(2,1,6,1,0),(2,1,7,1,0),(2,1,8,1,0),(2,1,9,1,0),(2,1,10,1,0),(2,2,1,1,0),(2,2,2,1,0),(2,2,3,1,0),(2,2,4,1,0),(2,2,5,1,0),(2,2,6,1,0),(2,2,7,1,0),(2,2,8,1,0),(2,2,9,1,0),(2,2,10,1,0),(3,1,1,0,0),(3,1,2,1,0),(3,1,3,1,0),(3,1,4,1,0),(3,1,5,1,0),(3,1,6,1,0),(3,1,7,1,0),(3,1,8,1,0),(3,1,9,1,0),(3,1,10,1,0),(3,2,1,1,0),(3,2,2,1,0),(3,2,3,1,0),(3,2,4,1,0),(3,2,5,1,0),(3,2,6,1,0),(3,2,7,1,0),(3,2,8,1,0),(3,2,9,1,0),(3,2,10,1,0),(4,1,1,1,0),(4,1,2,1,0),(4,1,3,1,0),(4,1,4,1,0),(4,1,5,1,0),(4,1,6,1,0),(4,1,7,1,0),(4,1,8,1,0),(4,1,9,1,0),(4,1,10,1,0),(4,2,1,1,0),(4,2,2,1,0),(4,2,3,1,0),(4,2,4,1,0),(4,2,5,1,0),(4,2,6,1,0),(4,2,7,1,0),(4,2,8,1,0),(4,2,9,1,0),(4,2,10,1,0),(5,1,1,1,0),(5,1,2,1,0),(5,1,3,1,0),(5,1,4,1,0),(5,1,5,1,0),(5,1,6,1,0),(5,1,7,1,0),(5,1,8,1,0),(5,1,9,1,0),(5,1,10,1,0),(5,2,1,1,0),(5,2,2,1,0),(5,2,3,1,0),(5,2,4,1,0),(5,2,5,1,0),(5,2,6,1,0),(5,2,7,1,0),(5,2,8,1,0),(5,2,9,1,0),(5,2,10,1,0),(6,1,1,1,0),(6,1,2,1,0),(6,1,3,1,0),(6,1,4,1,0),(6,1,5,1,0),(6,1,6,1,0),(6,1,7,1,0),(6,1,8,1,0),(6,1,9,1,0),(6,1,10,1,0),(6,2,1,1,0),(6,2,2,1,0),(6,2,3,1,0),(6,2,4,1,0),(6,2,5,1,0),(6,2,6,1,0),(6,2,7,1,0),(6,2,8,1,0),(6,2,9,1,0),(6,2,10,1,0),(7,1,1,1,0),(7,1,2,1,0),(7,1,3,1,0),(7,1,4,1,0),(7,1,5,1,0),(7,1,6,1,0),(7,1,7,1,0),(7,1,8,1,0),(7,1,9,1,0),(7,1,10,1,0),(7,2,1,1,0),(7,2,2,1,0),(7,2,3,1,0),(7,2,4,1,0),(7,2,5,1,0),(7,2,6,1,0),(7,2,7,1,0),(7,2,8,1,0),(7,2,9,1,0),(7,2,10,1,0),(8,1,1,1,0),(8,1,2,1,0),(8,1,3,1,0),(8,1,4,1,0),(8,1,5,1,0),(8,1,6,1,0),(8,1,7,1,0),(8,1,8,1,0),(8,1,9,1,0),(8,1,10,1,0),(8,2,1,1,0),(8,2,2,1,0),(8,2,3,1,0),(8,2,4,1,0),(8,2,5,1,0),(8,2,6,1,0),(8,2,7,1,0),(8,2,8,1,0),(8,2,9,1,0),(8,2,10,1,0),(9,1,1,1,0),(9,1,2,1,0),(9,1,3,1,0),(9,1,4,1,0),(9,1,5,1,0),(9,1,6,1,0),(9,1,7,1,0),(9,1,8,1,0),(9,1,9,1,0),(9,1,10,1,0),(9,2,1,1,0),(9,2,2,1,0),(9,2,3,1,0),(9,2,4,1,0),(9,2,5,1,0),(9,2,6,1,0),(9,2,7,1,0),(9,2,8,1,0),(9,2,9,1,0),(9,2,10,1,0),(10,1,1,1,0),(10,1,2,1,0),(10,1,3,1,0),(10,1,4,1,0),(10,1,5,1,0),(10,1,6,1,0),(10,1,7,1,0),(10,1,8,1,0),(10,1,9,1,0),(10,1,10,1,0),(10,2,1,1,0),(10,2,2,1,0),(10,2,3,1,0),(10,2,4,1,0),(10,2,5,1,0),(10,2,6,1,0),(10,2,7,1,0),(10,2,8,1,0),(10,2,9,1,0),(10,2,10,1,0);
/*!40000 ALTER TABLE `tw_slots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact_no` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `wallet_balance` float NOT NULL DEFAULT '500',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `contact_no_UNIQUE` (`contact_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'Test User','Test@123','test1@gmail.com','1234567890','Pune',500),(2,'User2','Test@123','test2@gmail.com','9876543210','Nashik',600);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-11 23:48:01
