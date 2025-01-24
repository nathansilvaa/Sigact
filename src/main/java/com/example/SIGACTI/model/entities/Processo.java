package com.example.SIGACTI.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
public class Processo {
    @Id
    @NotBlank
    private String processo;
    @NotBlank
    private String UnidadeGestora;
    @NotBlank
    private String Situacao;
    @Min(0)
    private Double ValorPrevisto;
    private Date DataAtuacao;
    @NotBlank
    private String Interessados;
    @NotBlank
    private String Assunto;
    @NotBlank
    private String ResumoObjeto;

    public Processo(){

    }

    public Processo(String processo, String unidadeGestora, String situacao, Double valorPrevisto, Date dataAtuacao, String interessados, String assunto, String resumoObjeto) {
        processo = processo;
        UnidadeGestora = unidadeGestora;
        Situacao = situacao;
        ValorPrevisto = valorPrevisto;
        DataAtuacao = dataAtuacao;
        Interessados = interessados;
        Assunto = assunto;
        ResumoObjeto = resumoObjeto;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        processo = processo;
    }

    public String getUnidadeGestora() {
        return UnidadeGestora;
    }

    public void setUnidadeGestora(String unidadeGestora) {
        UnidadeGestora = unidadeGestora;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String situacao) {
        Situacao = situacao;
    }

    public Double getValorPrevisto() {
        return ValorPrevisto;
    }

    public void setValorPrevisto(Double valorPrevisto) {
        ValorPrevisto = valorPrevisto;
    }

    public Date getDataAtuacao() {
        return DataAtuacao;
    }

    public void setDataAtuacao(Date dataAtuacao) {
        DataAtuacao = dataAtuacao;
    }

    public String getInteressados() {
        return Interessados;
    }

    public void setInteressados(String interessados) {
        Interessados = interessados;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String assunto) {
        Assunto = assunto;
    }

    public String getResumoObjeto() {
        return ResumoObjeto;
    }

    public void setResumoObjeto(String resumoObjeto) {
        ResumoObjeto = resumoObjeto;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "Processo='" + processo + '\'' +
                ", UnidadeGestora='" + UnidadeGestora + '\'' +
                ", Situacao='" + Situacao + '\'' +
                ", ValorPrevisto=" + ValorPrevisto +
                ", DataAtuacao=" + DataAtuacao +
                ", Interessados='" + Interessados + '\'' +
                ", Assunto='" + Assunto + '\'' +
                ", ResumoObjeto='" + ResumoObjeto + '\'' +
                '}';
    }
}
