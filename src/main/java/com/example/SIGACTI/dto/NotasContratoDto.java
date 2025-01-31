package com.example.SIGACTI.dto;

public record NotasContratoDto(
        String notaFiscal,
        String contrato,
        String processo,
        String objeto,
        String contratado,
        String cnpj,
        Double valorContra,
        String atesto,
        String fiscalContrato,
        String gestorContrato
) {}
