package com.ponto.eletronico.exceptions;

public class CnpjJaCadastradoException extends RuntimeException {
    public CnpjJaCadastradoException(String cnpj) {
        super("CNPJ já cadastrado: " + cnpj);
    }
}
