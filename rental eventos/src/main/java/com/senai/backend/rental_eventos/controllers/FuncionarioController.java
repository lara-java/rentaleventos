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

import com.senai.backend.rental_eventos.models.Funcionario;
import com.senai.backend.rental_eventos.services.FuncionarioService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping("/buscar/{id}")
    public Funcionario buscarFuncionario(@PathVariable Integer id) {
        return funcionarioService.buscarFuncionario(id);
    }

    @GetMapping("/listar")
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Integer id) {

        if (funcionarioService.deletarFuncionario(id)) {
            return "Funcionário removido com sucesso.";
        }

        return "Falha ao remover o funcionário.";
    }

    @PostMapping("/salvar")
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.cadastrarFuncionario(funcionario);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarFuncionario(
            @PathVariable Integer id,
            @RequestBody Funcionario funcionario) {

        if (funcionarioService.atualizarFuncionario(id, funcionario) != null) {
            return "Funcionário atualizado com sucesso.";
        }

        return "Falha ao atualizar o funcionário.";
    }
}