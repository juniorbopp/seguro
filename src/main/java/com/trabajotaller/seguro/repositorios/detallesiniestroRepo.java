package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.DetalleSiniestro;
public interface detallesiniestroRepo extends JpaRepository<DetalleSiniestro, Integer> {
    
}
