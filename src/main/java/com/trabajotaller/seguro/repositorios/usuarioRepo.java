package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.Usuario;
public interface usuarioRepo extends JpaRepository<Usuario, Integer> {
    
}
