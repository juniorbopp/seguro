
package com.trabajotaller.seguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trabajotaller.seguro.entidad.Usuario;
import com.trabajotaller.seguro.repositorios.usuarioRepo;

@Controller
public class UsuarioController {

    private final usuarioRepo usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(usuarioRepo usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuario/lista";
    }

    @GetMapping("/admin/usuarios/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formulario";
    }

    @PostMapping("/admin/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario,
            Model model) {

        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            model.addAttribute("error", "Ya existe un usuario registrado con ese correo.");
            return "usuario/formulario";
        }

        usuario.setContrasena(
                passwordEncoder.encode(usuario.getContrasena()));

        usuarioRepository.save(usuario);

        return "redirect:/admin/usuarios";
    }
}
