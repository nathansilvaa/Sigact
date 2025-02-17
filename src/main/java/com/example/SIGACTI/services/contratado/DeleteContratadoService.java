package com.example.SIGACTI.services.contratado;

import com.example.SIGACTI.model.repositories.ContratadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteContratadoService {
    private final ContratadoRepository contratadoRepository;

    @Autowired
    public DeleteContratadoService(ContratadoRepository contratadoRepository) {
        this.contratadoRepository = contratadoRepository;
    }

    public void deletarContratado(Long idContratado) {
        if (contratadoRepository.existsById(idContratado)) {
            contratadoRepository.deleteById(idContratado);
        } else {
            throw new RuntimeException("Pessoa contratada com ID " + idContratado + " não encontrada.");
        }
    }
}
