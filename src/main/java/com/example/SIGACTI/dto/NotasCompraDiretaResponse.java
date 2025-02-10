package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.NotasCompraDireta;

import java.util.Date;

public record NotasCompraDiretaResponse(
        String notaFiscal,
        CompraDireta portaria,
        String sgd,
        String processo,
        String unidade,
        String objeto,
        String contratado,
        String cnpj,
        Double valorTotal,
        Date emissao,
        String atesto,
        String responsavelRecebimento
) {
    public static NotasCompraDiretaResponse converterNotasCompraDireta(NotasCompraDireta nota) {
        return new NotasCompraDiretaResponse(
                nota.getNotaFiscal(),
                nota.getPortaria(),
                nota.getSgd(),
                nota.getProcesso(),
                nota.getUnidade(),
                nota.getObjeto(),
                nota.getContratado(),
                nota.getCnpj(),
                nota.getValorTotal(),
                nota.getEmissao(),
                nota.getAtesto(),
                nota.getResponsavelRecebimento()
        );
    }
}
