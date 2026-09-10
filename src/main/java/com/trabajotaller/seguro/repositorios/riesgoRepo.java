package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.Riesgo;
public interface riesgoRepo extends JpaRepository<Riesgo, Integer> {
    
}
