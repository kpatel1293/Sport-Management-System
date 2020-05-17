DROP TABLE IF EXISTS injuries;
DROP TABLE IF EXISTS `players`;
DROP TABLE IF EXISTS `managers`;
DROP TABLE IF EXISTS `teams`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `addresses`;

CREATE TABLE IF NOT EXISTS `addresses` (
	`address_id` BIGINT AUTO_INCREMENT,
	`city` VARCHAR(255),
	`state` VARCHAR(255),
	`street_main` VARCHAR(255),
	`street_opt` VARCHAR(255),
	`zipcode` VARCHAR(255),
	primary key (`address_id`)
);