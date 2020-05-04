-- barebones! will be updated with further fields, maybe:
-- - w/l pct 
-- - years served 
-- - more?
ALTER TABLE teams ADD coachRecords jsonb;
UPDATE teams SET coachRecords = '{"coachname": "placeholder"}';