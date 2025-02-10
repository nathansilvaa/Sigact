package com.example.SIGACTI.services.notasCompraDireta;

import com.example.SIGACTI.dto.NotasCompraDiretaResponse;
import com.example.SIGACTI.model.entities.NotasCompraDireta;
import com.example.SIGACTI.model.repositories.NotasCompraDiretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GetNotaCompraDiretaService {

    private final NotasCompraDiretaRepository notasCompraDiretaRepository;

    @Autowired
    public GetNotaCompraDiretaService(NotasCompraDiretaRepository notasCompraDiretaRepository) {
        this.notasCompraDiretaRepository = notasCompraDiretaRepository;
    }

    // Método para obter todas as notas de compra direta
    public List<NotasCompraDiretaResponse> obterTodasNotas() {
        Iterable<NotasCompraDireta> notas = notasCompraDiretaRepository.findAll();
        return StreamSupport.stream(notas.spliterator(), false)
                .map(NotasCompraDiretaResponse::converterNotasCompraDireta)
                .collect(Collectors.toList());
    }

    // Método para obter uma nota específica pelo ID (notaFiscal)
    public Optional<NotasCompraDiretaResponse> obterNotaPorId(String notaFiscal) {
        Optional<NotasCompraDireta> notaOpt = notasCompraDiretaRepository.findById(notaFiscal);
        return notaOpt.map(NotasCompraDiretaResponse::converterNotasCompraDireta);
    }
}
