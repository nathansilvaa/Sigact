package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.ItemContrato;
import com.example.SIGACTI.model.entities.TipoContrato;
import com.example.SIGACTI.model.entities.Processo;

public record ItemContratoRequest(
        Long idProcesso,
        Long idContrato,
        String item,
        Integer siga,
        String descricao,
        String modelo,
        Integer quantidade,
        TipoContrato tipoContrato,
        Double valorUnitario,
        Double valorTotal
) {
    public static ItemContrato converterItemContrato(ItemContratoRequest itemContratoRequest, Processo processo, Contrato contrato) {
        ItemContrato itemContrato =  new ItemContrato();

        itemContrato.setProcesso(processo);
        itemContrato.setContrato(contrato);
        itemContrato.setItem(itemContratoRequest.item());
        itemContrato.setSiga(itemContratoRequest.siga());
        itemContrato.setDescricao(itemContratoRequest.descricao());
        itemContrato.setModelo(itemContratoRequest.modelo());
        itemContrato.setQuantidade(itemContratoRequest.quantidade());
        itemContrato.setTipoContrato(itemContratoRequest.tipoContrato());
        itemContrato.setValorUnitario(itemContratoRequest.valorUnitario());
        itemContrato.setValorTotal(itemContratoRequest.valorTotal());

        return itemContrato;
    }
}
