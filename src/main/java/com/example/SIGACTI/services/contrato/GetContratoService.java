package com.example.SIGACTI.services.contrato;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> listarTodos() {
        return (List<Contrato>) contratoRepository.findAll();
    }

    public Optional<Contrato> buscarPorId(String id) {
        return contratoRepository.findById(id);
    }

    public boolean existePorId(String id) {
        return contratoRepository.existsById(id);
    }
}
