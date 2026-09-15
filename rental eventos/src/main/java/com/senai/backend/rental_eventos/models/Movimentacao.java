package com.senai.backend.rental_eventos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="data_entrada")
    private LocalDate dataEntrada;

    @Column(name="data_saida")
    private LocalDate dataSaida;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "equipamentos_id")
    private Equipamentos equipamentos;

    @OneToOne
    @JoinColumn(name = "historico_id")
    private Historico historico;

    @OneToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    public Movimentacao() {
    }

    public Movimentacao(Cliente cliente, LocalDate dataEntrada, LocalDate dataSaida, Equipamentos equipamentos, Estoque estoque, Historico historico, Integer id) {
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.equipamentos = equipamentos;
        this.estoque = estoque;
        this.historico = historico;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamentos getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamentos equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
}
