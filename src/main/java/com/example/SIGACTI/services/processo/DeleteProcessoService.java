package com.example.SIGACTI.services.processo;

import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProcessoService {

    private final ProcessoRepository processoRepository;

    @Autowired
    public DeleteProcessoService(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    public void deletarProcesso(Long idProcesso) {
        if (processoRepository.existsById(idProcesso)) {
            processoRepository.deleteById(idProcesso);
        } else {
            throw new RuntimeException("Processo com ID " + idProcesso + " não encontrado.");
        }
    }
}
