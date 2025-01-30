package com.example.SIGACTI.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Processo {
    @Id
    private String processo;
    private String unidadeGestora;
    private String situacao;
    @Min(0)
    private Double valorPrevisto;
    private Date dataAtuacao;
    private String interessados;
    private String assunto;
    private String resumoObjeto;
    // Relacionamento OneToMany com Contrato
    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("processo")
    private List<Contrato> contratos = new ArrayList<>();

    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Inexigibilidade> inexigibilidades = new ArrayList<>();

    public Processo(){

    }

    public Processo(List<Inexigibilidade> inexigibilidades, List<Contrato> contratos, String resumoObjeto, String assunto, String interessados, Date dataAtuacao, Double valorPrevisto, String situacao, String unidadeGestora, String processo) {
        this.inexigibilidades = inexigibilidades;
        this.contratos = contratos;
        this.resumoObjeto = resumoObjeto;
        this.assunto = assunto;
        this.interessados = interessados;
        this.dataAtuacao = dataAtuacao;
        this.valorPrevisto = valorPrevisto;
        this.situacao = situacao;
        this.unidadeGestora = unidadeGestora;
        this.processo = processo;
    }

    public @NotBlank String getProcesso() {
        return processo;
    }

    public void setProcesso(@NotBlank String processo) {
        this.processo = processo;
    }

    public String getUnidadeGestora() {
        return unidadeGestora;
    }

    public void setUnidadeGestora(String unidadeGestora) {
        this.unidadeGestora = unidadeGestora;
    }

    public List<Inexigibilidade> getInexigibilidades() {
        return inexigibilidades;
    }

    public void setInexigibilidades(List<Inexigibilidade> inexigibilidades) {
        this.inexigibilidades = inexigibilidades;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public @Min(0) Double getValorPrevisto() {
        return valorPrevisto;
    }

    public void setValorPrevisto(@Min(0) Double valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }

    public Date getDataAtuacao() {
        return dataAtuacao;
    }

    public void setDataAtuacao(Date dataAtuacao) {
        this.dataAtuacao = dataAtuacao;
    }

    public String getInteressados() {
        return interessados;
    }

    public void setInteressados(String interessados) {
        this.interessados = interessados;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getResumoObjeto() {
        return resumoObjeto;
    }

    public void setResumoObjeto(String resumoObjeto) {
        this.resumoObjeto = resumoObjeto;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "processo='" + processo + '\'' +
                ", unidadeGestora='" + unidadeGestora + '\'' +
                ", situacao='" + situacao + '\'' +
                ", valorPrevisto=" + valorPrevisto +
                ", dataAtuacao=" + dataAtuacao +
                ", interessados='" + interessados + '\'' +
                ", assunto='" + assunto + '\'' +
                ", resumoObjeto='" + resumoObjeto + '\'' +
                ", contratos=" + contratos +
                '}';
    }
}
