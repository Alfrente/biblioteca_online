package com.arroyo.biblioteca_online.dto;

import com.arroyo.biblioteca_online.entity.Libro;

import java.time.LocalDate;

public class LibroDto {
    private Integer id;
    private Integer autor_id;
    private String titulo;
    private Long ano_publicado;
    private String lenguaje;
    private String portada_url;
    private Double precio;
    private byte vendible;
    private Integer copias;
    private String decripcion;

    public LibroDto() {
    }

    public LibroDto(Libro libro) {
        this.id = libro.getId();
        this.autor_id = libro.getAutor_id();
        this.titulo = libro.getTitulo();
        this.ano_publicado = libro.getAno_publicado();
        this.lenguaje = libro.getLenguaje();
        this.portada_url = libro.getPortada_url();
        this.precio = libro.getPrecio();
        this.vendible = libro.getVendible();
        this.copias = libro.getCopias();
        this.decripcion = libro.getDescripcion();
    }

    public LibroDto(Integer id, Integer autor_id, String titulo, Long ano_publicado, String lenguaje, String portada_url, Double precio, byte vendible, Integer copias, String decripcion) {
        this.id = id;
        this.autor_id = autor_id;
        this.titulo = titulo;
        this.ano_publicado = ano_publicado;
        this.lenguaje = lenguaje;
        this.portada_url = portada_url;
        this.precio = precio;
        this.vendible = vendible;
        this.copias = copias;
        this.decripcion = decripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Integer autor_id) {
        this.autor_id = autor_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAno_publicado() {
        return ano_publicado;
    }

    public void setAno_publicado(Long ano_publicado) {
        this.ano_publicado = ano_publicado;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getPortada_url() {
        return portada_url;
    }

    public void setPortada_url(String portada_url) {
        this.portada_url = portada_url;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public byte getVendible() {
        return vendible;
    }

    public void setVendible(byte vendible) {
        this.vendible = vendible;
    }

    public Integer getCopias() {
        return copias;
    }

    public void setCopias(Integer copias) {
        this.copias = copias;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }
}
