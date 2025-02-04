package com.example.SIGACTI.services.contrato;

import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetContratoService {
    private final ContratoRepository contratoRepository;

    public GetContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    // Método para buscar todos os contratos
    public List<ContratoResponse> obterTodosContratos() {
        List<Contrato> contratos = (List<Contrato>) contratoRepository.findAll();
        return contratos.stream()
                .map(ContratoResponse::conveterContrato)
                .collect(Collectors.toList());
    }

    // Método para buscar um contrato específico pelo ID
    public Optional<ContratoResponse> obterContratoPorId(String idContrato) {
        Optional<Contrato> contratoOpt = contratoRepository.findById(idContrato);
        return contratoOpt.map(ContratoResponse::conveterContrato);
    }
}
