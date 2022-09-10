package com.arroyo.biblioteca_online.error;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ErrorRespuesta {
    private int estado;
    private String mensaje;
    private LocalDate fecha;
    List<String> errores;

    public ErrorRespuesta() {
    }

    public ErrorRespuesta(int estado, String mensaje, LocalDate fecha) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public ErrorRespuesta(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }
}
