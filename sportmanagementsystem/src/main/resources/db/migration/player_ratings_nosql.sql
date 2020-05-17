ALTER TABLE players ADD playerGameRatings jsonb;

UPDATE players SET playerGameRatings = '{"rating1to10": "7", "message": "good game" }';


ALTER TABLE players ADD playerSeasonRatings jsonb;

UPDATE players SET playerSeasonRatings = '{"rating1to10": "5", "message": "should be benched" }';

