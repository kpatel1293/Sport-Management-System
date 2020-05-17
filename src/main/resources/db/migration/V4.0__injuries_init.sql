-- requires table 'players' to exist
-- TODO: This the best way to do this? Delete record completely when injury gone?
-- TODO: Is this enough? Include date of injury? String for doctor's notes?
CREATE TABLE injuries (
    id int primary key auto_increment,
    player_id int,
    CONSTRAINT injury_player_fk FOREIGN KEY(`player_id`) REFERENCES players(`player_id`)
);