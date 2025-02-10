package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ProcessoRepository;

import java.util.Date;

public record CompraDiretaRequest(
        String portaria,
        String processo,
        String resumoObjeto,
        String interessado,
        String sgd,
        String objeto,
        String statusContrato,
        String funLegal,
        String naturezaServico,
        Date dataContrato,
        Integer prazoContrato,
        Date vigencia,
        Double valorContrato,
        Double saldo,
        String situacaoVigencia,
        double consumido

) {
    public CompraDireta converterCompraDireta(ProcessoRepository processoRepository){

        Processo processo2 = processoRepository.findById(processo).orElse(null);

        CompraDireta  compraDireta = new CompraDireta();
        compraDireta.setPortaria(portaria);
        compraDireta.setProcesso(processo2);
        compraDireta.setResumoObjeto(resumoObjeto);
        compraDireta.setInteressado(interessado);
        compraDireta.setSgd(sgd());
        compraDireta.setObjeto(objeto());
        compraDireta.setStatusContrato(statusContrato);
        compraDireta.setFunLegal(funLegal);
        compraDireta.setNaturezaServico(naturezaServico);
        compraDireta.setDataContrato(dataContrato);
        compraDireta.setPrazoContrato(prazoContrato);
        compraDireta.setVigencia(vigencia);
        compraDireta.setValorContrato(valorContrato);
        compraDireta.setSaldo(saldo);
        compraDireta.setSituacaoVigencia(situacaoVigencia);
        compraDireta.setConsumido(consumido);
        return compraDireta;
    }
}
