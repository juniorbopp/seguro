
package com.trabajotaller.seguro.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.poliza;

public interface polizaRepo extends JpaRepository<poliza, Integer> {

    List<poliza> findByCliente_IdCliente(int idCliente);

}