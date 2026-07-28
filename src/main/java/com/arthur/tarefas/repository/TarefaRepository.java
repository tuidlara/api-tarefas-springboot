package com.arthur.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arthur.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByTituloContainsIgnoreCase(String titulo);

    List<Tarefa> findByConcluida(boolean concluida);

    List<Tarefa> findByDescricaoContainingIgnoreCase(String descricao);

}