package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Ocorrencias;

import java.util.Date;

public record OcorrenciaResponse(
        ProcessoResponse processo,
        ContratoResponse contrato,
        Date dataOcorrencia,
        String situacao
) {
    public static OcorrenciaResponse converter(Ocorrencias ocorrencias){
        OcorrenciaResponse ocorrenciaResponse = new OcorrenciaResponse(
                ProcessoResponse.conveterProcesso(ocorrencias.getProcesso()),
                ContratoResponse.conveterContrato(ocorrencias.getContrato()),
                ocorrencias.getDataOcorrencia(),
                ocorrencias.getSituacao()
        );
        return ocorrenciaResponse;
    }
}
