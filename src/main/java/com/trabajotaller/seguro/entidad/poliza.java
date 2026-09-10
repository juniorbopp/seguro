package com.trabajotaller.seguro.entidad;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPoliza;
    private String numeroPoliza;
    private String tipoCobertura;
    private Date fechaInicio;
    private Date fechaFin;
    private double montoAsegurado;
    private double prima;
    private String estado;
    private String condicioneGenerales;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public int getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(int idPoliza) {
        this.idPoliza = idPoliza;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicioneGenerales() {
        return condicioneGenerales;
    }

    public void setCondicioneGenerales(String condicioneGenerales) {
        this.condicioneGenerales = condicioneGenerales;
    }
}
