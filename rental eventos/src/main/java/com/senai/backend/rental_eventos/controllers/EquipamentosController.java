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

import com.senai.backend.rental_eventos.models.Equipamentos;
import com.senai.backend.rental_eventos.services.EquipamentosService;


@RestController
@RequestMapping("/equipamentos")
public class EquipamentosController {

    @Autowired
    private EquipamentosService equipamentosService;


    @GetMapping("/buscar/{id}")
    public Equipamentos buscarEquipamento(@PathVariable Integer id) {
        return equipamentosService.buscarEquipamento(id);
    }

    @GetMapping("/listar")
    public List<Equipamentos> listarEquipamentos() {
        return equipamentosService.listarEquipamentos();
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarEquipamento(@PathVariable Integer id) {

        if (equipamentosService.deletarEquipamento(id)) {
            return "Equipamento removido com sucesso.";
        }

        return "Falha ao remover o equipamento.";
    }

    @PostMapping("/salvar")
    public Equipamentos cadastrarEquipamento(
            @RequestBody Equipamentos equipamento) {

        return equipamentosService.cadastrarEquipamento(equipamento);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarEquipamento(
            @PathVariable Integer id,
            @RequestBody Equipamentos equipamento) {

        if (equipamentosService.atualizarEquipamento(id, equipamento) != null) {
            return "Equipamento atualizado com sucesso.";
        }

        return "Falha ao atualizar o equipamento.";
    }
}