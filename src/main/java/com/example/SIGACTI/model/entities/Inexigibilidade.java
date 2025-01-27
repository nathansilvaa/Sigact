package com.example.SIGACTI.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.Date;

@Entity
public class Inexigibilidade extends Contrato{
    private String portaria;
    private String resumoObjeto;
    private String sgd;


    public Inexigibilidade(String portaria, String resumoObjeto, String sgd) {
        this.portaria = portaria;
        this.resumoObjeto = resumoObjeto;
        this.sgd = sgd;
    }

    public Inexigibilidade(String contrato, Processo processo, Date orcamento, int acaoOrcamentaria, int fonteRecurso, String tipoContratacao, String contratado, int numeroAltomatico, String objeto, String statusContrato, String funLegal, String naturezaServico, Date dataContrato, Date vigenciaInicial, Double valorContrato, Double saldo, Float consumido, String situacaoVigencia, String portaria, String resumoObjeto, String sgd) {
        super(contrato, processo, orcamento, acaoOrcamentaria, fonteRecurso, tipoContratacao, contratado, numeroAltomatico, objeto, statusContrato, funLegal, naturezaServico, dataContrato, vigenciaInicial, valorContrato, saldo, consumido, situacaoVigencia);
        this.portaria = portaria;
        this.resumoObjeto = resumoObjeto;
        this.sgd = sgd;
    }

    public Inexigibilidade(){

    }

    public String getPortaria() {
        return portaria;
    }

    public void setPortaria(String portaria) {
        this.portaria = portaria;
    }

    public String getResumoObjeto() {
        return resumoObjeto;
    }

    public void setResumoObjeto(String resumoObjeto) {
        this.resumoObjeto = resumoObjeto;
    }

    public String getSgd() {
        return sgd;
    }

    public void setSgd(String sgd) {
        this.sgd = sgd;
    }

    @Override
    public String toString() {
        return "Inexigibilidade{" +
                "portaria='" + portaria + '\'' +
                ", resumoObjeto='" + resumoObjeto + '\'' +
                ", sgd='" + sgd + '\'' +
                '}';
    }
}
