package com.proyecto.controller;

import com.proyecto.dao.EstadoMembresiaDao;
import com.proyecto.domain.*;
import com.proyecto.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/clientes") //Prefijo
public class ClienteController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoMembresiaService tipoMembresiaService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MembresiaService membresiaService;

    @Autowired
    private EstadoMembresiaDao estadoMembresiaDao;
    
    @RequestMapping("/listado")
    public String index(Model model) {
        List<Usuario> listaClientes = usuarioService.findByTipoUsuario_IdTipoUsuario(1);

        model.addAttribute("clientes", listaClientes);
        return "/cliente/listado";
    }
    
    @RequestMapping("/agregar")
    public String clienteAgregar(Model model) {
        Usuario cliente = new Usuario();
        TipoUsuario tipoUsuario = new TipoUsuario();

        tipoUsuario.setIdTipoUsuario(1L);
        cliente.setTipoUsuario(tipoUsuario);
        model.addAttribute("cliente", cliente);

        List<TipoMembresia> listaTiposMembresias = tipoMembresiaService.getTipoMembresia();
        List<EstadoBDD> listaEstados = estadoService.getListaEstados();

        model.addAttribute("estados", listaEstados);
        model.addAttribute("membresias", listaTiposMembresias);

        return "/cliente/agregar";
    }
    
    @PostMapping("/guardar")
    public String clienteGuardar(Usuario usuario) {

        membresiaService.save(usuario.getMembresia());  // Guarda la membresía

        if (usuario.getMembresia().getFechaInicio() == null && usuario.getMembresia().getFechaFinal() == null) {
            int cantidadDias = usuario.getMembresia().getTipoMembresia().getCantidadDias();

            LocalDate hoy = LocalDate.now();
            LocalDate fechaFin = hoy.plusDays(cantidadDias);

            usuario.getMembresia().setFechaInicio(hoy);
            usuario.getMembresia().setFechaFinal(fechaFin);

            EstadoMembresia estadoMembresia = estadoMembresiaDao.findByidEstadoMembresia(1);

            usuario.getMembresia().setEstadoMembresia(estadoMembresia);

            EstadoBDD estado = estadoService.getEstadoBDD(1);

            usuario.getMembresia().setEstadoBDD(estado);

        }

        usuarioService.save(usuario);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String clienteEliminar(Usuario usuario) {

        usuarioService.delete(usuario);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String clienteModifica(Usuario usuario, Model model) {

        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("membresias", membresiaService.getListaMembresias());
        model.addAttribute("estados", estadoService.getListaEstados());
        model.addAttribute("cliente", usuario);

        return "/cliente/modifica";
    }
}
