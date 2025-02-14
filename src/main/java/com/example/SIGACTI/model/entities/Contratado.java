package com.example.SIGACTI.model.entities;

import jakarta.persistence.*;

@Entity
public class Contratado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cpf_ou_cnpj;

    private String nomeRazaoSocial;
    private String email;

    @OneToOne(optional = false)
    @JoinColumn(name = "contrato", nullable = false)
    private Contrato contrato;

    public Contratado() {}
    public Contratado(Long id, String cpf_ou_cnpj, String nomeRazaoSocial, String email) {
        this.id = id;
        this.cpf_ou_cnpj = cpf_ou_cnpj;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.email = email;
    }
}
