package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;

public record NotasContratoResponse(
        Long id,
        String notaFiscal,
        ContratoResponse contrato,
        ProcessoResponse processo,
        String objeto,
        String contratado,
        String cnpj,
        Double valorContrato,
        String atesto,
        String fiscalContrato,
        String gestorContrato
) {
    public static NotasContratoResponse converterNotasContrato(NotasContrato notasContrato) {
        return new NotasContratoResponse(
                notasContrato.getId(),
                notasContrato.getNotaFiscal(),
                ContratoResponse.conveterContrato( notasContrato.getContrato()),
                ProcessoResponse.conveterProcesso(notasContrato.getProcesso()),
                notasContrato.getObjeto(),
                notasContrato.getContratado(),
                notasContrato.getCnpj(),
                notasContrato.getValorContrato(),
                notasContrato.getAtesto(),
                notasContrato.getFiscalContrato(),
                notasContrato.getGestorContrato()
        );
    }
}
