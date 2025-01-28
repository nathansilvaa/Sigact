package com.example.SIGACTI.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Inexigibilidade extends Contrato{
    private String portaria;
    private String resumoObjeto;
    private String sgd;

    @OneToMany(mappedBy = "inexigibilidade", cascade = CascadeType.ALL)
    private List<NotasInexigibilidade> notasInexigibilidade = new ArrayList<>();


    public Inexigibilidade(){

    }

    public Inexigibilidade(String portaria, String resumoObjeto, String sgd, List<NotasInexigibilidade> notasInexigibilidade) {
        this.portaria = portaria;
        this.resumoObjeto = resumoObjeto;
        this.sgd = sgd;
        this.notasInexigibilidade = notasInexigibilidade;
    }

    public Inexigibilidade(String contrato, List<NotasContrato> notasContrato, Processo processo, Date orcamento, int acaoOrcamentaria, int fonteRecurso, String tipoContratacao, String contratado, int numeroAltomatico, String objeto, String statusContrato, String funLegal, String naturezaServico, Date dataContrato, Date vigenciaInicial, Double valorContrato, Double saldo, float consumido, String situacaoVigencia, String portaria, String resumoObjeto, String sgd, List<NotasInexigibilidade> notasInexigibilidade) {
        super(contrato, notasContrato, processo, orcamento, acaoOrcamentaria, fonteRecurso, tipoContratacao, contratado, numeroAltomatico, objeto, statusContrato, funLegal, naturezaServico, dataContrato, vigenciaInicial, valorContrato, saldo, consumido, situacaoVigencia);
        this.portaria = portaria;
        this.resumoObjeto = resumoObjeto;
        this.sgd = sgd;
        this.notasInexigibilidade = notasInexigibilidade;
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
                ", resumoObjeto='" + resumoObjeto + '\'' +
                ", sgd='" + sgd + '\'' +
                ", notasInexigibilidade=" + notasInexigibilidade +
                '}';
    }
}
