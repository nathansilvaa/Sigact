package com.example.SIGACTI.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Contrato {
    @Id
    @NotBlank
    private String contrato;

    @ManyToOne(optional = false)
    @JoinColumn(name = "processo", nullable = false)
    private Processo processo;

    @NotNull
    private Date orcamento;

    @NotNull
    private int acaoOrcamentaria;

    @NotNull
    private int fonteRecurso;

    @NotBlank
    private String tipoContratacao;

    @NotBlank
    private String contratado;

    @NotNull
    private int numeroAltomatico;

    @NotBlank
    private String objeto;

    @NotBlank
    private String statusContrato;

    @NotBlank
    private String funLegal;

    @NotBlank
    private String naturezaServico;

    @NotNull
    private Date dataContrato;

    @NotNull
    private Date vigenciaInicial;

    @NotNull
    @Min(0) // Valida que o valor seja maior ou igual a 0
    private Double valorContrato;

    @NotNull
    @Min(0) // Valida que o saldo seja maior ou igual a 0
    private Double saldo;
    @Column(nullable = false, columnDefinition = "float default 0")
    private float consumido = 0;

    private String situacaoVigencia;

    public Contrato(){

    }

    public Contrato(String contrato, Processo processo, Date orcamento, int acaoOrcamentaria, int fonteRecurso, String tipoContratacao, String contratado, int numeroAltomatico, String objeto, String statusContrato, String funLegal, String naturezaServico, Date dataContrato, Date vigenciaInicial, Double valorContrato, Double saldo, Float consumido, String situacaoVigencia) {
        this.contrato = contrato;
        this.processo = processo;
        this.orcamento = orcamento;
        this.acaoOrcamentaria = acaoOrcamentaria;
        this.fonteRecurso = fonteRecurso;
        this.tipoContratacao = tipoContratacao;
        this.contratado = contratado;
        this.numeroAltomatico = numeroAltomatico;
        this.objeto = objeto;
        this.statusContrato = statusContrato;
        this.funLegal = funLegal;
        this.naturezaServico = naturezaServico;
        this.dataContrato = dataContrato;
        this.vigenciaInicial = vigenciaInicial;
        this.valorContrato = valorContrato;
        this.saldo = saldo;
        this.consumido = consumido;
        this.situacaoVigencia = situacaoVigencia;
    }

    public @NotBlank String getContrato() {
        return contrato;
    }

    public void setContrato(@NotBlank String contrato) {
        this.contrato = contrato;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public @NotNull Date getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(@NotNull Date orcamento) {
        this.orcamento = orcamento;
    }

    @NotNull
    public int getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }

    public void setAcaoOrcamentaria(@NotNull int acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }

    @NotNull
    public int getFonteRecurso() {
        return fonteRecurso;
    }

    public void setFonteRecurso(@NotNull int fonteRecurso) {
        this.fonteRecurso = fonteRecurso;
    }

    public @NotBlank String getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(@NotBlank String tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public @NotBlank String getContratado() {
        return contratado;
    }

    public void setContratado(@NotBlank String contratado) {
        this.contratado = contratado;
    }

    @NotNull
    public int getNumeroAltomatico() {
        return numeroAltomatico;
    }

    public void setNumeroAltomatico(@NotNull int numeroAltomatico) {
        this.numeroAltomatico = numeroAltomatico;
    }

    public @NotBlank String getObjeto() {
        return objeto;
    }

    public void setObjeto(@NotBlank String objeto) {
        this.objeto = objeto;
    }

    public @NotBlank String getStatusContrato() {
        return statusContrato;
    }

    public void setStatusContrato(@NotBlank String statusContrato) {
        this.statusContrato = statusContrato;
    }

    public @NotBlank String getFunLegal() {
        return funLegal;
    }

    public void setFunLegal(@NotBlank String funLegal) {
        this.funLegal = funLegal;
    }

    public @NotBlank String getNaturezaServico() {
        return naturezaServico;
    }

    public void setNaturezaServico(@NotBlank String naturezaServico) {
        this.naturezaServico = naturezaServico;
    }

    public @NotNull Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(@NotNull Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public @NotNull Date getVigenciaInicial() {
        return vigenciaInicial;
    }

    public void setVigenciaInicial(@NotNull Date vigenciaInicial) {
        this.vigenciaInicial = vigenciaInicial;
    }

    public @NotNull @Min(0) Double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(@NotNull @Min(0) Double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public @NotNull @Min(0) Double getSaldo() {
        return saldo;
    }

    public void setSaldo(@NotNull @Min(0) Double saldo) {
        this.saldo = saldo;
    }

    public double getConsumido() {
        return consumido;
    }

    public void setConsumido(Float consumido) {
        this.consumido = consumido;
    }

    public String getSituacaoVigencia() {
        return situacaoVigencia;
    }

    public void setSituacaoVigencia(String situacaoVigencia) {
        this.situacaoVigencia = situacaoVigencia;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "contrato='" + contrato + '\'' +
                ", processo=" + processo +
                ", orcamento=" + orcamento +
                ", acaoOrcamentaria=" + acaoOrcamentaria +
                ", fonteRecurso=" + fonteRecurso +
                ", tipoContratacao='" + tipoContratacao + '\'' +
                ", contratado='" + contratado + '\'' +
                ", numeroAltomatico=" + numeroAltomatico +
                ", objeto='" + objeto + '\'' +
                ", statusContrato='" + statusContrato + '\'' +
                ", funLegal='" + funLegal + '\'' +
                ", naturezaServico='" + naturezaServico + '\'' +
                ", dataContrato=" + dataContrato +
                ", vigenciaInicial=" + vigenciaInicial +
                ", valorContrato=" + valorContrato +
                ", saldo=" + saldo +
                ", consumido=" + consumido +
                ", situacaoVigencia='" + situacaoVigencia + '\'' +
                '}';
    }
}
