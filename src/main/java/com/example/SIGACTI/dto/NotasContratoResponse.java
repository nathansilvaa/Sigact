package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;

public record NotasContratoResponse(
        String notaFiscal,
        Contrato contrato,
        Processo processo,
        String objeto,
        String contratado,
        String cnpj,
        Double valorContrato,
        String atesto,
        String fiscalContrato,
        String gestorContrato
) {
    public static NotasContratoResponse converterNotasContrato(NotasContrato notasContrato) {
        NotasContratoResponse notasContratoResponse = new NotasContratoResponse(
                notasContrato.getNotaFiscal(),
                notasContrato.getContrato(),
                notasContrato.getProcesso(),
                notasContrato.getObjeto(),
                notasContrato.getContratado(),
                notasContrato.getCnpj(),
                notasContrato.getValorContrato(),
                notasContrato.getAtesto(),
                notasContrato.getFiscalContrato(),
                notasContrato.getGestorContrato()
                );
        return notasContratoResponse;
    }
}
