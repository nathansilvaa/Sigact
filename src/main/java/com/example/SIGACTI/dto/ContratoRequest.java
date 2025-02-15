package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;

import java.sql.Date;
import java.util.List;



public record ContratoRequest(
    String idNumeroContrato,
    Long idProcesso,
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
    float consumido,
    String situacaoVigencia


){
    public static Contrato converterContrato(ContratoRequest request) {
        Contrato contrato = new Contrato();

        contrato.setIdContrato(request.idNumeroContrato());
        contrato.setOrcamento(request.orcamento());
        contrato.setAcaoOrcamentaria(request.acaoOrcamentaria());
        contrato.setFonteRecurso(request.fonteRecurso());
        contrato.setTipoContratacao(request.tipoContratacao());
        contrato.setContratado(request.contratado());
        contrato.setNumeroAltomatico(request.numeroAltomatico());
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