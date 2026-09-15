package com.senai.backend.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.models.Historico;
import com.senai.backend.rental_eventos.repositories.HistoricoRepository;

@Service
public class HistoricoService {
    
    @Autowired
    private HistoricoRepository historicoRepository;

    public Historico buscarHistorico(Integer id) {
        return historicoRepository.findById(id).get();
    }

    public List<Historico> listarHistoricos() {
        return historicoRepository.findAll();
    }

    public Boolean deletarHistorico(Integer id) {

        if (historicoRepository.existsById(id)) {
            historicoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Historico cadastrarHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    public Historico atualizarHistorico(Integer id, Historico historico) {

        if (historicoRepository.existsById(id)) {
            historico.setId(id);
            return historicoRepository.save(historico);
        }

        return null;
    }
}
