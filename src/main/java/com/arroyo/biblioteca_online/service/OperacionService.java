package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.repository.IOperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OperacionService {

    @Autowired
    private IOperacionRepository iOperacionDao;

}
