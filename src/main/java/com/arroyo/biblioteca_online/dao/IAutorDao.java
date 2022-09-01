package com.arroyo.biblioteca_online.dao;

import com.arroyo.biblioteca_online.dto.AutorDto;
import com.arroyo.biblioteca_online.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutorDao extends JpaRepository<Autor, Integer> {

    Autor findFirstByNombre(String nombre); //PARA TRAER UN DATO ES first or top

    @Query(value = "SELECT a.autor_id, a.nombre, l.pais as nacionalidad FROM autor a join lenguaje l on a.nacionalidad =?1 and l.codigo = ?2", nativeQuery = true)
    Autor buscarAutorNombre(@Param("nacionalidad") String nombre, @Param("codigo") String codigo_pais);

    @Query(value = "SELECT * FROM biblioteca.autores", nativeQuery = true)
    Autor ver();
}
