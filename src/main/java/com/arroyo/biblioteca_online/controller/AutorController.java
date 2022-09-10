package com.arroyo.biblioteca_online.controller;

import com.arroyo.biblioteca_online.dto.AutorDto;
import com.arroyo.biblioteca_online.entity.Autor;
import com.arroyo.biblioteca_online.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AutorDto>> getAll() {
        return new ResponseEntity<>(autorService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/findByNombre/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<AutorDto> findByNombre(@PathVariable("nombre") String nombre) {
        return new ResponseEntity<>(autorService.findByNombre(nombre), HttpStatus.OK);
    }

    @RequestMapping(value = "/verAutorConPais/{nacionalidad}/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<AutorDto> verAutorConPais(@PathVariable("nacionalidad") String nacionalidad, @PathVariable("nombre") String nombre) {
        return new ResponseEntity<>(autorService.verAutorConPais(nacionalidad, nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AutorDto> save(@RequestBody Autor autor) {
        return new ResponseEntity<>(autorService.save(autor), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<AutorDto>> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(autorService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteByName/{nombre}")
    public ResponseEntity<AutorDto> deleteByNombre(@PathVariable("nombre") String nombre) {
        return new ResponseEntity<>(autorService.deleteByNombre(nombre), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<AutorDto> deleteById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(autorService.deleteById(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/guardarAutorDevolverConNombrePais/{nombre}/{nacionalidad}")
    public ResponseEntity<AutorDto> guardarAutorDevolverConNombrePais(@PathVariable("nombre") String nombre, @PathVariable("nacionalidad") String nacionalidad) {
        return new ResponseEntity<>(autorService.guardarAutorDevolverConNombrePais(nombre, nacionalidad), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AutorDto> actualizarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        return new ResponseEntity<>(autorService.actualizarAutor(id, autor), HttpStatus.OK);
    }

}
