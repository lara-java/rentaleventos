package com.senai.backend.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.models.Alerta;
import com.senai.backend.rental_eventos.repositories.AlertaRepository;

@Service
public class AlertaService {
    
    @Autowired
    private AlertaRepository alertaRepository;


    public Alerta buscarAlerta(Integer id) {
        return alertaRepository.findById(id).get();
    }

    public List<Alerta> listarAlertas() {
        return alertaRepository.findAll();
    }

    public Boolean deletarAlerta(Integer id) {

        if (alertaRepository.existsById(id)) {
            alertaRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Alerta cadastrarAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public Alerta atualizarAlerta(Integer id, Alerta alerta) {

        Alerta alertaRecuperado = buscarAlerta(id);

        if (alertaRecuperado != null) {

            alerta.setId(id);
            return alertaRepository.save(alerta);
        }

        return null;
    }
}
