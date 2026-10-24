
package com.trabajotaller.seguro.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @GetMapping("/inicio")
    public String mostrarInicio(Authentication authentication, Model model) {

        boolean esAdmin = authentication.getAuthorities().stream()
                .anyMatch(autoridad -> autoridad.getAuthority().equals("ROLE_ADMIN"));

        if (esAdmin) {
            return "admin";
        }

        model.addAttribute("correo", authentication.getName());
        model.addAttribute("esAdmin", false);

        return "inicio";
    }
}
