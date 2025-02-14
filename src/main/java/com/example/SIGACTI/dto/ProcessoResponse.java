package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.Contrato;

import com.example.SIGACTI.model.entities.Processo;

import java.util.Date;
import java.util.List;

public record ProcessoResponse(
        Long id,
        String idNumeroProcesso,
        String unidadeGestora,
        String situacao,
        Double valorPrevisto,
        Date dataAtuacao,
        String interessados,
        String assunto,
        String resumoObjeto,
        List<ProcessoContratoResponse> contratos,
        List<CompraDiretaResponseList> compraDireta

) {
    public static ProcessoResponse conveterProcesso(Processo processo) {
        ProcessoResponse processoResponse = new ProcessoResponse(
                processo.getId(),
                processo.getIdProcesso(),
                processo.getUnidadeGestora(),
                processo.getSituacao(),
                processo.getValorPrevisto(),
                processo.getDataAtuacao(),
                processo.getInteressados(),
                processo.getAssunto(),
                processo.getResumoObjeto(),
                processo.getContratos().stream().map(ProcessoContratoResponse::conveterContrato).toList(),
                processo.getComprasDireta().stream().map(CompraDiretaResponseList::converterCompraDireta).toList()
        );
        return processoResponse;
    }
}
