package com.desafio.orangetalents.service;

import com.desafio.orangetalents.model.Endereco;
import com.desafio.orangetalents.model.Usuario;
import com.desafio.orangetalents.model.exception.UsuarioNotFoundException;
import com.desafio.orangetalents.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EnderecoService enderecoService;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, EnderecoService enderecoService) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoService = enderecoService;
    }

    public Usuario addUsuario(Usuario usuario){
        try{
            return usuarioRepository.save(usuario);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao realizar cadastro. Verifique os dados.");
        }
    }

    public Usuario getUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(() ->
                new UsuarioNotFoundException(id));
    }

    @Transactional
    public Usuario addEnderecoToUsuario(Long usuarioId, Long enderecoId){
        Usuario usuario = getUsuario(usuarioId);
        Endereco endereco = enderecoService.getEndereco(enderecoId);
        try{
            usuario.addEndereco(endereco);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao realizar cadastro. Verifique os dados");
        }
        return usuario;
    }

}
