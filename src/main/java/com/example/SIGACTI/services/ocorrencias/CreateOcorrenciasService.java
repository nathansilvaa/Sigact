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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;

@Service
@Transactional
public class CreateOcorrenciasService {

    @Autowired
    private final OcorrenciasRepository ocorrenciasRepository;
    @Autowired
    private final ContratoRepository contratoRepository;
    @Autowired
    private final ProcessoRepository processoRepository;

    public CreateOcorrenciasService(OcorrenciasRepository ocorrenciasRepository, ContratoRepository contratoRepository, ProcessoRepository processoRepository) {
        this.ocorrenciasRepository = ocorrenciasRepository;
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
    }

    public OcorrenciaResponse salvar(OcorreciasRequest ocorreciasRequest) {
        try {
            Ocorrencias ocorrencias = ocorreciasRequest.converterOcorrencia(processoRepository, contratoRepository);

            Optional<Processo> processo = processoRepository.findById(ocorreciasRequest.processo());
            Optional<Contrato> contrato = contratoRepository.findById(ocorreciasRequest.contrato());

            if (processo.isPresent()) {
                ocorrencias.setProcesso(processo.get());
            } else {
                throw new InvalidAttributesException("ID do processo inválido: " + ocorreciasRequest.processo());
            }

            if (contrato.isPresent()) {
                ocorrencias.setContrato(contrato.get());
            } else {
                throw new InvalidAttributesException("ID do contrato inválido: " + ocorreciasRequest.contrato());
            }


            ocorrenciasRepository.save(ocorrencias);
            return new OcorrenciaResponse(
                    ProcessoResponse.conveterProcesso(ocorrencias.getProcesso()),
                    ContratoResponse.conveterContrato(ocorrencias.getContrato()),
                    ocorrencias.getDataOcorrencia(),
                    ocorrencias.getSituacao()
            );
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }
}
