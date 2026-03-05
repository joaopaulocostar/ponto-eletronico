package com.ponto.eletronico.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ponto.eletronico.exception.EmailJaCadastradoException;
import com.ponto.eletronico.exception.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailJaCadastradoException.class)
        public ResponseEntity<Object> handleEmailDuplicado(EmailJaCadastradoException ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", 409);
            body.put("error", "Conflict");
            body.put("message", ex.getMessage());

            return new ResponseEntity<>(body, HttpStatus.CONFLICT);

        }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
        public ResponseEntity<Object> handleNaoEncontrado(RecursoNaoEncontradoException ex){
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", 404);
            body.put("error", "Not Found");
            body.put("message", ex.getMessage());

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", 400);
            body.put("error", "Bad Request");

            List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList();
            body.put("messages", errors);

            return new
            ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
}
