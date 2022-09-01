package com.arroyo.biblioteca_online.dao;

import com.arroyo.biblioteca_online.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Autor, Integer> {
}
