package com.example.SIGACTI.services.compraDireta;

import com.example.SIGACTI.dto.CompraDiretaResponse;
import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.repositories.CompraDiretaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetCompraDiretaService {

    private final CompraDiretaRepository compraDiretaRepository;

    public GetCompraDiretaService(CompraDiretaRepository compraDiretaRepository) {
        this.compraDiretaRepository = compraDiretaRepository;
    }

    // Método para buscar todas as compras diretas
    public List<CompraDiretaResponse> obterTodasComprasDiretas() {
        List<CompraDireta> comprasDiretas = compraDiretaRepository.findAll();
        return comprasDiretas.stream()
                .map(CompraDiretaResponse::converterCompraDireta)
                .collect(Collectors.toList());
    }

    // Método para buscar uma compra direta específica pelo ID
    public Optional<CompraDiretaResponse> obterCompraDiretaPorId(String idCompraDireta) {
        Optional<CompraDireta> compraDiretaOpt = compraDiretaRepository.findById(idCompraDireta);
        return compraDiretaOpt.map(CompraDiretaResponse::converterCompraDireta);
    }
}
