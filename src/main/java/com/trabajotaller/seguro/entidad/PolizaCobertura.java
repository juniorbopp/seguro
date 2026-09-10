package com.trabajotaller.seguro.entidad;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class PolizaCobertura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPolizaCobertura;
    private String condiciones;
    private BigDecimal prima;
    private BigDecimal sumaAsegurada;
    private BigDecimal deducible;

    @ManyToOne
    @JoinColumn(name = "idPoliza")
    private poliza poliza;

    @ManyToOne
    @JoinColumn(name = "idCobertura")
    private Cobertura cobertura;

    public int getIdPolizaCobertura() {
        return idPolizaCobertura;
    }

    public void setIdPolizaCobertura(int idPolizaCobertura) {
        this.idPolizaCobertura = idPolizaCobertura;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public BigDecimal getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(BigDecimal sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public BigDecimal getDeducible() {
        return deducible;
    }

    public void setDeducible(BigDecimal deducible) {
        this.deducible = deducible;
    }
}
