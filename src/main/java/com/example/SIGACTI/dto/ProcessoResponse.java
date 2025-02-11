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
        String resumoObjeto


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
                processo.getResumoObjeto()

        );
        return processoResponse;
    }
}
