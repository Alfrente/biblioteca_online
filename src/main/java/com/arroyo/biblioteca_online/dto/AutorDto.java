package com.arroyo.biblioteca_online.dto;

import com.arroyo.biblioteca_online.entity.Autor;

import java.io.Serializable;

public class AutorDto implements Serializable {
    private Integer numero;
    private String nombre;

    private String pais;

    public AutorDto() {
    }

    public AutorDto(Autor autor) {

        this.numero = autor.getId();

        if (autor.getNombre() != null) {
            this.nombre = autor.getNombre().toUpperCase();
        }
        if (autor.getNacionalidad() != null) {
            this.pais = autor.getNacionalidad().toUpperCase();
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return pais;
    }

    public void setNacionalidad(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "AutorDto{" +
                "id=" + numero +
                ", nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
