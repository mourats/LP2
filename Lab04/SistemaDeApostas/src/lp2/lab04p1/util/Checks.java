package lp2.lab04p1.util;

import lp2.lab04p1.entidades.Aposta;
import lp2.lab04p1.enums.Status;

/**
 * Classe responsável por encapsular os métodos relacionados com validações no
 * projeto.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Checks {

	/**
	 * Método que verifica se o caixa é menor que zero. Lança uma execeção caso
	 * o caixa seja menor que zero e interrompe a execução do programa.
	 * 
	 * @param caixa
	 *            Caixa a ser válidado.
	 */
	public static void verificaCaixaMenorZero(int caixa, String msg) {
		if (caixa < 0)
			throw new IllegalArgumentException(msg + "Caixa nao pode ser inferior a 0");
	}

	/**
	 * Método que verifica se a taxa é menor que zero. Lança uma execeção caso a
	 * taxa seja menor que zero e interrompe a execução do programa.
	 * 
	 * @param taxa
	 *            Taxa a ser válidada.
	 */
	public static void verificaTaxaMenorZero(double taxa, String msg) {
		if (taxa < 0)
			throw new IllegalArgumentException(msg + "Taxa nao pode ser inferior a 0");
	}

	/**
	 * Método que verifica se cenário escolhido está cadastrado, caso não esteja
	 * lança uma exceção e imterrompe a execução do programa.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 */
	public static void verificaCenarioNaoCadastrado(int cenario, int quant_cenarios, String msg) {
		if (cenario - 1 >= quant_cenarios)
			throw new IllegalArgumentException(msg + "Cenario nao cadastrado");
	}

	/**
	 * Método que verifica se cenário escolhido é válido, caso não seja lança
	 * uma exceção e imterrompe a execução do programa.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 */
	public static void verificaCenarioInvalido(int cenario, String msg) {
		if (cenario <= 0)
			throw new NullPointerException(msg + "Cenario invalido");
	}

	/**
	 * Método que verifica se a descrição é uma string composta por espaços.
	 * Lança uma execeção caso a descrição seja composto por espaços e
	 * interrompe a execução do programa.
	 * 
	 * @param descricao
	 *            Valor a ser válidado.
	 */
	public static void verificaDescricaoVazia(String descricao, String msg) {
		if (descricao.trim().isEmpty())
			throw new IllegalArgumentException(msg + "Descricao nao pode ser composta por espacos");

	}

	/**
	 * Método que verifica se a descrição é nula. Lança uma exceção caso a
	 * descrição seja vazia e interrompe a execução do programa.
	 * 
	 * @param descricao
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaDescricaoNula(String descricao, String msg) {
		if (descricao.isEmpty())
			throw new NullPointerException(msg + "Descricao nao pode ser vazia");
	}

	/**
	 * Método que verifica se cenário escolhido está cadastrado, caso não esteja
	 * lança uma exceção e imterrompe a execução do programa.
	 * 
	 * @param estado
	 *            Estado do cenário escolhido.
	 * 
	 */
	public static void verificaCenarioJaFechado(String estado, String msg) {
		if (estado != Status.NAO_FINALIZADO.getStatus())
			throw new NullPointerException(msg + "Cenario ja esta fechado");
	}

	/**
	 * Método que verifica se a previsão é nula. Lança uma execeção caso a
	 * previsão seja nula e interrompe a execução do programa.
	 * 
	 * @param previsao
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaPrevisaoVazia(String previsao, String msg) {
		if (previsao.trim().isEmpty())
			throw new IllegalArgumentException(msg + "Previsao nao pode ser vazia ou nula");
	}

	/**
	 * Método que verifica se o apostador é uma string composta por espaços ou
	 * nula. Caso isso aconteça, lança uma exceção e interrompe a execução do
	 * programa.
	 * 
	 * @param apostador
	 *            Valor a ser válidado.
	 */
	public static void verificaApostadorVazio(String apostador, String msg) {
		if (apostador.trim().isEmpty())
			throw new IllegalArgumentException(msg + "Apostador nao pode ser vazio ou nulo");
	}

	/**
	 * Método que verifica se o valor é menor ou igual a zero. Lança uma
	 * execeção caso o valor seja zero e interrompe a execução do programa.
	 * 
	 * @param valor
	 *            Valor a ser válidado.
	 */
	public static void verificaValorZero(int valor, String msg) {
		if (valor <= 0)
			throw new IllegalArgumentException(msg + "Valor nao pode ser menor ou igual a zero");
	}

	/**
	 * Método que verifica se cenário escolhido está cadastrado, caso não esteja
	 * lança uma exceção e imterrompe a execução do programa.
	 * 
	 * @param estado
	 *            Estado do cenário escolhido.
	 * 
	 */
	public static void verificaCenarioAindaAberto(String estado, String msg) {
		if (estado == Status.NAO_FINALIZADO.getStatus())
			throw new NullPointerException(msg + "Cenario ainda esta aberto");
	}

	/**
	 * Método que verifica se cenário escolhido é válido, caso não seja lança
	 * uma exceção e imterrompe a execução do programa.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 */
	public static void verificaBonusInvalido(int bonus, String msg) {
		if (bonus <= 0)
			throw new NullPointerException(msg + "Bonus invalido");
	}
	
	/**
	 * Método que verifica se cenário escolhido é válido, caso não seja lança
	 * uma exceção e imterrompe a execução do programa.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 */
	public static void verificaApostaInvalida(int aposta, String msg) {
		if (aposta <= 0)
			throw new NullPointerException(msg + "Aposta invalida");
	}
	
	/**
	 * Método que verifica se cenário escolhido está cadastrado, caso não esteja
	 * lança uma exceção e imterrompe a execução do programa.
	 * 
	 * @param cenario
	 *            Cenário escolhido.
	 * 
	 */
	public static void verificaApostaNaoCadastrada(int aposta, int quant_apostas, String msg) {
		if (aposta - 1 >= quant_apostas)
			throw new NullPointerException(msg + "Aposta nao cadastrada");
	}
	
	/**
	 * Método que verifica se o apostador é uma string composta por espaços ou
	 * nula. Caso isso aconteça, lança uma exceção e interrompe a execução do
	 * programa.
	 * 
	 * @param apostador
	 *            Valor a ser válidado.
	 */
	public static void verificaApostaNaoSegura(Aposta aposta, String msg) {
		if (aposta.getClass() == Aposta.class)
			throw new IllegalArgumentException(msg + "Aposta nao assegura");
	}
	
}