package com.example.SIGACTI.services.contrato;

import com.example.SIGACTI.dto.ContratoRequest;
import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.model.entities.AcaoOrcamentaria;
import com.example.SIGACTI.model.entities.Contratado;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.AcaoOrcamentariaRepository;
import com.example.SIGACTI.model.repositories.ContratadoRepository;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;

@Service
public class CreateContratoService {

    @Autowired
    private final ContratoRepository contratoRepository;
    @Autowired
    private final ProcessoRepository processoRepository;

    @Autowired
    private AcaoOrcamentariaRepository acaoOrcamentariaRepository;

    @Autowired
    ContratadoRepository contratadoRepository;


    public CreateContratoService(ContratoRepository contratoRepository, ProcessoRepository processoRepository, AcaoOrcamentariaRepository acaoOrcamentariaRepository, ContratadoRepository contratadoRepository) {
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
        this.acaoOrcamentariaRepository = acaoOrcamentariaRepository;
        this.contratadoRepository = contratadoRepository;
    }

    @Transactional
    public ContratoResponse salvar(ContratoRequest contratoDto) {

        AcaoOrcamentaria encontrada = acaoOrcamentariaRepository.findById(contratoDto.acaoOrcamentaria()).orElseThrow(() -> new RuntimeException("Acao nao encontrada"));
        Contratado econtrado = contratadoRepository.findById(contratoDto.contratado()).orElseThrow(() -> new RuntimeException("Contratado nao encontrada"));
        try {
            Contrato contrato = ContratoRequest.converterContrato(contratoDto,encontrada,econtrado);


            Optional<Processo> processo = processoRepository.findById(contratoDto.idProcesso());
            if (processo.isPresent()) {
                contrato.setProcesso(processo.get());
            }else{
                throw new InvalidAttributesException("Id do processo invalido");
            }
            contratoRepository.save(contrato);

            return ContratoResponse.conveterContrato(contrato);
        }catch (Exception erro){
            return null;
        }
    }
}
