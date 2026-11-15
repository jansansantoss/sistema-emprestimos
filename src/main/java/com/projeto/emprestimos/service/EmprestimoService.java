
package com.projeto.emprestimos.service;

import com.projeto.emprestimos.model.Colaborador;
import com.projeto.emprestimos.model.Equipamento;
import com.projeto.emprestimos.model.Emprestimo;
import com.projeto.emprestimos.repository.ColaboradorRepository;
import com.projeto.emprestimos.repository.EquipamentoRepository;
import com.projeto.emprestimos.repository.EmprestimoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final ColaboradorRepository colaboradorRepository;

    public EmprestimoService(
            EmprestimoRepository emprestimoRepository,
            EquipamentoRepository equipamentoRepository,
            ColaboradorRepository colaboradorRepository) {

        this.emprestimoRepository = emprestimoRepository;
        this.equipamentoRepository = equipamentoRepository;
        this.colaboradorRepository = colaboradorRepository;
    }

    @Transactional
    public Emprestimo realizarEmprestimo(
            Long equipamentoId, Long colaboradorId) {

        Equipamento equipamento = equipamentoRepository
                .findById(equipamentoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Equipamento não encontrado"));

        Colaborador colaborador = colaboradorRepository
                .findById(colaboradorId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Colaborador não encontrado"));

        if (!equipamento.isDisponivel()) {
            throw new IllegalStateException(
                    "Equipamento indisponível");
        }

        boolean possuiAtraso = emprestimoRepository
                .existsByColaboradorIdAndDataDevolucaoIsNullAndDataPrevistaDevolucaoBefore(
                        colaborador.getId(), LocalDate.now());

        if (possuiAtraso) {
            throw new IllegalStateException(
                    "Colaborador possui empréstimo atrasado");
        }

        equipamento.setDisponivel(false);
        equipamentoRepository.save(equipamento);

        Emprestimo emprestimo = new Emprestimo(
                equipamentoId, colaboradorId, LocalDate.now());

        return emprestimoRepository.save(emprestimo);
    }

    @Transactional
    public Emprestimo devolverEmprestimo(Long emprestimoId) {

        Emprestimo emprestimo = emprestimoRepository
                .findById(emprestimoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Empréstimo não encontrado"));

        emprestimo.devolver(LocalDate.now());

        Equipamento equipamento = equipamentoRepository
                .findById(emprestimo.getEquipamentoId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Equipamento não encontrado"));

        equipamento.setDisponivel(true);
        equipamentoRepository.save(equipamento);

        return emprestimoRepository.save(emprestimo);
    }

    // NOVO: listar todos os empréstimos
    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    // NOVO: buscar empréstimo pelo ID
    public Emprestimo buscar(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Empréstimo não encontrado"));
    }

    public List<Emprestimo> listarAtrasados() {
        return emprestimoRepository
                .findByDataDevolucaoIsNullAndDataPrevistaDevolucaoBefore(
                        LocalDate.now());
    }

    public List<Emprestimo> listarPorColaborador(
            Long colaboradorId) {

        return emprestimoRepository
                .findByColaboradorId(colaboradorId);
    }
}
