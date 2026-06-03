package com.arthur.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arthur.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}