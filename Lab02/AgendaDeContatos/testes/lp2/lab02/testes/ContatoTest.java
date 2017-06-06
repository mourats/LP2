package lp2.lab02.testes;

/**
 * Classe teste responsável por realizar testes na classe Contato.
 * 
 * Laboratório de Programação 2 - Lab 02
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import lp2.lab02.agenda.Contato;

public class ContatoTest {

	private Contato contatoBasico;

	@SuppressWarnings("unused")
	private Contato contatoInvalido;

	/**
	 * Método que instancia um contato para realizar os testes básicos.
	 */
	@Before
	public void criaContato() {
		contatoBasico = new Contato("Thiago", "Santos", "2101-0000");
	}

	/**
	 * Método que testa o nome completo.
	 */
	@Test
	public void testNomeCompleto() {
		String msg = "Esperando obter o nome completo";
		assertEquals(msg, "Thiago Santos", contatoBasico.nomeCompleto());
	}

	/**
	 * Método que testa a impressão de um contato atráves do toString().
	 */
	@Test
	public void testToString() {
		assertEquals(contatoBasico.toString(), "Thiago Santos - 2101-0000");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um nome
	 * nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testNomeNull() {
		contatoInvalido = new Contato(null, "Pereira", "3333-0000");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um
	 * sobrenome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testSobrenomeNull() {
		contatoInvalido = new Contato("José", null, "3333-0000");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um telefone
	 * nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testTelefoneNull() {
		contatoInvalido = new Contato("José", "Pereira", null);
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um nome
	 * composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNomeVazio() {
		contatoInvalido = new Contato("     ", "Gomes", "3311-1000");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um
	 * sobrenome composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSobrenomeVazio() {
		contatoInvalido = new Contato("Lucas", "     ", "3311-1000");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um telefone
	 * composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTelefoneVazio() {
		contatoInvalido = new Contato("Lucas", "Gomes", "     ");
	}

}
