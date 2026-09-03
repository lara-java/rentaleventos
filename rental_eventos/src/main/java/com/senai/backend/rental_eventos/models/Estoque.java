package com.senai.backend.rental_eventos.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="estoque")
public class Estoque {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="quantidade_pecas")
    private Integer quantidadePecas;
    
    @OneToOne(mappedBy = "estoque")
    private Movimentacao movimentacao;

    @OneToMany(mappedBy = "estoque")
    private List<Alerta> alertas = new ArrayList<>();

    public Estoque() {
    }

    public Estoque(Integer id, Movimentacao movimentacao, Integer quantidadePecas) {
        this.id = id;
        this.movimentacao = movimentacao;
        this.quantidadePecas = quantidadePecas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(Integer quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }
    
}
