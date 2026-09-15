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

import com.senai.backend.rental_eventos.models.Movimentacao;
import com.senai.backend.rental_eventos.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/buscar{id}")
    public Movimentacao buscarMovimentacao(@PathVariable Integer id) {
        return movimentacaoService.buscarMovimentacao(id);
    }

    @GetMapping("/listar")
    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoService.listarMovimentacoes();
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarMovimentacao(@PathVariable Integer id) {

        if (movimentacaoService.deletarMovimentacao(id)) {
            return "Movimentação removida com sucesso.";
        }

        return "Falha ao remover a movimentação.";
    }

    @PostMapping("/salvar")
    public Movimentacao cadastrarMovimentacao(
            @RequestBody Movimentacao movimentacao) {

        return movimentacaoService.cadastrarMovimentacao(movimentacao);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarMovimentacao(
            @PathVariable Integer id,
            @RequestBody Movimentacao movimentacao) {

        if (movimentacaoService.atualizarMovimentacao(id, movimentacao) != null) {
            return "Movimentação atualizada com sucesso.";
        }

        return "Falha ao atualizar a movimentação.";
    }
}