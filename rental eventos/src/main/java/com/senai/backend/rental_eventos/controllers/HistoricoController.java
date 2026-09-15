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

import com.senai.backend.rental_eventos.models.Historico;
import com.senai.backend.rental_eventos.services.HistoricoService;


@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;


    @GetMapping("/buscar/{id}")
    public Historico buscarHistorico(@PathVariable Integer id) {
        
        return historicoService.buscarHistorico(id);
    }

    @GetMapping("/listar")
    public List<Historico> listarHistoricos() {
        return historicoService.listarHistoricos();
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarHistorico(@PathVariable Integer id) {

        if (historicoService.deletarHistorico(id)) {
            return "Histórico removido com sucesso.";
        }

        return "Falha ao remover o histórico.";
    }

    @PostMapping("/salvar")
    public Historico cadastrarHistorico(@RequestBody Historico historico) {
        return historicoService.cadastrarHistorico(historico);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarHistorico(
            @PathVariable Integer id,
            @RequestBody Historico historico) {

        if (historicoService.atualizarHistorico(id, historico) != null) {
            return "Histórico atualizado com sucesso.";
        }

        return "Falha ao atualizar o histórico.";
    }
}