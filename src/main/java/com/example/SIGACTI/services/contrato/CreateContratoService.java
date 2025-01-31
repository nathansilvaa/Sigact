package com.example.SIGACTI.services.contrato;

import com.example.SIGACTI.dto.ContratoDto;
import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateContratoService {

    @Autowired
    private final ContratoRepository contratoRepository;

    public CreateContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public Contrato salvar(Contrato contrato) {
        return contratoRepository.save(contrato);
    }


}
