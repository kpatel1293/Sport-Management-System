DROP TABLE IF EXISTS players;


CREATE TABLE players (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) ,
  last_name VARCHAR(250) ,
  age INT(3) DEFAULT NULL,
  manager_id INT (4),
 FOREIGN KEY (manager_id) REFERENCES managers(id)
);

 
INSERT INTO players (first, last_name, age) VALUES
  ('Ali', 'Dan', '22'),
  ('fill', 'Nates', '19'),
  ('Fol', 'kija', '23');





