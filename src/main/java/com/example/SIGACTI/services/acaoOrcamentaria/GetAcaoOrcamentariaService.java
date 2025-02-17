package com.example.SIGACTI.services.acaoOrcamentaria;

import com.example.SIGACTI.dto.AcaoOrcamentariaResponse;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.model.entities.AcaoOrcamentaria;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.AcaoOrcamentariaRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetAcaoOrcamentariaService {

    private final AcaoOrcamentariaRepository acaoOrcamentariaRepository;

    public GetAcaoOrcamentariaService(AcaoOrcamentariaRepository acaoOrcamentariaRepository) {
        this.acaoOrcamentariaRepository = acaoOrcamentariaRepository;
    }

    public List<AcaoOrcamentariaResponse> obterTodasAcoes() {
        List<AcaoOrcamentaria> acaoOrcamentarias = (List<AcaoOrcamentaria>) acaoOrcamentariaRepository.findAll();
        return acaoOrcamentarias.stream()
                .map(AcaoOrcamentariaResponse::converterAcao)
                .collect(Collectors.toList());
    }

    public Optional<AcaoOrcamentariaResponse> obterProcessoPorId(Long id) {
        Optional<AcaoOrcamentaria> acaoOrcamentaria = acaoOrcamentariaRepository.findById(id);
        return acaoOrcamentaria.map(AcaoOrcamentariaResponse::converterAcao);
    }
}