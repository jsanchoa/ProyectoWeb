package com.proyecto.controller;

import com.proyecto.domain.Cliente;
import com.proyecto.domain.EstadoMembresia;
import com.proyecto.domain.Membresia;
import com.proyecto.domain.Estado;
import com.proyecto.service.ClienteService;
import com.proyecto.service.MembresiaService;
import com.proyecto.service.EstadoMembresiaService;
import com.proyecto.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/clientes") //Prefijo
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MembresiaService membresiaService;
    
    @Autowired
    private EstadoMembresiaService estadoMembresiaService;

    @Autowired
    private EstadoService estadoService;
    
    @RequestMapping("/listado")
    public String index(Model model) {
        List<Cliente> listaClientes = clienteService.getCliente();

        model.addAttribute("clientes", listaClientes);
        return "/cliente/listado";
    }
    
    @RequestMapping("/agregar")
    public String clienteAgregar(Model model) {
        model.addAttribute("cliente", new Cliente());
        List<Membresia> listaMembresias = membresiaService.getListaMembresias();
        List<EstadoMembresia> listaEstadoMembresias = estadoMembresiaService.getListaEstadoMembresias();
        List<Estado> listaEstados = estadoService.getListaEstados();
    
        model.addAttribute("membresias", listaMembresias);
        model.addAttribute("estadoMembresias", listaEstadoMembresias);
        model.addAttribute("estados", listaEstados);

        return "/cliente/agregar";
    }
    
    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModifica(Cliente cliente, Model model) {

        //Necesito enviarle tanto los estados/membresias/estados de membresias
        cliente = clienteService.getCliente(cliente);
        List<Membresia> listaMembresias = membresiaService.getListaMembresias();
        List<EstadoMembresia> listaEstadoMembresias = estadoMembresiaService.getListaEstadoMembresias();
        List<Estado> listaEstados = estadoService.getListaEstados();
        model.addAttribute("membresias", listaMembresias);
        model.addAttribute("estadoMembresias", listaEstadoMembresias);
        model.addAttribute("cliente", cliente);

        return "/cliente/modifica";
    }
}
