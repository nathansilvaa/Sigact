package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.ItemContrato;
import com.example.SIGACTI.model.entities.TipoContrato;

public record ItemContratoResponse(
        Long id,
        ProcessoResponse processo,
        ContratoResponse contrato,
        String item,
        Integer siga,
        String descricao,
        String modelo,
        Integer quantidade,
        TipoContrato tipoContrato,
        Double valorUnitario,
        Double valorTotal
) {
    public static ItemContratoResponse converterItemContrato(ItemContrato item){
        return new ItemContratoResponse(
                item.getId(),
                ProcessoResponse.conveterProcesso(item.getProcesso()),
                ContratoResponse.conveterContrato(item.getContrato()),
                item.getItem(),
                item.getSiga(),
                item.getDescricao(),
                item.getModelo(),
                item.getQuantidade(),
                item.getTipoContrato(),
                item.getValorUnitario(),
                item.getValorTotal()
        );
    }
}
