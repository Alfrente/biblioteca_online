package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {

    @Autowired
    private IClienteRepository iClienteRepository;
}
