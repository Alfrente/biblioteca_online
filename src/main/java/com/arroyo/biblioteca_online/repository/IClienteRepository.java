package com.arroyo.biblioteca_online.repository;

import com.arroyo.biblioteca_online.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Autor, Integer> {
}
