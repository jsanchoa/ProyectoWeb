package com.proyecto.controller;

import com.proyecto.domain.Usuario;
import com.proyecto.service.AccesoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acceso")
public class AccesoController {

    @Autowired
    private AccesoService accesoService;

    // al hacer clic desde la navbar
    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        model.addAttribute("mensaje", "Realiza una búsqueda para verificar acceso");
        return "acceso/listado";
    }

    @GetMapping("/verificar")
    public String verificarAcceso(String nombreCliente, Model model) {
    List<Usuario> usuarios = accesoService.buscarClientesPorNombre(nombreCliente, 1);

    if (usuarios.isEmpty()) {
        model.addAttribute("mensaje", "No se encontró ningún cliente con ese nombre.");
    } else if (usuarios.size() == 1) {

        Long id = usuarios.get(0).getIdUsuario();
        return "redirect:/acceso/detalle?idUsuario=" + id;
    } else {
        model.addAttribute("usuarios", usuarios);
    }

    return "acceso/listado";
  }
    
    @GetMapping("/detalle")
public String detalleAcceso(Long idUsuario, Model model) {
    Usuario usuario = accesoService.buscarClientePorId(idUsuario);

    if (usuario == null) {
        model.addAttribute("mensaje", "Usuario no encontrado.");
        return "acceso/listado";
    }

    String tipoMembresia = usuario.getMembresia().getTipoMembresia().getNombre();
    String estadoMembresia = usuario.getMembresia().getEstadoMembresia().getNombre();

    model.addAttribute("nombre", usuario.getNombre() + " " + usuario.getApellido());
    model.addAttribute("tipo", tipoMembresia);
    model.addAttribute("estado", estadoMembresia);

    if ("Inactiva".equalsIgnoreCase(estadoMembresia)) {
        model.addAttribute("redirigir", "/clientes/modificar/" + usuario.getIdUsuario());
    }

    return "acceso/listado";
}
}