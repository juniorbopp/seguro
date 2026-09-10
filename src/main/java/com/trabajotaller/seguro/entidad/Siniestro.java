package com.trabajotaller.seguro.entidad;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSiniestro;
    private String descripcionSiniestro;
    private Date fechaSiniestro;
    private String estadosiniestro;
    private String observacionesSiniestro;

    @ManyToOne
    @JoinColumn(name = "idPoliza")
    private poliza poliza;

    @ManyToOne
    @JoinColumn(name = "idEstadoSiniestro")
    private EstadoSiniestro estadoSiniestro;

    public int getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(int idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public String getDescripcionSiniestro() {
        return descripcionSiniestro;
    }

    public void setDescripcionSiniestro(String descripcionSiniestro) {
        this.descripcionSiniestro = descripcionSiniestro;
    }

    public Date getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(Date fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public String getEstadoSiniestro() {
        return estadosiniestro;
    }

    public void setEstadoSiniestro(String estadoSiniestro) {
        this.estadosiniestro = estadoSiniestro;
    }

    public String getObservacionesSiniestro() {
        return observacionesSiniestro;
    }

    public void setObservacionesSiniestro(String observacionesSiniestro) {
        this.observacionesSiniestro = observacionesSiniestro;
    }
}
