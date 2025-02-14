package com.example.SIGACTI.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CompraDireta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String portaria;

    @ManyToOne(optional = false)
    @JoinColumn(name = "processo_id", nullable = false) // Sem `unique = true`!
    @JsonIgnoreProperties("comprasDireta") // Evita recursão infinita
    private Processo processo;
    private String resumoObjeto;
    private String interessado;
    private String sgd;
    private String objeto;
    private String statusContrato;
    private String funLegal;
    private String naturezaServico;
    private Date dataContrato;
    private Integer prazoContrato;
    private Date vigencia;
    private Double valorContrato;
    private Double saldo;
    private String situacaoVigencia;
    private double consumido;
    @OneToMany(mappedBy = "portaria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("portaria") // Evita loop na serialização
    private List<NotasCompraDireta> notasCompraDiretas = new ArrayList<>();

    public Double getSaldoRestanteCompraDireta() {
        final Double valorNotas = this.getNotasCompraDiretas().stream().map(NotasCompraDireta::getValorTotal).reduce(0.0, Double::sum);
        return this.valorContrato - valorNotas;
    }


    public long getPercentualConsumido(){
        final Double  percentRestante =  (100 - ((getSaldoRestanteCompraDireta() / (this.valorContrato) * 100)));
        final Long percentArredondado = Math.round(percentRestante);
        return percentArredondado;
    };

    public CompraDireta(Long id, String portaria, Processo processo, String resumoObjeto, String interessado, String sgd, String objeto, String statusContrato, String funLegal, String naturezaServico, Date dataContrato, Integer prazoContrato, Date vigencia, Double valorContrato, Double saldo, String situacaoVigencia, double consumido, List<NotasCompraDireta> notasCompraDiretas) {
        this.id = id;
        this.portaria = portaria;
        this.processo = processo;
        this.resumoObjeto = resumoObjeto;
        this.interessado = interessado;
        this.sgd = sgd;
        this.objeto = objeto;
        this.statusContrato = statusContrato;
        this.funLegal = funLegal;
        this.naturezaServico = naturezaServico;
        this.dataContrato = dataContrato;
        this.prazoContrato = prazoContrato;
        this.vigencia = vigencia;
        this.valorContrato = valorContrato;
        this.saldo = saldo;
        this.situacaoVigencia = situacaoVigencia;
        this.consumido = consumido;
        this.notasCompraDiretas = notasCompraDiretas;
    }

    public CompraDireta() {

    }

    public List<NotasCompraDireta> getNotasCompraDiretas() {
        return notasCompraDiretas;
    }


    public void setNotasCompraDiretas(List<NotasCompraDireta> notasCompraDiretas) {
        this.notasCompraDiretas = notasCompraDiretas;
    }

    public double getConsumido() {
        return consumido;
    }

    public void setConsumido(double consumido) {
        this.consumido = consumido;
    }

    public String getSituacaoVigencia() {
        return situacaoVigencia;
    }

    public void setSituacaoVigencia(String situacaoVigencia) {
        this.situacaoVigencia = situacaoVigencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(Double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getPrazoContrato() {
        return prazoContrato;
    }

    public void setPrazoContrato(Integer prazoContrato) {
        this.prazoContrato = prazoContrato;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public String getNaturezaServico() {
        return naturezaServico;
    }

    public void setNaturezaServico(String naturezaServico) {
        this.naturezaServico = naturezaServico;
    }

    public String getFunLegal() {
        return funLegal;
    }

    public void setFunLegal(String funLegal) {
        this.funLegal = funLegal;
    }

    public String getStatusContrato() {
        return statusContrato;
    }

    public void setStatusContrato(String statusContrato) {
        this.statusContrato = statusContrato;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getSgd() {
        return sgd;
    }

    public void setSgd(String sgd) {
        this.sgd = sgd;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {
        this.interessado = interessado;
    }

    public String getResumoObjeto() {
        return resumoObjeto;
    }

    public void setResumoObjeto(String resumoObjeto) {
        this.resumoObjeto = resumoObjeto;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public @NotBlank String getPortaria() {
        return portaria;
    }

    public void setPortaria(@NotBlank String portaria) {
        this.portaria = portaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CompraDireta{" +
                "id=" + id +
                ", portaria='" + portaria + '\'' +
                ", processo=" + processo +
                ", resumoObjeto='" + resumoObjeto + '\'' +
                ", interessado='" + interessado + '\'' +
                ", sgd='" + sgd + '\'' +
                ", objeto='" + objeto + '\'' +
                ", statusContrato='" + statusContrato + '\'' +
                ", funLegal='" + funLegal + '\'' +
                ", naturezaServico='" + naturezaServico + '\'' +
                ", dataContrato=" + dataContrato +
                ", prazoContrato=" + prazoContrato +
                ", vigencia=" + vigencia +
                ", valorContrato=" + valorContrato +
                ", saldo=" + saldo +
                ", situacaoVigencia='" + situacaoVigencia + '\'' +
                ", consumido=" + consumido +
                ", notasCompraDiretas=" + notasCompraDiretas +
                '}';
    }
}
