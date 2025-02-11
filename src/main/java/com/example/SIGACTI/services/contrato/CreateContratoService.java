package com.example.SIGACTI.services.contrato;

import com.example.SIGACTI.dto.ContratoRequest;
import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;
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



    public CreateContratoService(ContratoRepository contratoRepository, ProcessoRepository processoRepository) {
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
    }

    @Transactional
    public ContratoResponse salvar(ContratoRequest contratoDto) {
        try {
            Contrato contrato = ContratoRequest.converterContrato(contratoDto);


            Optional<Processo> processo = processoRepository.findById(contratoDto.idProcesso());
            if (processo.isPresent()) {
                contrato.setProcesso(processo.get());
            }else{
                new InvalidAttributesException("Id do processo invalido");
            }
            contratoRepository.save(contrato);

            return ContratoResponse.conveterContrato(contrato);
        }catch (Exception erro){
            return null;
        }
    }
}
