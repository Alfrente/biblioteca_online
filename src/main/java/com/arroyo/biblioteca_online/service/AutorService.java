package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.repository.IAutorRepository;
import com.arroyo.biblioteca_online.dto.AutorDto;
import com.arroyo.biblioteca_online.entity.Autor;
import com.arroyo.biblioteca_online.mapper.AutorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.arroyo.biblioteca_online.datos_esticos.ExprecionRegular.VALIDAR_LETRAS;
import static com.arroyo.biblioteca_online.datos_esticos.ExprecionRegular.VALIDAR_LETRAS_CON_ESPACIOS;

@Service
public class AutorService {

    @Autowired
    private IAutorRepository iAutorRepository;

    @Autowired
    private AutorMapper autorMapper;

    public List<AutorDto> getAll() {
        return iAutorRepository.findAll().stream().map(autor -> autorMapper.aAutorDto(autor)).collect(Collectors.toList());
    }

    @Transactional
    public AutorDto save(Autor dato) {
        Optional<Autor> autorTraido;
        if (validarAutor(dato)) {
            autorTraido = iAutorRepository.findFirstByNombre(dato.getNombre());

            if (autorTraido.isEmpty()) {
                dato.getNombre().toUpperCase();
                dato.getNacionalidad().toUpperCase();
                Autor autor = iAutorRepository.save(autorEnMayuscula(dato));
                return new AutorDto(autorEnMayuscula(autor));
            } else {
                return new AutorDto(autorEnMayuscula(autorTraido.get()));
            }
        } else {
            return new AutorDto();
        }
    }

    public AutorDto findByNombre(String nombre) {
        if (nombre != null && nombre.matches(VALIDAR_LETRAS)) {
            Optional<Autor> autor = iAutorRepository.findFirstByNombre(nombre);
            return autor.map(value -> new AutorDto(autorEnMayuscula(value))).orElseGet(AutorDto::new);
        } else {
            return new AutorDto();
        }
    }

    public Optional<AutorDto> findById(Integer id) {
        if (id != null && id > 0) {
            Optional<Autor> autor = iAutorRepository.findById(id);
            if (autor.isPresent()) {
                return autor.map(autor1 -> new AutorDto(autorEnMayuscula(autor1)));
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public AutorDto verAutorConPais(String nacionalidad, String nombre) {
        if (nacionalidad != null && nombre != null && nacionalidad.matches(VALIDAR_LETRAS_CON_ESPACIOS) && nombre.matches(VALIDAR_LETRAS)) {
            Autor autor = iAutorRepository.proAlmacenadoBuscarAutorConNombrePais(nacionalidad, nombre);
            if (autor != null && autor.getId() != null && autor.getId() > 0) {
                return new AutorDto(autorEnMayuscula(autor));
            } else {
                return new AutorDto();
            }
        } else {
            return new AutorDto();
        }
    }

    @Transactional
    public AutorDto deleteById(Integer id) {
        if (id != null && id > 0) {
            Optional<Autor> autor = iAutorRepository.findById(id);
            if (autor.isPresent()) {
                iAutorRepository.deleteById(id);
                return new AutorDto(autorEnMayuscula(autor.get()));
            } else {
                return new AutorDto();
            }
        } else {
            return new AutorDto();
        }
    }

    @Transactional
    public AutorDto deleteByNombre(String nombre) {
        if (nombre.matches(VALIDAR_LETRAS)) {
            Autor autor = iAutorRepository.findFirstByNombre(nombre).get();
            if (autor != null) {
                iAutorRepository.deleteById(autor.getId());
                return new AutorDto(autorEnMayuscula(autor));
            } else {
                return new AutorDto();
            }
        } else {
            return new AutorDto();
        }
    }

    public AutorDto guardarAutorDevolverConNombrePais(String nombre, String nacionalidad) {
        Optional<Autor> usuarioTraido;

        if (nombre.matches(VALIDAR_LETRAS) && nacionalidad.matches(VALIDAR_LETRAS_CON_ESPACIOS)) {
            usuarioTraido = iAutorRepository.findFirstByNombre(nombre);
            if (!usuarioTraido.isPresent()) {
                Autor autor = iAutorRepository.guardarAutorDevolverConNombrePais(nombre.toUpperCase(), nacionalidad.toLowerCase());
                return new AutorDto(autorEnMayuscula(autor));
            } else {
                return new AutorDto(autorEnMayuscula(usuarioTraido.get()));
            }
        }
        return new AutorDto();
    }

    public AutorDto actualizarAutor(Integer id, Autor autor) {
        if (validarAutor(autor) && id != null && id > 0) {
            Optional<Autor> idAutor = Optional.ofNullable(iAutorRepository.findById(id).orElse(null));
            if (idAutor.isPresent()) {
                autor.setId(id);
                return new AutorDto(iAutorRepository.save(autorEnMayuscula(autor)));
            } else {
                return new AutorDto();
            }
        }
        return new AutorDto();
    }

    private boolean validarAutor(Autor dato) {
        if (dato != null && dato.getNombre() != null && (!dato.getNombre().isBlank()) && dato.getNacionalidad() != null && (!dato.getNacionalidad().isBlank())) {
            return true;
        }
        return false;
    }

    private Autor autorEnMayuscula(Autor autor) {
        autor.getNombre().toUpperCase();
        autor.getNacionalidad().toUpperCase();
        return autor;
    }
}
