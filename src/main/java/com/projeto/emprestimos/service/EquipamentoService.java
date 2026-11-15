
package com.projeto.emprestimos.service;

import com.projeto.emprestimos.model.Equipamento;
import com.projeto.emprestimos.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(
            EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Equipamento> listar() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscar(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Equipamento não encontrado"));
    }

    public Equipamento cadastrar(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listarDisponiveis() {
        return equipamentoRepository.findByDisponivelTrue();
    }
}
