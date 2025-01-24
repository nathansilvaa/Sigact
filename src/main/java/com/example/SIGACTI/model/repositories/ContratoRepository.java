package com.example.SIGACTI.model.repositories;

import com.example.SIGACTI.model.entities.Contrato;
import org.springframework.data.repository.CrudRepository;

public interface ContratoRepository extends CrudRepository <Contrato, String> {

    Iterable<Contrato> findByContratoContainingIgnoreCase(String parteContrato);
}
