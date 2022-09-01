create database biblioteca;
use biblioteca;

CREATE TABLE IF NOT EXISTS autor(
autor_id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "Identificador único de la tabla",
nombre VARCHAR(100) NOT NULL UNIQUE COMMENT "Nombre de el autor de el libro", -- ***********
nacionalidad VARCHAR(3) COMMENT "Nacionalidad de el autor de el libro"
);

CREATE TABLE IF NOT EXISTS lenguaje(
lenguaje_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "Identificador único de la tabla",
codigo VARCHAR(2) UNIQUE NOT NULL COMMENT "ISO 3166-1 alfa-2 código del lenguaje",
pais VARCHAR(52) NOT NULL COMMENT "Nombre de el país"
);

CREATE TABLE IF NOT EXISTS libro(
libro_id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "Identificador único de la tabla",
autor_id INTEGER UNSIGNED NOT NULL COMMENT "El autor_id es la referencia de la tabla autor",
titulo VARCHAR(100) NOT NULL COMMENT "Título de el libro",
año_publicado INTEGER UNSIGNED NOT NULL COMMENT "Es el año cuando se publico o añadió el libro", 
lenguaje VARCHAR(2) NOT NULL COMMENT "ISO 3166-1 alfa-2 código del lenguaje",
portada_url VARCHAR(500) COMMENT "Es la url de la portada del libro",
precio DOUBLE NOT NULL DEFAULT 10.0 COMMENT "Precio de el libro",
vendible TINYINT DEFAULT 1 COMMENT "Es una bandera para saber si el libro se puede vender donde 0 es no  y 1 es si",
copias INTEGER NOT NULL DEFAULT 1 COMMENT "Cantidad de copias que hay del libro",
descripcion TEXT COMMENT "Descripción del libro",
FOREIGN KEY (autor_id) REFERENCES autor(autor_id)
);

CREATE TABLE IF NOT EXISTS cliente(
cliente_id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "Identificador único de la tabla",
nombre VARCHAR(50) NOT NULL COMMENT "Nombre del cliente", 
correo VARCHAR(100) NOT NULL UNIQUE COMMENT "Correo del cliente",
fecha_nacimiento DATETIME COMMENT "Fecha de nacimiento del cliente",
genero ENUM("M","F") NOT NULL COMMENT "Género del cliente",
activo TINYINT NOT NULL DEFAULT 1 COMMENT "Es una bandera para saber si el cliente esta activo 0 es desactivado y 1 activo",
creado TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "Fecha cuando se creó el cliente",
actualizado TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "Fecha cuando se actualiza el cliente"
);

CREATE TABLE IF NOT EXISTS operacion(
operacion_id INTEGER PRIMARY KEY AUTO_INCREMENT COMMENT "Identificador único de la tabla",
libro_id INTEGER UNSIGNED NOT NULL COMMENT "El libro_id es la referencia para la tabla libro",
cliente_id INTEGER UNSIGNED NOT NULL COMMENT "El cliente_id es la referencia para la tabla cliente",
tipo ENUM("PRESTADO", "DEVUELTO", "VENDIDO") COMMENT "Es un enumerador donde va el estado del libro",
creado TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "Fecha cuando se creó la operación",
actualizado TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "Fecha cuando se actualiza la operación",
finalizado TINYINT NOT NULL COMMENT "Es una bandera donde 0 es que la operación no a terminado y 1 es cuando ya termino",
FOREIGN KEY (libro_id) REFERENCES libro(libro_id),
FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id)
);

