package com.ponto.eletronico.exceptions;

public class EmpresaNaoEncontradaException extends RuntimeException{
    public EmpresaNaoEncontradaException(Long id){
        super("Empresa não encontrada!");
    }
}
