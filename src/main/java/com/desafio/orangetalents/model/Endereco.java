package com.desafio.orangetalents.model;

import com.desafio.orangetalents.model.dto.EnderecoDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Endereco")
public class Endereco {
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

    public static Endereco from(EnderecoDto enderecoDto){
        Endereco endereco = new Endereco();
        enderecoDto.setLogradouro(enderecoDto.getLogradouro());
        enderecoDto.setNumero(enderecoDto.getNumero());
        enderecoDto.setComplemento(enderecoDto.getComplemento());
        enderecoDto.setBairro(enderecoDto.getBairro());
        enderecoDto.setCidade(enderecoDto.getCidade());
        enderecoDto.setEstado(enderecoDto.getEstado());
        enderecoDto.setCEP(enderecoDto.getCEP());
        return endereco;
    }
}
