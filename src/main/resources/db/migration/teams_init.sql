DROP TABLE IF EXISTS teams;


CREATE TABLE teams (
--    auto_increment is with mysql and H2
    id INT PRIMARY KEY AUTO_INCREMENT,
    team_name VARCHAR NOT NULL,
    city_name VARCHAR NOT NULL
);