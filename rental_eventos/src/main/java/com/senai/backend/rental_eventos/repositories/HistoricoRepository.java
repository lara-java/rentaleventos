package com.senai.backend.rental_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.rental_eventos.models.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
    
}
