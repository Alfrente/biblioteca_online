package com.arroyo.biblioteca_online.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "operacion")
public class Operacion {
    @Id
    @Column(name = "operacion_id")
    private Integer id;
    private Integer libro_id;
    private Integer cliente_id;
    private String tipo;
    private LocalDateTime creado;
    private LocalDateTime actualizado;
    private Byte finalizado;

    public Operacion() {
    }

    public Operacion(Integer id, Integer libro_id, Integer cliente_id, String tipo, LocalDateTime creado, LocalDateTime actualizado, Byte finalizado) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
