package lp2.lab04.testes;

/**
 * Classe responsável por realizar os testes na classe Sistema.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab04p1.controllers.Sistema;

public class SistemaTest {

	private final String NL = System.lineSeparator();

	private Sistema sistema;

	/**
	 * Método responsável por criar o sistema utilizado nos testes.
	 */
	@Before
	public void criaSistema() {
		sistema = new Sistema(1000, 0.2);
	}

	/**
	 * Método responsável por testar a recuraperação do dinheiro em caixa do
	 * sistema
	 */
	@Test
	public void testGetCaixa() {
		assertEquals(sistema.getCaixa(), 1000);
	}

	/**
	 * Método responsável por testar a criação de cenários e seus index
	 * corretos.
	 */
	@Test
	public void testCadastrarCenario() {
		assertEquals(sistema.cadastrarCenario("A grade vai mudar em 2018.1!"), 1);
		assertEquals(sistema.cadastrarCenario("Tudo que sobe, desce!"), 2);
		assertEquals(sistema.cadastrarCenario("Um dia eu termino esse lab!"), 3);
	}

	/**
	 * Método responsável por encapsular o cadastro de cenários recorrentes nos
	 * testes do sistema.
	 */
	private void cadastrarCenariosParaTestes() {
		sistema.cadastrarCenario("A grade vai mudar em 2018.1!");
		sistema.cadastrarCenario("Tudo que sobe, desce!");
	}

	/**
	 * Método responsável por encapsular o cadastro das apostas recorrentes nos
	 * testes do sistema.
	 */
	private void cadastrarApostasParaTestes() {
		sistema.cadastrarAposta(1, "Thiago", 15000, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "João", 10000, "N VAI ACONTECER");
		sistema.cadastrarAposta(1, "Maria", 1500, "N VAI ACONTECER");
		sistema.cadastrarAposta(2, "José", 20000, "VAI ACONTECER");
		sistema.cadastrarAposta(2, "Pedro", 25000, "VAI ACONTECER");
		sistema.cadastrarAposta(2, "Simão", 30000, "N VAI ACONTECER");
	}

	/**
	 * Método responsável por testar o acesso a um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioNaoCadastrado() {
		
		cadastrarCenariosParaTestes();
		sistema.exibirCenario(3);
		sistema.exibirCenario(4);
	}
	
	/**
	 * Método responsável por testar o acesso a um cenário inválido.
	 */
	@Test(expected = NullPointerException.class)
	public void testExibirCenariInvalido() {
		
		sistema.exibirCenario(0);
		sistema.exibirCenario(-1);
	}

	/**
	 * Método responsável por testar a exibição de um cenário a partir do seu
	 * index. Cobrindo o caso do cenário não existir.
	 */
	@Test
	public void testExibirCenario() {
		cadastrarCenariosParaTestes();

		assertEquals(sistema.exibirCenario(1), "1 - A grade vai mudar em 2018.1! - Nao finalizado");
		assertEquals(sistema.exibirCenario(2), "2 - Tudo que sobe, desce! - Nao finalizado");
	}

	/**
	 * Método responsável por testar a exibição dos cenários de um sistema.
	 */
	@Test
	public void testExibirCenarios() {
		assertEquals(sistema.exibirCenarios(), "");

		cadastrarCenariosParaTestes();

		String msg = "0 - A grade vai mudar em 2018.1! - Nao finalizado" + NL
				+ "1 - Tudo que sobe, desce! - Nao finalizado" + NL;

		assertEquals(sistema.exibirCenarios(), msg);
	}

	/**
	 * Método responsável por testar o cadastro de apostas em cenários.
	 * Avaliando sua existência antes e depois.
	 */
	@Test
	public void testCadastrarAposta() {

		cadastrarCenariosParaTestes();

		assertEquals(sistema.exibeApostas(1), "");
		assertEquals(sistema.exibeApostas(2), "");

		sistema.cadastrarAposta(1, "Thiago", 15000, "VAI ACONTECER");
		sistema.cadastrarAposta(2, "Thiago", 10000, "N VAI ACONTECER");

		assertEquals(sistema.exibeApostas(1), "Thiago - R$ 150,00 - VAI ACONTECER" + NL);
		assertEquals(sistema.exibeApostas(2), "Thiago - R$ 100,00 - N VAI ACONTECER" + NL);

	}

	/**
	 * Método responsável por testar o calculo do valor total das apostas em um
	 * cenário.
	 */
	@Test
	public void testValorTotalApostas() {
		cadastrarCenariosParaTestes();

		assertEquals(sistema.valorTotalApostas(1), 0);
		assertEquals(sistema.valorTotalApostas(2), 0);

		cadastrarApostasParaTestes();

		assertEquals(sistema.valorTotalApostas(1), 26500);
		assertEquals(sistema.valorTotalApostas(2), 75000);
	}

	/**
	 * Método responsável por testar a recuperação do total de aposta em um
	 * cenário.
	 */
	@Test
	public void testTotalDeApostas() {
		cadastrarCenariosParaTestes();

		assertEquals(sistema.totalDeApostas(1), 0);
		assertEquals(sistema.totalDeApostas(2), 0);

		cadastrarApostasParaTestes();
		sistema.cadastrarAposta(2, "Matheus", 300000, "N VAI ACONTECER");

		assertEquals(sistema.totalDeApostas(1), 3);
		assertEquals(sistema.totalDeApostas(2), 4);
	}

	/**
	 * Método responsável por testar o fechamento de um cenário e a arrecadação
	 * do valor do caixa com base na taxa indicada.
	 */
	@Test
	public void testFecharAposta() {

		cadastrarCenariosParaTestes();
		cadastrarApostasParaTestes();
		assertEquals(sistema.getCaixa(), 1000);
		sistema.fecharAposta(1, true);
		assertEquals(sistema.getCaixa(), 3300);
		sistema.fecharAposta(2, false);
		assertEquals(sistema.getCaixa(), 12300);
	}

	/**
	 * Método responsável por testar o retorno correto do valor que foi
	 * direcionado ao caixa ao encerramento de um cenário.
	 */
	@Test
	public void testGetCaixaCenario() {
		cadastrarCenariosParaTestes();
		cadastrarApostasParaTestes();
		sistema.fecharAposta(1, true);
		sistema.fecharAposta(2, false);
		assertEquals(sistema.getCaixaCenario(1), 2300);
		assertEquals(sistema.getCaixaCenario(2), 9000);
	}

	/**
	 * Método responsável por testar o retorno correto do valor que será
	 * dividido entre os apostadores quando um cenário é encerrado.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		cadastrarCenariosParaTestes();
		cadastrarApostasParaTestes();
		sistema.fecharAposta(1, true);
		sistema.fecharAposta(2, false);
		assertEquals(sistema.getTotalRateioCenario(1), 9200);
		assertEquals(sistema.getTotalRateioCenario(2), 36000);
	}

}
