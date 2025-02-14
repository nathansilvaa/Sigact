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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ID_NUMERO_PROCESSO", unique = true)
    private String idProcesso;
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
    @JsonIgnoreProperties("processo")
    private List<CompraDireta> comprasDireta = new ArrayList<>();

    public Processo(){

    }

    public Processo(Long id, String idProcesso, String unidadeGestora, String situacao, Double valorPrevisto, Date dataAtuacao, String interessados, String assunto, String resumoObjeto, List<Contrato> contratos, List<CompraDireta> comprasDireta) {
        this.id = id;
        this.idProcesso = idProcesso;
        this.unidadeGestora = unidadeGestora;
        this.situacao = situacao;
        this.valorPrevisto = valorPrevisto;
        this.dataAtuacao = dataAtuacao;
        this.interessados = interessados;
        this.assunto = assunto;
        this.resumoObjeto = resumoObjeto;
        this.contratos = contratos;
        this.comprasDireta = comprasDireta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(String idProcesso) {
        this.idProcesso = idProcesso;
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

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public List<CompraDireta> getComprasDireta() {
        return comprasDireta;
    }

    public void setComprasDireta(List<CompraDireta> comprasDireta) {
        this.comprasDireta = comprasDireta;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", idProcesso='" + idProcesso + '\'' +
                ", unidadeGestora='" + unidadeGestora + '\'' +
                ", situacao='" + situacao + '\'' +
                ", valorPrevisto=" + valorPrevisto +
                ", dataAtuacao=" + dataAtuacao +
                ", interessados='" + interessados + '\'' +
                ", assunto='" + assunto + '\'' +
                ", resumoObjeto='" + resumoObjeto + '\'' +
                ", contratos=" + contratos +
                ", comprasDireta=" + comprasDireta +
                '}';
    }
}
