package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.AcaoOrcamentaria;

public record AcaoOrcamentariaResponse(
         Long id,
         Integer ano,
         String UnidadeGestora,
         String acaoOrcamentaria,
         String fonteRecurso,
         Double valor
) {
    public static AcaoOrcamentariaResponse converterAcao(AcaoOrcamentaria acaoOrcamentaria) {
        AcaoOrcamentariaResponse acaoOrcamentariaResponse = new AcaoOrcamentariaResponse(
                acaoOrcamentaria.getId(),
                acaoOrcamentaria.getAno(),
                acaoOrcamentaria.getUnidadeGestora(),
                acaoOrcamentaria.getAcaoOrcamentaria(),
                acaoOrcamentaria.getFonteRecurso(),
                acaoOrcamentaria.getValor()
        );
        return acaoOrcamentariaResponse;
    }
}
