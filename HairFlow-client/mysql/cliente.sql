CREATE TABLE `cliente` (
	`id_cliente` INT(10) NOT NULL,
	`nome` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`cognome` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`data_nascita` DATE NULL DEFAULT NULL,
	`provincia` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`email` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`numero_telefono` VARCHAR(15) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`sesso` CHAR(1) NOT NULL COLLATE 'utf8mb4_general_ci',
	`data_ultima_visita` DATE NULL DEFAULT NULL,
	`data_registrazione` DATE NOT NULL,
	PRIMARY KEY (`id_cliente`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
