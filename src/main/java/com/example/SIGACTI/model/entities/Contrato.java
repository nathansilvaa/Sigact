package com.example.SIGACTI.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private Date orcamento;
    @ManyToOne
    @JoinColumn(name = "acao_orcamentaria_id", nullable = false) // Chave estrangeira
    private AcaoOrcamentaria acaoOrcamentaria;
    private int fonteRecurso;
    private String tipoContratacao;
    @OneToOne
    @JoinColumn(name = "contratado")
    private Contratado contratado;
    private int numeroAltomatico;
    private String objeto;
    private String statusContrato;
    private String funLegal;
    private String naturezaServico;
    private Date dataContrato;
    private Date vigenciaInicial;
    private Double valorContrato;
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ocorrencias> ocorrencias = new ArrayList<>();


    private String situacaoVigencia;

    public Contrato(){

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

    public Contrato(Long id, String idContrato, List<NotasContrato> notasContrato, Processo processo, Date orcamento, AcaoOrcamentaria acaoOrcamentaria, int fonteRecurso, String tipoContratacao, Contratado contratado, int numeroAltomatico, String objeto, String statusContrato, String funLegal, String naturezaServico, Date dataContrato, Date vigenciaInicial, Double valorContrato, List<Ocorrencias> ocorrencias, String situacaoVigencia) {
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
        this.ocorrencias = ocorrencias;
        this.situacaoVigencia = situacaoVigencia;
    }

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

    public Date getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Date orcamento) {
        this.orcamento = orcamento;
    }

    public AcaoOrcamentaria getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }

    public void setAcaoOrcamentaria(AcaoOrcamentaria acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }

    public int getFonteRecurso() {
        return fonteRecurso;
    }

    public void setFonteRecurso(int fonteRecurso) {
        this.fonteRecurso = fonteRecurso;
    }

    public String getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(String tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Contratado getContratado() {
        return contratado;
    }

    public void setContratado(Contratado contratado) {
        this.contratado = contratado;
    }

    public int getNumeroAltomatico() {
        return numeroAltomatico;
    }

    public void setNumeroAltomatico(int numeroAltomatico) {
        this.numeroAltomatico = numeroAltomatico;
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

    public String getNaturezaServico() {
        return naturezaServico;
    }

    public void setNaturezaServico(String naturezaServico) {
        this.naturezaServico = naturezaServico;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Date getVigenciaInicial() {
        return vigenciaInicial;
    }

    public void setVigenciaInicial(Date vigenciaInicial) {
        this.vigenciaInicial = vigenciaInicial;
    }

    public Double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(Double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public List<Ocorrencias> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencias> ocorrencias) {
        this.ocorrencias = ocorrencias;
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
                ", ocorrencias=" + ocorrencias +
                ", situacaoVigencia='" + situacaoVigencia + '\'' +
                '}';
    }
}
