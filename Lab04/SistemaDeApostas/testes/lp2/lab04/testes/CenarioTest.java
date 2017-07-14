package lp2.lab04.testes;

/**
 * Classe responsável por realizar os testes na classe Cenario.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab04p1.controllers.Cenario;

public class CenarioTest {

	private final String NL = System.lineSeparator();

	private Cenario cenarioBasicoUm, cenarioBasicoDois;

	@SuppressWarnings("unused")
	private Cenario cenarioInvalido;

	/**
	 * Método responsável por criar um cenário básico para realização dos
	 * testes.
	 */
	@Before
	public void criaCenario() {
		cenarioBasicoUm = new Cenario("A grade vai mudar em 2018.1!");
		cenarioBasicoDois = new Cenario("Tudo que sobe, desce!");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em uma
	 * descrição nula.
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testDescricaoNull() {
		cenarioInvalido = new Cenario(null);
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em uma
	 * descrição composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoVazio() {
		cenarioInvalido = new Cenario("      ");
	}

	private void adicionarApostasEmCenario() {
		cenarioBasicoUm.adicionarNovaAposta("Thiago", 150000, "VAI ACONTECER");
		cenarioBasicoUm.adicionarNovaAposta("José", 20000, "N VAI ACONTECER");
		cenarioBasicoUm.adicionarNovaAposta("Pedro", 1000, "N VAI ACONTECER");
		cenarioBasicoDois.adicionarNovaAposta("Thiago", 5000, "N VAI ACONTECER");
		cenarioBasicoDois.adicionarNovaAposta("Matheus", 8500, "VAI ACONTECER");
	}

	/**
	 * Método responsável por testar o valor total apostado em um cenário.
	 * Verificando antes e depois das apostas ocorrerem.
	 */
	@Test
	public void testValorTotalApostasCenario() {

		assertEquals(cenarioBasicoUm.valorTotalApostasCenario(), 0);
		assertEquals(cenarioBasicoDois.valorTotalApostasCenario(), 0);

		adicionarApostasEmCenario();

		assertEquals(cenarioBasicoUm.valorTotalApostasCenario(), 171000);
		assertEquals(cenarioBasicoDois.valorTotalApostasCenario(), 13500);

	}

	/**
	 * Método responsável por testar a quantidade de apostas em um cenário.
	 * Verificando antes e depois das apostas ocorrerem.
	 */
	@Test
	public void testTotalApostasCenario() {

		assertEquals(cenarioBasicoUm.totalApostasCenario(), 0);
		assertEquals(cenarioBasicoDois.totalApostasCenario(), 0);

		adicionarApostasEmCenario();

		assertEquals(cenarioBasicoUm.totalApostasCenario(), 3);
		assertEquals(cenarioBasicoDois.totalApostasCenario(), 2);
	}

	/**
	 * Método responsável por testar a exibição das apostas de um cenário
	 */
	@Test
	public void testExibirApostasCenario() {
		assertEquals(cenarioBasicoUm.exibirApostasCenario(), "");
		assertEquals(cenarioBasicoDois.exibirApostasCenario(), "");

		cenarioBasicoUm.adicionarNovaAposta("Thiago", 150000, "VAI ACONTECER");
		cenarioBasicoDois.adicionarNovaAposta("Thiago", 5000, "N VAI ACONTECER");

		String msgUm = "Thiago - R$1500.00 - VAI ACONTECER" + NL;
		String msgDois = "Thiago - R$50.00 - N VAI ACONTECER" + NL;
		assertEquals(cenarioBasicoUm.exibirApostasCenario(), msgUm);
		assertEquals(cenarioBasicoDois.exibirApostasCenario(), msgDois);

	}

	/**
	 * Método responsável por testar a ação de fechar um cenário. Verificando
	 * sua modificação na variável estado.
	 */
	@Test
	public void testFecharApostaCenario() {
		String msgUm = "A grade vai mudar em 2018.1! - Não finalizado";
		String msgDois = "Tudo que sobe, desce! - Não finalizado";

		assertEquals(cenarioBasicoUm.toString(), msgUm);
		assertEquals(cenarioBasicoDois.toString(), msgDois);

		cenarioBasicoUm.fecharApostaCenario(true);
		cenarioBasicoDois.fecharApostaCenario(false);

		String msgTres = "A grade vai mudar em 2018.1! - Finalizado (ocorreu)";
		String msgQuatro = "Tudo que sobe, desce! - Finalizado (n ocorreu)";

		assertEquals(cenarioBasicoUm.toString(), msgTres);
		assertEquals(cenarioBasicoDois.toString(), msgQuatro);
	}

	/**
	 * Método responsável por testar a funcionalidade do método
	 * getValorTotalPerdedores da classe Cenario.
	 */
	@Test
	public void testGetValorTotalPerdedores() {

		adicionarApostasEmCenario();

		cenarioBasicoUm.fecharApostaCenario(true);
		cenarioBasicoDois.fecharApostaCenario(false);

		assertEquals(cenarioBasicoUm.getValorTotalPerdedores(), 21000);
		assertEquals(cenarioBasicoDois.getValorTotalPerdedores(), 8500);

	}

}
