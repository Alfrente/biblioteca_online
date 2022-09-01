package com.arroyo.biblioteca_online.dao;

import com.arroyo.biblioteca_online.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroDao extends JpaRepository<Libro, Integer> {
}
