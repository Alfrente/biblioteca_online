package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.dao.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {

    @Autowired
    private IClienteDao iClienteDao;
}
