package com.desafio.orangetalents.model.dto;

import com.desafio.orangetalents.model.Endereco;
import com.desafio.orangetalents.model.Usuario;
import lombok.Data;

//import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String CPF;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos = new ArrayList<>();

    public static UsuarioDto from(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setCPF(usuario.getCPF());
        usuarioDto.setDataNascimento(usuario.getDataNascimento());
        usuarioDto.setEnderecos(usuario.getEnderecos());
        return usuarioDto;
    }
}
