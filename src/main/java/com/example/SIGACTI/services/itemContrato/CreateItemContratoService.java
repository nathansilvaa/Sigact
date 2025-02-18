package com.example.SIGACTI.services.itemContrato;

import com.example.SIGACTI.dto.ItemContratoRequest;
import com.example.SIGACTI.dto.ItemContratoResponse;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.ItemContrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ItemContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateItemContratoService {
    @Autowired
    private final ItemContratoRepository itemContratoRepository;
    @Autowired
    private final ProcessoRepository processoRepository;
    @Autowired
    private final ContratoRepository contratoRepository;

    public CreateItemContratoService(ContratoRepository contratoRepository, ProcessoRepository processoRepository, ItemContratoRepository itemContratoRepository) {
        this.contratoRepository = contratoRepository;
        this.processoRepository = processoRepository;
        this.itemContratoRepository = itemContratoRepository;
    }

    @Transactional
    public ItemContratoResponse salvar(ItemContratoRequest itemContratoDto) {
        Processo processo = processoRepository.findById(itemContratoDto.idProcesso()).orElseThrow(() -> new RuntimeException("Processo relacionado não encontrado"));
        Contrato contrato = contratoRepository.findById(itemContratoDto.idContrato()).orElseThrow(() -> new RuntimeException("Contrato relacionado não encontrado"));

        try {
            ItemContrato itemContrato = ItemContratoRequest.converterItemContrato(itemContratoDto, processo, contrato);
            itemContratoRepository.save(itemContrato);

            return ItemContratoResponse.converterItemContrato(itemContrato);
        } catch (Exception e) {
            return null;
        }
    }
}
