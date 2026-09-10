package com.trabajotaller.seguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.trabajotaller.seguro.entidad.poliza;
import com.trabajotaller.seguro.repositorios.clienteRepo;
import com.trabajotaller.seguro.repositorios.polizaRepo;

@Controller
public class PolizaController {
    private polizaRepo polizaRepository;
    private clienteRepo clienteRepository;

    public PolizaController(polizaRepo polizaRepository, clienteRepo clienteRepository) {
        this.polizaRepository = polizaRepository;
        this.clienteRepository = clienteRepository;

    }

    @GetMapping("/admin/polizas")
    public String listarPolizas(Model model) {

        model.addAttribute("polizas", polizaRepository.findAll());

        return "poliza/lista";
    }

    @GetMapping("/admin/polizas/nuevo")
    public String nuevaPoliza(Model model) {

        model.addAttribute("poliza", new poliza());
        model.addAttribute("clientes", clienteRepository.findAll());

        return "poliza/formulario";
    }

    @PostMapping("/admin/polizas/guardar")
public String guardarPoliza(@ModelAttribute("Poliza")poliza poliza) {

    polizaRepository.save(poliza);

    return "redirect:/admin/polizas";
}
}
