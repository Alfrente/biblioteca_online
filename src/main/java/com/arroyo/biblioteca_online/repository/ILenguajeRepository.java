package com.arroyo.biblioteca_online.repository;

import com.arroyo.biblioteca_online.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILenguajeRepository extends JpaRepository<Cliente, Integer> {
}
