package lp2.lab04p1.controllers;

/**
 * Classe responsável por ser o controller principal do sistema.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.ArrayList;
import java.util.List;

import lp2.lab04p1.util.Checks;

public class Sistema {

	private final String NL = System.lineSeparator();

	private double taxa;
	private int caixa;
	private List<Cenario> cenarios;

	/**
	 * Construtor de Sistema responsável por inicializar o sistema, armazenando
	 * o valor em caixa e sua taxa de cobrança quando o cenário é finalizado.
	 * 
	 * @param caixa
	 *            Valor inicial do caixa.
	 * @param taxa
	 *            Valor da taxa que será cobrada a cada cenário encerrado.
	 */
	public Sistema(int caixa, double taxa) {

		Checks.verificaCaixaMenorZero(caixa, "Erro na inicializacao: ");
		Checks.verificaTaxaMenorZero(taxa, "Erro na inicializacao: ");

		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<Cenario>();

	}

	public int getCaixa() {
		return caixa;
	}

	/**
	 * Método responsável por cadastrar um novo cenário.
	 * 
	 * @param descricao
	 *            Descrição do novo cenário.
	 * 
	 * @return Retorna o int refente a sua posição no ArrayList.
	 */
	public int cadastrarCenario(String descricao) {

		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		return cenarios.indexOf(cenario);
	}

	/**
	 * Método responsável por retornar a representação string de um cenário
	 * jutamente com seu index. Tratando o caso de não existência do mesmo.
	 * 
	 * @param cenario
	 *            Index do cenário escolhido.
	 * 
	 * @return Retorna a representação string do cenário.
	 */
	public String exibirCenario(int cenario) {

		Checks.verificaCenarioInvalido(cenario, "Erro na consulta de cenario: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro na consulta de cenario: ");

		return cenario + " - " + cenarios.get(cenario - 1).toString();
	}

	/**
	 * Método responsável por retornar uma string com os cenários de um sistema.
	 * 
	 * @return Retorna uma string com os cenários.
	 */
	public String exibirCenarios() {

		String stringRetorno = "";
		for (Cenario cenario : cenarios)
			stringRetorno += cenarios.indexOf(cenario) + " - " + cenario.toString() + NL;

		return stringRetorno;
	}

	/**
	 * Método responsável por cadastrar uma nova aposta e um cénario escolhido.
	 * 
	 * @param cenario
	 *            Cenário escolhido para realizar a aposta.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão do desfecho do cenário.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {

		Checks.verificaCenarioInvalido(cenario, "Erro no cadastro de aposta: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro no cadastro de aposta: ");

		Cenario refCenario = cenarios.get(cenario - 1);
		refCenario.adicionarNovaAposta(apostador, valor, previsao);

	}

	/**
	 * Método responsável por retornar o valor total das apostas de um cenário
	 * escolhido.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 * @return Retorna o valor total das apostas.
	 */
	public int valorTotalApostas(int cenario) {

		Checks.verificaCenarioInvalido(cenario, "Erro na consulta do valor total de apostas: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro na consulta do valor total de apostas: ");

		Cenario refCenario = cenarios.get(cenario - 1);
		return refCenario.valorTotalApostasCenario();
	}

	/**
	 * Método responsável por retornar o total de aposta de um cenário
	 * escolhido.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 * @return Retorna o total de aposta de um cenário.
	 */
	public int totalDeApostas(int cenario) {

		Checks.verificaCenarioInvalido(cenario, "Erro na consulta do total de apostas: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro na consulta do total de apostas: ");

		Cenario refCenario = cenarios.get(cenario - 1);
		return refCenario.totalApostasCenario();
	}

	/**
	 * Método responsável por retornar uma string com a representação de uma
	 * aposta.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 * @return Retorna uma string da aposta.
	 */
	public String exibeApostas(int cenario) {

		Checks.verificaCenarioInvalido(cenario, "Erro na consulta de aposta: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro na consulta de aposta: ");

		Cenario refCenario = cenarios.get(cenario - 1);
		return refCenario.exibirApostasCenario();
	}

	/**
	 * Método responsável por fechar um cenário e transferir o valor do cenário
	 * que pertence ao caixa para o caixa.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * @param ocorreu
	 *            Boolean do desfecho do cenário
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {

		Checks.verificaCenarioInvalido(cenario, "Erro ao fechar aposta: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro ao fechar aposta: ");

		Cenario refCenario = cenarios.get(cenario - 1);
		Checks.verificaCenarioJaFechado(refCenario.getEstado(), "Erro ao fechar aposta: ");
		
		refCenario.fecharApostaCenario(ocorreu);
		this.caixa += getCaixaCenario(cenario);

	}

	/**
	 * Método responsável por retornar o valor do total dos perdedores que
	 * pertence ao caixa do sistema.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 * @return Retornar um int com esse valor.
	 */
	public int getCaixaCenario(int cenario) {

		Checks.verificaCenarioInvalido(cenario, "Erro na consulta do caixa do cenario: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro na consulta do caixa do cenario: ");

		Cenario refCenario = cenarios.get(cenario - 1);
		Checks.verificaCenarioAindaAberto(refCenario.getEstado(), "Erro na consulta do caixa do cenario: ");
		
		return (int) (refCenario.getValorTotalPerdedores() * this.taxa);

	}

	/**
	 * Método responsável por retornar o valor do total dos perdedores que irão
	 * ser distribuidos entre os ganhadores.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 * @return Retorna um int com esse valor.
	 */
	public int getTotalRateioCenario(int cenario) {

		Checks.verificaCenarioInvalido(cenario, "Erro na consulta do total de rateio do cenario: ");
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), "Erro na consulta do total de rateio do cenario: ");

		Cenario refCenario = cenarios.get(cenario - 1);
		Checks.verificaCenarioAindaAberto(refCenario.getEstado(), "Erro na consulta do total de rateio do cenario: ");
		int valor = (int) (refCenario.getValorTotalPerdedores() - getCaixaCenario(cenario));
		return valor;
	}

}
