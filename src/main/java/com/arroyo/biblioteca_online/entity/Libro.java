package com.arroyo.biblioteca_online.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Integer id;
    private Integer autor_id;
    private String titulo;
    @Column(name = "año_publicado")
    private Long ano_publicado;
    private String lenguaje;
    private String portada_url;
    private Double precio;
    private byte vendible;
    private Integer copias;
    private String descripcion;

    @OneToMany(mappedBy = "libro")
    private List<Autor> autores;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
