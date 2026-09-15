package com.senai.backend.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.models.Funcionario;
import com.senai.backend.rental_eventos.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    public Funcionario buscarFuncionario(Integer id) {
        return funcionarioRepository.findById(id).get();
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Boolean deletarFuncionario(Integer id) {

        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Integer id, Funcionario funcionario) {

        if (funcionarioRepository.existsById(id)) {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }

        return null;
    }
}