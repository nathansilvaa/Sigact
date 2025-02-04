package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;


import java.util.Date;
import java.util.List;


public record ContratoResponse(
    String idNumeroContrato,
    Processo processo,
    Date orcamento,
    int acaoOrcamentaria,
    int fonteRecurso,
    String tipoContratacao,
    String contratado,
    int numeroAltomatico,
    String objeto,
    String statusContrato,
    String funLegal,
    String naturezaServico,
    Date dataContrato,
    Date vigenciaInicial,
    Double valorContrato,
    Double saldo,
    float consumido,
    String situacaoVigencia,
    List<NotasContrato> notasContrato


){
    public static ContratoResponse conveterContrato(Contrato contrato){
        ContratoResponse contratoResponse = new ContratoResponse(
                contrato.getIdContrato(),
                contrato.getProcesso(),
                contrato.getOrcamento(),
                contrato.getAcaoOrcamentaria(),
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
                contrato.getSaldo(),
                contrato.getConsumido(),
                contrato.getSituacaoVigencia(),
                contrato.getNotasContrato()

        );
        return contratoResponse;
    }
}