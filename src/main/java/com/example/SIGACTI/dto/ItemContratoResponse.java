package com.example.SIGACTI.dto;

import com.example.SIGACTI.model.entities.ItemContrato;
import com.example.SIGACTI.model.entities.TipoContrato;

public record ItemContratoResponse(
        Long id,
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
