package com.trabajotaller.seguro.entidad;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;

@Entity
public class DetalleSiniestro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleSiniestro;
    private String descripcionDetalleSiniestro;
    private BigDecimal montoReclamado;
    private BigDecimal montoAprobado;


    @ManyToOne
    @JoinColumn(name = "idSiniestro")
    private Siniestro siniestro;

    @ManyToOne
    @JoinColumn(name = "idPolizaCobertura")
    private PolizaCobertura polizaCobertura;

    public int getIdDetalleSiniestro() {
        return idDetalleSiniestro;
    }

    public void setIdDetalleSiniestro(int idDetalleSiniestro) {
        this.idDetalleSiniestro = idDetalleSiniestro;
    }

    public String getDescripcionDetalleSiniestro() {
        return descripcionDetalleSiniestro;
    }

    public void setDescripcionDetalleSiniestro(String descripcionDetalleSiniestro) {
        this.descripcionDetalleSiniestro = descripcionDetalleSiniestro;
    }

    public BigDecimal getMontoReclamado() {
        return montoReclamado;
    }

    public void setMontoReclamado(BigDecimal montoReclamado) {
        this.montoReclamado = montoReclamado;
    }

    public BigDecimal getMontoAprobado() {
        return montoAprobado;
    }

    public void setMontoAprobado(BigDecimal montoAprobado) {
        this.montoAprobado = montoAprobado;
    }
}