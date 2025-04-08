package com.proyecto.controller;

import com.proyecto.dao.EstadoInvDao;
import com.proyecto.dao.RutinaDao;
import com.proyecto.domain.*;
import com.proyecto.service.*;
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

    @Autowired
    private TipoRutinaService tipoRutinaService;

    @Autowired
    private HorariosService horariosService;

    @Autowired
    private EstadoInvService estadoInvService;

    @RequestMapping("/listado")
    public String listarEntrenamientos(Model model) {
        List<Entrenamiento> listaEntrenamientos = entrenamientoService.getEntrenamiento(false);
        model.addAttribute("entrenamientos", listaEntrenamientos);
        return "entrenamiento/listado";
    }

    @RequestMapping("/agregar")
    public String agregarEntrenamiento(Model model) {
        model.addAttribute("entrenamiento", new Entrenamiento());

        List<TipoRutina> listaRutinas = tipoRutinaService.getTipoRutina();
        List<Usuario> listaEntrenadores = usuarioService.findByTipoUsuario_IdTipoUsuario(2);
        List<Horario> listaHorarios = horariosService.getListaHorarios();
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();
        List<EstadoInventario> listaEstadosInventario = estadoInvService.getListaEstadosInventario();


        model.addAttribute("rutinas", listaRutinas);
        model.addAttribute("horarios", listaHorarios);
        model.addAttribute("entrenadores", listaEntrenadores);
        model.addAttribute("estados", listaEstados);
        model.addAttribute("estadosInv", listaEstadosInventario);

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

        List<EstadoBDD> listaEstados = estadoService.getListaEstados();
        List<TipoRutina> listaRutinas = tipoRutinaService.getTipoRutina();
        List<Usuario> listaEntrenadores = usuarioService.findByTipoUsuario_IdTipoUsuario(2);
        List<Horario> listaHorarios = horariosService.getListaHorarios();
        List<EstadoInventario> listaEstadosInventario = estadoInvService.getListaEstadosInventario();

        model.addAttribute("horarios", listaHorarios);
        model.addAttribute("estadosInv", listaEstadosInventario);
        model.addAttribute("entrenadores", listaEntrenadores);
        model.addAttribute("estados", listaEstados);
        model.addAttribute("rutinas", listaRutinas);
        model.addAttribute("entrenamiento", entrenamiento);

        return "entrenamiento/modifica";
    }
}