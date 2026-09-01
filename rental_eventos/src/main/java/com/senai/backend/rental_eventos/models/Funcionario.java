package com.senai.backend.rental_eventos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="cpf")
    private String cpf; 

    @Column(name="data_nascimento")
    private String dataNascimento;

    @Column(name="senha")
    private int senha;

    @Column(name="cargo")
    private String cargo;

    @OneToMany(mappedBy = "funcionarioResponsavel")
    private List<Equipamentos> equipamentos;


}
