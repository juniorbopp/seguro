package com.trabajotaller.seguro.entidad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Riesgo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRiesgo;
    private String seccionRiesgo;
    private String descripcionRiesgo;
    private String tipoRiesgo;

    public int getIdRiesgo() {
        return idRiesgo;
    }

    public void setIdRiesgo(int idRiesgo) {
        this.idRiesgo = idRiesgo;
    }

    public String getSeccionRiesgo() {
        return seccionRiesgo;
    }

    public void setSeccionRiesgo(String seccionRiesgo) {
        this.seccionRiesgo = seccionRiesgo;
    }

    public String getDescripcionRiesgo() {
        return descripcionRiesgo;
    }

    public void setDescripcionRiesgo(String descripcionRiesgo) {
        this.descripcionRiesgo = descripcionRiesgo;
    }

    public String getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(String tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }
}
