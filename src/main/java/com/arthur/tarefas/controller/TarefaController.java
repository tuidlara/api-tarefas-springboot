package com.arthur.tarefas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.arthur.tarefas.dto.TarefaRequestDTO;
import com.arthur.tarefas.dto.TarefaResponseDTO;
import com.arthur.tarefas.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaResponseDTO criarTarefa(
            @Valid @RequestBody TarefaRequestDTO dto) {

        return service.criarTarefa(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> listarTarefas() {

        return service.listarTarefas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TarefaResponseDTO buscarPorId(@PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TarefaResponseDTO atualizarTarefa(
            @PathVariable Long id,
            @Valid @RequestBody TarefaRequestDTO dto) {

        return service.atualizarTarefa(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTarefa(@PathVariable Long id) {

        service.deletarTarefa(id);
    }

    @GetMapping("/titulo/{titulo}")
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> buscarPorTitulo(@PathVariable String titulo) {
        return service.buscarPorTitulo(titulo);
    }

    @GetMapping("/concluidas")
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> buscarConcluidas() {
        return service.buscarPorConcluida(true);
    }

    @GetMapping("/pendentes")
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> buscarPendentes() {
        return service.buscarPorConcluida(false);
    }

}