package com.arthur.tarefas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
// tratar exceções em toda a aplicação, evita muitos try-catch
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErroValidacao(
            MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        // getBindingResult() -> Pega o resultado da validação.
        // getFieldErrors() -> pega uma lista com todos os erros dos campos
        // getDefaultMessage() -> pega a mensagem configurada na validação (que fiz tipo
        // em @notBlank)
        // erros.put() -> adiciona um item ao mapa (pois estou usando HashMap, que
        // funciona chave / valor)

        ex.getBindingResult().getFieldErrors().forEach(erro -> {
            erros.put(erro.getField(), erro.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(erros);
    }
}
