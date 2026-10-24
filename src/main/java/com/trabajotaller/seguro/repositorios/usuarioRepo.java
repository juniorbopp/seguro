package com.trabajotaller.seguro.repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.Usuario;

public interface usuarioRepo extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);
}
