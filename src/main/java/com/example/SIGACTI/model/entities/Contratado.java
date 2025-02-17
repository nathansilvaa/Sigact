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

    public Contratado() {}
    public Contratado(Long id, String cpfOuCnpj, String nomeRazaoSocial, String email) {
        this.id = id;
        this.cpfOuCnpj = cpfOuCnpj;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contratado{" +
                "id=" + id +
                ", cpfOuCnpj='" + cpfOuCnpj + '\'' +
                ", nomeRazaoSocial='" + nomeRazaoSocial + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
