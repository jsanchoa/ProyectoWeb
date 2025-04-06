package com.proyecto.controller;


import com.proyecto.dao.TipoUsuarioDao;
import com.proyecto.dao.UsuarioDao;
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
@RequestMapping("/entrenadores") //Prefijo
public class EntrenadorController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private RolService rolService;

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    private MembresiaService membresiaService;


    @RequestMapping("/listado")
    public String index(Model model) {
        List<Usuario> listaEntrenadores = usuarioService.findByTipoUsuario_IdTipoUsuario(2);
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();

        model.addAttribute("estados", listaEstados);
        model.addAttribute("entrenadores", listaEntrenadores);
        return "/entrenador/listado";
    }

    @RequestMapping("/agregar")
    public String entrenadorAgregar(Model model) {

        List<EstadoBDD> listaEstados = estadoService.getListaEstados();
        model.addAttribute("estados", listaEstados);

        Usuario entrenador = new Usuario();

        Rol rol = rolService.findByidRol(2);

        TipoUsuario tipoUsuario = tipoUsuarioService.findByidTipoUsuario(2);

        entrenador.setTipoUsuario(tipoUsuario);
        entrenador.setRol(rol);

        model.addAttribute("entrenador", entrenador);


        return "/entrenador/agregar";
    }

    @PostMapping("/guardar")
    public String entrenadorGuardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/entrenadores/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String entrenadorEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/entrenadores/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String entrenadorModifica(Usuario usuario, Model model) {

        //Necesito enviarle tanto los estados/especialidades
        usuario = usuarioService.getUsuario(usuario);
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();

        model.addAttribute("estados", listaEstados);
        model.addAttribute("entrenador", usuario);

        return "/entrenador/modifica";
    }

}
