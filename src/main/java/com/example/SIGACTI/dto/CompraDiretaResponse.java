package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.Processo;

import java.util.Date;

public record CompraDiretaResponse(
        Long id,
        String portaria,
        ProcessoResponse processo,
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
        String situacaoVigencia,
        double consumido
) {
    public static CompraDiretaResponse converterCompraDireta(CompraDireta compraDireta) {
        CompraDiretaResponse compraDiretaResponse = new CompraDiretaResponse(
                compraDireta.getId(),
                compraDireta.getPortaria(),
                ProcessoResponse.conveterProcesso(compraDireta.getProcesso()),
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
                compraDireta.getSituacaoVigencia(),
                compraDireta.getConsumido()
        );
        return compraDiretaResponse;
    }
}
