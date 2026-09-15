package com.senai.backend.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.models.Equipamentos;
import com.senai.backend.rental_eventos.repositories.EquipamentosRepository;

@Service
public class EquipamentosService {
    
    @Autowired
    private EquipamentosRepository equipamentosRepository;

    public Equipamentos buscarEquipamento(Integer id) {
        return equipamentosRepository.findById(id).get();
    }

    public List<Equipamentos> listarEquipamentos() {
        return equipamentosRepository.findAll();
    }

    public Boolean deletarEquipamento(Integer id) {

        if (equipamentosRepository.existsById(id)) {
            equipamentosRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Equipamentos cadastrarEquipamento(Equipamentos equipamento) {
        return equipamentosRepository.save(equipamento);
    }

    public Equipamentos atualizarEquipamento(Integer id, Equipamentos equipamento) {

        if (equipamentosRepository.existsById(id)) {
            equipamento.setId(id);
            return equipamentosRepository.save(equipamento);
        }

        return null;
    }
}
