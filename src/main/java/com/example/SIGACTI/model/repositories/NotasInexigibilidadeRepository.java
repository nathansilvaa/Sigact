package com.example.SIGACTI.model.repositories;

import com.example.SIGACTI.model.entities.Inexigibilidade;
import com.example.SIGACTI.model.entities.NotasInexigibilidade;
import org.springframework.data.repository.CrudRepository;

public interface NotasInexigibilidadeRepository extends CrudRepository<NotasInexigibilidade, Long> {
    Iterable<NotasInexigibilidade> findByNotaFiscalContainingIgnoreCase(String parteNotaFiscal);
}
