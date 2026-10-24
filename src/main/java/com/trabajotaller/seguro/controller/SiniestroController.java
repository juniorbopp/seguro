package com.trabajotaller.seguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trabajotaller.seguro.entidad.EstadoSiniestro;
import com.trabajotaller.seguro.entidad.Siniestro;
import com.trabajotaller.seguro.entidad.poliza;
import com.trabajotaller.seguro.repositorios.polizaRepo;
import com.trabajotaller.seguro.repositorios.estadosiniestroRepo;
import com.trabajotaller.seguro.repositorios.siniestroRepo;

@Controller
public class SiniestroController {

    private final polizaRepo polizaRepository;
    private final estadosiniestroRepo estadoSiniestroRepo;
    private final siniestroRepo siniestroRepository;

    @GetMapping("/admin/siniestros")
    public String listarSiniestros(Model model) {
        model.addAttribute(
                "siniestros",
                siniestroRepository.findAll()
                        .stream()
                        .filter(Siniestro::isActivo)
                        .toList());
        return "siniestro/lista";
    }

    public SiniestroController(
            siniestroRepo siniestroRepository,
            polizaRepo polizaRepository,
            estadosiniestroRepo estadoSiniestroRepository) {
        this.siniestroRepository = siniestroRepository;
        this.polizaRepository = polizaRepository;
        this.estadoSiniestroRepo = estadoSiniestroRepository;
    }

    @GetMapping("/admin/siniestros/nuevo")
    public String nuevoSiniestro(Model model) {
        model.addAttribute("siniestro", new Siniestro());
        model.addAttribute("polizas", polizaRepository.findAll());
        model.addAttribute("estados", estadoSiniestroRepo.findAll());
        return "siniestro/formulario";
    }

    @PostMapping("/admin/siniestros/guardar")
    public String guardarSiniestro(
            @ModelAttribute("siniestro") Siniestro siniestro,
            @RequestParam("idPoliza") int idPoliza,
            @RequestParam("idEstadoSiniestro") int idEstadoSiniestro) {

        poliza polizaSeleccionada = polizaRepository.findById(idPoliza).orElse(null);
        EstadoSiniestro estadoSeleccionado = estadoSiniestroRepo.findById(idEstadoSiniestro).orElse(null);

        siniestro.setPoliza(polizaSeleccionada);
        siniestro.setEstadoSiniestroEntidad(estadoSeleccionado);

        siniestroRepository.save(siniestro);

        return "redirect:/admin/siniestros";
    }

    @GetMapping("/admin/siniestros/ver/{id}")
    public String verSiniestro(@PathVariable int id, Model model) {
        Siniestro siniestro = siniestroRepository.findById(id).orElse(null);

        if (siniestro == null) {
            return "redirect:/admin/siniestros";
        }

        model.addAttribute("siniestro", siniestro);
        return "siniestro/detalle";
    }

    @GetMapping("/admin/siniestros/editar/{id}")
    public String editarSiniestro(@PathVariable int id, Model model) {
        Siniestro siniestro = siniestroRepository.findById(id).orElse(null);

        if (siniestro == null) {
            return "redirect:/admin/siniestros";
        }

        model.addAttribute("siniestro", siniestro);
        model.addAttribute("polizas", polizaRepository.findAll());
        model.addAttribute("estados", estadoSiniestroRepo.findAll());

        return "siniestro/formulario";
    }

    @GetMapping("/admin/siniestros/archivar/{id}")
    public String archivarSiniestro(@PathVariable int id) {
        Siniestro siniestro = siniestroRepository.findById(id).orElse(null);

        if (siniestro != null) {
            siniestro.setActivo(false);
            siniestroRepository.save(siniestro);
        }

        return "redirect:/admin/siniestros";
    }
    @GetMapping("/admin/siniestros/archivados")
public String listarArchivados(Model model) {
    model.addAttribute(
        "siniestros",
        siniestroRepository.findAll()
            .stream()
            .filter(siniestro -> !siniestro.isActivo())
            .toList()
    );

    return "siniestro/archivados";
}
@GetMapping("/admin/siniestros/reanudar/{id}")
public String reanudarSiniestro(@PathVariable int id) {
    Siniestro siniestro = siniestroRepository.findById(id).orElse(null);

    if (siniestro != null) {
        siniestro.setActivo(true);
        siniestroRepository.save(siniestro);
    }

    return "redirect:/admin/siniestros/archivados";
}
}
