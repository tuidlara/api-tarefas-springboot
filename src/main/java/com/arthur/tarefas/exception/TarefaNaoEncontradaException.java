package com.arthur.tarefas.exception;

public class TarefaNaoEncontradaException extends RuntimeException {

    public TarefaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}