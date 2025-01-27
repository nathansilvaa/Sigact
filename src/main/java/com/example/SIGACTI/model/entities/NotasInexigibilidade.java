package com.example.SIGACTI.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceUnit;

import java.util.Date;
@Entity
public class NotasInexigibilidade extends Inexigibilidade{
    private String cnpj;
    private String notaFiscal;
    private String atesto;
    private String gestorContrato;
    private String fiscalAdministrativo;
    private String fiscalTecnico;

    public NotasInexigibilidade(String portaria, String resumoObjeto, String sgd, String cnpj, String notaFiscal, String atesto, String gestorContrato, String fiscalAdministrativo, String fiscalTecnico) {
        super(portaria, resumoObjeto, sgd);
        this.cnpj = cnpj;
        this.notaFiscal = notaFiscal;
        this.atesto = atesto;
        this.gestorContrato = gestorContrato;
        this.fiscalAdministrativo = fiscalAdministrativo;
        this.fiscalTecnico = fiscalTecnico;
    }

    public NotasInexigibilidade(String contrato, Processo processo, Date orcamento, int acaoOrcamentaria, int fonteRecurso, String tipoContratacao, String contratado, int numeroAltomatico, String objeto, String statusContrato, String funLegal, String naturezaServico, Date dataContrato, Date vigenciaInicial, Double valorContrato, Double saldo, Float consumido, String situacaoVigencia, String portaria, String resumoObjeto, String sgd, String cnpj, String notaFiscal, String atesto, String gestorContrato, String fiscalAdministrativo, String fiscalTecnico) {
        super(contrato, processo, orcamento, acaoOrcamentaria, fonteRecurso, tipoContratacao, contratado, numeroAltomatico, objeto, statusContrato, funLegal, naturezaServico, dataContrato, vigenciaInicial, valorContrato, saldo, consumido, situacaoVigencia, portaria, resumoObjeto, sgd);
        this.cnpj = cnpj;
        this.notaFiscal = notaFiscal;
        this.atesto = atesto;
        this.gestorContrato = gestorContrato;
        this.fiscalAdministrativo = fiscalAdministrativo;
        this.fiscalTecnico = fiscalTecnico;
    }

    public NotasInexigibilidade(){

    }
    public NotasInexigibilidade(String cnpj, String notaFiscal, String atesto, String gestorContrato, String fiscalAdministrativo, String fiscalTecnico) {
        this.cnpj = cnpj;
        this.notaFiscal = notaFiscal;
        this.atesto = atesto;
        this.gestorContrato = gestorContrato;
        this.fiscalAdministrativo = fiscalAdministrativo;
        this.fiscalTecnico = fiscalTecnico;
    }

    public String getFiscalTecnico() {
        return fiscalTecnico;
    }

    public void setFiscalTecnico(String fiscalTecnico) {
        this.fiscalTecnico = fiscalTecnico;
    }

    public String getFiscalAdministrativo() {
        return fiscalAdministrativo;
    }

    public void setFiscalAdministrativo(String fiscalAdministrativo) {
        this.fiscalAdministrativo = fiscalAdministrativo;
    }

    public String getGestorContrato() {
        return gestorContrato;
    }

    public void setGestorContrato(String gestorContrato) {
        this.gestorContrato = gestorContrato;
    }

    public String getAtesto() {
        return atesto;
    }

    public void setAtesto(String atesto) {
        this.atesto = atesto;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "NotasInexigibilidade{" +
                "cnpj='" + cnpj + '\'' +
                ", notaFiscal='" + notaFiscal + '\'' +
                ", atesto='" + atesto + '\'' +
                ", gestorContrato='" + gestorContrato + '\'' +
                ", fiscalAdministrativo='" + fiscalAdministrativo + '\'' +
                ", fiscalTecnico='" + fiscalTecnico + '\'' +
                '}';
    }
}
