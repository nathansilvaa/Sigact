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

import java.util.Optional;

@Service
@Transactional
public class UpdateCompraDiretaService {

    private final CompraDiretaRepository compraDiretaRepository;
    private final ProcessoRepository processoRepository;

    @Autowired
    public UpdateCompraDiretaService(CompraDiretaRepository compraDiretaRepository, ProcessoRepository processoRepository) {
        this.compraDiretaRepository = compraDiretaRepository;
        this.processoRepository = processoRepository;
    }

    public Optional<CompraDiretaResponse> atualizarCompraDireta(Long idCompraDireta, CompraDiretaRequest compraDiretaDto) {
        Optional<CompraDireta> compraDiretaOpt = compraDiretaRepository.findById(idCompraDireta);

        if (compraDiretaOpt.isPresent()) {
            CompraDireta compraDireta = compraDiretaOpt.get();

            // Atualizando os campos da compra direta
            compraDireta.setPortaria(compraDiretaDto.portaria());
            compraDireta.setResumoObjeto(compraDiretaDto.resumoObjeto());
            compraDireta.setInteressado(compraDiretaDto.interessado());
            compraDireta.setSgd(compraDiretaDto.sgd());
            compraDireta.setObjeto(compraDiretaDto.objeto());
            compraDireta.setStatusContrato(compraDiretaDto.statusContrato());
            compraDireta.setFunLegal(compraDiretaDto.funLegal());
            compraDireta.setNaturezaServico(compraDiretaDto.naturezaServico());
            compraDireta.setDataContrato(compraDiretaDto.dataContrato());
            compraDireta.setPrazoContrato(compraDiretaDto.prazoContrato());
            compraDireta.setVigencia(compraDiretaDto.vigencia());
            compraDireta.setValorContrato(compraDiretaDto.valorContrato());
            compraDireta.setSaldo(compraDiretaDto.saldo());
            compraDireta.setSituacaoVigencia(compraDiretaDto.situacaoVigencia());
            compraDireta.setConsumido(compraDiretaDto.consumido());

            // Atualiza o processo, se necessário
            if (compraDiretaDto.idprocesso() != null) {
                Optional<Processo> processoOpt = processoRepository.findById(compraDiretaDto.idprocesso());
                processoOpt.ifPresent(compraDireta::setProcesso);
            }

            compraDiretaRepository.save(compraDireta);

            return Optional.of(CompraDiretaResponse.converterCompraDireta(compraDireta));
        } else {
            return Optional.empty(); // Retorna vazio caso a compra direta não seja encontrada
        }
    }
}
