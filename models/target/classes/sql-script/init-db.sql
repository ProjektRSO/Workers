
-- docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=workers -p 5432:5432 postgres:13
-- INSERT INTO artikel (naziv, status, kategorija, seznam_id, id) VALUES ('Brsticni ohrovt', 'Na voljo', 'Hrana', 100, 500);


-- CREATE TABLE workers (
--                          id serial PRIMARY KEY,
--                          lastName VARCHAR ( 50 ) UNIQUE NOT NULL,
--                          address VARCHAR ( 50 ) NOT NULL,
--                          date_of_birth VARCHAR ( 255 ) UNIQUE NOT NULL,
--                          firstName VARCHAR ( 50 ) UNIQUE NOT NULL
-- );
INSERT INTO workers (firstName, lastName, address, date_of_birth, id) VALUES ('Brsticni', 'ohrovt', 'Na voljo', '10.10.1985', 1);
--
-- SELECT * FROM workers