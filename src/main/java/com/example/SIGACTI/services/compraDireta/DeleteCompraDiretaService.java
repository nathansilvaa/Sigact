package com.example.SIGACTI.services.compraDireta;

import com.example.SIGACTI.model.repositories.CompraDiretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteCompraDiretaService {

    private final CompraDiretaRepository compraDiretaRepository;

    @Autowired
    public DeleteCompraDiretaService(CompraDiretaRepository compraDiretaRepository) {
        this.compraDiretaRepository = compraDiretaRepository;
    }

    @Transactional
    public boolean deletarCompraDireta(Long idCompraDireta) {
        if (compraDiretaRepository.existsById(idCompraDireta)) {
            compraDiretaRepository.deleteById(idCompraDireta);
            return true;
        }
        return false; // Retorna false se a compra direta não existir
    }
}
