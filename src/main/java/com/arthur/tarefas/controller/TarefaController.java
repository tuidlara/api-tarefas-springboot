package com.arthur.tarefas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.arthur.tarefas.dto.TarefaResponseDTO;
import com.arthur.tarefas.model.Tarefa;
import com.arthur.tarefas.service.TarefaService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@Valid @RequestBody Tarefa tarefa) {

        Tarefa tarefaCriada = service.criarTarefa(tarefa);
        TarefaResponseDTO dto = converterParaDTO(tarefaCriada);

        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas() {
        List<Tarefa> tarefas = service.listarTarefas();
        List<TarefaResponseDTO> dtos = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            dtos.add(converterParaDTO(tarefa));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = service.buscarPorId(id);

        if (tarefa.isPresent()) {
            TarefaResponseDTO dto = converterParaDTO(tarefa.get());

            return ResponseEntity.ok(dto);

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {

        Optional<Tarefa> tarefa = service.buscarPorId(id);

        if (tarefa.isPresent()) {
            service.deletarTarefa(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizarTarefa(@PathVariable Long id,
            @Valid @RequestBody Tarefa tarefaAtualizada) {
        Tarefa tarefa = service.atualizarTarefa(id, tarefaAtualizada);
        if (tarefa != null) {
            TarefaResponseDTO dto = converterParaDTO(tarefa);

            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.notFound().build();

    }

    private TarefaResponseDTO converterParaDTO(Tarefa tarefa) {

        TarefaResponseDTO dto = new TarefaResponseDTO();
        dto.setId(tarefa.getId());
        dto.setTitulo(tarefa.getTitulo());
        dto.setDescricao(tarefa.getDescricao());
        dto.setConcluida(tarefa.isConcluida());

        return dto;
    }
}