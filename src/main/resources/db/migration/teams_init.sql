DROP TABLE IF EXISTS teams;


CREATE TABLE teams (
--    auto_increment is with mysql and H2
    id int primary key auto_increment,
    team_name VARCHAR(25) NOT NULL,
    city_name VARCHAR(25) NOT NULL,

);

