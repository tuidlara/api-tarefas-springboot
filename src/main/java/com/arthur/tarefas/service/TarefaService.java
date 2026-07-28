package com.arthur.tarefas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arthur.tarefas.dto.TarefaRequestDTO;
import com.arthur.tarefas.dto.TarefaResponseDTO;
import com.arthur.tarefas.exception.TarefaNaoEncontradaException;
import com.arthur.tarefas.model.Tarefa;
import com.arthur.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO dto) {

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setConcluida(dto.isConcluida());

        Tarefa salva = repository.save(tarefa);

        return converterParaDTO(salva);
    }

    public List<TarefaResponseDTO> listarTarefas() {

        List<Tarefa> tarefas = repository.findAll();
        List<TarefaResponseDTO> dtos = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            dtos.add(converterParaDTO(tarefa));
        }

        return dtos;
    }

    public TarefaResponseDTO buscarPorId(Long id) {

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa não encontrada"));

        return converterParaDTO(tarefa);
    }

    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO dto) {

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa não encontrada"));

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setConcluida(dto.isConcluida());

        Tarefa atualizada = repository.save(tarefa);

        return converterParaDTO(atualizada);
    }

    public void deletarTarefa(Long id) {

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa não encontrada"));

        repository.delete(tarefa);
    }

    private TarefaResponseDTO converterParaDTO(Tarefa tarefa) {

        TarefaResponseDTO dto = new TarefaResponseDTO();

        dto.setId(tarefa.getId());
        dto.setTitulo(tarefa.getTitulo());
        dto.setDescricao(tarefa.getDescricao());
        dto.setConcluida(tarefa.isConcluida());

        return dto;
    }

    public List<TarefaResponseDTO> buscarPorTitulo(String titulo) {
        List<Tarefa> tarefas = repository.findByTituloContainsIgnoreCase(titulo);
        return tarefas.stream()
                .map(this::converterParaDTO)
                .toList();

    }

    public List<TarefaResponseDTO> buscarPorConcluida(boolean concluida) {
        List<Tarefa> tarefas = repository.findByConcluida(concluida);
        return tarefas.stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public List<TarefaResponseDTO> buscarPorDescricao(String descricao) {
        List<Tarefa> tarefas = repository.findByDescricaoContainingIgnoreCase(descricao);
        return tarefas.stream()
                .map(this::converterParaDTO)
                .toList();
    }
}