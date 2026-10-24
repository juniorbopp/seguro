
package com.trabajotaller.seguro.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajotaller.seguro.entidad.Siniestro;

public interface siniestroRepo extends JpaRepository<Siniestro, Integer> {

    List<Siniestro> findByPoliza_Cliente_IdCliente(int idCliente);

}
