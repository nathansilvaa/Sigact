package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.*;

import java.util.Date;
import java.util.List;


public record ProcessoContratoResponse(
        Long id,
    String idNumeroContrato,
    Date orcamento,
    AcaoOrcamentariaResponse acaoOrcamentaria,
    int fonteRecurso,
    String tipoContratacao,
    Contratado contratado,
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
    List<NotasContrato> notasContrato,
    List<ItemContratoResponse> itensContrato
){
    public static ProcessoContratoResponse conveterContrato(Contrato contrato){
        ProcessoContratoResponse contratoResponse = new ProcessoContratoResponse(
                contrato.getId(),
                contrato.getIdContrato(),
                contrato.getOrcamento(),
                AcaoOrcamentariaResponse.converterAcao(contrato.getAcaoOrcamentaria()),
                contrato.getFonteRecurso(),
                contrato.getTipoContratacao(),
                contrato.getContratado(),
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
                contrato.getNotasContrato(),
                contrato.getItemContrato().stream().map(ItemContratoResponse::converterItemContrato).toList()

        );
        return contratoResponse;
    }
}