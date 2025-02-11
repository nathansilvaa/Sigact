package com.example.SIGACTI.services.processo;

import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetProcessoService {

    private final ProcessoRepository processoRepository;

    @Autowired
    public GetProcessoService(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    // Método para buscar todos os processos
    public List<ProcessoResponse> obterTodosProcessos() {
        List<Processo> processos = (List<Processo>) processoRepository.findAll();
        return processos.stream()
                .map(ProcessoResponse::conveterProcesso)
                .collect(Collectors.toList());
    }

    // Método para buscar um processo específico pelo ID
    public Optional<ProcessoResponse> obterProcessoPorId(Long idProcesso) {
        Optional<Processo> processoOpt = processoRepository.findById(idProcesso);
        return processoOpt.map(ProcessoResponse::conveterProcesso);
    }
}