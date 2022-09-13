package com.arroyo.biblioteca_online.mapper;

import com.arroyo.biblioteca_online.dto.AutorDto;
import com.arroyo.biblioteca_online.entity.Autor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(target = "numero", source = "autor.id")
    @Mapping(target = "pais", source = "autor.nacionalidad")
    AutorDto aAutorDto(Autor autor);

    @InheritInverseConfiguration
    @Mapping(target = "libro", ignore = true)
    Autor aAutor(AutorDto autorDto);
}
