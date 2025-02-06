package com.example.SIGACTI.services.processo;

import com.example.SIGACTI.dto.ProcessoRequest;
import com.example.SIGACTI.dto.ProcessoResponse;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UpdateProcessoService {

    private final ProcessoRepository processoRepository;

    @Autowired
    public UpdateProcessoService(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    // Método para atualizar um processo
    public Optional<ProcessoResponse> atualizarProcesso(String idProcesso, ProcessoRequest request) {
        Optional<Processo> processoOpt = processoRepository.findById(idProcesso);

        if (processoOpt.isPresent()) {
            Processo processo = processoOpt.get();

            // Atualizando os dados do processo
            processo.setUnidadeGestora(request.unidadeGestora());
            processo.setSituacao(request.situacao());
            processo.setValorPrevisto(request.valorPrevisto());
            processo.setDataAtuacao(request.dataAtuacao());
            processo.setInteressados(request.interessados());
            processo.setAssunto(request.assunto());
            processo.setResumoObjeto(request.resumoObjeto());

            // Salvando no banco
            processoRepository.save(processo);

            return Optional.of(ProcessoResponse.conveterProcesso(processo));
        }

        return Optional.empty();
    }
}