package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.NotasContrato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.util.List;
import lombok.Getter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDto {
    public String contrato;
    public String processo;
    public Date orcamento;
    public int acaoOrcamentaria;
    public int fonteRecurso;
    public String tipoContratacao;
    public String contratado;
    public int numeroAltomatico;
    public String objeto;
    public String statusContrato;
    public String funLegal;
    public String naturezaServico;
    public Date dataContrato;
    public Date vigenciaInicial;
    public Double valorContrato;
    public Double saldo;
    public float consumido;
    public String situacaoVigencia;
    public List<NotasContrato> notasContrato;


}