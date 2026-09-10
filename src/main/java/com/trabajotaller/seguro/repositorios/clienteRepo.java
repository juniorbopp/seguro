package com.trabajotaller.seguro.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.Cliente;
public interface clienteRepo extends JpaRepository<Cliente, Integer> {

}