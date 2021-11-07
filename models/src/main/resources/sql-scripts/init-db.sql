
-- docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=workers -p 5432:5432 postgres:13
-- INSERT INTO artikel (naziv, status, kategorija, seznam_id, id) VALUES ('Brsticni ohrovt', 'Na voljo', 'Hrana', 100, 500);


-- CREATE TABLE workers (
--                          id serial PRIMARY KEY,
--                          lastName VARCHAR ( 50 ) UNIQUE NOT NULL,
--                          address VARCHAR ( 50 ) NOT NULL,
--                          date_of_birth VARCHAR ( 255 ) UNIQUE NOT NULL,
--                          firstName VARCHAR ( 50 ) UNIQUE NOT NULL
-- );
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES (1, 'Mojster', 'Miha', 'Sanjska 1, 1000 Ljubljana', '5.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', 'null');
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES (2, 'Čebelica', 'Maja', 'Lepa 1, 2000 Maribor', '5.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', 'null', '8.00-17.00', '8.00-17.00', 'null');

--
-- SELECT * FROM workers