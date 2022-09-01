package com.arroyo.biblioteca_online.service;

import com.arroyo.biblioteca_online.dao.IAutorDao;
import com.arroyo.biblioteca_online.dto.AutorDto;
import com.arroyo.biblioteca_online.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private IAutorDao iAutorDao;

    public List<AutorDto> getAll() {
        List<Autor> autors = iAutorDao.findAll();
        return autors.stream().map(autor -> new AutorDto(autor.getId(), autor.getNombre(), autor.getNacionalidad())).collect(Collectors.toList());
    }

    @Transactional
    public AutorDto save(Autor autor) {
        iAutorDao.save(autor);
        Autor autor1 =  iAutorDao.buscarAutorNombre(autor.getNacionalidad(), autor.getNacionalidad());
        System.out.println(autor1);
        if (autor1 == null || autor1.getId() == null || autor1.getId() == 0) {
            new Exception(new Exception("La informacion es erronea"));
            return new AutorDto();
        } else {
            return new AutorDto(autor1.getId(), autor1.getNombre(), autor1.getNacionalidad());
        }
    }

    public AutorDto findByNombre(String nombre) {
        Autor autor = iAutorDao.findFirstByNombre(nombre);
        return new AutorDto(autor.getId(), autor.getNombre(), autor.getNacionalidad());
    }

}
