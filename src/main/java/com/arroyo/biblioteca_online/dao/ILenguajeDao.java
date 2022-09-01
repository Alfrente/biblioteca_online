package com.arroyo.biblioteca_online.dao;

import com.arroyo.biblioteca_online.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILenguajeDao extends JpaRepository<Cliente, Integer> {
}
