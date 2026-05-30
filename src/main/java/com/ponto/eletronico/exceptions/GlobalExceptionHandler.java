package com.ponto.eletronico.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmpresaNaoEncontradaException.class)
    public ResponseEntity<String> tratarEmpresaNaoEncontrada(EmpresaNaoEncontradaException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public ResponseEntity<String> tratarFuncionarioNaoEncontrado(
            FuncionarioNaoEncontradoException ex){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<String> tratarCpfJaCadastrado(
            CpfJaCadastradoException ex){

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    @ExceptionHandler(CnpjJaCadastradoException.class)
    public ResponseEntity<String> tratarCnpjJaCadastrado(
            CnpjJaCadastradoException ex){

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }
}
