package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;

import java.util.Optional;

public record NotasContratoRequest(
        String notaFiscal,
        String contrato,
        String processo,
        String objeto,
        String contratado,
        String cnpj,
        Double valorContrato,
        String atesto,
        String fiscalContrato,
        String gestorContrato
) {
    public NotasContrato converterNotasContrato(ProcessoRepository processoRepository, ContratoRepository contratoRepository){

        Processo processo2 = processoRepository.findById(processo).orElse(null);
        Contrato contrato2 = contratoRepository.findById(contrato).orElse(null);

        NotasContrato notasContrato = new NotasContrato();
        notasContrato.setNotaFiscal(notaFiscal());
        notasContrato.setContrato(contrato2);
        notasContrato.setProcesso(processo2);
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
