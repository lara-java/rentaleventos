package com.senai.backend.rental_eventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.repositories.EstoqueRepository;

@Service
public class EstoqueService {
    
    @Autowired
    private EstoqueRepository estoqueRepository;
}


