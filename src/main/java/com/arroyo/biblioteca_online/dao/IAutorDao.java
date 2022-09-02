package com.arroyo.biblioteca_online.dao;

import com.arroyo.biblioteca_online.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IAutorDao extends JpaRepository<Autor, Integer> {

    Optional<Autor> findFirstByNombre(String nombre); //PARA TRAER UN DATO ES first or top

    @Transactional
    @Query(value = "CALL guardarAutorDevolverConNombrePais(?1, ?2)", nativeQuery = true)
    Autor guardarAutorDevolverConNombrePais(@Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad);

    @Query(value = "CALL buscarAutorConNombrePais(?1, ?2);", nativeQuery = true)
    Autor proAlmacenadoBuscarAutorConNombrePais(@Param("nacionalidad") String nacionalidad, @Param("nombre") String nombre);

    @Transactional
    @Query(value = "CALL eliminarAutorConNombre(?1); ", nativeQuery = true)
    void deleteByNombre(@Param("nombre") String nombre);
}
