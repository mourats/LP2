package lp2.lab04p1.controllers;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por moldar a representação de um cenário e controlar as apostas de um sistema.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import lp2.lab04p1.entidades.Aposta;
import lp2.lab04p1.entidades.ApostaSegura;
import lp2.lab04p1.enums.Previsao;
import lp2.lab04p1.enums.Status;
import lp2.lab04p1.util.Checks;

public class Cenario {

	private final String NL = System.lineSeparator();

	private String descricao;
	private Status estado;

	private List<Aposta> apostas;

	/**
	 * Construtor responsável por inicializar um cenário, validando sua
	 * descrição antes.
	 * 
	 * @param descricao
	 *            Descrição do novo cenário.
	 */
	public Cenario(String descricao) {

		String msgErro = "Erro no cadastro de cenario: ";
		Checks.verificaDescricaoNula(descricao, msgErro);
		Checks.verificaDescricaoVazia(descricao, msgErro);

		this.descricao = descricao;
		this.estado = Status.NAO_FINALIZADO;
		this.apostas = new ArrayList<Aposta>();
	}

	public String getEstado() {
		return this.estado.getStatus();
	}

	@Override
	public String toString() {
		return this.descricao + " - " + this.estado.getStatus();
	}

	/**
	 * Método responsável por adicionar uma aposta sem seguro ao ArrayList de
	 * apostas.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 */
	public void adicionarNovaAposta(String apostador, int valor, String previsao) {
		
		String msgErro = "Erro no cadastro de aposta: ";
		validacaoDadosDaAposta(apostador, valor, previsao, msgErro);
		
		Previsao previsaoIdentificada = Previsao.identificaPrevisao(previsao, msgErro);
		Aposta aposta = new Aposta(apostador, valor, previsaoIdentificada);
		
		apostas.add(aposta);

	}

	protected void validacaoDadosDaAposta(String apostador, int valor, String previsao, String msgErro) {
		Checks.verificaApostadorVazio(apostador, msgErro);
		Checks.verificaValorZero(valor, msgErro);
		Checks.verificaPrevisaoVazia(previsao, msgErro);
	}

	/**
	 * Método responsável por adicionar uma aposta com seguro de valor ao
	 * ArrayList de apostas.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param valorSeguro
	 *            Valor assegurado da aposta.
	 */
	public int adicionarNovaApostaSegura(String apostador, int valor, String previsao, int valorSeguro) {
		
		String msgErro = "Erro no cadastro de aposta assegurada por valor: ";
		validacaoDadosDaAposta(apostador, valor, previsao, msgErro);
		
		Previsao previsaoIdentificada = Previsao.identificaPrevisao(previsao, msgErro);
		ApostaSegura aposta = new ApostaSegura(apostador, valor, previsaoIdentificada, valorSeguro);
		apostas.add(aposta);
		return apostas.indexOf(aposta);
	}

	/**
	 * Método responsável por adicionar uma aposta com seguro de taxa ao
	 * ArrayList de apostas.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param taxaSegura
	 *            Taxa assegurada da aposta.
	 */
	public int adicionarNovaApostaSegura(String apostador, int valor, String previsao, double taxaSegura) {
		
		String msgErro = "Erro no cadastro de aposta assegurada por taxa: ";
		validacaoDadosDaAposta(apostador, valor, previsao, msgErro);
		
		Previsao previsaoIdentificada = Previsao.identificaPrevisao(previsao, msgErro);
		ApostaSegura aposta = new ApostaSegura(apostador, valor, previsaoIdentificada, taxaSegura);
		apostas.add(aposta);
		return apostas.indexOf(aposta);
	}

	/**
	 * Método responsável por retornar o valor total das apostas de um cenário.
	 * 
	 * @return Retorna um int com esse valor.
	 */
	public int valorTotalApostasCenario() {
		int valorTotal = 0;
		for (Aposta aposta : apostas) {
			valorTotal += aposta.getValor();
		}
		return valorTotal;
	}

	/**
	 * Método responsável por retornar o total de apostas de um cenário.
	 * 
	 * @return Retorna um int com esse valor.
	 */
	public int totalApostasCenario() {
		return apostas.size();
	}

