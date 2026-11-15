
package com.projeto.emprestimos.repository;

import com.projeto.emprestimos.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipamentoRepository
        extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByDisponivelTrue();
}
