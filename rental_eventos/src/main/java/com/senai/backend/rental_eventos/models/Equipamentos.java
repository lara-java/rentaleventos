package com.senai.backend.rental_eventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="equipamentos")
public class Equipamentos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="modelo")
    private String modelo;

    @Column(name="categoria")
    private String categoria;

    @Column(name="potencia")
    private String potencia;

    @Column(name="material")
    private String material;

    @Column(name="peso")
    private Double peso;

    @Column(name="altura")
    private Double altura;

    @Column(name="largura")
    private Double largura;

    @Column(name="comprimento")
    private Double comprimento;

    @Column(name="cor")
    private String cor;

    @Column(name="quantidade_disponivel")
    private Integer quantidadeDisponivel;

    @Column(name="quantidade_minima")
    private Integer quantidadeMinima;

}
