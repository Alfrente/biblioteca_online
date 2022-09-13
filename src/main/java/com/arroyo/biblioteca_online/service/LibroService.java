package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.repository.ILibroRepository;
import com.arroyo.biblioteca_online.dto.LibroDto;
import com.arroyo.biblioteca_online.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.arroyo.biblioteca_online.datos_esticos.ExprecionRegular.*;

@Service
public class LibroService {

    @Autowired
    private ILibroRepository iLibroRepository;

    public List<LibroDto> getAll() {
        return iLibroRepository.findAll().stream().map(libro -> new LibroDto(libro)).collect(Collectors.toList());
    }

    public Function<Libro, LibroDto> save = libro -> {
        if (validarLibro(libro) && validarAutorId(libro.getAutor_id()) && validarLenguajeLibro(libro.getLenguaje())) {
            libro.setAno_publicado((long) LocalDate.now().getYear());
            return new LibroDto(iLibroRepository.save(libro));
        }
        return new LibroDto();
    };

    public Function<String, LibroDto> buscarLibroTitulo = tituloLibro -> {
        return new LibroDto(iLibroRepository.findTopByTitulo(tituloLibro));
    };

    public Boolean validarAutorId(Integer autor_id) {
        Libro libro = iLibroRepository.buscarAutorConId(autor_id);
        if (libro != null && libro.getAutores() != null) {
            return true;
        }
        return false;
    }

    public Boolean validarLenguajeLibro(String lenguaje) {
        Libro libro = iLibroRepository.validarLenguajeLibro(lenguaje);
        if (libro != null && (!libro.getLenguaje().isBlank()) && lenguaje.length() == 2 && lenguaje.matches(VALIDAR_LETRAS)) {
            return true;
        }
        return false;
    }

    public boolean validarLibro(Libro libro) {
        if (libro != null && libro.getAutor_id() != null && libro.getTitulo() != null && libro.getLenguaje() != null && libro.getAutor_id() > 0 && libro.getTitulo().matches(VALIDAR_LETRAS_CON_ESPACIOS) && libro.getLenguaje().matches(VALIDAR_LETRAS)) {
            return true;
        }
        return false;
    }

}
