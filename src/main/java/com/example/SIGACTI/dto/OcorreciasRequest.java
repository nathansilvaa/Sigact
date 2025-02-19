package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Ocorrencias;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;

import java.util.Date;

public record OcorreciasRequest(
        Long processo,
        Long contrato,
        Date dataOcorrencia,
        String situacao
) {
    public Ocorrencias converterOcorrencia(ProcessoRepository processoRepository, ContratoRepository contratoRepository){
        Ocorrencias ocorrencias = new Ocorrencias();
        ocorrencias.setProcesso(processoRepository.findById(processo).get());
        ocorrencias.setContrato(contratoRepository.findById(contrato).get());
        ocorrencias.setDataOcorrencia(dataOcorrencia);
        ocorrencias.setSituacao(situacao);
        return ocorrencias;
    }
}
