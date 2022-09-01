package com.arroyo.biblioteca_online.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lenguaje")
public class Lenguaje {
    @Id
    @Column(name = "lenguaje_id")
    private Integer id;
    private String codigo;
    private String pais;

    public Lenguaje() {
    }

    public Lenguaje(Integer id, String codigo, String pais) {
        this.id = id;
        this.codigo = codigo;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Lenguaje{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
