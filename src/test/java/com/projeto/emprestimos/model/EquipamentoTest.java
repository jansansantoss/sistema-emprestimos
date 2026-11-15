
package com.projeto.emprestimos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EquipamentoTest {

    @Test
    void equipamentoNovoDeveEstarDisponivel() {
        Equipamento equipamento = new Equipamento();

        assertTrue(equipamento.isDisponivel());
    }

    @Test
    void equipamentoEmprestadoDeveFicarIndisponivel() {
        Equipamento equipamento = new Equipamento();

        equipamento.emprestar();

        assertFalse(equipamento.isDisponivel());
    }

    @Test
    void naoDeveEmprestarEquipamentoIndisponivel() {
        Equipamento equipamento = new Equipamento();

        equipamento.emprestar();

        assertThrows(
                IllegalStateException.class,
                () -> equipamento.emprestar()
        );
    }
}
