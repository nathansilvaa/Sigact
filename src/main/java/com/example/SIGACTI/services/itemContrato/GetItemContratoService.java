package com.example.SIGACTI.services.itemContrato;

import com.example.SIGACTI.dto.ItemContratoResponse;
import com.example.SIGACTI.dto.NotasContratoResponse;
import com.example.SIGACTI.model.entities.ItemContrato;
import com.example.SIGACTI.model.repositories.ItemContratoRepository;
import com.example.SIGACTI.model.repositories.NotasContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetItemContratoService {
    private final ItemContratoRepository itemContratoRepository;

    public GetItemContratoService(ItemContratoRepository itemContratoRepository) { this.itemContratoRepository = itemContratoRepository; }

    public List<ItemContratoResponse> obterTodosItensContrato() {
        List<ItemContrato> listaItensContrato = (List<ItemContrato>) itemContratoRepository.findAll();
        return listaItensContrato.stream()
                .map(ItemContratoResponse::converterItemContrato)
                .collect(Collectors.toList());
    }
//    public ItemContratoResponse obterItemContratoPeloId(Long id) {}
}
