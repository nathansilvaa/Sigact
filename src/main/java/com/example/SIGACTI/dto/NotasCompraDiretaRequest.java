package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.CompraDireta;
import com.example.SIGACTI.model.entities.NotasCompraDireta;

import java.util.Date;

public record NotasCompraDiretaRequest(
        String notaFiscal,
        Long idCompraDireta, // Referência ao ID da CompraDireta
        String sgd,
        String processo,
        String unidade,
        String objeto,
        String contratado,
        String cnpj,
        Double valorTotal,
        Date emissao,
        String atesto,
        String responsavelRecebimento
) {
    public static NotasCompraDireta converterNotasCompraDireta(NotasCompraDiretaRequest request, CompraDireta compraDireta) {
        NotasCompraDireta nota = new NotasCompraDireta();
        nota.setNotaFiscal(request.notaFiscal());
        nota.setPortaria(compraDireta); // Associando a compra direta
        nota.setSgd(request.sgd());
        nota.setProcesso(request.processo());
        nota.setUnidade(request.unidade());
        nota.setObjeto(request.objeto());
        nota.setContratado(request.contratado());
        nota.setCnpj(request.cnpj());
        nota.setValorTotal(request.valorTotal());
        nota.setEmissao(request.emissao());
        nota.setAtesto(request.atesto());
        nota.setResponsavelRecebimento(request.responsavelRecebimento());
        return nota;
    }
}
