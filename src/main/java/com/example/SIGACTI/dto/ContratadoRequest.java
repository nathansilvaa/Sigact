package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.entities.Contrato;

public record ContratadoRequest(
        Long id,
        String cpfOuCnpj,
        String nomeRazaoSocial,
        String email
) {
    public static Contratado converterContratado(ContratadoRequest contratadoRequest) {
        return new Contratado(
            contratadoRequest.id,
            contratadoRequest.cpfOuCnpj,
            contratadoRequest.nomeRazaoSocial,
            contratadoRequest.email
        );
    }
}
