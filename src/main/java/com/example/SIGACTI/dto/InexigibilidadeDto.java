package com.example.SIGACTI.dto;

import java.util.Date;

public record InexigibilidadeDto(
        String portaria,
        String processo,
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
}
