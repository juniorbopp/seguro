package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trabajotaller.seguro.entidad.Siniestro;

public interface siniestroRepo extends JpaRepository<Siniestro, Integer> {
    
}
