package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.DocumentoSiniestro;
public interface documentosiniestroRepo extends JpaRepository<DocumentoSiniestro, Integer> {
    
}
