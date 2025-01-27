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
        this.processo = processo;
        UnidadeGestora = unidadeGestora;
        Situacao = situacao;
        ValorPrevisto = valorPrevisto;
        DataAtuacao = dataAtuacao;
        Interessados = interessados;
        Assunto = assunto;
        ResumoObjeto = resumoObjeto;
    }

    public @NotBlank String getResumoObjeto() {
        return ResumoObjeto;
    }

    public void setResumoObjeto(@NotBlank String resumoObjeto) {
        ResumoObjeto = resumoObjeto;
    }

    public @NotBlank String getAssunto() {
        return Assunto;
    }

    public void setAssunto(@NotBlank String assunto) {
        Assunto = assunto;
    }

    public @NotBlank String getInteressados() {
        return Interessados;
    }

    public void setInteressados(@NotBlank String interessados) {
        Interessados = interessados;
    }

    public Date getDataAtuacao() {
        return DataAtuacao;
    }

    public void setDataAtuacao(Date dataAtuacao) {
        DataAtuacao = dataAtuacao;
    }

    public @Min(0) Double getValorPrevisto() {
        return ValorPrevisto;
    }

    public void setValorPrevisto(@Min(0) Double valorPrevisto) {
        ValorPrevisto = valorPrevisto;
    }

    public @NotBlank String getSituacao() {
        return Situacao;
    }

    public void setSituacao(@NotBlank String situacao) {
        Situacao = situacao;
    }

    public @NotBlank String getUnidadeGestora() {
        return UnidadeGestora;
    }

    public void setUnidadeGestora(@NotBlank String unidadeGestora) {
        UnidadeGestora = unidadeGestora;
    }

    public @NotBlank String getProcesso() {
        return processo;
    }

    public void setProcesso(@NotBlank String processo) {
        this.processo = processo;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "processo='" + processo + '\'' +
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
