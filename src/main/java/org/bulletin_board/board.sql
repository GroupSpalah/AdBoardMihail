
CREATE TABLE `email` (
  `email_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email_id`));

CREATE TABLE `phone` (
  `phone_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `number` varchar(255) DEFAULT NULL);

CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) DEFAULT NULL);

CREATE TABLE `ad` (
  `FK_Ad_Category` int DEFAULT NULL,
  `ad_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `cost_service` int NOT NULL,
  `date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  KEY (`FK_Ad_Category`),
  FOREIGN KEY (`FK_Ad_Category`) REFERENCES `category` (`category_id`));

CREATE TABLE `author` (
  `FK_Author_Ad` int DEFAULT NULL,
  `FK_Author_Email` int DEFAULT NULL,
  `FK_Author_Phone` int DEFAULT NULL,
  `author_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) DEFAULT NULL,
  UNIQUE KEY (`FK_Author_Email`),
  UNIQUE KEY (`FK_Author_Phone`),
  KEY (`FK_Author_Ad`),
  FOREIGN KEY (`FK_Author_Ad`) REFERENCES `ad` (`ad_id`),
  FOREIGN KEY (`FK_Author_Email`) REFERENCES `email` (`email_id`),
  FOREIGN KEY (`FK_Author_Phone`) REFERENCES `phone` ( `phone_id`));
  
CREATE TABLE `address` (
  `FK_Address_Author` int DEFAULT NULL ,
  `address_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  UNIQUE KEY (`FK_Address_Author`),
  FOREIGN KEY (`FK_Address_Author`) REFERENCES `author` (`author_id`));