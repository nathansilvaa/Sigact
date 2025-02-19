package com.example.SIGACTI.services.itemContrato;

import com.example.SIGACTI.dto.*;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.ItemContrato;
import com.example.SIGACTI.model.entities.Processo;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import com.example.SIGACTI.model.repositories.ItemContratoRepository;
import com.example.SIGACTI.model.repositories.ProcessoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateItemContratoService {
    private final ItemContratoRepository itemContratoRepository;
    private final ProcessoRepository processoRepository;
    private final ContratoRepository contratoRepository;

    public UpdateItemContratoService(ItemContratoRepository itemContratoRepository, ProcessoRepository processoRepository, ContratoRepository contratoRepository) {
        this.itemContratoRepository = itemContratoRepository;
        this.processoRepository = processoRepository;
        this.contratoRepository = contratoRepository;
    }

    public Optional<ItemContratoResponse> atualizarItemsContrato(Long idItem, ItemContratoRequest itemContratoDto) {
        Optional<ItemContrato> itemContratoOpt = itemContratoRepository.findById(idItem);

        if(itemContratoOpt.isPresent()) {
            ItemContrato itemContrato = itemContratoOpt.get();

            itemContrato.setItem(itemContratoDto.item());
            itemContrato.setSiga(itemContratoDto.siga());
            itemContrato.setDescricao(itemContratoDto.descricao());
            itemContrato.setModelo(itemContratoDto.modelo());
            itemContrato.setTipoContrato(itemContratoDto.tipoContrato());
            itemContrato.setQuantidade(itemContratoDto.quantidade());
            itemContrato.setValorUnitario(itemContratoDto.valorUnitario());
            itemContrato.setValorTotal(itemContratoDto.valorTotal());

            if (itemContratoDto.idProcesso() != null) {
                Optional<Processo> processoOpt = processoRepository.findById(itemContratoDto.idProcesso());
                processoOpt.ifPresent(itemContrato::setProcesso);
            }
            if (itemContratoDto.idContrato() != null) {
                Optional<Contrato> contratoOpt = contratoRepository.findById(itemContratoDto.idContrato());
                contratoOpt.ifPresent(itemContrato::setContrato);
            }
            itemContratoRepository.save(itemContrato);

            return Optional.of(new ItemContratoResponse(
                    itemContrato.getId(),
                    itemContrato.getItem(),
                    itemContrato.getSiga(),
                    itemContrato.getDescricao(),
                    itemContrato.getModelo(),
                    itemContrato.getQuantidade(),
                    itemContrato.getTipoContrato(),
                    itemContrato.getValorUnitario(),
                    itemContrato.getValorTotal()
            ));
        } else {
            return Optional.empty();
        }

    }
}
