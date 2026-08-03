package com.arthur.tarefas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados pela API ao consultar uma tarefa.")
public class TarefaResponseDTO {

    @Schema(description = "Identificador único da tarefa", example = "1")
    private Long id;

    @Schema(description = "Título da tarefa", example = "Estudar Spring Boot")
    private String titulo;

    @Schema(description = "Descrição detalhada da tarefa", example = "Assistir às aulas sobre DTOs, Validation e Exception Handler no Spring Boot.")
    private String descricao;

    @Schema(description = "Indica se a tarefa foi concluída", example = "false")
    private boolean concluida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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