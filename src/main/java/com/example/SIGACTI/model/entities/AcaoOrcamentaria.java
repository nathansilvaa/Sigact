package com.example.SIGACTI.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AcaoOrcamentaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ano;
    private String UnidadeGestora;
    private String acaoOrcamentaria;
    private String fonteRecurso;
    private Double valor;
    @OneToMany(mappedBy = "acaoOrcamentaria", cascade = CascadeType.ALL)
    private List<Contrato> contratos = new ArrayList<>();

    public AcaoOrcamentaria() {

    }

    public AcaoOrcamentaria(Long id, Integer ano, String unidadeGestora, String acaoOrcamentaria, String fonteRecurso, Double valor, List<Contrato> contratos) {
        this.id = id;
        this.ano = ano;
        UnidadeGestora = unidadeGestora;
        this.acaoOrcamentaria = acaoOrcamentaria;
        this.fonteRecurso = fonteRecurso;
        this.valor = valor;
        this.contratos = contratos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getUnidadeGestora() {
        return UnidadeGestora;
    }

    public void setUnidadeGestora(String unidadeGestora) {
        UnidadeGestora = unidadeGestora;
    }

    public String getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }

    public void setAcaoOrcamentaria(String acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }

    public String getFonteRecurso() {
        return fonteRecurso;
    }

    public void setFonteRecurso(String fonteRecurso) {
        this.fonteRecurso = fonteRecurso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    @Override
    public String toString() {
        return "AcaoOrcamentaria{" +
                "id=" + id +
                ", ano=" + ano +
                ", UnidadeGestora='" + UnidadeGestora + '\'' +
                ", acaoOrcamentaria='" + acaoOrcamentaria + '\'' +
                ", fonteRecurso='" + fonteRecurso + '\'' +
                ", valor=" + valor +
                ", contratos=" + contratos +
                '}';
    }
}
