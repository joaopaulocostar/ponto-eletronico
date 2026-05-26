package com.ponto.eletronico.exceptions;

public class EmpresaNaoEncontradaException extends RuntimeException{
    public EmpresaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
