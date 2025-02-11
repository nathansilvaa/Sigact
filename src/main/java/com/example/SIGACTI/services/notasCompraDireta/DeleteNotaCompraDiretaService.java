package com.example.SIGACTI.services.notasCompraDireta;
import com.example.SIGACTI.model.repositories.NotasCompraDiretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteNotaCompraDiretaService {

    private final NotasCompraDiretaRepository notasCompraDiretaRepository;

    @Autowired
    public DeleteNotaCompraDiretaService(NotasCompraDiretaRepository notasCompraDiretaRepository) {
        this.notasCompraDiretaRepository = notasCompraDiretaRepository;
    }

    public boolean deletarNotaCompraDireta(Long notaFiscal) {
        if (notasCompraDiretaRepository.existsById(notaFiscal)) {
            notasCompraDiretaRepository.deleteById(notaFiscal);
            return true; // Deletado com sucesso
        }
        return false; // Nota não encontrada
    }
}
