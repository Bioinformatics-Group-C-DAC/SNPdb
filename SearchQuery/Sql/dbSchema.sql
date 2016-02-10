-- MySQL dump 10.13  Distrib 5.1.61, for redhat-linux-gnu (x86_64)
--
-- Host: localhost    Database: PirbrightNew
-- ------------------------------------------------------
-- Server version	5.1.61

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
-- Table structure for table `ChickenLine_Chromosome_Info`
--

DROP TABLE IF EXISTS `ChickenLine_Chromosome_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ChickenLine_Chromosome_Info` (
  `Chromosome_ID` int(2) NOT NULL AUTO_INCREMENT,
  `Chromosome` char(5) NOT NULL,
  PRIMARY KEY (`Chromosome_ID`),
  UNIQUE KEY `Chromosome` (`Chromosome`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ChickenLine_Chromosome_Info`
--

LOCK TABLES `ChickenLine_Chromosome_Info` WRITE;
/*!40000 ALTER TABLE `ChickenLine_Chromosome_Info` DISABLE KEYS */;
INSERT INTO `ChickenLine_Chromosome_Info` VALUES (1,'1'),(2,'10'),(3,'11'),(4,'12'),(5,'13'),(6,'14'),(7,'15'),(8,'16'),(9,'17'),(10,'18'),(11,'19'),(12,'2'),(13,'20'),(14,'21'),(15,'22'),(16,'23'),(17,'24'),(18,'25'),(19,'26'),(20,'27'),(21,'28'),(22,'3'),(23,'32'),(24,'4'),(25,'5'),(26,'6'),(27,'7'),(28,'8'),(29,'9'),(30,'mt'),(31,'W'),(32,'Z');
/*!40000 ALTER TABLE `ChickenLine_Chromosome_Info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ChickenLine_Info`
--

DROP TABLE IF EXISTS `ChickenLine_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ChickenLine_Info` (
  `ChickenLine_ID` int(2) NOT NULL AUTO_INCREMENT,
  `ChickenLine_Name` char(15) NOT NULL,
  PRIMARY KEY (`ChickenLine_ID`),
  UNIQUE KEY `ChickenLine_ID` (`ChickenLine_ID`),
  UNIQUE KEY `ChickenLine_Name` (`ChickenLine_Name`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ChickenLine_Info`
--

LOCK TABLES `ChickenLine_Info` WRITE;
/*!40000 ALTER TABLE `ChickenLine_Info` DISABLE KEYS */;
INSERT INTO `ChickenLine_Info` VALUES (1,'Line15'),(2,'Line6'),(3,'Line7'),(4,'LineC'),(5,'LineN'),(6,'LineP'),(7,'LineWellcome'),(8,'LineZero'),(9,'m1'),(10,'m2'),(11,'m3'),(12,'m4');
/*!40000 ALTER TABLE `ChickenLine_Info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Common_ChickenLines`
--

DROP TABLE IF EXISTS `Common_ChickenLines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Common_ChickenLines` (
  `Record_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ChickenLine_ID` int(2) NOT NULL,
  `Chromosome_ID` int(2) NOT NULL,
  `Chromosome_Position` int(11) NOT NULL,
  `Ref` char(1) NOT NULL,
  `ALT` char(1) NOT NULL,
  `Ensemble_ID` varchar(25) NOT NULL,
  PRIMARY KEY (`Record_ID`),
  KEY `ChickenLine_ID` (`ChickenLine_ID`),
  KEY `Chromosome_ID` (`Chromosome_ID`),
  KEY `index_CommonChickenLines` (`Record_ID`,`ChickenLine_ID`,`Chromosome_ID`,`Chromosome_Position`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Common_ChickenLines`
--

LOCK TABLES `Common_ChickenLines` WRITE;
/*!40000 ALTER TABLE `Common_ChickenLines` DISABLE KEYS */;
INSERT INTO `Common_ChickenLines` VALUES (1,12,1,2,'C','T',''),(2,12,1,4,'T','C',''),(3,12,1,6,'C','A',''),(4,11,1,2,'C','T',''),(5,11,1,4,'T','C',''),(6,11,1,8,'T','G',''),(7,9,1,2,'C','A',''),(8,9,1,6,'C','G',''),(9,9,1,8,'T','A',''),(10,10,1,2,'C','A',''),(11,10,1,4,'T','C',''),(12,10,1,6,'C','G',''),(13,10,1,8,'T','C','');
/*!40000 ALTER TABLE `Common_ChickenLines` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-10 10:49:06
