package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;

import java.util.Date;
import java.util.List;

public record ProcessoRequest(
        String idNumeroProcesso,
        String unidadeGestora,
        String situacao,
        Double valorPrevisto,
        Date dataAtuacao,
        String interessados,
        String assunto,
        String resumoObjeto
) {
    public static Processo conveterProcesso(ProcessoRequest request) {
        Processo processo = new Processo();
        processo.setIdProcesso(request.idNumeroProcesso);
        processo.setUnidadeGestora(request.unidadeGestora);
        processo.setSituacao(request.situacao);
        processo.setValorPrevisto(request.valorPrevisto);
        processo.setDataAtuacao(request.dataAtuacao);
        processo.setInteressados(request.interessados);
        processo.setAssunto(request.assunto);
        processo.setResumoObjeto(request.resumoObjeto);
        return processo;
    }
}
