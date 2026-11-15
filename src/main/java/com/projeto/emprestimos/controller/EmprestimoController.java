
package com.projeto.emprestimos.controller;

import com.projeto.emprestimos.model.Emprestimo;
import com.projeto.emprestimos.service.EmprestimoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(
            EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    // 1. Realizar um novo empréstimo
    @PostMapping
    public Emprestimo realizar(
            @RequestParam Long equipamentoId,
            @RequestParam Long colaboradorId) {

        return emprestimoService.realizarEmprestimo(
                equipamentoId,
                colaboradorId
        );
    }

    // 2. Registrar a devolução de um empréstimo
    @PutMapping("/{id}/devolucao")
    public Emprestimo devolver(@PathVariable Long id) {
        return emprestimoService.devolverEmprestimo(id);
    }

    // 3. Listar empréstimos atrasados
    @GetMapping(params = "atrasados=true")
    public List<Emprestimo> listarAtrasados() {
        return emprestimoService.listarAtrasados();
    }

    // 4. Listar empréstimos por colaborador
    @GetMapping("/colaborador/{id}")
    public List<Emprestimo> listarPorColaborador(
            @PathVariable Long id) {

        return emprestimoService.listarPorColaborador(id);
    }

    // 5. Listar todos os empréstimos
    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoService.listarTodos();
    }

    // 6. Buscar um empréstimo pelo ID
    @GetMapping("/{id}")
    public Emprestimo buscar(@PathVariable Long id) {
        return emprestimoService.buscar(id);
    }

    // 7. Tratar conflitos de regras de negócio
    // Exemplo: equipamento indisponível
    // ou empréstimo já devolvido
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> tratarErro(
            IllegalStateException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", ex.getMessage()));
    }

    // 8. Tratar recursos não encontrados
    // Exemplo: empréstimo inexistente
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> tratarNaoEncontrado(
            IllegalArgumentException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", ex.getMessage()));
    }
}
