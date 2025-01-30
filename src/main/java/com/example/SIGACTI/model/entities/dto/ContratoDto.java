package com.example.SIGACTI.model.entities.dto;

import com.example.SIGACTI.model.entities.NotasContrato;

import java.sql.Date;
import java.util.List;

public record ContratoDto(
        String contrato,
        String processo,
        Date orcamento,
        int acaoOrcamentaria,
        int fonteRecurso,
        String tipoContratacao,
        String contratado,
        int numeroAltomatico,
        String objeto,
        String statusContrato,
        String funLegal,
        String naturezaServico,
        Date dataContrato,
        Date vigenciaInicial,
        Double valorContrato,
        Double saldo,
        float consumido,
        String situacaoVigencia,
        List<NotasContrato> notasContrato
) {}