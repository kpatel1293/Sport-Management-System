DROP TABLE IF EXISTS trainingdates;

-- requires table 'teams' to exist
-- TODO: more granular time tracking, not just 'day of year' 
CREATE TABLE trainingdates (
    id int primary key auto_increment,
    team_name VARCHAR(255),
    train_date date not null,
    CONSTRAINT team_daes_fk FOREIGN KEY(`team_name`) REFERENCES teams(`team_name`)
);