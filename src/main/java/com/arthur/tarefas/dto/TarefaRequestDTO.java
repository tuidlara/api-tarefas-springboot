package com.arthur.tarefas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TarefaRequestDTO {

    @NotBlank(message = "O título não pode ser vazio")
    private String titulo;

    @Size(min = 20, max = 500, message = "A descrição deve ter entre 20 e 500 caracteres")
    private String descricao;

    private boolean concluida;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}