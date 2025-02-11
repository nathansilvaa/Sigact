package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;

import java.util.Optional;

public record NotasContratoRequest(
        String notaFiscal,
        Long idContrato,
        Long idProcesso,
        String objeto,
        String contratado,
        String cnpj,
        Double valorContrato,
        String atesto,
        String fiscalContrato,
        String gestorContrato
) {
    public NotasContrato converterNotasContrato(ProcessoRepository processoRepository, ContratoRepository contratoRepository){


        NotasContrato notasContrato = new NotasContrato();
        notasContrato.setNotaFiscal(notaFiscal());
        notasContrato.setObjeto(objeto);
        notasContrato.setContratado(contratado);
        notasContrato.setCnpj(cnpj);
        notasContrato.setValorContrato(valorContrato);
        notasContrato.setAtesto(atesto);
        notasContrato.setFiscalContrato(fiscalContrato);
        notasContrato.setGestorContrato(gestorContrato);
        return notasContrato;
    }
}
