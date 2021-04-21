package com.desafio.orangetalents.model.exception;

import java.text.MessageFormat;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(Long id){
        super(MessageFormat.format("Usuário não encontrado com o Id: {0}", id));
    }
}
