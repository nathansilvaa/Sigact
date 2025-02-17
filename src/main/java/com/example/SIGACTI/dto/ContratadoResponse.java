package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.entities.Contrato;

import java.util.List;

public record ContratadoResponse(
        Long id,
        String cpfOuCnpj,
        String nomeRazaoSocial,
        String email
) {
    public static ContratadoResponse converterContratado(Contratado contratado) {
        return new ContratadoResponse(
          contratado.getId(),
          contratado.getCpfOuCnpj(),
          contratado.getNomeRazaoSocial(),
          contratado.getEmail()
        );
    }
}
