package com.desafio.orangetalents.model.exception;

import java.text.MessageFormat;

public class EnderecoNotFoundException extends RuntimeException{

    public EnderecoNotFoundException(Long id){
        super(MessageFormat.format("Endereço não encontrado com o Id: {0}", id));
    }
}
