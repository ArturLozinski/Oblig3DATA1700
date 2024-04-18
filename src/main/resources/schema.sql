SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS Tickets;
CREATE TABLE Tickets (
    id INTEGER AUTO_INCREMENT NOT NULL,
    movie varchar(255) NOT NULL,
    numberOfTickets INTEGER NOT NULL,
    fname varchar(255) NOT NULL,
    lname varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    phone INTEGER NOT NULL,
    PRIMARY KEY (id)
);