package com.example.SIGACTI.services.acaoOrcamentaria;

import com.example.SIGACTI.dto.AcaoOrcamentariaRequest;
import com.example.SIGACTI.dto.AcaoOrcamentariaResponse;
import com.example.SIGACTI.model.entities.AcaoOrcamentaria;
import com.example.SIGACTI.model.repositories.AcaoOrcamentariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateAcaoService {

    private final AcaoOrcamentariaRepository acaoOrcamentariaRepository;
    private AcaoOrcamentariaRepository aRepository;

    @Autowired
    public UpdateAcaoService(AcaoOrcamentariaRepository aRepository, AcaoOrcamentariaRepository acaoOrcamentariaRepository) {
        this.aRepository = aRepository;
        this.acaoOrcamentariaRepository = acaoOrcamentariaRepository;
    }

    public Optional<AcaoOrcamentariaResponse> atualizarAcao(long id, AcaoOrcamentariaRequest request) {
        Optional<AcaoOrcamentaria> acaoOrcamentaria = aRepository.findById(id);
        if (acaoOrcamentaria.isPresent()) {
            AcaoOrcamentaria acao = acaoOrcamentaria.get();

            acao.setAno(request.ano());
            acao.setUnidadeGestora(request.UnidadeGestora());
            acao.setAcaoOrcamentaria(request.acaoOrcamentaria());
            acao.setFonteRecurso(request.fonteRecurso());
            acao.setValor(request.valor());
            acaoOrcamentariaRepository.save(acao);
            return Optional.of(AcaoOrcamentariaResponse.converterAcao(acao));
        }
        return Optional.empty();
    }
}
