
CREATE TABLE `email` (
  `email_id` int NOT NULL AUTO_INCREMENT,
  `version` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email_id`));

CREATE TABLE `phone` (
  `phone_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `version` int NOT NULL,
  `number` varchar(255) DEFAULT NULL);

CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `version` int NOT NULL,
  `name` varchar(255) DEFAULT NULL);
 
CREATE TABLE `author` (
  `author_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `version` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `FK_Author_Email` int DEFAULT NULL,
  `FK_Author_Phone` int DEFAULT NULL,
  UNIQUE KEY (`FK_Author_Email`),
  UNIQUE KEY (`FK_Author_Phone`),
  FOREIGN KEY (`FK_Author_Email`) REFERENCES `email` (`email_id`),
  FOREIGN KEY (`FK_Author_Phone`) REFERENCES `phone` (`phone_id`));

CREATE TABLE `ad` (
  `ad_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `version` int NOT NULL,
  `cost_service` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `FK_Ad_Author` int DEFAULT NULL,
  `FK_Ad_Category` int DEFAULT NULL,
  KEY (`FK_Ad_Author`),
  KEY (`FK_Ad_Category`),
  FOREIGN KEY (`FK_Ad_Author`) REFERENCES `author` (`author_id`),
  FOREIGN KEY (`FK_Ad_Category`) REFERENCES `category` (`category_id`));
  
CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `version` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `FK_Address_Author` int DEFAULT NULL,
  UNIQUE KEY (`FK_Address_Author`),
  FOREIGN KEY (`FK_Address_Author`) REFERENCES `author` (`author_id`));

CREATE TABLE `matchingad` (
  `matching_ad_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `price_from` double DEFAULT NULL,
  `price_to` double DEFAULT NULL,
  `version` int NOT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  `FK_Matching_Ad_Author` int DEFAULT NULL,
  `FK_Matching_Ad_Category` int DEFAULT NULL,
  KEY (`FK_Matching_Ad_Author`),
  KEY (`FK_Matching_Ad_Category`),
  CONSTRAINT FOREIGN KEY (`FK_Matching_Ad_Category`) REFERENCES `category` (`category_id`),
  CONSTRAINT FOREIGN KEY (`FK_Matching_Ad_Author`) REFERENCES `author` (`author_id`));