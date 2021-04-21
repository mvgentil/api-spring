package com.desafio.orangetalents.service;

import com.desafio.orangetalents.model.Endereco;
import com.desafio.orangetalents.model.exception.EnderecoNotFoundException;
import com.desafio.orangetalents.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco addEndereco(Endereco endereco){
        try{
            return enderecoRepository.save(endereco);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao realizar o cadastro. Verifique os dados");
        }
    }

    public Endereco getEndereco(Long id){
        return enderecoRepository.findById(id).orElseThrow(() ->
                new EnderecoNotFoundException(id));
    }

    public List<Endereco> getEnderecos(){
        return StreamSupport
                .stream(enderecoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
