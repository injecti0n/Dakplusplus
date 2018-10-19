-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: dakDB
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `idemployees` bigint(15) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `birthDay` datetime NOT NULL,
  `idcontract` int(11) DEFAULT NULL,
  PRIMARY KEY (`idemployees`,`lastName`,`firstName`,`birthDay`),
  UNIQUE KEY `idemployees_UNIQUE` (`idemployees`)
) ENGINE=InnoDB AUTO_INCREMENT=1990937850357 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (88484844,'Phiber','Optik','1994-01-04 21:00:00',NULL),(129193412,'Haci','Bekir','1990-01-04 21:00:00',NULL),(232323233,'Tarek','Abaza','1990-01-04 21:00:00',NULL),(345345345,'Jamie','Jamie','1990-01-04 21:00:00',NULL),(434343434,'Nathalie','Nathalie','1990-01-04 21:00:00',NULL),(434343435,'Umut','Basal','2018-10-02 00:00:00',NULL),(434343436,'Umut','Basal','2002-10-09 00:00:00',NULL),(434343437,'Barrack','Obama','2018-10-01 00:00:00',NULL),(434343438,'Donald','Trump','2018-10-10 00:00:00',NULL),(434343439,'Phiber','Optik','1994-01-04 00:00:00',NULL),(434343440,'Testasd','testad','2018-10-24 00:00:00',NULL),(434343441,'Abuzittin','Canyakmaz','2018-10-05 00:00:00',NULL),(434343442,'asdasdad','asdasdasdasd','2018-10-03 00:00:00',NULL),(434343443,'testasda','aasaa','2018-10-03 00:00:00',NULL),(1990081721558,'Umut','Basal','2018-10-02 00:00:00',NULL),(1990127495590,'sadasd','asdasdasd','2018-10-02 00:00:00',NULL),(1990227843816,'asdasdasdasa','sdasdasdasd','2018-10-04 00:00:00',NULL),(1990237351064,'Jamie','Jamie','1990-01-04 00:00:00',NULL),(1990375688717,'Haci','Bekir','1990-01-04 00:00:00',NULL),(1990467458729,'asdasdas','dasdasdasd','2018-10-03 00:00:00',NULL),(1990469310096,'Nathalie','Nathalie','1990-01-04 00:00:00',NULL),(1990500456506,'Tarek','Abaza','1990-01-04 00:00:00',NULL),(1990634112656,'Jamie','Jamie','1990-01-04 00:00:00',NULL),(1990775763151,'asdasdasd','asdasdasdasdasd','2018-10-03 00:00:00',NULL),(1990793570187,'Jamie','Jamie','1990-01-04 00:00:00',NULL),(1990801858061,'Tarek','Abaza','1990-01-04 00:00:00',1),(1990937850356,'Tarek','Abaza','1990-01-04 00:00:00',NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-19 16:01:05
