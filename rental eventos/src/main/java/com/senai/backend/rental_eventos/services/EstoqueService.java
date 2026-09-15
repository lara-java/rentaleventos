package com.senai.backend.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.models.Estoque;
import com.senai.backend.rental_eventos.repositories.EstoqueRepository;

@Service
public class EstoqueService {
    
    @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque buscarEstoque(Integer id) {
        return estoqueRepository.findById(id).get();
    }

    public List<Estoque> listarEstoques() {
        return estoqueRepository.findAll();
    }

    public Boolean deletarEstoque(Integer id) {

        if (estoqueRepository.existsById(id)) {
            estoqueRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Estoque cadastrarEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public Estoque atualizarEstoque(Integer id, Estoque estoque) {

        if (estoqueRepository.existsById(id)) {
            estoque.setId(id);
            return estoqueRepository.save(estoque);
        }

        return null;
    }
}


