package com.example.SIGACTI.services.processo;
import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;

import com.example.SIGACTI.model.entities.Processo;

import com.example.SIGACTI.model.repositories.ProcessoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateProcessoService {

    private final ProcessoRepository processoRepository;

    public CreateProcessoService(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    public ProcessoResponse criarProcesso(ProcessoRequest processoRequest) {
        Processo processo = ProcessoRequest.conveterProcesso(processoRequest);
        processo = processoRepository.save(processo);
        return ProcessoResponse.conveterProcesso(processo);
    }
}
