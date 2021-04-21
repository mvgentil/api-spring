package com.desafio.orangetalents.model;

import com.desafio.orangetalents.model.dto.UsuarioDto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String CPF;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Endereco> enderecos = new ArrayList<>();


    public void addEndereco(Endereco endereco){
        enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco){
        enderecos.remove(endereco);
    }

    public static Usuario from(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setCPF(usuarioDto.getCPF());
        usuario.setDataNascimento(usuarioDto.getDataNascimento());
        usuario.setEnderecos(usuarioDto.getEnderecos());
        return usuario;
    }

}
