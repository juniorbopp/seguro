package com.trabajotaller.seguro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.EstadoSiniestro;

public interface estadosiniestroRepo extends JpaRepository<EstadoSiniestro, Integer> {
    
}
