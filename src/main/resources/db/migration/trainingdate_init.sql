DROP TABLE IF EXISTS trainingdates;

-- requires table 'teams' to exist
-- TODO: more granular time tracking, not just 'day of year' 
CREATE TABLE trainingdates (
    id int primary key auto_increment,
    team_id int not null foreign key references teams(id);
    train_date date not null;
);