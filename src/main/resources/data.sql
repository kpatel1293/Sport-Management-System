DROP TABLE IF EXISTS players;
DROP TABLE IF EXISTS managers;


CREATE TABLE managers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) ,
  last_name VARCHAR(250) ,
  team VARCHAR(250) DEFAULT NULL
);

CREATE TABLE players (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) ,
  last_name VARCHAR(250) ,
  age INT(3) DEFAULT NULL,
  manager_id INT (4),
 FOREIGN KEY (manager_id) REFERENCES managers(id)
);

 
INSERT INTO players (first_name, last_name, age) VALUES
  ('Ali', 'Dan', '22', '1'),
  ('fill', 'Nates', '19','1'),
  ('Fol', 'kija', '23','2');




INSERT INTO managers (first_name, last_name, team) VALUES
  ('Aliko', 'Dangote', 'bulls'),
  ('Bill', 'Gates', 'Nicks'),
  ('Folrunsho', 'Alakija', 'Lakers');



