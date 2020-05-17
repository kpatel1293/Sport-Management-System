CREATE TABLE managers (
  manager_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id bigint,
  team_name VARCHAR(255),
  CONSTRAINT manager_user_fk FOREIGN KEY(`user_id`) REFERENCES users(`user_id`),
  CONSTRAINT team_manager_fk FOREIGN KEY(`team_name`) REFERENCES teams(`team_name`)
);