-- ******************** **** Tabla Autor **** ******************** --
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

-- ******************** **** Tabla  cliente **** ******************** --
/*fecha_nacimiento
-- creado datos que puedo no pasar en insert
-- actualizado*/
