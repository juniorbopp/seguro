package com.trabajotaller.seguro.entidad;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class DocumentoSiniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumentoSiniestro;
    private String tipoDocumento;
    private String nombreDocumento;
    private String rutaDocumento;
    private String fechaCarga;

    @ManyToOne
    @JoinColumn(name = "idSiniestro")
    private Siniestro siniestro;

    public int getIdDocumentoSiniestro() {
        return idDocumentoSiniestro;
    }

    public void setIdDocumentoSiniestro(int idDocumentoSiniestro) {
        this.idDocumentoSiniestro = idDocumentoSiniestro;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getRutaDocumento() {
        return rutaDocumento;
    }

    public void setRutaDocumento(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public String getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(String fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
}
