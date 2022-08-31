CREATE TABLE IF NOT EXISTS author(
author_id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "Unique identifier of the table",
`name` VARCHAR(100) NOT NULL COMMENT "Name of the author of the book",
nationality VARCHAR(3) COMMENT "Nationality of the author of the book"
);

CREATE TABLE IF NOT EXISTS `language`(
language_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "Unique identifier of the table",
`code` VARCHAR(2) UNIQUE NOT NULL COMMENT "ISO 3166-1 alfa-2 language code",
country VARCHAR(52) NOT NULL COMMENT "Name of the country"
);

CREATE TABLE IF NOT EXISTS book(
book_id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "Unique identifier of the table",
author_id INTEGER UNSIGNED COMMENT "The author_id is the reference for the author table",
title VARCHAR(100) NOT NULL COMMENT "Title of the book",
`year_published` INTEGER UNSIGNED NOT NULL COMMENT "Is the year when the book was published or added", 
`language` VARCHAR(2) NOT NULL COMMENT "ISO 3166-1 alfa-2 language code",
cover_url VARCHAR(500) COMMENT "It is the url of the book cover",
price DOUBLE NOT NULL DEFAULT 10.0 COMMENT "Book price",
sellable TINYINT DEFAULT 1 COMMENT "It is a flag to know if the book can be sold where 0 is no and 1 is yes",
copies INTEGER NOT NULL DEFAULT 1 COMMENT "Number of copies of the book",
`description` TEXT COMMENT "Book description",
FOREIGN KEY (author_id) REFERENCES author(author_id)
);

CREATE TABLE IF NOT EXISTS `client`(
client_id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "Unique identifier of the table",
`name` VARCHAR(50) NOT NULL COMMENT "Customer name", 
email VARCHAR(100) NOT NULL UNIQUE COMMENT "Customer mail",
birthdate DATETIME COMMENT "Client's Date of Birth",
gender ENUM("M","F") NOT NULL COMMENT "Client's gender",
`active` TINYINT NOT NULL DEFAULT 1 COMMENT "It is a flag to know if the client is active 0 is deactivated and 1 is active",
create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "Date when the customer was created",
update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "Date when the client is updated"
);

CREATE TABLE IF NOT EXISTS operation(
operation_id INTEGER PRIMARY KEY AUTO_INCREMENT COMMENT "Unique identifier of the table",
book_id INTEGER UNSIGNED COMMENT "The book_id is the reference for the book table",
client_id INTEGER UNSIGNED COMMENT "The client_id is the reference for the client table",
`type` ENUM("PRESTADO", "DEVUELTO", "VENDIDO") COMMENT "It is an enumerator where the state of the book goes",
create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "Date when the operation was created",
update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON
UPDATE CURRENT_TIMESTAMP COMMENT "Date when the operation is updated",
finished TINYINT NOT NULL COMMENT "It is a flag where 0 is that the operation has not finished and 1 is when it is finished",
FOREIGN KEY (book_id) REFERENCES book(book_id),
FOREIGN KEY (client_id) REFERENCES `client`(client_id)
);