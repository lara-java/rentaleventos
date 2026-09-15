package com.senai.backend.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.rental_eventos.models.Movimentacao;
import com.senai.backend.rental_eventos.repositories.MovimentacaoRepository;

@Service 
public class MovimentacaoService {
    
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    public Movimentacao buscarMovimentacao(Integer id) {
        return movimentacaoRepository.findById(id).get();
    }

    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    public Boolean deletarMovimentacao(Integer id) {

        if (movimentacaoRepository.existsById(id)) {
            movimentacaoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao atualizarMovimentacao(Integer id, Movimentacao movimentacao) {

        if (movimentacaoRepository.existsById(id)) {
            movimentacao.setId(id);
            return movimentacaoRepository.save(movimentacao);
        }

        return null;
    }
}
