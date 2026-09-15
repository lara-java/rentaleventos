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

import com.senai.backend.rental_eventos.models.Alerta;
import com.senai.backend.rental_eventos.services.AlertaService;


@RestController
@RequestMapping("/alerta")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;


    @GetMapping("/buscar-alerta/{id}")
    public Alerta buscarAlerta(@PathVariable Integer id) {
        return alertaService.buscarAlerta(id);
    }

    @GetMapping("/listar-alertas")
    public List<Alerta> listarAlertas() {
        return alertaService.listarAlertas();
    }

    @DeleteMapping("/deletar-alerta/{id}")
    public String deletarAlerta(@PathVariable Integer id) {

        if (alertaService.deletarAlerta(id)) {
            return "Alerta removido com sucesso.";
        }

        return "Falha ao remover alerta.";
    }

    @PostMapping("/salvar-alerta")
    public Alerta salvarAlerta(@RequestBody Alerta alerta) {
        return alertaService.cadastrarAlerta(alerta);
    }

    @PutMapping("/atualizar-alerta/{id}")
    public String atualizarAlerta(
            @PathVariable Integer id,
            @RequestBody Alerta alerta) {

        if (alertaService.atualizarAlerta(id, alerta) != null) {
            return "Alerta atualizado com sucesso.";
        }

        return "Falha ao atualizar alerta.";
    }
}