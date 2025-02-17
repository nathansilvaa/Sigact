package com.example.SIGACTI.services.acaoOrcamentaria;

import com.example.SIGACTI.dto.AcaoOrcamentariaRequest;
import com.example.SIGACTI.dto.AcaoOrcamentariaResponse;
import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.model.entities.AcaoOrcamentaria;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.AcaoOrcamentariaRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateAcaoOrcamentariaService {

    private final AcaoOrcamentariaRepository acaoOrcamentariaRepository;

    public CreateAcaoOrcamentariaService(AcaoOrcamentariaRepository acaoOrcamentariaRepository) {
        this.acaoOrcamentariaRepository = acaoOrcamentariaRepository;
    }

    public AcaoOrcamentariaResponse criarAcao(AcaoOrcamentariaRequest acaoOrcamentariaRequest) {
        AcaoOrcamentaria acaoOrcamentaria = AcaoOrcamentariaRequest.converter(acaoOrcamentariaRequest);
        acaoOrcamentaria = acaoOrcamentariaRepository.save(acaoOrcamentaria);
        return AcaoOrcamentariaResponse.converterAcao(acaoOrcamentaria);
    }
}
