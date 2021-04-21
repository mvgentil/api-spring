package com.desafio.orangetalents.controller;

import com.desafio.orangetalents.model.Usuario;
import com.desafio.orangetalents.model.dto.UsuarioDto;
import com.desafio.orangetalents.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private Object ResponseEntity;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> addUsuario(@RequestBody final UsuarioDto usuarioDto){
        Usuario usuario = usuarioService.addUsuario(Usuario.from(usuarioDto));
        return new ResponseEntity<>(UsuarioDto.from(usuario), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UsuarioDto> getUsuario(@PathVariable final Long id){
        Usuario usuario = usuarioService.getUsuario(id);
        return new ResponseEntity<>(UsuarioDto.from(usuario), HttpStatus.OK);
    }

    @PostMapping(value = "{usuarioId}/enderecos/{enderecoId}/add")
    public ResponseEntity<UsuarioDto> addEnderecoToUsuario(@PathVariable final Long usuarioId,
                                                           @PathVariable final Long enderecoId){
        Usuario usuario =  usuarioService.addEnderecoToUsuario(usuarioId, enderecoId);
        return new ResponseEntity<>(UsuarioDto.from(usuario), HttpStatus.OK);
    }
}
