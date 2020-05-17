CREATE TABLE players (
	player_id INT AUTO_INCREMENT PRIMARY KEY,
	user_id bigint,
	team_name VARCHAR(255),
    manager_id bigint,
	active_player boolean,
	CONSTRAINT player_user_fk FOREIGN KEY(`user_id`) REFERENCES users(`user_id`),
	CONSTRAINT team_player_fk FOREIGN KEY(`team_name`) REFERENCES teams(`team_name`),
	CONSTRAINT manager_player_fk FOREIGN KEY(`manager_id`) REFERENCES managers(`manager_id`)
);