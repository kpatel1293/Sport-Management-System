DROP TABLE IF EXISTS `game_schedule`;

CREATE TABLE IF NOT EXISTS `game_schedule` (
	`game_id` BIGINT AUTO_INCREMENT,
	`home_team` VARCHAR(255),
	`away_team` VARCHAR(255),
    `game_date` TIMESTAMP,
	`season` VARCHAR(255),

	primary key (`game_id`)
);