USE `PirbrightNew`;
-- MySQL dump 10.13  Distrib 5.5.47, for debian-linux-gnu (i686)
--
-- Host: bioblaze2    Database: PirbrightNew
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
CREATE TABLE `ChickenLine_Chromosome_Info` (`Chromosome_ID` int(2) NOT NULL AUTO_INCREMENT,`Chromosome` char(5) NOT NULL,PRIMARY KEY (`Chromosome_ID`),UNIQUE KEY `Chromosome` (`Chromosome`)) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Common_ChikenLines`
--

DROP TABLE IF EXISTS `Common_ChickenLines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Common_ChickenLines` (`Record_ID` int(11) NOT NULL AUTO_INCREMENT,`ChickenLine_ID` int(2) NOT NULL,`Chromosome_ID` int(2) NOT NULL,`Chromosome_Position` int(11) NOT NULL,`Ref` char(1) NOT NULL,`ALT` char(1) NOT NULL,`Ensemble_ID` varchar(25) NOT NULL,PRIMARY KEY (`Record_ID`),KEY `ChickenLine_ID` (`ChickenLine_ID`),KEY `Chromosome_ID` (`Chromosome_ID`),KEY `index_CommonChickenLines` (`Record_ID`,`ChickenLine_ID`,`Chromosome_ID`,`Chromosome_Position`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ChikenLine_Info`
--

DROP TABLE IF EXISTS `ChickenLine_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ChickenLine_Info` (`ChickenLine_ID` int(2) NOT NULL AUTO_INCREMENT,`ChickenLine_Name` char(15) NOT NULL,PRIMARY KEY (`ChickenLine_ID`),UNIQUE KEY `ChickenLine_ID` (`ChickenLine_ID`),UNIQUE KEY `ChickenLine_Name` (`ChickenLine_Name`)) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-05  5:23:47