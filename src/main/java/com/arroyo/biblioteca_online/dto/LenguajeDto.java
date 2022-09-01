package com.arroyo.biblioteca_online.dto;

public class LenguajeDto {
    private Integer id;
    private String codigo;
    private String pais;

    public LenguajeDto() {
    }

    public LenguajeDto(Integer id, String codigo, String pais) {
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
}
