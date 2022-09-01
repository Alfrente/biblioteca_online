package com.arroyo.biblioteca_online.controller;

import com.arroyo.biblioteca_online.dto.AutorDto;
import com.arroyo.biblioteca_online.entity.Autor;
import com.arroyo.biblioteca_online.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @RequestMapping
    public ResponseEntity<List<AutorDto>> getAll(){
        return new ResponseEntity<>(autorService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AutorDto> save(@RequestBody Autor autor){
        return new ResponseEntity<>(autorService.save(autor), HttpStatus.CREATED);
    }

}
