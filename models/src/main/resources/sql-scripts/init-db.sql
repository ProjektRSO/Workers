
-- docker run -d --name postgres-jdbc -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=workers -p 5432:5432 postgres:13
-- INSERT INTO artikel (naziv, status, kategorija, seznam_id, id) VALUES ('Brsticni ohrovt', 'Na voljo', 'Hrana', 100, 500);

drop table workers;
CREATE TABLE workers (
                         id serial PRIMARY KEY,
                         firstName VARCHAR ( 50 ) NOT NULL,
                         lastName VARCHAR ( 50 ) NOT NULL,
                         address VARCHAR ( 50 ) NOT NULL,
                         hourlyRate real NOT NULL,
                         monday boolean NOT NULL,
                         tuesday boolean NOT NULL,
                         wednesday boolean NOT NULL,
                         thursday boolean NOT NULL,
                         friday boolean NOT NULL,
                         saturday boolean NOT NULL,
                         sunday boolean NOT NULL,
                         IBAN varchar (50) NOT NULL
);
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday, IBAN) VALUES (1, 'Mojster', 'Miha', 'Sanjska 1, 1000 Ljubljana', '8.80', true, false, true, true, true, false, false, 'NL20INGB4418364501');
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday, IBAN) VALUES (2, 'Čebelica', 'Maja', 'Lepa 1, 2000 Maribor', '5.40', false, false, true, false, false, false, false, 'LT247972521286178578');
INSERT INTO workers (id, firstName, lastName, address, hourlyRate, monday, tuesday, wednesday, thursday, friday, saturday, sunday, IBAN) VALUES (3, 'Andrej', 'Novak', 'Oblačna 1, 5000 Koper', '7.00', true, true, true, true, false, false, false, 'SI65725753942163783');

select * from workers;