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
public class HistorialTrabajo {
    
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizo;
    private String estado;
    private Persona persona;
    private Cargo cargo;
    private Horario horario;

    public HistorialTrabajo() {
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

    public LocalDate getFechaFinalizo() {
        return fechaFinalizo;
    }

    public void setFechaFinalizo(LocalDate fechaFinalizo) {
        this.fechaFinalizo = fechaFinalizo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
    
}
