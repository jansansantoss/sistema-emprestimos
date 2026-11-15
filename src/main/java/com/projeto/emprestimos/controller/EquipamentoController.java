
package com.projeto.emprestimos.controller;

import com.projeto.emprestimos.model.Equipamento;
import com.projeto.emprestimos.service.EquipamentoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(
            EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @GetMapping
    public List<Equipamento> listar() {
        return equipamentoService.listar();
    }

    @GetMapping("/{id}")
    public Equipamento buscar(@PathVariable Long id) {
        return equipamentoService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipamento cadastrar(
            @RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrar(equipamento);
    }

    @GetMapping("/disponiveis")
    public List<Equipamento> listarDisponiveis() {
        return equipamentoService.listarDisponiveis();
    }
}
