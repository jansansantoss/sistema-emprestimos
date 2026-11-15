
package com.projeto.emprestimos.service;

import com.projeto.emprestimos.model.Colaborador;
import com.projeto.emprestimos.repository.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(
            ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public List<Colaborador> listar() {
        return colaboradorRepository.findAll();
    }

    public Colaborador buscar(Long id) {
        return colaboradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Colaborador não encontrado"));
    }

    public Colaborador cadastrar(Colaborador colaborador) {

        if (colaboradorRepository.existsByEmail(
                colaborador.getEmail())) {
            throw new IllegalStateException(
                    "E-mail já cadastrado");
        }

        return colaboradorRepository.save(colaborador);
    }
}
