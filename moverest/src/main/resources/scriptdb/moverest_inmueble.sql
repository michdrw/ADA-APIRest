-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: moverest
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
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmueble` (
  `inmueble_id` int(11) NOT NULL AUTO_INCREMENT,
  `ubicacion` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `ambiente` int(11) NOT NULL,
  `superficie` double NOT NULL,
  `precio` double NOT NULL,
  `moneda` varchar(45) NOT NULL,
  `tipo_inmueble` varchar(45) NOT NULL,
  `amenity` varchar(100) DEFAULT NULL,
  `instalacion` varchar(100) DEFAULT NULL,
  `locador_id` int(11) NOT NULL,
  `estado` varchar(100) NOT NULL,
  PRIMARY KEY (`inmueble_id`),
  UNIQUE KEY `inmueble_id_UNIQUE` (`inmueble_id`),
  KEY `inmueble_locador_FK_idx` (`locador_id`),
  CONSTRAINT `inmueble_locador_FK` FOREIGN KEY (`locador_id`) REFERENCES `locador` (`locador_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` VALUES (1,'Springfield','Calle Falsa 1234',2,23456,110000,'USD','Departamento','Ninguna','Agua, luz, gas, Electricidad, Internet',1,'ahi anda'),(2,'Sydney','Calle Wallaby 42',2,2500,130000,'USD','Departamento','Ninguna','Agua, luz, gas, Electricidad, Internet',1,'disponible'),(3,'Disney','Tower of Terror',1,5390,6000,'USD','Departamento','Ascensor','Agua, luz, gas, Electricidad, Internet',1,'disponible'),(4,'Disney','Haunted Mansion',7,9390,6000,'USD','Departamento','Cementery','Agua, luz, gas, Electricidad, Internet, Fantasmas',1,'arrendado');
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-22 11:24:16
