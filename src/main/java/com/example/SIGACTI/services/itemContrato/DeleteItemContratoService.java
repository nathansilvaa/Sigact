package com.example.SIGACTI.services.itemContrato;

import com.example.SIGACTI.model.repositories.ItemContratoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteItemContratoService {
    private final ItemContratoRepository itemContratoRepository;

    public DeleteItemContratoService(ItemContratoRepository itemContratoRepository) { this.itemContratoRepository = itemContratoRepository; }

    @Transactional
    public boolean deletarItemContrato(Long notaFiscal) {
        if (itemContratoRepository.existsById(notaFiscal)) {
            itemContratoRepository.deleteById(notaFiscal);
            return true;
        }
        return false;
    }
}
