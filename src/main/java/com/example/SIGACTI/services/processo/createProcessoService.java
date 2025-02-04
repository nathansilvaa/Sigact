package com.example.SIGACTI.services.processo;

import com.example.SIGACTI.dto.ContratoRequest;
import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;

import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;

@Service
@Transactional
public class createProcessoService {

    private final ProcessoRepository processoRepository;

    public createProcessoService(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    public ProcessoResponse criarProcesso(ProcessoRequest processoRequest) {
        Processo processo = ProcessoRequest.conveterProcesso(processoRequest);
        processo = processoRepository.save(processo);
        return ProcessoResponse.conveterProcesso(processo);
    }
}
