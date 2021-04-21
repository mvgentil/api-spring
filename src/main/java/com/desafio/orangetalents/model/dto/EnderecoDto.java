package com.desafio.orangetalents.model.dto;

import com.desafio.orangetalents.model.Endereco;
// import com.desafio.orangetalents.model.Usuario;
import lombok.Data;

@Data
public class EnderecoDto {

    private Long id;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String CEP;

    public static EnderecoDto from(Endereco endereco){
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setId(endereco.getId());
        enderecoDto.setLogradouro(endereco.getLogradouro());
        enderecoDto.setNumero(endereco.getNumero());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setBairro(endereco.getBairro());
        enderecoDto.setCidade(endereco.getCidade());
        enderecoDto.setEstado(endereco.getEstado());
        enderecoDto.setCEP(endereco.getCEP());
        return enderecoDto;
    }
}
