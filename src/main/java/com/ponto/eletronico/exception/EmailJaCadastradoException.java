package com.ponto.eletronico.exception;

public class EmailJaCadastradoException extends RuntimeException{
    public EmailJaCadastradoException(String mensagem){
        super(mensagem);
    }
}
