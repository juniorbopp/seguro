package com.trabajotaller.seguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.trabajotaller.seguro.entidad.EstadoSiniestro;
import com.trabajotaller.seguro.repositorios.estadosiniestroRepo;

@Controller
public class EstadoSiniestroController {

    private final estadosiniestroRepo estadoRepository;

    public EstadoSiniestroController(estadosiniestroRepo estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @GetMapping("/admin/estados-siniestro")
    public String listarEstados(Model model) {
        model.addAttribute("estados", estadoRepository.findAll());
        return "estado-siniestro/lista";
    }

    @GetMapping("/admin/estados-siniestro/nuevo")
    public String nuevoEstado(Model model) {
        model.addAttribute("estado", new EstadoSiniestro());
        return "estado-siniestro/formulario";
    }

    @PostMapping("/admin/estados-siniestro/guardar")
    public String guardarEstado(@ModelAttribute("estado") EstadoSiniestro estado) {
        estadoRepository.save(estado);
        return "redirect:/admin/estados-siniestro";
    }
}

