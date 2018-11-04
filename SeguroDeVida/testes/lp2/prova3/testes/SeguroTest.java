package lp2.prova3.testes;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import lp2.prova3.entidades.Seguro;

public class SeguroTest {

	private Seguro seguroBasico;

	private Seguro seguroPleno;

	@Before
	public void criaSeguro() {

		seguroBasico = new Seguro(LocalDate.now().getYear(), "Basico");
		seguroPleno = new Seguro(LocalDate.now().getYear(), "Pleno");
	}

	@Test
	public void testRecebePagamento() {

		seguroBasico.recebePagamento();

		assertEquals(seguroBasico.getSaldo(), 250.0, 0.001);

		seguroPleno.recebePagamento();

		assertEquals(seguroPleno.getSaldo(), 400.0, 0.001);

	}

	@Test
	public void testGetValorPagamentoMensalPorDoenca() {
		
		assertEquals(seguroBasico.getValorPagamentoMensalPorDoenca(), 1000.0, 0.001);

		assertEquals(seguroPleno.getValorPagamentoMensalPorDoenca(), 2000.0, 0.001);
	}

	@Test
	public void testSetTipoDeSeguro() {

		assertEquals(seguroBasico.getTipo(), "Basico");

		assertEquals(seguroPleno.getTipo(), "Pleno");
	}

}
