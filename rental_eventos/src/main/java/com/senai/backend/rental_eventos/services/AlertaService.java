package com.senai.backend.rental_eventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.repositories.AlertaRepository;

@Service
public class AlertaService {
    
    @Autowired
    private AlertaRepository alertaRepository;
    
}
