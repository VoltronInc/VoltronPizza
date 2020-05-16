-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: pizza
-- ------------------------------------------------------
-- Server version	5.6.47

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
-- Table structure for table `attribute`
--

DROP TABLE IF EXISTS `attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute` (
  `attribute_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `attribute_set_entity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`attribute_id`),
  KEY `FKgdp3haw6xacc9micyf3l4bc7e` (`attribute_set_entity_id`),
  CONSTRAINT `FKgdp3haw6xacc9micyf3l4bc7e` FOREIGN KEY (`attribute_set_entity_id`) REFERENCES `attribute_set` (`entity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute`
--

LOCK TABLES `attribute` WRITE;
/*!40000 ALTER TABLE `attribute` DISABLE KEYS */;
INSERT INTO `attribute` VALUES (1,'name',1),(2,'price',1),(3,'size',1),(4,'weight',1),(5,'ingridientsAmount',1);
/*!40000 ALTER TABLE `attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribute_set`
--

DROP TABLE IF EXISTS `attribute_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute_set` (
  `entity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`entity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_set`
--

LOCK TABLES `attribute_set` WRITE;
/*!40000 ALTER TABLE `attribute_set` DISABLE KEYS */;
INSERT INTO `attribute_set` VALUES (1,'ingridient');
/*!40000 ALTER TABLE `attribute_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingridient_group`
--

DROP TABLE IF EXISTS `ingridient_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingridient_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  `parent_group_group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `FKnwj14jnl9sadd0xt7v5py59sw` (`parent_group_group_id`),
  CONSTRAINT `FKnwj14jnl9sadd0xt7v5py59sw` FOREIGN KEY (`parent_group_group_id`) REFERENCES `ingridient_group` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingridient_group`
--

LOCK TABLES `ingridient_group` WRITE;
/*!40000 ALTER TABLE `ingridient_group` DISABLE KEYS */;
INSERT INTO `ingridient_group` VALUES (1,'base',NULL),(2,'fillings',NULL),(3,'sauces',NULL),(4,'additional',NULL),(5,'vegetables',2),(6,'meat',2),(7,'seafoods',2),(8,'cheeses',2),(9,'fruits',2),(10,'herbs',2),(11,'sauces',NULL),(12,'regularSauces',11),(13,'sweetSauces',11),(14,'additional',NULL),(15,'boards',14);
/*!40000 ALTER TABLE `ingridient_group` ENABLE KEYS */;
UNLOCK TABLES;mysql

--
-- Table structure for table `ingridient_value`
--

DROP TABLE IF EXISTS `ingridient_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingridient_value` (
  `value_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  `attribute_attribute_id` bigint(20) DEFAULT NULL,
  `ingridient_entity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`value_id`),
  KEY `FK1fkwy1v60e568rofit2tdonqs` (`attribute_attribute_id`),
  KEY `FKqrwh1vj5yy4u597fcrkjak72p` (`ingridient_entity_id`),
  CONSTRAINT `FK1fkwy1v60e568rofit2tdonqs` FOREIGN KEY (`attribute_attribute_id`) REFERENCES `attribute` (`attribute_id`),
  CONSTRAINT `FKqrwh1vj5yy4u597fcrkjak72p` FOREIGN KEY (`ingridient_entity_id`) REFERENCES `ingridients_entity` (`entity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingridient_value`
--

LOCK TABLES `ingridient_value` WRITE;
/*!40000 ALTER TABLE `ingridient_value` DISABLE KEYS */;
INSERT INTO `ingridient_value` VALUES (1,'thinDough',1,1),(2,'10, 20, 30',2,1),(3,'25, 30, 35',3,1),(4,'70, 85, 20',4,1),(5,'15, 20',5,1),(6,'regularDough',1,2),(7,'10',2,2),(8,'79, 85, 100',4,2),(9,'olives',1,3),(10,'7',2,3),(11,'25',4,3),(12,'mushrooms',1,4),(13,'7',2,4),(14,'25',4,4),(15,'tomato',1,5),(16,'7',2,5),(17,'25',4,5),(18,'pepper',1,6),(19,'7',2,6),(20,'25',4,6),(21,'onion',1,7),(22,'7',2,7),(23,'25',4,7),(24,'hen',1,8),(25,'10',2,8),(26,'25',4,8),(27,'beef',1,9),(28,'10',2,9),(29,'25',4,9),(30,'salami',1,10),(31,'10',2,10),(32,'25',4,10),(33,'huntingSausages',1,11),(34,'10',2,11),(35,'25',4,11),(36,'bacon',1,12),(37,'10',2,12),(38,'25',4,12),(54,'anchovies',1,18),(55,'25',4,18),(56,'mussels',1,19),(57,'10',2,19),(58,'10',2,18),(59,'25',4,19),(60,'shrimp',1,20),(61,'10',2,20),(62,'25',4,20),(63,'squid',1,21),(64,'10',2,21),(65,'25',4,21),(66,'salmon',1,22),(67,'10',2,22),(68,'25',4,22),(69,'mozzarella',1,23),(70,'10',2,23),(71,'25',4,23),(72,'brie',1,24),(73,'10',2,24),(74,'25',4,24),(75,'parmesan',1,25),(76,'10',2,25),(77,'25',4,25),(78,'cheder',1,26),(79,'10',2,26),(80,'25',4,26),(81,'mazdam',1,27),(82,'10',2,27),(83,'25',4,27),(84,'pear',1,28),(85,'10',2,28),(86,'25',4,28),(87,'orange',1,29),(88,'10',2,29),(89,'25',4,29),(90,'pumpkin',1,30),(91,'10',2,30),(92,'25',4,30),(93,'cannedPeach',1,31),(94,'10',2,31),(95,'25',4,31),(96,'cannedPineapple',1,32),(97,'10',2,32),(98,'25',4,32),(99,'spinach',1,33),(100,'5',2,33),(101,'10',4,33),(102,'arugula',1,34),(103,'10',2,34),(104,'25',4,34),(105,'basil',1,35),(106,'10',2,35),(107,'25',4,35),(108,'cilantro',1,36),(109,'10',2,36),(110,'25',4,36),(111,'ketchup',1,38),(112,'5',2,38),(113,'10',4,38),(114,'BBQ',1,39),(115,'5',2,39),(116,'10',4,39),(117,'pesto',1,40),(118,'5',2,40),(119,'10',4,40),(120,'garlicSouce',1,41),(121,'5',2,41),(122,'10',4,41),(123,'tartarus',1,42),(124,'5',2,42),(125,'10',4,42),(126,'orangeSauce',1,43),(127,'5',2,43),(128,'10',4,43),(129,'sweetChili',1,44),(130,'5',2,44),(131,'10',4,44),(132,'philadelphiaBoard',1,45),(133,'5',2,45),(134,'10',4,45),(135,'sausageBoard',1,46),(136,'5',2,46),(137,'10',4,46);
/*!40000 ALTER TABLE `ingridient_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingridients_entity`
--

DROP TABLE IF EXISTS `ingridients_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingridients_entity` (
  `entity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_set_entity_id` bigint(20) DEFAULT NULL,
  `ingridient_group_group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`entity_id`),
  KEY `FKi4cgis3cuuvjocemq94wvg6pi` (`attribute_set_entity_id`),
  KEY `FKm2xvcnvx4393nx93119kdr934` (`ingridient_group_group_id`),
  CONSTRAINT `FKi4cgis3cuuvjocemq94wvg6pi` FOREIGN KEY (`attribute_set_entity_id`) REFERENCES `attribute_set` (`entity_id`),
  CONSTRAINT `FKm2xvcnvx4393nx93119kdr934` FOREIGN KEY (`ingridient_group_group_id`) REFERENCES `ingridient_group` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingridients_entity`
--

LOCK TABLES `ingridients_entity` WRITE;
/*!40000 ALTER TABLE `ingridients_entity` DISABLE KEYS */;
INSERT INTO `ingridients_entity` VALUES (1,1,1),(2,1,1),(3,1,5),(4,1,5),(5,1,5),(6,1,5),(7,1,5),(8,1,6),(9,1,6),(10,1,6),(11,1,6),(12,1,6),(18,1,7),(19,1,7),(20,1,7),(21,1,7),(22,1,7),(23,1,8),(24,1,8),(25,1,8),(26,1,8),(27,1,8),(28,1,9),(29,1,9),(30,1,9),(31,1,9),(32,1,9),(33,1,10),(34,1,10),(35,1,10),(36,1,10),(38,1,12),(39,1,12),(40,1,12),(41,1,12),(42,1,12),(43,1,13),(44,1,13),(45,1,15),(46,1,15);
/*!40000 ALTER TABLE `ingridients_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_entity`
--

DROP TABLE IF EXISTS `pizza_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_entity` (
  `entity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_set_id` int(11) NOT NULL,
  PRIMARY KEY (`entity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_entity`
--

LOCK TABLES `pizza_entity` WRITE;
/*!40000 ALTER TABLE `pizza_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `pizza_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-25 16:13:36
