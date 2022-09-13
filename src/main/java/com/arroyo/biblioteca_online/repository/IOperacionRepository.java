package com.arroyo.biblioteca_online.repository;

import com.arroyo.biblioteca_online.entity.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperacionRepository extends JpaRepository<Operacion, Integer> {
}
