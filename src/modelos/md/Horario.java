/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.md;

import java.time.LocalTime;

/**
 *
 * @author MrRainx
 */
public class Horario {

    private int id;
    private LocalTime inicio;
    private LocalTime fin;
    private String jornada;

    public Horario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String informacionCmb() {
        return "ID: " + this.id + ", H.Inicio: " + this.inicio + ", H.Fin: " + this.fin + ", Jornada: " + this.jornada;
    }

    public String informacionTbl() {
        return " " + this.inicio + " - " + this.fin + ", " + this.jornada;
    }

}
