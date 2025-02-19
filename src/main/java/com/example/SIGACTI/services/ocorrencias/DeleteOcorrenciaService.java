package com.example.SIGACTI.services.ocorrencias;

import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import com.example.SIGACTI.model.repositories.OcorrenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteOcorrenciaService {
    private final OcorrenciasRepository ocorrenciasRepository;

    @Autowired
    public DeleteOcorrenciaService(OcorrenciasRepository ocorrenciasRepository) {
        this.ocorrenciasRepository = ocorrenciasRepository;
    }


    @Transactional
    public boolean deletarOcorrencia(Long id) {
        if (ocorrenciasRepository.existsById(id)) {
            ocorrenciasRepository.deleteById(id);
            return true;
        }
        return false; // Retorna false se a nota não existir
    }
}
