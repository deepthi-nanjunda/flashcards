-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: flash_card
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards` (
  `cardno` int NOT NULL AUTO_INCREMENT,
  `type` varchar(40) DEFAULT NULL,
  `word` text,
  `meaning` text,
  PRIMARY KEY (`cardno`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (1,'emotions','admiration','the feeling of admiring someone or something:'),(2,'emotions','adoration','very strong love or worship for someone'),(3,'emotions','appreciation','the act of recognizing or understanding that something is valuable, important, or as described'),(4,'emotions','amusement','the feeling of being entertained or made to laugh'),(5,'emotions','anger','a strong feeling that makes you want to hurt someone or be unpleasant because of something unfair or unkind that has happened'),(6,'emotions','anxiety','an uncomfortable feeling of nervousness or worry about something that is happening or might happen in the future'),(7,'emotions','awe','a feeling of great respect sometimes mixed with fear or surprise'),(8,'emotions','awkwardness','embarrassment, or a situation that is difficult and not relaxed'),(9,'emotions','boredom','the state of being bored, feeling unhappy because something is not interesting or because you have nothing to do'),(10,'emotions','calmness','the quality of being peaceful, quiet, and without worry'),(11,'emotions','confusion','a situation in which people do not understand what is happening, what they should do or who someone or something is'),(12,'emotions','craving','a strong feeling of wanting something'),(13,'emotions','disgust','a strong feeling of disapproval and dislike at a situation'),(14,'emotions','entrancement','a feeling of delight at being filled with wonder and enchantment'),(15,'emotions','excitement','a feeling of being excited, or an exciting event'),(16,'emotions','fear','An unpleasant feeling triggered by the perception of danger, real or imagined.'),(17,'emotions','horror','an extremely strong feeling of fear and shock'),(18,'statesandcapitals','Arunachal Pradesh','Itanagar'),(19,'statesandcapitals','Assam','Dispur'),(20,'statesandcapitals','Bihar','Patna'),(21,'statesandcapitals','Chhattisgarh','Raipur'),(22,'statesandcapitals','Goa','Panaji'),(23,'statesandcapitals','Gujarat','GandhiNagar'),(24,'statesandcapitals','Haryana','Chandigarh'),(25,'statesandcapitals','Himachal Pradesh','Simla'),(26,'idioms','once in a blue moon','an event that happens infrequently'),(27,'idioms','The best of both worlds','means you can enjoy two different opportunities at the same time'),(28,'idioms','Speak of the devil','this means that the person you’re just talking about actually appears at that moment'),(29,'idioms','See eye to eye','this means agreeing with someone'),(30,'idioms','To feel under the weather','to not feel well'),(31,'idioms','To kill two birds with one stone','to solve two problems at once'),(32,'idioms','To add insult to injury','to make a situation worse'),(47,'idioms','A dime a dozen','A dime a dozen'),(48,'idioms','Cut somebody some slack','Don\'t be so critical'),(49,'idioms','Go back to the drawing board','Start over'),(50,'idioms','Let someone off the hook','To not hold someone responsible for something'),(51,'statesandcapitals','Jharkhand','Ranchi'),(52,'statesandcapitals','Karnataka','Bengaluru'),(53,'statesandcapitals','Kerala','Thiruvananthapuram'),(54,'statesandcapitals','Meghalaya','Shillong'),(55,'statesandcapitals','Tamil Nadu','Chennai'),(56,'Periodic Table','H','hydrogen'),(57,'Periodic Table','He','helium'),(58,'Periodic Table','Li','lithium'),(59,'Periodic Table','B','boron'),(60,'Periodic Table','C','carbon'),(61,'Periodic Table','O','oxygen'),(62,'Periodic Table','N','nitrogen'),(63,'Periodic Table','F','fluorine'),(64,'Periodic Table','Ne','neon');
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 17:23:09
