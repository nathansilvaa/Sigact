package com.example.SIGACTI.services.contratado;

import com.example.SIGACTI.dto.ContratadoRequest;
import com.example.SIGACTI.dto.ContratadoResponse;
import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.repositories.ContratadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateContratadoService {

    @Autowired
    private final ContratadoRepository contratadoRepository;

    public CreateContratadoService(ContratadoRepository contratadoRepository) {
        this.contratadoRepository = contratadoRepository;
    }

    public ContratadoResponse criarContratado(ContratadoRequest contratadoRequest) {
        Contratado contratado = ContratadoRequest.converterContratado(contratadoRequest);
        contratado = contratadoRepository.save(contratado);
        return ContratadoResponse.converterContratado(contratado);
    }
}
