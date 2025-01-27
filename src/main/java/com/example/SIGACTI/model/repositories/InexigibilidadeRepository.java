package com.example.SIGACTI.model.repositories;

import com.example.SIGACTI.model.entities.Contrato;
import com.example.SIGACTI.model.entities.Inexigibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface InexigibilidadeRepository extends JpaRepository<Inexigibilidade, String> {
    Iterable<Inexigibilidade> findByPortariaContainingIgnoreCase(String portaria);
}
