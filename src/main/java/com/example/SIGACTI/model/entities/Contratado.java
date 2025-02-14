package com.example.SIGACTI.model.entities;

import jakarta.persistence.*;

@Entity
public class Contratado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cpfOuCnpj;

    private String nomeRazaoSocial;
    private String email;

    @OneToOne(optional = false)
    @JoinColumn(name = "contrato", nullable = false)
    private Contrato contrato;

    public Contratado() {}
    public Contratado(Long id, String cpfOuCnpj, String nomeRazaoSocial, String email) {
        this.id = id;
        this.cpfOuCnpj = cpfOuCnpj;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.email = email;
    }
}
