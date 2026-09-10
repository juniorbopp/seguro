package com.trabajotaller.seguro.entidad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class EstadoSiniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadoSiniestro;
    private String descripcion;


    public int getIdEstadoSiniestro() {
        return idEstadoSiniestro;
    }

    public void setIdEstadoSiniestro(int idEstadoSiniestro) {
        this.idEstadoSiniestro = idEstadoSiniestro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
