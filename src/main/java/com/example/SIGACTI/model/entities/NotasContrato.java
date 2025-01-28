package com.example.SIGACTI.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name = "contrato", nullable = false)
    @JsonIgnore
    private Contrato contrato;
    private String processo;
    private String objeto;
    private String contratado;
    private String cnpj;
    private Double valorContra;
    private String atesto;
    private String fiscalContrato;
    private String gestorContrato;

    public NotasContrato(String gestorContrato, String fiscalContrato, String atesto, Double valorContra, String cnpj, String contratado, String objeto, String processo, Contrato contrato, String notaFiscal) {
        this.gestorContrato = gestorContrato;
        this.fiscalContrato = fiscalContrato;
        this.atesto = atesto;
        this.valorContra = valorContra;
        this.cnpj = cnpj;
        this.contratado = contratado;
        this.objeto = objeto;
        this.processo = processo;
        this.contrato = contrato;
        this.notaFiscal = notaFiscal;
    }
    public NotasContrato(){

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

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
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

    public Double getValorContra() {
        return valorContra;
    }

    public void setValorContra(Double valorContra) {
        this.valorContra = valorContra;
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
                ", processo='" + processo + '\'' +
                ", objeto='" + objeto + '\'' +
                ", contratado='" + contratado + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", valorContra=" + valorContra +
                ", atesto='" + atesto + '\'' +
                ", fiscalContrato='" + fiscalContrato + '\'' +
                ", gestorContrato='" + gestorContrato + '\'' +
                '}';
    }
}
