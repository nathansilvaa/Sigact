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

import java.util.Optional;

@Service
@Transactional
public class UpdateContratoService {

    private final ContratoRepository contratoRepository;
    private final ProcessoRepository processoRepository;

    @Autowired
    public UpdateContratoService(ContratoRepository contratoRepository, ProcessoRepository processoRepository) {
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
    }

    public Optional<ContratoResponse> atualizarContrato(Long idContrato, ContratoRequest contratoDto) {
        Optional<Contrato> contratoOpt = contratoRepository.findById(idContrato);

        if (contratoOpt.isPresent()) {
            Contrato contrato = contratoOpt.get();

            // Atualizando os campos do contrato
            contrato.setOrcamento(contratoDto.orcamento());
            contrato.setAcaoOrcamentaria(contratoDto.acaoOrcamentaria());
            contrato.setFonteRecurso(contratoDto.fonteRecurso());
            contrato.setTipoContratacao(contratoDto.tipoContratacao());
            contrato.setContratado(contratoDto.contratado());
            contrato.setNumeroAltomatico(contratoDto.numeroAltomatico());
            contrato.setObjeto(contratoDto.objeto());
            contrato.setStatusContrato(contratoDto.statusContrato());
            contrato.setFunLegal(contratoDto.funLegal());
            contrato.setNaturezaServico(contratoDto.naturezaServico());
            contrato.setDataContrato(contratoDto.dataContrato());
            contrato.setVigenciaInicial(contratoDto.vigenciaInicial());
            contrato.setValorContrato(contratoDto.valorContrato());
            contrato.setConsumido(contratoDto.consumido());
            contrato.setSituacaoVigencia(contratoDto.situacaoVigencia());

            // Atualiza o processo, se necessário
            if (contratoDto.idProcesso() != null) {
                Optional<Processo> processoOpt = processoRepository.findById(contratoDto.idProcesso());
                processoOpt.ifPresent(contrato::setProcesso);
            }

            contratoRepository.save(contrato);

            return Optional.of(ContratoResponse.conveterContrato(contrato));
        } else {
            return Optional.empty(); // Retorna vazio caso o contrato não seja encontrado
        }
    }
}