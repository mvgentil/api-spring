package com.desafio.orangetalents.controller;

import com.desafio.orangetalents.model.Endereco;
import com.desafio.orangetalents.model.dto.EnderecoDto;
import com.desafio.orangetalents.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> addEndereco(@RequestBody final EnderecoDto enderecoDto){
        Endereco endereco = enderecoService.addEndereco(Endereco.from(enderecoDto));
        return new ResponseEntity<>(EnderecoDto.from(endereco), HttpStatus.OK);
    }

}
