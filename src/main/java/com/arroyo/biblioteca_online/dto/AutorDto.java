package com.arroyo.biblioteca_online.dto;

public class AutorDto {
    private Integer id;
    private String nombre;

    private String pais;

    public AutorDto() {
    }

    public AutorDto(Integer id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
