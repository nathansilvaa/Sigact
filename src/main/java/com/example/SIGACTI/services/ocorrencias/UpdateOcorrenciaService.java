package com.example.SIGACTI.services.ocorrencias;

import com.example.SIGACTI.dto.*;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.Ocorrencias;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import com.example.SIGACTI.model.repositories.OcorrenciasRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UpdateOcorrenciaService {

    private final OcorrenciasRepository ocorrenciasRepository;
    private final ContratoRepository contratoRepository;
    private final ProcessoRepository processoRepository;


    public UpdateOcorrenciaService(OcorrenciasRepository ocorrenciasRepository, ContratoRepository contratoRepository, ProcessoRepository processoRepository) {
        this.ocorrenciasRepository = ocorrenciasRepository;
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
    }


    public Optional<OcorrenciaResponse> atualizarOcorrencia(Long id, OcorreciasRequest ocorreciasRequest) {
        Optional<Ocorrencias> ocorrencias = ocorrenciasRepository.findById(id);

        if (ocorrencias.isPresent()) {
            Ocorrencias ocorrencias1 = ocorrencias.get();

            // Atualizando os campos da nota de contrato
            ocorrencias1.setDataOcorrencia(ocorreciasRequest.dataOcorrencia());
            ocorrencias1.setSituacao(ocorreciasRequest.situacao());


            // Atualiza o processo, se necessário
            if (ocorreciasRequest.processo() != null) {
                Optional<Processo> processo = processoRepository.findById(ocorrencias1.getId());
                processo.ifPresent(ocorrencias1::setProcesso);
            }

            // Atualiza o contrato, se necessário
            if (ocorreciasRequest.contrato() != null) {
                Optional<Contrato> contratoOpt = contratoRepository.findById(ocorrencias1.getId());
                contratoOpt.ifPresent(ocorrencias1::setContrato);
            }

            ocorrenciasRepository.save(ocorrencias1);

            return Optional.of(new OcorrenciaResponse(
                    ProcessoResponse.conveterProcesso(ocorrencias1.getProcesso()),
                    ContratoResponse.conveterContrato(ocorrencias1.getContrato()),
                                ocorrencias1.getDataOcorrencia(),
                                ocorrencias1.getSituacao()
                        ));
        } else {
            return Optional.empty(); // Retorna vazio caso a nota de contrato não seja encontrada
        }
    }

}
