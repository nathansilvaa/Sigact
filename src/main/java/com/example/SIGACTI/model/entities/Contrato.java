package com.example.SIGACTI.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties("notasContrato") // Evita recursão infinita
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "ID_NUMERO_CONTRATO", unique = true, nullable = false)
    private String idContrato;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
    private List<NotasContrato> notasContrato = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "processo", nullable = false)
    @JsonManagedReference
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

    @Column(nullable = false, columnDefinition = "float default 0")
    private float consumido = 0;

    private String situacaoVigencia;

    public Contrato(){

    }

    public Contrato(Long id, String idContrato, List<NotasContrato> notasContrato, Processo processo, Date orcamento, int acaoOrcamentaria, int fonteRecurso, String tipoContratacao, String contratado, int numeroAltomatico, String objeto, String statusContrato, String funLegal, String naturezaServico, Date dataContrato, Date vigenciaInicial, Double valorContrato, float consumido, String situacaoVigencia) {
        this.id = id;
        this.idContrato = idContrato;
        this.notasContrato = notasContrato;
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
        this.consumido = consumido;
        this.situacaoVigencia = situacaoVigencia;
    }

    public Double getSaldoRestanteContrato() {
        final Double valorNotas = this.getNotasContrato().stream().map(NotasContrato::getValorContrato).reduce(0.0, Double::sum);
        return this.valorContrato - valorNotas;
    };

    public long getPercentualConsumido(){
        final Double  percentRestante =  (100 - ((getSaldoRestanteContrato() / (this.valorContrato) * 100)));
        final Long percentArredondado = Math.round(percentRestante);
        return percentArredondado;
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(@NotBlank String idContrato) {
        this.idContrato = idContrato;
    }

    public List<NotasContrato> getNotasContrato() {
        return notasContrato;
    }

    public void setNotasContrato(List<NotasContrato> notasContrato) {
        this.notasContrato = notasContrato;
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

    public float getConsumido() {
        return consumido;
    }

    public void setConsumido(float consumido) {
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
                "id=" + id +
                ", idContrato='" + idContrato + '\'' +
                ", notasContrato=" + notasContrato +
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
                ", consumido=" + consumido +
                ", situacaoVigencia='" + situacaoVigencia + '\'' +
                '}';
    }


}
