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

		String msgErro = "Erro na inicializacao: ";
		Checks.verificaCaixaMenorZero(caixa, msgErro);
		Checks.verificaTaxaMenorZero(taxa, msgErro);

		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<Cenario>();

	}

	public int getCaixa() {
		return caixa;
	}

	/**
	 * Método responsável por cadastrar um novo cenário bônus.
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
	 * Método responsável por cadastrar um novo cenário.
	 * 
	 * @param descricao
	 *            Descrição do novo cenário.
	 * @param bonus
	 *            Bônus do novo cenário.
	 * @return Retorna o int refente a sua posição no ArrayList.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		this.caixa -= bonus;
		CenarioBonus cenario = new CenarioBonus(descricao, bonus);
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

		String msgErro = "Erro na consulta de cenario: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

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

		String msgErro = "Erro no cadastro de aposta: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		Cenario refCenario = cenarios.get(cenario - 1);
		refCenario.adicionarNovaAposta(apostador, valor, previsao);

	}

	/**
	 * Método responsável por solicitar o cadastro de uma aposta com seguro do
	 * tipo valor.
	 * 
	 * @param cenario
	 *            Cenário escolhido para apostar.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param valorSeguro
	 *            Valor assegurado na aposta.
	 * @param custo
	 *            Custo da criação de uma aposta assegurada.
	
	 * @return Retorna um int com o index da aposta.
	 */
	public int cadastrarAposta(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {

		String msgErro = "Erro no cadastro de aposta assegurada por valor: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		this.caixa += custo;
		Cenario refCenario = cenarios.get(cenario - 1);
		return refCenario.adicionarNovaApostaSegura(apostador, valor, previsao, valorSeguro);

	}

	/**
	 * Método responsável por solicitar o cadastro de uma aposta com seguro do
	 * tipo valor.
	 * 
	 * @param cenario
	 *            Cenário escolhido para apostar.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param valorSeguro
	 *            Valor assegurado na aposta.
	 * @param custo
	 *            Custo da criação de uma aposta assegurada.
	
	 * @return Retorna um int com o index da aposta.
	 */
	public int cadastrarAposta(int cenario, String apostador, int valor, String previsao, double taxaSegura,
			int custo) {

		String msgErro = "Erro no cadastro de aposta assegurada por taxa: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		this.caixa += custo;
		Cenario refCenario = cenarios.get(cenario - 1);
		return refCenario.adicionarNovaApostaSegura(apostador, valor, previsao, taxaSegura);

	}

	/**
	 * Método responsável por modularizar a validação do cenário escolhido para
	 * ser acessado.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 */
	private void validacaoNoCenarioEscolhido(int cenario, String msgErro) {

		Checks.verificaCenarioInvalido(cenario, msgErro);
		Checks.verificaCenarioNaoCadastrado(cenario, cenarios.size(), msgErro);
	}

	/**
	 * Método responsável solicitar a alteração do tipo do seguro de uma aposta
	 * assegurada.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * @param apostaAssegurada
	 *            Aposta escolhida.
	 * @param valor
	 *            Valor do seguro.
	 * 
	 * @return Retorna um int com o index da aposta alterada.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {

		String msgErro = "Erro na alteracao do seguro: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		Cenario refCenario = cenarios.get(cenario - 1);
		return refCenario.alterarSeguroAposta(apostaAssegurada, valor);
	}

	/**
	 * Método responsável solicitar a alteração do tipo do seguro de uma aposta
	 * assegurada.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * @param apostaAssegurada
	 *            Aposta escolhida.
	 * @param taxa
	 *            Taxa do seguro.
	 * 
	 * @return Retorna um int com o index da aposta alterada.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {

		String msgErro = "Erro na alteracao do seguro: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		Cenario refCenario = cenarios.get(cenario - 1);
		return refCenario.alterarSeguroAposta(apostaAssegurada, taxa);
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

		String msgErro = "Erro na consulta do valor total de apostas: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

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

		String msgErro = "Erro na consulta do total de apostas: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

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

		String msgErro = "Erro na consulta de aposta: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

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

		String msgErro = "Erro ao fechar aposta: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		Cenario refCenario = cenarios.get(cenario - 1);
		Checks.verificaCenarioJaFechado(refCenario.getEstado(), msgErro);

		refCenario.fecharApostaCenario(ocorreu);
		this.caixa += getCaixaCenario(cenario);

		this.caixa -= refCenario.pagarSegurosCenario();

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

		String msgErro = "Erro na consulta do caixa do cenario: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		Cenario refCenario = cenarios.get(cenario - 1);
		Checks.verificaCenarioAindaAberto(refCenario.getEstado(), msgErro);

		return (int) (refCenario.getValorTotalArrecadadoPerdedoresPadrao() * this.taxa);

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

		String msgErro = "Erro na consulta do total de rateio do cenario: ";
		validacaoNoCenarioEscolhido(cenario, msgErro);

		Cenario refCenario = cenarios.get(cenario - 1);
		Checks.verificaCenarioAindaAberto(refCenario.getEstado(), msgErro);
		int valor = (refCenario.getValorTotalArrecadadoPerdedoresModificado() - getCaixaCenario(cenario));
		return valor;
	}

}
