package com.trabajotaller.seguro.controller;

import com.trabajotaller.seguro.repositorios.siniestroRepo;
import com.trabajotaller.seguro.entidad.Usuario;
import com.trabajotaller.seguro.repositorios.usuarioRepo;
import com.trabajotaller.seguro.repositorios.polizaRepo;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientePortalController {

    private final usuarioRepo usuarioRepository;
    private final siniestroRepo siniestroRepository;
    private final polizaRepo polizaRepository;

    public ClientePortalController(
            usuarioRepo usuarioRepository,
            polizaRepo polizaRepository,
            siniestroRepo siniestroRepository) {

        this.usuarioRepository = usuarioRepository;
        this.polizaRepository = polizaRepository;
        this.siniestroRepository = siniestroRepository;
    }

    @GetMapping("/cliente/polizas")
    public String misPolizas(Authentication authentication, Model model) {

        Usuario usuario = usuarioRepository
                .findByCorreo(authentication.getName())
                .orElseThrow();

        if (usuario.getCliente() == null) {
            model.addAttribute("error",
                    "Esta cuenta todavía no está vinculada a un cliente.");
            return "cliente/error";
        }

        model.addAttribute("polizas",
                polizaRepository.findByCliente_IdCliente(
                        usuario.getCliente().getIdCliente()));

        return "cliente/polizas";
    }

    @GetMapping("/cliente/siniestros")
    public String misSiniestros(Authentication authentication, Model model) {

        Usuario usuario = usuarioRepository
                .findByCorreo(authentication.getName())
                .orElseThrow();

        if (usuario.getCliente() == null) {
            model.addAttribute("error",
                    "Esta cuenta todavía no está vinculada a un cliente.");
            return "cliente/error";
        }

        model.addAttribute("siniestros",
                siniestroRepository.findByPoliza_Cliente_IdCliente(
                        usuario.getCliente().getIdCliente()));

        return "cliente/siniestros";
    }

}
