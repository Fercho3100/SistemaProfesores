/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.21 : Database - profesores
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`profesores` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `profesores`;

/*Table structure for table `curso` */

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `idCURSO` int NOT NULL AUTO_INCREMENT,
  `idCARRERA` int NOT NULL,
  `NOMBRE_CURSO` varchar(90) NOT NULL,
  `DURACION_CURSO` varchar(20) NOT NULL,
  `DESCRIPCION_CURSO` varchar(90) NOT NULL,
  PRIMARY KEY (`idCURSO`),
  KEY `idCARRERA` (`idCARRERA`),
  CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`idCARRERA`) REFERENCES `carrera` (`idCARRERA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `curso` */

/*Table structure for table `estudiante` */

DROP TABLE IF EXISTS `estudiante`;

CREATE TABLE `estudiante` (
  `id_estudiante` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `contrasena` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `desc_estudiante` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nombre_carrera` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `identificacion` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_estudiante`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `estudiante` */

insert  into `estudiante`(`id_estudiante`,`nombre`,`email`,`fecha_nacimiento`,`contrasena`,`desc_estudiante`,`nombre_carrera`,`identificacion`) values (1,'fernando aguilar madriz','a@a.com','2021-04-01','123','123','Ing Sistemase','123123'),(2,'sdf','sdf','2020-01-10','12','12','12','12');

/*Table structure for table `profesores` */

DROP TABLE IF EXISTS `profesores`;

CREATE TABLE `profesores` (
  `id_profesor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `identificacion` varchar(15) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `email` varchar(150) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

/*Data for the table `profesores` */

insert  into `profesores`(`id_profesor`,`nombre`,`identificacion`,`email`,`estado`) values (2,'xc','zxczxc','zxc',1),(3,'asd','asd','asd',0),(4,'asd','asd','asd',0),(5,'wdf','sdf','sdfs',0),(6,'qdd','qwd','dsa',0);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `pwUsuario` varchar(100) DEFAULT NULL,
  `nombreUsuario` varchar(100) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`idUsuario`,`pwUsuario`,`nombreUsuario`,`idrol`) values (1,123,'123','fer',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
