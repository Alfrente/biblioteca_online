package com.arroyo.biblioteca_online.controller;

import com.arroyo.biblioteca_online.dto.LibroDto;
import com.arroyo.biblioteca_online.entity.Libro;
import com.arroyo.biblioteca_online.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libro")
public class LibroController {

    @Autowired
    public LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroDto>> getAll (){
        return new ResponseEntity<>(libroService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LibroDto> save (@RequestBody Libro libro){
        return new ResponseEntity<>(libroService.save.apply(libro), HttpStatus.CREATED);
    }

    @GetMapping("/buscarLibroTitulo/{tituloLibro}")
    public ResponseEntity<LibroDto> buscarLibroTitulo (@PathVariable("tituloLibro") String tituloLibro){
        return new ResponseEntity<>(libroService.buscarLibroTitulo.apply(tituloLibro), HttpStatus.OK);
    }

    /*@GetMapping("/buscarAutorConId/{autor_id}")
    public ResponseEntity<LibroDto> buscarAutorConId (@PathVariable("autor_id") Integer autor_id){
        return new ResponseEntity<>(libroService.buscarAutorConId.apply(autor_id), HttpStatus.OK);
    }*/
}


