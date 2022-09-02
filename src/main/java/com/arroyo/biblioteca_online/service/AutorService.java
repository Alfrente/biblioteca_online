package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.dao.IAutorDao;
import com.arroyo.biblioteca_online.dto.AutorDto;
import com.arroyo.biblioteca_online.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.arroyo.biblioteca_online.datos_esticos.DatosEstaticos.*;

@Service
public class AutorService {

    @Autowired
    private IAutorDao iAutorDao;

    public List<AutorDto> getAll() {
        List<Autor> autores = iAutorDao.findAll();
        if (autores != null && (!autores.isEmpty())) {
            return autores.stream().map(autor -> new AutorDto(autor)).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public AutorDto save(Autor dato) {
        Optional<Autor> autorTraido;
        if (validarUsuario(dato)) {
            autorTraido = iAutorDao.findFirstByNombre(dato.getNombre());

            if (autorTraido.isEmpty()) {
                dato.getNombre().toUpperCase();
                dato.getNacionalidad().toUpperCase();
                Autor autor = iAutorDao.save(dato);
                return new AutorDto(autor);
            } else {
                return new AutorDto(autorTraido.get());
            }
        } else {
            return new AutorDto();
        }
    }

    public AutorDto findByNombre(String nombre) {
        if (nombre != null && nombre.matches(validarLetras)) {
            Autor autor = iAutorDao.findFirstByNombre(nombre).get();
            if (autor != null && (!autor.getNombre().isBlank())) {
                return new AutorDto(autor);
            } else {
                return new AutorDto();
            }
        } else {
            return new AutorDto();
        }
    }

    public Optional<AutorDto> findById(Integer id) {
        if (id != null && id > 0) {
            Optional<Autor> autor = iAutorDao.findById(id);
            if (autor.isPresent()) {
                return autor.map(autor1 -> new AutorDto(autor1));
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public AutorDto verAutorConPais(String nacionalidad, String nombre) {
        if (nacionalidad != null && nombre != null && nacionalidad.matches(validarLetrasConEspacios) && nombre.matches(validarLetras)) {
            Autor autor = iAutorDao.proAlmacenadoBuscarAutorConNombrePais(nacionalidad, nombre);
            if (autor != null && autor.getId() != null && autor.getId() > 0) {
                return new AutorDto(autor);
            } else {
                return new AutorDto();
            }
        } else {
            return new AutorDto();
        }
    }

    public AutorDto deleteById(Integer id) {
        if (id != null && id > 0) {
            Optional<Autor> autor = iAutorDao.findById(id);
            if (autor.isPresent()) {
                iAutorDao.deleteById(id);
                return new AutorDto(autor.get());
            } else {
                return new AutorDto();
            }
        } else {
            return new AutorDto();
        }
    }

    public AutorDto deleteByNombre(String nombre) {
        if (nombre.matches(validarLetras)) {
            Autor autor = iAutorDao.findFirstByNombre(nombre).get();
            if (autor != null) {
                iAutorDao.deleteById(autor.getId());
                return new AutorDto(autor);
            } else {
                return new AutorDto();
            }
        } else {
            return new AutorDto();
        }
    }

    public AutorDto guardarAutorDevolverConNombrePais(String nombre, String nacionalidad) {
        Optional<Autor> usuarioTraido;
        if (nombre.matches(validarLetras) && nacionalidad.matches(validarLetrasConEspacios)) {
            usuarioTraido = iAutorDao.findFirstByNombre(nombre);
            if (!usuarioTraido.isPresent()) {
                Autor autor = iAutorDao.guardarAutorDevolverConNombrePais(nombre.toUpperCase(), nacionalidad.toLowerCase());
                return new AutorDto(autor);
            } else {
                return new AutorDto(usuarioTraido.get());
            }
        } else {
            return new AutorDto();
        }
    }

    private boolean validarUsuario(Autor dato) {
        if (dato != null && dato.getNombre() != null && (!dato.getNombre().isBlank()) && dato.getNacionalidad() != null && (!dato.getNacionalidad().isBlank())) {
            return true;
        } else {
            return false;
        }
    }
}
