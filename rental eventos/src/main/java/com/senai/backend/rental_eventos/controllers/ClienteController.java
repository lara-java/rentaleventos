package com.senai.backend.rental_eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.rental_eventos.models.Cliente;
import com.senai.backend.rental_eventos.services.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/buscar/{id}")
    public Cliente buscarCliente(@PathVariable Integer id) {
        return clienteService.buscarCliente(id);
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Integer id) {

        if (clienteService.deletarCliente(id)) {
            return "Cliente removido com sucesso.";
        }

        return "Falha ao remover o cliente.";
    }

    @PostMapping("/salvar-cliente")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

    @PutMapping("/atualizar-cliente/{id}")
    public String atualizarCliente(
            @PathVariable Integer id,
            @RequestBody Cliente cliente) {

        if (clienteService.atualizarCliente(id, cliente) != null) {
            return "Cliente atualizado com sucesso.";
        }

        return "Falha ao atualizar o cliente.";
    }
}