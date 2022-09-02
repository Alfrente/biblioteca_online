SELECT * FROM biblioteca.autor;

delimiter //
CREATE PROCEDURE verAutorConPais (
IN pNacionalidad VARCHAR(51), 
IN pNpmbre VARCHAR(100)
)
BEGIN
SELECT a.autor_id, a.nombre, l.pais AS nacionalidad FROM autor a JOIN lenguaje l ON a.nacionalidad = pNacionalidad AND l.codigo = pNacionalidad WHERE nombre = pNpmbre;
END //
delimiter ;

delimiter //
CREATE PROCEDURE eliminarAutorConNombre(pNombre varchar(100))
BEGIN
DELETE FROM autor WHERE nombre = pNombre LIMIT 1;
END
//
delimiter ;

SELECT a.autor_id, a.nombre, l.pais AS nacionalidad FROM autor a JOIN lenguaje l ON a.nacionalidad ="CN" AND l.codigo = "CN" WHERE nombre = "ftfy" LIMIT 1;

INSERT INTO autor(nombre, nacionalidad) VALUES ("Arroyo", "GF");

CALL verAutorConPais("GF", "AA");

CALL eliminarAutorConNombre("asssdfr");