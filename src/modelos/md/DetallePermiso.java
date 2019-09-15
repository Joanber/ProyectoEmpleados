/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.md;

import java.time.LocalDate;

/**
 *
 * @author MrRainx
 */
public class DetallePermiso {

    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String observaciones;
    private Persona persona;
    private TipoPermiso tipo;

    public DetallePermiso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoPermiso getTipo() {
        return tipo;
    }

    public void setTipo(TipoPermiso tipo) {
        this.tipo = tipo;
    }

}
