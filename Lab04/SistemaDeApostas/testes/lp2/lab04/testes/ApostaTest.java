package lp2.lab04.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import lp2.lab04.p1.Aposta;

public class ApostaTest {

	private Aposta apostaBasica;

	@Test
	public void testToString() {
		apostaBasica = new Aposta("Thiago", 15000, "VAI ACONTECER");

		String msg = "Thiago - R$150.00 - VAI ACONTECER";
		assertEquals(apostaBasica.toString(), msg);
	}

	/**
	 * Método responsável por certificar o lançamento de uma exceção em uma
	 * previsão incorreta.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPrevisaoErrada() {
		apostaBasica = new Aposta("Thiago", 15000, "Vai acontecer sim em");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um
	 * apostador nulo.
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testApostadorNull() {
		apostaBasica = new Aposta(null, 15000, "VAI ACONTECER");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em uma
	 * previsão nula.
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testPrevisaoNull() {
		apostaBasica = new Aposta("Thiago", 15000, null);
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um
	 * apostador composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostadorVazio() {
		apostaBasica = new Aposta("    ", 15000, "VAI ACONTECER");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em uma
	 * previsão composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPrevisaoVazia() {
		apostaBasica = new Aposta("Thiago", 15000, "     ");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um valor
	 * zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAValorZero() {
		apostaBasica = new Aposta("Thiago", 0, "VAI ACONTECER");
	}

}
