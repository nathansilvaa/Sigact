package com.example.SIGACTI.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Date;

@Entity
public class Ocorrencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProcesso", nullable = false)
    @JsonIgnore
    private Processo processo;

    @ManyToOne
    @JoinColumn(name = "contrato_id", nullable = false)
    @JsonIgnore
    private Contrato contrato;

    private Date dataOcorrencia;
    private String situacao;

    public Ocorrencias(Long id, Processo processo, Contrato contrato, Date dataOcorrencia, String situacao) {
        this.id = id;
        this.processo = processo;
        this.contrato = contrato;
        this.dataOcorrencia = dataOcorrencia;
        situacao = situacao;
    }
    public Ocorrencias(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Ocorrencias{" +
                "id=" + id +
                ", processo=" + processo +
                ", contrato=" + contrato +
                ", dataOcorrencia=" + dataOcorrencia +
                ", Situacao='" + situacao + '\'' +
                '}';
    }
}
