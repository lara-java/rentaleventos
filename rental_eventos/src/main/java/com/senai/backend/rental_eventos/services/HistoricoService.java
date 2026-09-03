package com.senai.backend.rental_eventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.repositories.HistoricoRepository;

@Service
public class HistoricoService {
    
    @Autowired
    private HistoricoRepository historicoRepository;
}
