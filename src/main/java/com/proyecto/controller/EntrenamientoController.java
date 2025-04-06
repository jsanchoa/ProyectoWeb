package com.proyecto.controller;

import com.proyecto.domain.Entrenamiento;
import com.proyecto.domain.EstadoBDD;
import com.proyecto.domain.Usuario;
import com.proyecto.service.EntrenamientoService;
import com.proyecto.service.EstadoService;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/entrenamientos") // Prefijo
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/listado")
    public String listarEntrenamientos(Model model) {
        List<Entrenamiento> listaEntrenamientos = entrenamientoService.getEntrenamiento(false);
        model.addAttribute("entrenamientos", listaEntrenamientos);
        return "entrenamiento/listado";
    }

    @RequestMapping("/agregar")
    public String agregarEntrenamiento(Model model) {
        model.addAttribute("entrenamiento", new Entrenamiento());

        List<Usuario> listaEntrenadores = usuarioService.getUsuarios(false);
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();

        model.addAttribute("entrenadores", listaEntrenadores);
        model.addAttribute("estados", listaEstados);

        return "entrenamiento/agregar";
    }

    @PostMapping("/guardar")
    public String guardarEntrenamiento(Entrenamiento entrenamiento) {
        entrenamientoService.save(entrenamiento);
        return "redirect:/entrenamientos/listado";
    }

    @GetMapping("/eliminar/{idEntrenamiento}")
    public String eliminarEntrenamiento(Entrenamiento entrenamiento) {
        entrenamientoService.delete(entrenamiento);
        return "redirect:/entrenamientos/listado";
    }

    @GetMapping("/modificar/{idEntrenamiento}")
    public String modificarEntrenamiento(Entrenamiento entrenamiento, Model model) {
        entrenamiento = entrenamientoService.getEntrenamiento(entrenamiento);

        List<Usuario> listaEntrenadores = usuarioService.getUsuarios(false);
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();

        model.addAttribute("entrenadores", listaEntrenadores);
        model.addAttribute("estados", listaEstados);
        model.addAttribute("entrenamiento", entrenamiento);

        return "entrenamiento/modifica";
    }
}