-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.30 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database hairflow
DROP DATABASE IF EXISTS `hairflow`;
CREATE DATABASE IF NOT EXISTS `hairflow` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hairflow`;

-- Dump della struttura di tabella hairflow.admin
DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(55) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `grant_id` int DEFAULT NULL,
  `informazioni_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `grant_id` (`grant_id`),
  KEY `informazioni_id` (`informazioni_id`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`grant_id`) REFERENCES `grant` (`id`),
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`informazioni_id`) REFERENCES `informazioni_admin_utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella hairflow.admin: ~2 rows (circa)
REPLACE INTO `admin` (`id`, `email`, `password`, `grant_id`, `informazioni_id`) VALUES
	(1, 'm.petraccini@hotmail.com', 'password', 1, 1),
	(2, 'daniele.petrach@gmail.com', 'password', 1, 2);

-- Dump della struttura di tabella hairflow.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cognome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `data_nascita` date DEFAULT NULL,
  `provincia` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `numero_telefono` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sesso` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `data_ultima_visita` date DEFAULT NULL,
  `data_registrazione` timestamp NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grant_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `grant_id` (`grant_id`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`grant_id`) REFERENCES `grant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella hairflow.cliente: ~22 rows (circa)
REPLACE INTO `cliente` (`id`, `nome`, `cognome`, `data_nascita`, `provincia`, `email`, `numero_telefono`, `sesso`, `data_ultima_visita`, `data_registrazione`, `password`, `grant_id`) VALUES
	(1, 'Nicola', 'Rosa', '1985-05-14', 'Genova', 'nicola@email.com', '123456789', 'M', '2023-01-01', '2023-01-01 10:00:00', 'password', 3),
	(2, 'Valentina', 'Blu', '1992-02-28', 'Bari', 'valentina@email.com', '987654321', 'F', '2023-02-01', '2023-01-02 12:30:00', 'password', 3),
	(3, 'Gianluca', 'Gialli', '1988-04-10', 'Milano', 'gianluca@email.com', '555666777', 'M', '2023-04-01', '2023-01-03 08:45:00', 'password', 3),
	(4, 'Alessandra', 'Verdi', '1997-08-25', 'Palermo', 'alessandra@email.com', '333222111', 'F', '2023-06-01', '2023-01-04 06:30:00', 'password', 3),
	(5, 'Dario', 'Arancio', '1991-11-18', 'Napoli', 'dario@email.com', '777888999', 'M', '2023-03-15', '2023-01-05 13:15:00', 'password', 3),
	(6, 'Anna', 'Viola', '1995-07-08', 'Firenze', 'anna@email.com', '111222333', 'F', '2023-02-28', '2023-01-06 07:00:00', 'password', 3),
	(7, 'Davide', 'Marrone', '1989-02-10', 'Bologna', 'davide@email.com', '444555666', 'M', '2023-01-20', '2023-01-07 09:30:00', 'password', 3),
	(8, 'Sofia', 'Neri', '1986-03-03', 'Roma', 'sofia@email.com', '999000111', 'F', '2023-04-10', '2023-01-08 11:45:00', 'password', 3),
	(9, 'Ludovica', 'Bianchi', '1992-06-18', 'Torino', 'ludovica@email.com', '222333444', 'F', '2023-03-01', '2023-01-09 14:30:00', 'password', 3),
	(10, 'Matteo', 'Celeste', '1987-04-27', 'Ancona', 'matteo@email.com', '666777888', 'M', '2023-02-15', '2023-01-10 08:15:00', 'password', 3),
	(11, 'Elisabetta', 'Gialli', '1994-09-22', 'Catanzaro', 'elisabetta@email.com', '444333222', 'F', '2023-05-01', '2023-01-11 12:00:00', 'password', 3),
	(12, 'Lorenzo', 'Rosa', '1984-07-14', 'Genova', 'lorenzo@email.com', '123456789', 'M', '2023-01-01', '2023-01-12 09:45:00', 'password', 3),
	(13, 'Martina', 'Blu', '1991-02-28', 'Bari', 'martina@email.com', '987654321', 'F', '2023-02-01', '2023-01-13 13:30:00', 'password', 3),
	(14, 'Riccardo', 'Gialli', '1987-04-10', 'Milano', 'riccardo@email.com', '555666777', 'M', '2023-04-01', '2023-01-14 07:15:00', 'password', 3),
	(15, 'Camilla', 'Verdi', '1996-08-25', 'Palermo', 'camilla@email.com', '333222111', 'F', '2023-06-01', '2023-01-15 10:00:00', 'password', 3),
	(16, 'Gabriel', 'Arancio', '1990-11-18', 'Napoli', 'gabriel@email.com', '777888999', 'M', '2023-03-15', '2023-01-16 12:30:00', 'password', 3),
	(17, 'Aurora', 'Viola', '1994-07-08', 'Firenze', 'aurora@email.com', '111222333', 'F', '2023-02-28', '2023-01-17 08:45:00', 'password', 3),
	(18, 'Federico', 'Marrone', '1988-02-10', 'Bologna', 'federico@email.com', '444555666', 'M', '2023-01-20', '2023-01-18 06:30:00', 'password', 3),
	(19, 'Caterina', 'Neri', '1985-03-03', 'Roma', 'caterina@email.com', '999000111', 'F', '2023-04-10', '2023-01-19 13:15:00', 'password', 3),
	(20, 'Gabriella', 'Bianchi', '1991-06-18', 'Torino', 'gabriella@email.com', '222333444', 'F', '2023-03-01', '2023-01-20 07:00:00', 'password', 3),
	(21, 'Stefano', 'Celeste', '1986-04-27', 'Ancona', 'stefano@email.com', '666777888', 'M', '2023-02-15', '2023-01-21 09:30:00', 'password', 3),
	(22, 'Sara', 'Gialli', '1993-09-22', 'Catanzaro', 'sara@email.com', '444333222', 'F', '2023-05-01', '2023-01-22 11:45:00', 'password', 3);

-- Dump della struttura di tabella hairflow.grant
DROP TABLE IF EXISTS `grant`;
CREATE TABLE IF NOT EXISTS `grant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_grant` varchar(6) COLLATE utf8mb4_general_ci NOT NULL,
  `descrizione` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella hairflow.grant: ~3 rows (circa)
REPLACE INTO `grant` (`id`, `type_grant`, `descrizione`) VALUES
	(1, 'ADMIN', 'Gestore dell\'applicativo'),
	(2, 'USER', 'Proprietario salone'),
	(3, 'CLIENT', 'Cliente e utilizzatore');

-- Dump della struttura di tabella hairflow.informazioni_admin_utente
DROP TABLE IF EXISTS `informazioni_admin_utente`;
CREATE TABLE IF NOT EXISTS `informazioni_admin_utente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `cognome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `dataNascita` date DEFAULT NULL,
  `provincia` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sesso` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `codice_fiscale` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dataRegistrazione` timestamp NULL DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  `data_registrazione` datetime(6) DEFAULT NULL,
  `numero_telefono` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella hairflow.informazioni_admin_utente: ~3 rows (circa)
REPLACE INTO `informazioni_admin_utente` (`id`, `nome`, `cognome`, `dataNascita`, `provincia`, `sesso`, `codice_fiscale`, `dataRegistrazione`, `data_nascita`, `data_registrazione`, `numero_telefono`) VALUES
	(1, 'Marco', 'Petraccini', '1997-01-05', 'Roma', 'M', 'PTRMRC97A05H501K', '2024-01-12 13:33:38', NULL, NULL, NULL),
	(2, 'Daniele', 'Petraccini', '1985-05-20', 'Roma', 'M', 'PTRDNL95C23H501U', '2024-01-12 13:33:38', NULL, NULL, NULL),
	(3, 'Francesco', 'Coletti', '1982-06-08', 'L\'Aquila', 'M', 'FRNCTT82H08A345K', '2024-01-12 13:42:32', NULL, NULL, NULL);

-- Dump della struttura di tabella hairflow.utente
DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(55) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `grant_id` int DEFAULT NULL,
  `informazioni_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `grant_id` (`grant_id`),
  KEY `informazioni_id` (`informazioni_id`),
  CONSTRAINT `utente_ibfk_1` FOREIGN KEY (`grant_id`) REFERENCES `grant` (`id`),
  CONSTRAINT `utente_ibfk_2` FOREIGN KEY (`informazioni_id`) REFERENCES `informazioni_admin_utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella hairflow.utente: ~1 rows (circa)
REPLACE INTO `utente` (`id`, `email`, `password`, `grant_id`, `informazioni_id`) VALUES
	(1, 'example@example.com', 'password', 2, 3);

-- Dump della struttura di tabella hairflow.utente_cliente
DROP TABLE IF EXISTS `utente_cliente`;
CREATE TABLE IF NOT EXISTS `utente_cliente` (
  `cliente_id` int NOT NULL,
  `utente_id` int NOT NULL,
  PRIMARY KEY (`cliente_id`,`utente_id`),
  KEY `utente_id` (`utente_id`),
  CONSTRAINT `utente_cliente_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `utente_cliente_ibfk_2` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella hairflow.utente_cliente: ~0 rows (circa)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
