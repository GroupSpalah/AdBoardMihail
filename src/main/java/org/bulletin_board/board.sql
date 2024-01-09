-- board.category definition
-- board.phone definition
-- board.email definition
-- board.address definition

CREATE TABLE `address` (
  `FK_Address_Author` int DEFAULT NULL,
  `address_id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `UK_2wlfjc5j19o2t0rj4kgtwoadq` (`FK_Address_Author`),
  CONSTRAINT `FK6o3psxc02blsvg7j5vr5mh672` FOREIGN KEY (`FK_Address_Author`) REFERENCES `author` (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `email` (
  `email_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `phone` (
  `phone_id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`phone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ad` (
  `FK_Ad_Category` int DEFAULT NULL,
  `ad_id` int NOT NULL AUTO_INCREMENT,
  `costService` int NOT NULL,
  `date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ad_id`),
  KEY `FKp5fb74lrnj4o0pk5o1aec6pry` (`FK_Ad_Category`),
  CONSTRAINT `FKp5fb74lrnj4o0pk5o1aec6pry` FOREIGN KEY (`FK_Ad_Category`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- board.author definition

CREATE TABLE `author` (
  `FK_Author_Ad` int DEFAULT NULL,
  `FK_Author_Email` int DEFAULT NULL,
  `FK_Author_Phone` int DEFAULT NULL,
  `author_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`author_id`),
  UNIQUE KEY `UK_2v1bv9deqgeck03fa6ows5q6n` (`FK_Author_Email`),
  UNIQUE KEY `UK_32qgklffa7bydnakt4cgubpa6` (`FK_Author_Phone`),
  KEY `FKbip69ev4ufvjy1igkm30p3y2x` (`FK_Author_Ad`),
  CONSTRAINT `FKbip69ev4ufvjy1igkm30p3y2x` FOREIGN KEY (`FK_Author_Ad`) REFERENCES `ad` (`ad_id`),
  CONSTRAINT `FKik1xh87w89eoni7wlo3afbn2v` FOREIGN KEY (`FK_Author_Email`) REFERENCES `email` (`email_id`),
  CONSTRAINT `FKno1oqpow7pfhmfsurfi3nex8w` FOREIGN KEY (`FK_Author_Phone`) REFERENCES `phone` (`phone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

