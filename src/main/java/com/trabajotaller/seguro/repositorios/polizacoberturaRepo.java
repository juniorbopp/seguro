package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.PolizaCobertura;
public interface polizacoberturaRepo extends JpaRepository<PolizaCobertura, Integer> {
    
}
