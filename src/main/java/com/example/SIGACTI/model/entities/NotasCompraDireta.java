
package com.example.SIGACTI.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
@Entity
public class NotasCompraDireta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String notaFiscal;
    @ManyToOne
    @JoinColumn(name = "portaria", nullable = false)
    @JsonIgnore
    private CompraDireta portaria;
    private String sgd;
    private String processo;
    private String unidade;
    private String objeto;
    private String contratado;
    private String cnpj;
    private Double valorTotal;
    private Date emissao;
    private String atesto;
    private String responsavelRecebimento;

    public NotasCompraDireta() {

    }
    public NotasCompraDireta(String notaFiscal, CompraDireta portaria, String sgd, String processo, String unidade, String objeto, String contratado, String cnpj, Double valorTotal, Date emissao, String atesto, String responsavelRecebimento) {
        this.notaFiscal = notaFiscal;
        this.portaria = portaria;
        this.sgd = sgd;
        this.processo = processo;
        this.unidade = unidade;
        this.objeto = objeto;
        this.contratado = contratado;
        this.cnpj = cnpj;
        this.valorTotal = valorTotal;
        this.emissao = emissao;
        this.atesto = atesto;
        this.responsavelRecebimento = responsavelRecebimento;
    }

    public NotasCompraDireta(Long id, String notaFiscal, CompraDireta portaria, String sgd, String processo, String unidade, String objeto, String contratado, String cnpj, Double valorTotal, Date emissao, String atesto, String responsavelRecebimento) {
        this.id = id;
        this.notaFiscal = notaFiscal;
        this.portaria = portaria;
        this.sgd = sgd;
        this.processo = processo;
        this.unidade = unidade;
        this.objeto = objeto;
        this.contratado = contratado;
        this.cnpj = cnpj;
        this.valorTotal = valorTotal;
        this.emissao = emissao;
        this.atesto = atesto;
        this.responsavelRecebimento = responsavelRecebimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(@NotBlank String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public CompraDireta getPortaria() {
        return portaria;
    }

    public void setPortaria(CompraDireta portaria) {
        this.portaria = portaria;
    }

    public String getSgd() {
        return sgd;
    }

    public void setSgd(String sgd) {
        this.sgd = sgd;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getContratado() {
        return contratado;
    }

    public void setContratado(String contratado) {
        this.contratado = contratado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public String getAtesto() {
        return atesto;
    }

    public void setAtesto(String atesto) {
        this.atesto = atesto;
    }

    public String getResponsavelRecebimento() {
        return responsavelRecebimento;
    }

    public void setResponsavelRecebimento(String responsavelRecebimento) {
        this.responsavelRecebimento = responsavelRecebimento;
    }

    @Override
    public String toString() {
        return "NotasCompraDireta{" +
                "id=" + id +
                ", notaFiscal='" + notaFiscal + '\'' +
                ", portaria=" + portaria +
                ", sgd='" + sgd + '\'' +
                ", processo='" + processo + '\'' +
                ", unidade='" + unidade + '\'' +
                ", objeto='" + objeto + '\'' +
                ", contratado='" + contratado + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", valorTotal=" + valorTotal +
                ", emissao=" + emissao +
                ", atesto='" + atesto + '\'' +
                ", responsavelRecebimento='" + responsavelRecebimento + '\'' +
                '}';
    }
}
