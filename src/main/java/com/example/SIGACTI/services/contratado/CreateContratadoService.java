package com.example.SIGACTI.services.contratado;

import com.example.SIGACTI.dto.ContratadoRequest;
import com.example.SIGACTI.dto.ContratadoResponse;
import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratadoRepository;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;

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
