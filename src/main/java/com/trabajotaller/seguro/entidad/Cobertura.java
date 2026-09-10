package com.trabajotaller.seguro.entidad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cobertura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCobertura;
    private String descripcionCobertura;
    private double montoMaximo;
    private double deducible;
    private String tipoCobertura;

    
    public int getIdCobertura() {
        return idCobertura;
    }

    public void setIdCobertura(int idCobertura) {
        this.idCobertura = idCobertura;
    }

    public String getDescripcionCobertura() {
        return descripcionCobertura;
    }

    public void setDescripcionCobertura(String descripcionCobertura) {
        this.descripcionCobertura = descripcionCobertura;
    }

    public double getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(double montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

    public double getDeducible() {
        return deducible;
    }

    public void setDeducible(double deducible) {
        this.deducible = deducible;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }
}
