package com.proyecto.controller;
import com.proyecto.domain.Cita;
import com.proyecto.domain.Entrenamiento;
import com.proyecto.domain.EstadoBDD;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.CitaService;
import com.proyecto.service.EntrenamientoService;
import com.proyecto.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/citas") //Prefijo
public class CitaController {


    @Autowired
    private CitaService citaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EntrenamientoService entrenamientoService;

    @Autowired
    private EstadoService estadoService;

    @RequestMapping("/listado")
    public String index(Model model) {
        List<Cita> listaCitas = citaService.getCita();

        model.addAttribute("citas", listaCitas);
        return "/cita/listado";
    }

    @RequestMapping("/agregar")
    public String citaAgregar(Model model) {
        model.addAttribute("cita", new Cita());

        List<Usuario> listaClientes = usuarioService.getUsuarios(false);
        List<Entrenamiento> listaEntrenamientos = entrenamientoService.getEntrenamiento(false);
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();

        model.addAttribute("clientes", listaClientes);
        model.addAttribute("entrenamientos", listaEntrenamientos);
        model.addAttribute("estados", listaEstados);

        return "/cita/agregar";
    }

    @PostMapping("/guardar")
    public String citaGuardar(Cita cita) {
        citaService.save(cita);
        return "redirect:/citas/listado";
    }

    @GetMapping("/eliminar/{idCita}")
    public String clienteEliminar(Cita cita) {
        citaService.delete(cita);
        return "redirect:/citas/listado";
    }

    @GetMapping("/modificar/{idCita}")
    public String clienteModifica(Cita cita, Model model) {

        cita = citaService.getCita(cita);
        List<Usuario> listaClientes = usuarioService.getUsuarios(false);
        List<Entrenamiento> listaEntrenamientos = entrenamientoService.getEntrenamiento(false);
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();

        model.addAttribute("cita", cita);
        model.addAttribute("clientes", listaClientes);
        model.addAttribute("entrenamientos", listaEntrenamientos);
        model.addAttribute("estados", listaEstados);

        return "/cita/modifica";
    }
}
