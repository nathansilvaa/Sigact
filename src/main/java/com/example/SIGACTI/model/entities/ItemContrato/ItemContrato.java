package com.example.SIGACTI.model.entities.ItemContrato;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;
import jakarta.persistence.*;

@Entity
public class ItemContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROCESSO", nullable = false)
    private Processo processo;
    @ManyToOne
    @JoinColumn(name = "CONTRATO", nullable = false)
    private Contrato contrato;

    private String item;
    private int siga;
    private String descricao;
    private String modelo;
    private int quantidade;
    private TipoContrato tipoContrato;
    private double valorUnitario;
    private double valorTotal;

    public ItemContrato() {
    }

    public ItemContrato(Long id, Processo processo, Contrato contrato, String item, int siga, String descricao, String modelo, int quantidade, TipoContrato tipoContrato, float valorUnitario, float valorTotal) {
        this.id = id;
        this.processo = processo;
        this.contrato = contrato;
        this.item = item;
        this.siga = siga;
        this.descricao = descricao;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.tipoContrato = tipoContrato;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getSiga() {
        return siga;
    }

    public void setSiga(int siga) {
        this.siga = siga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
