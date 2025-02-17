package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.Date;
import java.util.List;


public record ContratoResponse(
        Long id,
    String idNumeroContrato,
    ProcessoResponse processo,
    Date orcamento,
    AcaoOrcamentariaResponse acaoOrcamentaria,
    int fonteRecurso,
    String tipoContratacao,
    ContratadoResponse contratado,
    int numeroAltomatico,
    String objeto,
    String statusContrato,
    String funLegal,
    String naturezaServico,
    Date dataContrato,
    Date vigenciaInicial,
    Double valorContrato,
    Double saldo,
    long PercentualConsumido,
    float consumido,
    String situacaoVigencia,
    List<NotasContrato> notasContrato
){
    public static ContratoResponse conveterContrato(Contrato contrato){
        ContratoResponse contratoResponse = new ContratoResponse(
                contrato.getId(),
                contrato.getIdContrato(),
                ProcessoResponse.conveterProcesso(contrato.getProcesso()),
                contrato.getOrcamento(),
                AcaoOrcamentariaResponse.converterAcao(contrato.getAcaoOrcamentaria()),
                contrato.getFonteRecurso(),
                contrato.getTipoContratacao(),
                ContratadoResponse.converterContratado(contrato.getContratado()),
                contrato.getNumeroAltomatico(),
                contrato.getObjeto(),
                contrato.getStatusContrato(),
                contrato.getFunLegal(),
                contrato.getNaturezaServico(),
                contrato.getDataContrato(),
                contrato.getVigenciaInicial(),
                contrato.getValorContrato(),
                contrato.getSaldoRestanteContrato(),
                contrato.getPercentualConsumido(),
                contrato.getConsumido(),
                contrato.getSituacaoVigencia(),
                contrato.getNotasContrato()

        );
        return contratoResponse;
    }
}