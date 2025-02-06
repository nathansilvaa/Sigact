
package com.example.SIGACTI.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Inexigibilidade{
    @NotBlank
    @Id
    private String portaria;

    @ManyToOne(optional = false)
    @JoinColumn(name = "processo", nullable = false)
    @JsonBackReference
    private Processo processo;
    private String resumoObjeto;
    private String interessado;
    private String sgd;
    private String objeto;
    private String statusContrato;
    private String funLegal;
    private String naturezaServiço;
    private Date dataContrato;
    private Integer prazoContrato;
    private Date vigencia;
    private Double valorContrato;
    private Double saldo;
    private String situacaoVigencia;
    private double consumido;

    @OneToMany(mappedBy = "portaria", cascade = CascadeType.ALL)
    private List<NotasInexigibilidade> notasInexigibilidade = new ArrayList<>();



    public Inexigibilidade(){

    }

    public Inexigibilidade(String portaria, Processo processo, String resumoObjeto, String interessado, String sgd, String objeto, String statusContrato, String funLegal, String naturezaServiço, Date dataContrato, Integer prazoContrato, Date vigencia, Double valorContrato, Double saldo, String situacaoVigencia, double consumido, List<NotasInexigibilidade> notasInexigibilidade) {
        this.portaria = portaria;
        this.processo = processo;
        this.resumoObjeto = resumoObjeto;
        this.interessado = interessado;
        this.sgd = sgd;
        this.objeto = objeto;
        this.statusContrato = statusContrato;
        this.funLegal = funLegal;
        this.naturezaServiço = naturezaServiço;
        this.dataContrato = dataContrato;
        this.prazoContrato = prazoContrato;
        this.vigencia = vigencia;
        this.valorContrato = valorContrato;
        this.saldo = saldo;
        this.situacaoVigencia = situacaoVigencia;
        this.consumido = consumido;
        this.notasInexigibilidade = notasInexigibilidade;
    }

    public @NotBlank String getPortaria() {
        return portaria;
    }

    public void setPortaria(@NotBlank String portaria) {
        this.portaria = portaria;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public String getResumoObjeto() {
        return resumoObjeto;
    }

    public void setResumoObjeto(String resumoObjeto) {
        this.resumoObjeto = resumoObjeto;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {
        this.interessado = interessado;
    }

    public String getSgd() {
        return sgd;
    }

    public void setSgd(String sgd) {
        this.sgd = sgd;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getStatusContrato() {
        return statusContrato;
    }

    public void setStatusContrato(String statusContrato) {
        this.statusContrato = statusContrato;
    }

    public String getFunLegal() {
        return funLegal;
    }

    public void setFunLegal(String funLegal) {
        this.funLegal = funLegal;
    }

    public String getNaturezaServiço() {
        return naturezaServiço;
    }

    public void setNaturezaServiço(String naturezaServiço) {
        this.naturezaServiço = naturezaServiço;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Integer getPrazoContrato() {
        return prazoContrato;
    }

    public void setPrazoContrato(Integer prazoContrato) {
        this.prazoContrato = prazoContrato;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public Double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(Double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getSituacaoVigencia() {
        return situacaoVigencia;
    }

    public void setSituacaoVigencia(String situacaoVigencia) {
        this.situacaoVigencia = situacaoVigencia;
    }

    public double getConsumido() {
        return consumido;
    }

    public void setConsumido(double consumido) {
        this.consumido = consumido;
    }

    public List<NotasInexigibilidade> getNotasInexigibilidade() {
        return notasInexigibilidade;
    }

    public void setNotasInexigibilidade(List<NotasInexigibilidade> notasInexigibilidade) {
        this.notasInexigibilidade = notasInexigibilidade;
    }

    @Override
    public String toString() {
        return "Inexigibilidade{" +
                "portaria='" + portaria + '\'' +
                ", processo=" + processo +
                ", resumoObjeto='" + resumoObjeto + '\'' +
                ", interessado='" + interessado + '\'' +
                ", sgd='" + sgd + '\'' +
                ", objeto='" + objeto + '\'' +
                ", statusContrato='" + statusContrato + '\'' +
                ", funLegal='" + funLegal + '\'' +
                ", naturezaServiço='" + naturezaServiço + '\'' +
                ", dataContrato=" + dataContrato +
                ", prazoContrato=" + prazoContrato +
                ", vigencia=" + vigencia +
                ", valorContrato=" + valorContrato +
                ", saldo=" + saldo +
                ", situacaoVigencia='" + situacaoVigencia + '\'' +
                ", consumido=" + consumido +
                ", notasInexigibilidade=" + notasInexigibilidade +
                '}';
    }
}

