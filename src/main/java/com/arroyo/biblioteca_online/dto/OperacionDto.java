package com.arroyo.biblioteca_online.dto;

import java.time.LocalDateTime;

public class OperacionDto {
    private Integer id;
    private Integer libro_id;
    private Integer cliente_id;
    private Enum tipo;
    private LocalDateTime creado;
    private LocalDateTime actualizado;
    private Byte finalizado;

    public OperacionDto() {
    }

    public OperacionDto(Integer id, Integer libro_id, Integer cliente_id, Enum tipo, LocalDateTime creado, LocalDateTime actualizado, Byte finalizado) {
        this.id = id;
        this.libro_id = libro_id;
        this.cliente_id = cliente_id;
        this.tipo = tipo;
        this.creado = creado;
        this.actualizado = actualizado;
        this.finalizado = finalizado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Integer libro_id) {
        this.libro_id = libro_id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public LocalDateTime getActualizado() {
        return actualizado;
    }

    public void setActualizado(LocalDateTime actualizado) {
        this.actualizado = actualizado;
    }

    public Byte getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Byte finalizado) {
        this.finalizado = finalizado;
    }
}
