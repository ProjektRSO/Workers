# Workers

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
