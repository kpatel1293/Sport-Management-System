DROP TABLE IF EXISTS injuries;

-- requires table 'players' to exist
-- TODO: This the best way to do this? Delete record completely when injury gone?
-- TODO: Is this enough? Include date of injury? String for doctor's notes?
CREATE TABLE injuries (
    id int primary key auto_increment,
    player_id int not null foreign key references players(id);
);