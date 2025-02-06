package com.example.SIGACTI.services.notasContrato;

import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetNotasContratoService {
    private final NotasContratoRepository notasContratoRepository;

    public GetNotasContratoService(NotasContratoRepository notasContratoRepository) {
        this.notasContratoRepository = notasContratoRepository;
    }

    // Método para buscar todas as notas de contrato
    public List<NotasContratoResponse> obterTodasNotasContrato() {
        List<NotasContrato> notasContrato = (List<NotasContrato>) notasContratoRepository.findAll();
        return notasContrato.stream()
                .map(NotasContratoResponse::converterNotasContrato)
                .collect(Collectors.toList());
    }

    // Método para buscar uma nota de contrato específica pelo ID (notaFiscal)
    public Optional<NotasContratoResponse> obterNotaContratoPorId(String notaFiscal) {
        Optional<NotasContrato> notaOpt = notasContratoRepository.findById(notaFiscal);
        return notaOpt.map(NotasContratoResponse::converterNotasContrato);
    }
}
