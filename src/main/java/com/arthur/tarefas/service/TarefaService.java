package com.arthur.tarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.tarefas.model.Tarefa;
import com.arthur.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa criarTarefa(Tarefa tarefa) {

        return repository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {

        return repository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {

        return repository.findById(id);
    }

    public void deletarTarefa(Long id) {

        repository.deleteById(id);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {

        Tarefa tarefa = repository.findById(id).orElse(null);

        if (tarefa != null) {

            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setConcluida(tarefaAtualizada.isConcluida());

            return repository.save(tarefa);
        }

        return null;
    }
}