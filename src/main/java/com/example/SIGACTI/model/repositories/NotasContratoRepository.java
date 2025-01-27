package com.example.SIGACTI.model.repositories;

import com.example.SIGACTI.model.entities.NotasContrato;
import com.example.SIGACTI.model.entities.NotasInexigibilidade;
import org.springframework.data.repository.CrudRepository;

public interface NotasContratoRepository extends CrudRepository<NotasContrato, Long> {
    Iterable<NotasContrato> findByNotaFiscalContainingIgnoreCase(String parteNotaFiscal);
}
