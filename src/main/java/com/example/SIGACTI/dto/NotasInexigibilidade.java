package com.example.SIGACTI.dto;

import java.util.Date;

public record NotasInexigibilidade(
        String notaFiscal,
        String portaria,
        String sgd,
        String processo,
        String unidade,
        String objeto,
        String contratado,
        String cnpj,
        Double valorTotal,
        Date emissao,
        String atesto,
        String responsavelRecebimento
) {
}
