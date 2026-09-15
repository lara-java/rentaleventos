package com.senai.backend.rental_eventos.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @OneToMany(mappedBy = "equipamentos")
private List<Movimentacao> movimentacoes = new ArrayList<>();

    public Equipamentos() {
    }

    public Equipamentos(Double altura, String categoria, Double comprimento, String cor, Funcionario funcionario, Integer id, Double largura, String material, String modelo, Double peso, String potencia, Integer quantidadeDisponivel, Integer quantidadeMinima) {
        this.altura = altura;
        this.categoria = categoria;
        this.comprimento = comprimento;
        this.cor = cor;
        this.funcionario = funcionario;
        this.id = id;
        this.largura = largura;
        this.material = material;
        this.modelo = modelo;
        this.peso = peso;
        this.potencia = potencia;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeMinima = quantidadeMinima;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

}
