-- hairflow.utente_cliente definition

CREATE TABLE `utente_cliente` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `utente_id` int NOT NULL,
                                  `cliente_id` int NOT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `UK_utente_cliente` (`utente_id`,`cliente_id`),
                                  KEY `FK_utente_id` (`utente_id`),
                                  KEY `FK_cliente_id` (`cliente_id`),
                                  CONSTRAINT `FK_cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE CASCADE,
                                  CONSTRAINT `FK_utente_id` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;