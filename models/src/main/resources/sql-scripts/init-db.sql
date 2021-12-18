
-- docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=workers -p 5432:5432 postgres:13
-- INSERT INTO artikel (naziv, status, kategorija, seznam_id, id) VALUES ('Brsticni ohrovt', 'Na voljo', 'Hrana', 100, 500);

CREATE TABLE workers (
    id serial PRIMARY KEY,
    firstName VARCHAR ( 50 ) NOT NULL,
    lastName VARCHAR ( 50 ) NOT NULL,
    address VARCHAR ( 50 ) NOT NULL,
    hourlyRate real NOT NULL,
    monday VARCHAR (11) NOT NULL,
    tuesday VARCHAR (11) NOT NULL,
    wednesday VARCHAR (11) NOT NULL,
    thursday VARCHAR (11) NOT NULL,
    friday VARCHAR (11) NOT NULL,
    saturday VARCHAR (11) NOT NULL,
    sunday VARCHAR (11) NOT NULL
);
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES (1, 'Mojster', 'Miha', 'Sanjska 1, 1000 Ljubljana', '8.80', '8.00-17.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', '8.00-17.00', 'null');
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES (2, 'Čebelica', 'Maja', 'Lepa 1, 2000 Maribor', '5.40', '8.00-17.00', '8.00-17.00', '8.00-17.00', 'null', '8.00-17.00', '8.00-17.00', 'null');
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES (3, 'Andrej', 'Novak', 'Oblačna 1, 5000 Koper', '7.00', '8.00-17.00', 'null', '8.00-17.00', 'null', 'null', '8.00-17.00', '8.00-10.00');

--
-- SELECT * FROM workers