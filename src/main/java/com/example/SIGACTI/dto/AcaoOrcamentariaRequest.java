package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.AcaoOrcamentaria;

public record AcaoOrcamentariaRequest(

        Integer ano,
        String UnidadeGestora,
        String acaoOrcamentaria,
        String fonteRecurso,
        Double valor
) {
    public static AcaoOrcamentaria converter(AcaoOrcamentariaRequest request) {
        AcaoOrcamentaria acaoOrcamentaria = new AcaoOrcamentaria();
        acaoOrcamentaria.setAno(request.ano);
        acaoOrcamentaria.setUnidadeGestora(request.UnidadeGestora);
        acaoOrcamentaria.setAcaoOrcamentaria(request.acaoOrcamentaria);
        acaoOrcamentaria.setFonteRecurso(request.fonteRecurso);
        acaoOrcamentaria.setValor(request.valor);
        return acaoOrcamentaria;
    }
}
