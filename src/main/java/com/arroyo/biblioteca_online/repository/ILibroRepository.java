package com.arroyo.biblioteca_online.repository;

import com.arroyo.biblioteca_online.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ILibroRepository extends JpaRepository<Libro, Integer> {

    Libro findTopByTitulo(String titulo);

    @Query(value = "CALL buscarAutorConId(?1);", nativeQuery = true)
    Libro buscarAutorConId(Integer autorId);

    @Query(value = "CALL validarLenguajeLibro(?1);", nativeQuery = true)
    Libro validarLenguajeLibro(String lenguaje);

}
