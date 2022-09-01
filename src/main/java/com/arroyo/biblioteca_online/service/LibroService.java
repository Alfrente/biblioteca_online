package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.dao.ILibroDao;
import org.springframework.beans.factory.annotation.Autowired;

public class LibroService {

    @Autowired
    private ILibroDao iLibroDao;
}
