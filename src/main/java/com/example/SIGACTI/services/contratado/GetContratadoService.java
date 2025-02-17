package com.example.SIGACTI.services.contratado;
import com.example.SIGACTI.dto.ContratadoResponse;
import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.repositories.ContratadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetContratadoService {
    private final ContratadoRepository contratadoRepository;

    public GetContratadoService(ContratadoRepository contratadoRepository) { this.contratadoRepository = contratadoRepository; }

    public List<ContratadoResponse> obterTodosContratados() {
        List<Contratado> listaContratados = (List<Contratado>) contratadoRepository.findAll();
        return listaContratados.stream()
            .map(ContratadoResponse::converterContratado)
            .collect(Collectors.toList());
    }
    // Busca pelo id
    public Optional<ContratadoResponse> obterContratadoPorId(Long idContratado) {
        Optional<Contratado> contratadoOpt = contratadoRepository.findById(idContratado);
        return contratadoOpt.map(ContratadoResponse::converterContratado);
    }
}
