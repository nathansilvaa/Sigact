package com.example.SIGACTI.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;



@Entity
public class NotasContrato{
    @Id
    @NotBlank
    private String notaFiscal;

    @ManyToOne
    @JoinColumn(name = "CONTRATO", nullable = false)
    @JsonIgnore
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "PROCESSO", nullable = false)
    @JsonIgnore
    private Processo processo;

    private String objeto;
    private String contratado;
    private String cnpj;
    private Double valorContrato;
    private String atesto;
    private String fiscalContrato;
    private String gestorContrato;

    public NotasContrato(String notaFiscal, Contrato contrato, Processo processo, String objeto, String contratado, String cnpj, Double valorContrato, String atesto, String fiscalContrato, String gestorContrato) {
        this.notaFiscal = notaFiscal;
        this.contrato = contrato;
        this.processo = processo;
        this.objeto = objeto;
        this.contratado = contratado;
        this.cnpj = cnpj;
        this.valorContrato = valorContrato;
        this.atesto = atesto;
        this.fiscalContrato = fiscalContrato;
        this.gestorContrato = gestorContrato;
    }

    @JsonProperty("contrato")
    public String getContratoId() {
        return contrato.getIdContrato();
    }

    @JsonProperty("processo")
    public String getProcessoId() {
        return processo.getIdProcesso();
    }
    public  NotasContrato(){

    }
    public @NotBlank String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(@NotBlank String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
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

    public Double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(Double valorContra) {
        this.valorContrato = valorContra;
    }

    public String getAtesto() {
        return atesto;
    }

    public void setAtesto(String atesto) {
        this.atesto = atesto;
    }

    public String getFiscalContrato() {
        return fiscalContrato;
    }

    public void setFiscalContrato(String fiscalContrato) {
        this.fiscalContrato = fiscalContrato;
    }

    public String getGestorContrato() {
        return gestorContrato;
    }

    public void setGestorContrato(String gestorContrato) {
        this.gestorContrato = gestorContrato;
    }



    @Override
    public String toString() {
        return "NotasContrato{" +
                "notaFiscal='" + notaFiscal + '\'' +
                ", contrato=" + contrato +
                ", processo=" + processo +
                ", objeto='" + objeto + '\'' +
                ", contratado='" + contratado + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", valorContra=" + valorContrato +
                ", atesto='" + atesto + '\'' +
                ", fiscalContrato='" + fiscalContrato + '\'' +
                ", gestorContrato='" + gestorContrato + '\'' +
                '}';
    }

}
