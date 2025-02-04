package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.entities.Processo;

import java.util.Date;
import java.util.List;

public record ProcessoResponse(
        String idNumeroProcesso,
        String unidadeGestora,
        String situacao,
        Double valorPrevisto,
        Date dataAtuacao,
        String interessados,
        String assunto,
        String resumoObjeto,
        List<Contrato>contratos,
        List<Inexigibilidade> inexigibilidades

) {
    public static ProcessoResponse conveterProcesso(Processo processo) {
        ProcessoResponse processoResponse = new ProcessoResponse(
                processo.getIdProcesso(),
                processo.getUnidadeGestora(),
                processo.getSituacao(),
                processo.getValorPrevisto(),
                processo.getDataAtuacao(),
                processo.getInteressados(),
                processo.getAssunto(),
                processo.getResumoObjeto(),
                processo.getContratos(),
                processo.getInexigibilidades()
        );
        return processoResponse;
    }
}
