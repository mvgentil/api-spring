package com.desafio.orangetalents.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Endereco")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String CEP;

    public Address() {
    }
}