	/**
	 * Método responsável por retornar uma string com as apostas de um cenário.
	 * 
	 * @return Retorna um string com essa representação.
	 */
	public String exibirApostasCenario() {

		String stringRetorno = "";
		for (Aposta aposta : apostas)
			stringRetorno += aposta.toString() + NL;

		return stringRetorno;
	}

	/**
	 * Método responsável por fechar uma aposta.
	 * 
	 * @param ocorreu
	 *            Booleano com o resultado do cenário.
	 */
	public void fecharApostaCenario(boolean ocorreu) {
		if (ocorreu)
			this.estado = Status.FINALIZADO_TRUE;
		else
			this.estado = Status.FINALIZADO_FALSE;

	}

	/**
	 * Método responsável por retornar o valor total arrecadado dos perdedores
	 * de um cenário normal.
	 * 
	 * @return Retorna um int com esse valor.
	 */
	public int getValorTotalArrecadadoPerdedoresPadrao() {
		int valorTotal = 0;
		boolean resultado;
		resultado = resultadoCenario();
		for (Aposta aposta : apostas) {
			if (aposta.getPrevisao().equals(Previsao.VAI_ACONTECER)) {
				if (!resultado)
					valorTotal += aposta.getValor();
			} else {
				if (resultado)
					valorTotal += aposta.getValor();
			}
		}
		return valorTotal;
	}

	/**
	 * Método responsável por retornar o valor total arrecadado dos perdedores
	 * de um cenário mais a sua possível alteração em classes filhas.
	 * 
	 * @return Retorna um int com esse valor.
	 */
	public int getValorTotalArrecadadoPerdedoresModificado() {
		return getValorTotalArrecadadoPerdedoresPadrao();
	}

	/**
	 * Método responsável por encapsular a verificação do resultado de um
	 * cenário.
	 * 
	 * @return Retorna um booleano com esse resultado.
	 */
	private boolean resultadoCenario() {
		boolean resultado;
		if (this.estado.equals(Status.FINALIZADO_TRUE))
			resultado = true;
		else
			resultado = false;
		return resultado;
	}

	/**
	 * Método responsável por alterar o tipo de seguro de uma aposta assegurada,
	 * para seguro de valor.
	 * 
	 * @param apostaAssegurada
	 *            Index da aposta escolhida.
	 * @param taxa
	 *            Taxa assegurada.
	 * 
	 * @return Retorna o index dessa aposta.
	 */
	public int alterarSeguroAposta(int apostaAssegurada, int valor) {

		String msgErro = "Erro na alteracao do seguro: ";
		validacaoApostaEscolhida(apostaAssegurada, msgErro);

		Aposta aposta = apostas.get(apostaAssegurada);
		Checks.verificaApostaNaoSegura(aposta, msgErro);

		((ApostaSegura) aposta).alterarSeguro(valor);
		return apostas.indexOf(aposta);
	}

	/**
	 * Método responsável por alterar o tipo de seguro de uma aposta assegurada,
	 * para seguro de taxa.
	 * 
	 * @param apostaAssegurada
	 *            Index da aposta escolhida.
	 * @param taxa
	 *            Taxa assegurada.
	 * 
	 * @return Retorna o index dessa aposta.
	 */
	public int alterarSeguroAposta(int apostaAssegurada, double taxa) {

		String msgErro = "Erro na alteracao do seguro: ";
		validacaoApostaEscolhida(apostaAssegurada, msgErro);

		Aposta aposta = apostas.get(apostaAssegurada);
		Checks.verificaApostaNaoSegura(aposta, msgErro);

		((ApostaSegura) aposta).alterarSeguro(taxa);
		return apostas.indexOf(aposta);
	}

	/**
	 * Método responsável por validar a aposta escolhida.
	 * 
	 * @param apostaAssegurada
	 *            Index da aposta escolhida.
	 * @param msgErro
	 *            Mensagem de erro do respectivo método.
	 */
	private void validacaoApostaEscolhida(int apostaAssegurada, String msgErro) {

		Checks.verificaApostaInvalida(apostaAssegurada, msgErro);
		Checks.verificaApostaNaoCadastrada(apostaAssegurada, apostas.size(), msgErro);
	}

	public int pagarSegurosCenario() {
		int valorSeguros = 0;
		for (Aposta aposta : apostas) {
			if (aposta.getClass() != Aposta.class)
				valorSeguros += ((ApostaSegura) aposta).getValorSegurado();
		}
		return valorSeguros;
	}

}
