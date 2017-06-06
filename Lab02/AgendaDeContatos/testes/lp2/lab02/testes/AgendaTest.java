package lp2.lab02.testes;

/**
 * Classe teste responsável por realizar testes na classe Agenda.
 * 
 * Laboratório de Programação 2 - Lab 02
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import lp2.lab02.agenda.Agenda;

public class AgendaTest {

	final String NL = System.lineSeparator();

	private Agenda agenda;

	/**
	 * Método que instancia uma agenda para realizar os testes.
	 */
	@Before
	public void criaAgenda() {
		agenda = new Agenda();
	}

	/**
	 * Método responsável por testar o método cadastrarContatao() e
	 * exibirContato(). Para fazer isso, ele cadastra dois novos contatos e
	 * exibe eles, averiguando que o resultado é o esperado.
	 */
	@Test
	public void testCadastrarContato() {

		agenda.cadastrarContato(3, "Bart", "Simpson", "3322-8585");
		agenda.cadastrarContato(15, "Marge", "Simpson", "2222-0011");

		assertEquals(agenda.exibirContato(3), "Nome do Contato: Bart Simpson" + NL + "Telefone: 3322-8585" + NL);
		assertEquals(agenda.exibirContato(15), "Nome do Contato: Marge Simpson" + NL + "Telefone: 2222-0011" + NL);
	}

	/**
	 * Método responsável por testar o método listarContatos(). Para fazer isso,
	 * ele começa cadastrando cinco novos contatos em sequencias aleatórias e
	 * depois convoca o método para averiguar seu retorno de forma correta e com
	 * a sequência esperada.
	 * 
	 */
	@Test
	public void testListarContatos() {
		agenda.cadastrarContato(3, "Bart", "Simpson", "3322-8585");
		agenda.cadastrarContato(15, "Marge", "Simpson", "3322-0011");
		agenda.cadastrarContato(79, "Homer", "Simpson", "3322-7532");
		agenda.cadastrarContato(8, "Lisa", "Simpson", "3222-9512");
		agenda.cadastrarContato(25, "Maggie", "Simpson", "3322-8521");

		assertEquals(agenda.listarContatos(),
				"3 - Bart Simpson - 3322-8585" + NL + "8 - Lisa Simpson - 3222-9512" + NL
						+ "15 - Marge Simpson - 3322-0011" + NL + "25 - Maggie Simpson - 3322-8521" + NL
						+ "79 - Homer Simpson - 3322-7532" + NL);
	}

}
