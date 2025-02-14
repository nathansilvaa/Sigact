package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.NotasCompraDireta;

import java.util.Date;

public record NotasCompraDiretaResponse(
        Long id,
        String notaFiscal,
        String sgd,
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
                nota.getId(),
                nota.getNotaFiscal(),
                nota.getSgd(),
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
