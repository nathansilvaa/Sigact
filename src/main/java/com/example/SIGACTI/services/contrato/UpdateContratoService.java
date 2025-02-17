package com.example.SIGACTI.services.contrato;

import com.example.SIGACTI.dto.ContratoRequest;
import com.example.SIGACTI.dto.ContratoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.AcaoOrcamentariaRepository;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateContratoService {

    private  ContratoRepository contratoRepository;
    private  ProcessoRepository processoRepository;
    private  AcaoOrcamentariaRepository acaoOrcamentariaRepository;

    @Autowired
    public UpdateContratoService(ContratoRepository contratoRepository, ProcessoRepository processoRepository, AcaoOrcamentariaRepository acaoOrcamentariaRepository) {
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
        this.acaoOrcamentariaRepository = acaoOrcamentariaRepository;
    }


    public Optional<ContratoResponse> atualizarContrato(Long idContrato, ContratoRequest contratoDto) {
        Optional<Contrato> contratoOpt = contratoRepository.findById(idContrato);

        var acao = acaoOrcamentariaRepository.findById(contratoDto.acaoOrcamentaria()).orElse(null);

        if (contratoOpt.isPresent()) {
            Contrato contrato = contratoOpt.get();

            contrato.setOrcamento(contratoDto.orcamento());
            contrato.setAcaoOrcamentaria(acao);
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
            contrato.setSituacaoVigencia(contratoDto.situacaoVigencia());

            if (contratoDto.idProcesso() != null) {
                Optional<Processo> processoOpt = processoRepository.findById(contratoDto.idProcesso());
                processoOpt.ifPresent(contrato::setProcesso);
            }

            contratoRepository.save(contrato);

            return Optional.of(ContratoResponse.conveterContrato(contrato));
        } else {
            return Optional.empty();
        }
    }
}