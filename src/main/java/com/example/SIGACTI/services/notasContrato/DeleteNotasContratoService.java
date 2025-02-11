package com.example.SIGACTI.services.notasContrato;

import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteNotasContratoService {

    private final NotasContratoRepository notasContratoRepository;

    @Autowired
    public DeleteNotasContratoService(NotasContratoRepository notasContratoRepository) {
        this.notasContratoRepository = notasContratoRepository;
    }

    @Transactional
    public boolean deletarNotasContrato(Long notaFiscal) {
        if (notasContratoRepository.existsById(notaFiscal)) {
            notasContratoRepository.deleteById(notaFiscal);
            return true;
        }
        return false; // Retorna false se a nota não existir
    }
}
