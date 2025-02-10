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
public class UpdateNotaCompraDiretaService {

    private final NotasCompraDiretaRepository notasCompraDiretaRepository;
    private final CompraDiretaRepository compraDiretaRepository;

    @Autowired
    public UpdateNotaCompraDiretaService(NotasCompraDiretaRepository notasCompraDiretaRepository, CompraDiretaRepository compraDiretaRepository) {
        this.notasCompraDiretaRepository = notasCompraDiretaRepository;
        this.compraDiretaRepository = compraDiretaRepository;
    }

    public Optional<NotasCompraDiretaResponse> atualizarNotaCompraDireta(String notaFiscal, NotasCompraDiretaRequest request) {
        Optional<NotasCompraDireta> notaOpt = notasCompraDiretaRepository.findById(notaFiscal);

        if (notaOpt.isPresent()) {
            NotasCompraDireta nota = notaOpt.get();

            // Atualizando os campos da nota de compra direta
            nota.setSgd(request.sgd());
            nota.setProcesso(request.processo());
            nota.setUnidade(request.unidade());
            nota.setObjeto(request.objeto());
            nota.setContratado(request.contratado());
            nota.setCnpj(request.cnpj());
            nota.setValorTotal(request.valorTotal());
            nota.setEmissao(request.emissao());
            nota.setAtesto(request.atesto());
            nota.setResponsavelRecebimento(request.responsavelRecebimento());

            // Atualiza a CompraDireta (portaria), se necessário
            if (request.portaria() != null) {
                Optional<CompraDireta> compraDiretaOpt = compraDiretaRepository.findById(request.portaria());
                compraDiretaOpt.ifPresent(nota::setPortaria);
            }

            notasCompraDiretaRepository.save(nota);

            return Optional.of(NotasCompraDiretaResponse.converterNotasCompraDireta(nota));
        } else {
            return Optional.empty(); // Retorna vazio caso a nota não seja encontrada
        }
    }
}
