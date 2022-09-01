package com.arroyo.biblioteca_online.dto;

import java.time.LocalDate;

public class LibroDto {
    private Integer id;
    private Integer autor_id;
    private String titulo;
    private LocalDate ano_publicado;
    private String lenguaje;
    private String portada_url;
    private Double precio;
    private byte vendible;
    private Integer copias;
    private String decripcio;

    public LibroDto() {
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

    public LocalDate getAno_publicado() {
        return ano_publicado;
    }

    public void setAno_publicado(LocalDate ano_publicado) {
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

    public String getDecripcio() {
        return decripcio;
    }

    public void setDecripcio(String decripcio) {
        this.decripcio = decripcio;
    }
}
