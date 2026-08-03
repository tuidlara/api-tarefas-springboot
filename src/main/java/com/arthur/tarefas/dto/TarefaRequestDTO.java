package com.arthur.tarefas.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados necessários para criar ou atualizar uma tarefa.")
public class TarefaRequestDTO {

    @Schema(description = "Título da tarefa", example = "Estudar Spring Boot")
    @NotBlank(message = "O título não pode ser vazio")
    private String titulo;

    @Schema(description = "Descrição detalhada da tarefa", example = "Assistir às aulas sobre DTOs, Validation e Exception Handler no Spring Boot.")
    @NotBlank(message = "A descrição não pode ser vazia")
    @Size(min = 20, max = 500, message = "A descrição deve ter entre 20 e 500 caracteres")
    private String descricao;

    @Schema(description = "Indica se a tarefa foi concluída", example = "false")
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