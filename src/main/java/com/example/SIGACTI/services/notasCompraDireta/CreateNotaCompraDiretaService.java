package com.example.SIGACTI.services.notasCompraDireta;


import com.example.SIGACTI.dto.NotasCompraDiretaRequest;
import com.example.SIGACTI.dto.NotasCompraDiretaResponse;
import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.NotasCompraDireta;
import com.example.SIGACTI.model.repositories.CompraDiretaRepository;
import com.example.SIGACTI.model.repositories.NotasCompraDiretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CreateNotaCompraDiretaService {

    private final NotasCompraDiretaRepository notasCompraDiretaRepository;
    private final CompraDiretaRepository compraDiretaRepository;

    @Autowired
    public CreateNotaCompraDiretaService(NotasCompraDiretaRepository notasCompraDiretaRepository, CompraDiretaRepository compraDiretaRepository) {
        this.notasCompraDiretaRepository = notasCompraDiretaRepository;
        this.compraDiretaRepository = compraDiretaRepository;
    }

    public NotasCompraDiretaResponse salvar(NotasCompraDiretaRequest request) {
        try {
            // Verificar se a CompraDireta (portaria) existe
            Optional<CompraDireta> compraDiretaOpt = compraDiretaRepository.findById(request.portaria());

            if (compraDiretaOpt.isPresent()) {
                // Converter o request em uma entidade
                NotasCompraDireta nota = NotasCompraDiretaRequest.converterNotasCompraDireta(request, compraDiretaOpt.get());

                // Salvar a nota
                notasCompraDiretaRepository.save(nota);

                // Retornar a resposta
                return NotasCompraDiretaResponse.converterNotasCompraDireta(nota);
            } else {
                throw new IllegalArgumentException("Compra Direta (portaria) não encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Você pode tratar melhor os erros, retornando mensagens mais específicas
        }
    }
}
