package lp2.lab04p1.controllers;

/**
 * Classe responsável por moldar a representação de um cenário e controlar as apostas de um sistema.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.HashSet;
import java.util.Set;

import lp2.lab04p1.entidades.Aposta;
import lp2.lab04p1.enums.Previsao;
import lp2.lab04p1.enums.Status;
import lp2.lab04p1.util.Checks;

public class Cenario {

	private final String NL = System.lineSeparator();

	private String descricao;
	private Status estado;

	private Set<Aposta> apostas;

	/**
	 * Construtor responsável por inicializar um cenário, validando sua
	 * descrição antes.
	 * 
	 * @param descricao
	 *            Descrição do novo cenário.
	 */
	public Cenario(String descricao) {

		Checks.verificaDescricaoNula(descricao, "Erro no cadastro de cenario: ");
		Checks.verificaDescricaoVazia(descricao, "Erro no cadastro de cenario: ");

		this.descricao = descricao;
		this.estado = Status.NAO_FINALIZADO;
		this.apostas = new HashSet<Aposta>();
	}

	public String getEstado() {
		return this.estado.getStatus();
	}
	
	@Override
	public String toString() {
		return this.descricao + " - " + this.estado.getStatus();
	}

	/**
	 * Método responsável por adicionar uma aposta ao HashSet de apostas.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 */
	public void adicionarNovaAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		apostas.add(aposta);

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
	 * Método responsável por retornar o valor total arrecado dos perdedores de
	 * um cenário.
	 * 
	 * @return Retorna um int com esse valor.
	 */
	public int getValorTotalPerdedores() {
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
}
