
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

    @PostMapping
    public Emprestimo realizar(
            @RequestParam Long equipamentoId,
            @RequestParam Long colaboradorId) {

        return emprestimoService.realizarEmprestimo(
                equipamentoId,
                colaboradorId
        );
    }

    @PutMapping("/{id}/devolucao")
    public Emprestimo devolver(@PathVariable Long id) {
        return emprestimoService.devolverEmprestimo(id);
    }

    @GetMapping(params = "atrasados=true")
    public List<Emprestimo> listarAtrasados() {
        return emprestimoService.listarAtrasados();
    }

    @GetMapping("/colaborador/{id}")
    public List<Emprestimo> listarPorColaborador(
            @PathVariable Long id) {
        return emprestimoService.listarPorColaborador(id);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> tratarErro(
            IllegalStateException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", ex.getMessage()));
    }
}
