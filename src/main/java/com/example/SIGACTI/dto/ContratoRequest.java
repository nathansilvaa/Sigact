package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.*;

import java.sql.Date;
import java.util.List;



public record ContratoRequest(
    String idNumeroContrato,
    Long idProcesso,
    Date orcamento,
    Long acaoOrcamentaria,
    int fonteRecurso,
    String tipoContratacao,
    Long contratado,
    int numeroAltomatico,
    String objeto,
    String statusContrato,
    String funLegal,
    String naturezaServico,
    Date dataContrato,
    Date vigenciaInicial,
    Double valorContrato,
    float consumido,
    String situacaoVigencia


){
    public static Contrato converterContrato(ContratoRequest request, AcaoOrcamentaria acao, Contratado contratado) {
        Contrato contrato = new Contrato();

        contrato.setIdContrato(request.idNumeroContrato());
        contrato.setOrcamento(request.orcamento());
        contrato.setAcaoOrcamentaria(acao);
        contrato.setFonteRecurso(request.fonteRecurso());
        contrato.setTipoContratacao(request.tipoContratacao());
        contrato.setNumeroAltomatico(request.numeroAltomatico());
        contrato.setContratado(contratado);
        contrato.setObjeto(request.objeto());
        contrato.setStatusContrato(request.statusContrato());
        contrato.setFunLegal(request.funLegal());
        contrato.setNaturezaServico(request.naturezaServico());
        contrato.setDataContrato(request.dataContrato());
        contrato.setVigenciaInicial(request.vigenciaInicial());
        contrato.setValorContrato(request.valorContrato());
        contrato.setConsumido(request.consumido());
        contrato.setSituacaoVigencia(request.situacaoVigencia());

        return contrato;
    }

}