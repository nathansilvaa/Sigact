package com.example.SIGACTI.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AcaoOrcamentaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ano;
    private String UnidadeGestora;
    private String acaoOrcamentaria;
    private String fonteRecurso;
    private Double valor;
    @OneToMany(mappedBy = "acaoOrcamentaria", cascade = CascadeType.ALL)
    private List<Contrato> contratos = new ArrayList<>();
}
