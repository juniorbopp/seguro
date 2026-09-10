package com.trabajotaller.seguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.trabajotaller.seguro.entidad.Cliente;
import com.trabajotaller.seguro.repositorios.clienteRepo;

@Controller
public class ClienteController {
    private clienteRepo clienteRepository;

    public ClienteController(clienteRepo clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    @GetMapping("/admin/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "cliente/lista";
    }

    @GetMapping("/admin/clientes/nuevo")
    public String nuevoCliente(Model model) {

        model.addAttribute("cliente", new Cliente());

        return "cliente/formulario";
    }

    @PostMapping("/admin/clientes/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {

        clienteRepository.save(cliente);

        return "redirect:/admin/clientes";
    }

    @GetMapping("/admin/clientes/ver/{id}")
    public String verCliente(@PathVariable Integer id, Model model) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        model.addAttribute("cliente", cliente);

        return "cliente/detalle";
    }

    @GetMapping("/admin/clientes/editar/{id}")
    public String editarCliente(@PathVariable Integer id, Model model) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        model.addAttribute("cliente", cliente);

        return "cliente/formulario";
    }

    @GetMapping("/admin/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {

        clienteRepository.deleteById(id);

        return "redirect:/admin/clientes";
    }
}
