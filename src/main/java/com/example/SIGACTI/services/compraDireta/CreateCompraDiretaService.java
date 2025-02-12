package com.example.SIGACTI.services.compraDireta;

import com.example.SIGACTI.dto.CompraDiretaRequest;
import com.example.SIGACTI.dto.CompraDiretaResponse;
import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.CompraDiretaRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;

@Service
@Transactional
public class CreateCompraDiretaService {

    private final CompraDiretaRepository compraDiretaRepository;
    private final ProcessoRepository processoRepository;

    @Autowired
    public CreateCompraDiretaService(CompraDiretaRepository compraDiretaRepository, ProcessoRepository processoRepository) {
        this.compraDiretaRepository = compraDiretaRepository;
        this.processoRepository = processoRepository;
    }

    @Transactional
    public CompraDiretaResponse salvar(CompraDiretaRequest compraDiretaRequest) {
        try {
            CompraDireta compraDireta = compraDiretaRequest.converterCompraDireta(processoRepository);


            Optional<Processo> processo = processoRepository.findById(compraDiretaRequest.idprocesso());
            if (processo.isPresent()) {
                compraDireta.setProcesso(processo.get());
            }else{
                new InvalidAttributesException("Id do processo invalido");
            }
            compraDiretaRepository.save(compraDireta);

            return CompraDiretaResponse.converterCompraDireta(compraDireta);
        } catch (Exception erro) {
            return null;
        }
    }
}