CREATE TABLE `users` (
	`user_id` BIGINT AUTO_INCREMENT,
	`date_of_birth` TIMESTAMP,
	`user_email` VARCHAR(255),
	`first_name` VARCHAR(255),
	`gender` VARCHAR(255),
	`last_name` VARCHAR(255),
	`password` VARCHAR(255),
	`user_type` INT,
	`address_id` BIGINT,
	PRIMARY KEY (`user_id`),
    CONSTRAINT address_fk FOREIGN KEY(`address_id`) REFERENCES addresses(`address_id`)
);