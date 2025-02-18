package com.example.SIGACTI.services.ocorrencias;

import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.dto.OcorrenciaResponse;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Ocorrencias;
import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import com.example.SIGACTI.model.repositories.OcorrenciasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetOcorrenciaService {
    private final OcorrenciasRepository ocorrenciasRepository;

    public GetOcorrenciaService(OcorrenciasRepository ocorrenciasRepository) {
        this.ocorrenciasRepository = ocorrenciasRepository;
    }

    public List<OcorrenciaResponse> obterTodasOcorrencias() {
        List<Ocorrencias> ocorrencias = (List<Ocorrencias>) ocorrenciasRepository.findAll();
        return ocorrencias.stream()
                .map(OcorrenciaResponse::converter)
                .collect(Collectors.toList());
    }

    // Método para buscar uma nota de contrato específica pelo ID (notaFiscal)
    public Optional<OcorrenciaResponse> obterOcorrenciaPorId(Long id) {
        Optional<Ocorrencias> ocorrencias = ocorrenciasRepository.findById(id);
        return ocorrencias.map(OcorrenciaResponse::converter);
    }
}
