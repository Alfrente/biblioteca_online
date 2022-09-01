package com.arroyo.biblioteca_online.dao;

import com.arroyo.biblioteca_online.entity.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperacionDao extends JpaRepository<Operacion, Integer> {
}
