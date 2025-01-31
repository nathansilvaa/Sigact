package com.example.SIGACTI.dto;

import java.util.Date;
import java.util.List;

public record ProcessoDto(
        String processo,
        String unidadeGestora,
        String situacao,
        Double valorPrevisto,
        Date dataAtuacao,
        String interessados,
        String assunto,
        String resumoObjeto,
        List<String> contratos,
        List<String> inexigibilidades
) {
}
