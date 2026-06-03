package com.arthur.tarefas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa tarefa) {

        Tarefa tarefaCriada = service.criarTarefa(tarefa);

        return ResponseEntity.status(201).body(tarefaCriada);
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {

        return service.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = service.buscarPorId(id);

        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
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
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Tarefa tarefaAtualizada) {
        Tarefa tarefa = service.atualizarTarefa(id, tarefaAtualizada);
        if (tarefa != null) {
            return ResponseEntity.ok().body(tarefa);
        }
        return ResponseEntity.notFound().build();

    }
}