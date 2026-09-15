package com.senai.backend.rental_eventos.models;

import java.util.ArrayList;
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

     @OneToMany(mappedBy = "responsavel")
    private List<Equipamentos> equipamentos = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String cargo, String cpf, String dataNascimento, Integer id, String name, int senha) {
        this.cargo = cargo;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.id = id;
        this.name = name;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Equipamentos> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamentos> equipamentos) {
        this.equipamentos = equipamentos;
    }


}
