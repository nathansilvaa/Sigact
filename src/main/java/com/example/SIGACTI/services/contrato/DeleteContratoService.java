package com.example.SIGACTI.services.contrato;

import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class DeleteContratoService {

    private final ContratoRepository contratoRepository;

    @Autowired
    public DeleteContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    @Transactional
    public boolean deletarContrato(Long idNumeroContrato) {
        if (contratoRepository.existsById(idNumeroContrato)) {
            contratoRepository.deleteById(idNumeroContrato);
            return true;
        }
        return false; // Retorna false se o contrato não existir
    }
}
