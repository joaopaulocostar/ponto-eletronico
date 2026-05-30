package com.ponto.eletronico.exceptions;

public class FuncionarioNaoEncontradoException extends RuntimeException{
    public FuncionarioNaoEncontradoException(Long id){
        super("Funcionário não encontrado!");
    }
}
