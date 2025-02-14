package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.NotasCompraDireta;

import java.util.Date;
import java.util.List;

public record CompraDiretaResponseList(
        Long id,
        String portaria,
        String resumoObjeto,
        String interessado,
        String sgd,
        String objeto,
        String statusContrato,
        String funLegal,
        String naturezaServico,
        Date dataContrato,
        Integer prazoContrato,
        Date vigencia,
        Double valorContrato,
        Double saldo,
        Double saldoRestanteCompraDireta,
        Long percentualConsumido,
        String situacaoVigencia,
        double consumido,
        List<NotasCompraDiretaResponse> notasCompraDireta
) {
    public static CompraDiretaResponseList converterCompraDireta(CompraDireta compraDireta) {
        CompraDiretaResponseList compraDiretaResponse = new CompraDiretaResponseList(
                compraDireta.getId(),
                compraDireta.getPortaria(),
                compraDireta.getResumoObjeto(),
                compraDireta.getInteressado(),
                compraDireta.getSgd(),
                compraDireta.getObjeto(),
                compraDireta.getStatusContrato(),
                compraDireta.getFunLegal(),
                compraDireta.getNaturezaServico(),
                compraDireta.getDataContrato(),
                compraDireta.getPrazoContrato(),
                compraDireta.getVigencia(),
                compraDireta.getValorContrato(),
                compraDireta.getSaldo(),
                compraDireta.getSaldoRestanteCompraDireta(),
                compraDireta.getPercentualConsumido(),
                compraDireta.getSituacaoVigencia(),
                compraDireta.getConsumido(),
                compraDireta.getNotasCompraDiretas().stream().map(NotasCompraDiretaResponse::converterNotasCompraDireta).toList()
        );
        return compraDiretaResponse;
    }
}
