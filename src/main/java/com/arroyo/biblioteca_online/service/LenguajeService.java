package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.dao.ILenguajeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LenguajeService {

    @Autowired
    private ILenguajeDao iLenguajeDao;
}
