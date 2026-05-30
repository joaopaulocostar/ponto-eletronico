package com.ponto.eletronico.exceptions;

public class CpfJaCadastradoException extends RuntimeException {
    public CpfJaCadastradoException(String cpf) {
        super("CPF Já cadastrado: " + cpf);
    }
}
