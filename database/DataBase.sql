DROP SCHEMA IF EXISTS `blog`;

CREATE SCHEMA `blog`;

use `blog`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` 	 varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USERNAME_UNIQUE` (`username`),
  UNIQUE KEY `EMAIL_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `article_body` varchar(128) DEFAULT NULL,
  `like` 	int(11) DEFAULT 0 ,
  `dislike` int(11) DEFAULT 0 ,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  
  KEY `FK_USER_idx` (`user_id`),
  
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(256) DEFAULT NULL,
  `like` 	int(11) DEFAULT 0 ,
  `dislike` int(11) DEFAULT 0 ,
  `article_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_ARTICLE_ID_idx` (`article_id`),

  CONSTRAINT `FK_ARTICLE` FOREIGN KEY (`article_id`) 
  REFERENCES `article` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_USER_COMMENT` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_UNIQUE` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `article_categories`;
CREATE TABLE `article_categories` (
  `article_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  
  PRIMARY KEY (`article_id`,`category_id`),
  
  KEY `FK_Category_idx` (`category_id`),
  
  CONSTRAINT `FK_article_id` FOREIGN KEY (`article_id`) 
  REFERENCES `article` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_category_id` FOREIGN KEY (`category_id`) 
  REFERENCES `categories` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authority_UNIQUE` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  
  PRIMARY KEY (`username`,`authority` , `user_id` , `roles_id`),
  
  KEY `FK_authority` (`authority`),
  
  CONSTRAINT `FK_username_auth` FOREIGN KEY (`username`) 
  REFERENCES `users` (`username`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_authority` FOREIGN KEY (`authority`) 
  REFERENCES `roles` (`authority`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_userId_auth` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_rolesId` FOREIGN KEY (`roles_id`) 
  REFERENCES `roles` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
