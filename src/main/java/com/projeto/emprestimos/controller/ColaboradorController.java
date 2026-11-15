
package com.projeto.emprestimos.controller;

import com.projeto.emprestimos.model.Colaborador;
import com.projeto.emprestimos.model.Emprestimo;
import com.projeto.emprestimos.service.ColaboradorService;
import com.projeto.emprestimos.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;
    private final EmprestimoService emprestimoService;

    public ColaboradorController(
            ColaboradorService colaboradorService,
            EmprestimoService emprestimoService) {
        this.colaboradorService = colaboradorService;
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public List<Colaborador> listar() {
        return colaboradorService.listar();
    }

    @GetMapping("/{id}")
    public Colaborador buscar(@PathVariable Long id) {
        return colaboradorService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Colaborador cadastrar(
            @RequestBody Colaborador colaborador) {
        return colaboradorService.cadastrar(colaborador);
    }

    @GetMapping("/{id}/emprestimos")
    public List<Emprestimo> listarEmprestimos(
            @PathVariable Long id) {
        return emprestimoService.listarPorColaborador(id);
    }
}
