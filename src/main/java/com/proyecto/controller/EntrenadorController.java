package com.proyecto.controller;


import com.proyecto.domain.Entrenador;
import com.proyecto.domain.Especialidad;
import com.proyecto.domain.Estado;
import com.proyecto.service.ClienteService;
import com.proyecto.service.EntrenadorService;
import com.proyecto.service.EspecialidadService;
import com.proyecto.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/entrenadores") //Prefijo
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private EstadoService estadoService;

    @RequestMapping("/listado")
    public String index(Model model) {
        List<Entrenador> listaEntrenadores = entrenadorService.getEntrenador(false);

        model.addAttribute("entrenadores", listaEntrenadores);
        return "/entrenador/listado";
    }

    @RequestMapping("/agregar")
    public String entrenadorAgregar(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        List<Especialidad> listaEspecialidades = especialidadService.getListaEspecialidades();
        List<Estado> listaEstados = estadoService.getListaEstados();
        model.addAttribute("especialidades", listaEspecialidades);
        model.addAttribute("estados", listaEstados);

        return "/entrenador/agregar";
    }

    @PostMapping("/guardar")
    public String entrenadorGuardar(Entrenador entrenador) {
        entrenadorService.save(entrenador);
        return "redirect:/entrenadores/listado";
    }

    @GetMapping("/eliminar/{idEntrenador}")
    public String entrenadorEliminar(Entrenador entrenador) {
        entrenadorService.delete(entrenador);
        return "redirect:/entrenadores/listado";
    }

    @GetMapping("/modificar/{idEntrenador}")
    public String entrenadorModifica(Entrenador entrenador, Model model) {

        //Necesito enviarle tanto los estados/especialidades
        entrenador = entrenadorService.getEntrenador(entrenador);
        List<Especialidad> listaEspecialidades = especialidadService.getListaEspecialidades();
        List<Estado> listaEstados = estadoService.getListaEstados();

        model.addAttribute("especialidades", listaEspecialidades);
        model.addAttribute("estados", listaEstados);
        model.addAttribute("entrenador", entrenador);

        return "/entrenador/modifica";
    }

}
