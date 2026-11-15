
package projeto.emprestimos.model;

import com.projeto.emprestimos.model.Emprestimo;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    @Test
    void emprestimoDeveTerPrazoDe14Dias() {
        LocalDate hoje = LocalDate.of(2026, 11, 15);
        Emprestimo emprestimo = new Emprestimo(1L, 1L, hoje);

        assertEquals(hoje, emprestimo.getDataEmprestimo());
        assertEquals(hoje.plusDays(14),
                emprestimo.getDataPrevistaDevolucao());
    }

    @Test
    void emprestimoNovoNaoDeveEstarAtrasado() {
        LocalDate hoje = LocalDate.of(2026, 11, 15);
        Emprestimo emprestimo = new Emprestimo(1L, 1L, hoje);

        assertFalse(emprestimo.estaAtrasadoEm(hoje));
    }

    @Test
    void emprestimoDeveFicarAtrasadoAposPrazo() {
        LocalDate hoje = LocalDate.of(2026, 11, 15);
        Emprestimo emprestimo = new Emprestimo(1L, 1L, hoje);

        assertTrue(emprestimo.estaAtrasadoEm(hoje.plusDays(15)));
    }

    @Test
    void emprestimoNaoDeveEstarAtrasadoNoVencimento() {
        LocalDate hoje = LocalDate.of(2026, 11, 15);
        Emprestimo emprestimo = new Emprestimo(1L, 1L, hoje);

        assertFalse(emprestimo.estaAtrasadoEm(hoje.plusDays(14)));
    }

    @Test
    void devolucaoDeveRegistrarData() {
        LocalDate hoje = LocalDate.of(2026, 11, 15);
        Emprestimo emprestimo = new Emprestimo(1L, 1L, hoje);

        LocalDate devolucao = hoje.plusDays(5);
        emprestimo.devolver(devolucao);

        assertEquals(devolucao, emprestimo.getDataDevolucao());
    }

    @Test
    void naoDevePermitirDevolucaoDuplicada() {
        LocalDate hoje = LocalDate.of(2026, 11, 15);
        Emprestimo emprestimo = new Emprestimo(1L, 1L, hoje);

        emprestimo.devolver(hoje.plusDays(5));

        assertThrows(IllegalStateException.class,
                () -> emprestimo.devolver(hoje.plusDays(6)));
    }

    @Test
    void emprestimoDevolvidoNaoDeveEstarAtrasado() {
        LocalDate hoje = LocalDate.of(2026, 11, 15);
        Emprestimo emprestimo = new Emprestimo(1L, 1L, hoje);

        emprestimo.devolver(hoje.plusDays(5));

        assertFalse(emprestimo.estaAtrasadoEm(hoje.plusDays(20)));
    }
}
