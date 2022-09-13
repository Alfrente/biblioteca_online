package com.arroyo.biblioteca_online.dto;

import com.arroyo.biblioteca_online.entity.Autor;

public class AutorDto {
    private Integer numero;
    private String nombre;

    private String pais;

    public AutorDto() {
    }

    public AutorDto(Autor autor) {
        this.numero = autor.getId();
        this.nombre = autor.getNombre().toUpperCase();
        this.pais = autor.getNacionalidad().toUpperCase();
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
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
