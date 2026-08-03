package com.arthur.tarefas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.arthur.tarefas.dto.TarefaRequestDTO;
import com.arthur.tarefas.dto.TarefaResponseDTO;
import com.arthur.tarefas.service.TarefaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefas", description = "Operações relacionadas ao gerenciamento de tarefas.")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @Operation(summary = "Criar tarefa", description = "Cadastra uma nova tarefa.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaResponseDTO criarTarefa(@Valid @RequestBody TarefaRequestDTO dto) {

        return service.criarTarefa(dto);
    }

    @Operation(summary = "Listar tarefas", description = "Retorna todas as tarefas cadastradas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de tarefas retornada com sucesso")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> listarTarefas() {

        return service.listarTarefas();
    }

    @Operation(summary = "Buscar tarefa por ID", description = "Retorna uma tarefa a partir do seu identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TarefaResponseDTO buscarPorId(@PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar tarefa", description = "Atualiza os dados de uma tarefa existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TarefaResponseDTO atualizarTarefa(
            @PathVariable Long id,
            @Valid @RequestBody TarefaRequestDTO dto) {

        return service.atualizarTarefa(id, dto);
    }

    @Operation(summary = "Excluir tarefa", description = "Remove uma tarefa a partir do seu identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Tarefa removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTarefa(@PathVariable Long id) {

        service.deletarTarefa(id);
    }

    @Operation(summary = "Buscar tarefas por título", description = "Retorna uma lista de tarefas com o título informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    })
    @GetMapping("/titulo/{titulo}")
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> buscarPorTitulo(@PathVariable String titulo) {

        return service.buscarPorTitulo(titulo);
    }

    @Operation(summary = "Listar tarefas concluídas", description = "Retorna todas as tarefas marcadas como concluídas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefas concluídas retornadas com sucesso")
    })
    @GetMapping("/concluidas")
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> buscarConcluidas() {

        return service.buscarPorConcluida(true);
    }

    @Operation(summary = "Listar tarefas pendentes", description = "Retorna todas as tarefas que ainda não foram concluídas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefas pendentes retornadas com sucesso")
    })
    @GetMapping("/pendentes")
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> buscarPendentes() {

        return service.buscarPorConcluida(false);
    }

    @Operation(summary = "Buscar tarefas por descrição", description = "Retorna uma lista de tarefas cuja descrição contém o texto informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    })
    @GetMapping("/descricao")
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaResponseDTO> buscarPorDescricao(
            @RequestParam String descricao) {

        return service.buscarPorDescricao(descricao);
    }
}