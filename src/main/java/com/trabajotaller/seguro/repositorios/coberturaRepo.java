package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.Cobertura;
public interface coberturaRepo extends JpaRepository<Cobertura, Integer> {
    
}
