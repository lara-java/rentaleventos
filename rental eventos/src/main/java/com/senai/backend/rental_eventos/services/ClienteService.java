package com.senai.backend.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.models.Cliente;
import com.senai.backend.rental_eventos.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository; 


    public Cliente buscarCliente(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Boolean deletarCliente(Integer id) {

        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Integer id, Cliente cliente) {

        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }

        return null;
    }
}