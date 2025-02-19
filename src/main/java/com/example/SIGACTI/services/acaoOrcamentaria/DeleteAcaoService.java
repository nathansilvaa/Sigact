package com.example.SIGACTI.services.acaoOrcamentaria;

import com.example.SIGACTI.model.repositories.AcaoOrcamentariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAcaoService {
    private AcaoOrcamentariaRepository acaoOrcamentariaRepository;
    @Autowired

    public DeleteAcaoService(AcaoOrcamentariaRepository acaoOrcamentariaRepository) {
        this.acaoOrcamentariaRepository = acaoOrcamentariaRepository;
    }

    public void deletarAcaoOrcamentaria(Long id) {
        if (acaoOrcamentariaRepository.existsById(id)) {
            acaoOrcamentariaRepository.deleteById(id);
        }else {
            throw new RuntimeException("Açao orçamentaria com ID" + id + " não encontrato");
        }
    }
}
