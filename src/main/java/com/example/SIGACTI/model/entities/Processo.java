package com.example.SIGACTI.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

    public Processo(){

    }

    public Processo(String processo, String unidadeGestora, String situacao, Double valorPrevisto, Date dataAtuacao, String interessados, String assunto, String resumoObjeto) {
        this.processo = processo;
        this.unidadeGestora = unidadeGestora;
        this.situacao = situacao;
        this.valorPrevisto = valorPrevisto;
        this.dataAtuacao = dataAtuacao;
        this.interessados = interessados;
        this.assunto = assunto;
        this.resumoObjeto = resumoObjeto;
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
                '}';
    }
}
