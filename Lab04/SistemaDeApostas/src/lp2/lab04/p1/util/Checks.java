package lp2.lab04.p1.util;

/**
 * Classe responsável por encapsular os métodos relacionados com validações no
 * programa.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Checks {

	/**
	 * Método que verifica se o apostador é nulo. Lança uma execeção caso o
	 * apostador seja nulo e interrompe a execução do programa.
	 * 
	 * @param apostador
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaApostadorNulo(String apostador) {
		if (apostador.isEmpty()) {
			throw new NullPointerException("ERRO! Apostador nulo!");
		}
	}

	/**
	 * Método que verifica se a previsão é nula. Lança uma execeção caso a
	 * previsão seja nula e interrompe a execução do programa.
	 * 
	 * @param previsao
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaPrevisaoNula(String previsao) {
		if (previsao.isEmpty()) {
			throw new NullPointerException("ERRO! Previsão nula!");
		}
	}

	/**
	 * Método que verifica se o apostador é uma string composta por espaços.
	 * Lança uma execeção caso o apostador seja composto por espaços e
	 * interrompe a execução do programa.
	 * 
	 * @param apostador
	 *            Valor a ser válidado.
	 */
	public static void verificaApostadorVazio(String apostador) {
		if (apostador.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Apostador composto por espaços!");
		}
	}

	/**
	 * Método que verifica se o valor é igual a zero. Lança uma execeção caso o
	 * valor seja zero e interrompe a execução do programa.
	 * 
	 * @param valor
	 *            Valor a ser válidado.
	 */
	public static void verificaValorZero(int valor) {
		if (valor == 0) {
			throw new IllegalArgumentException("ERRO! Valor zero!");
		}
	}

	/**
	 * Método que verifica se a previsão é uma string composta por espaços.
	 * Lança uma execeção caso a previsão seja composto por espaços e interrompe
	 * a execução do programa.
	 * 
	 * @param previsao
	 *            Valor a ser válidado.
	 */
	public static void verificaPrevisaoVazia(String previsao) {
		if (previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Previsão composta por espaços!");
		}
	}

	/**
	 * Método que verifica se a descrição é uma string composta por espaços.
	 * Lança uma execeção caso a descrição seja composto por espaços e
	 * interrompe a execução do programa.
	 * 
	 * @param descricao
	 *            Valor a ser válidado.
	 */
	public static void verificaDescricaoVazia(String descricao) {
		if (descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Descrição composta por espaços!");
		}
	}

	/**
	 * Método que verifica se a descrição é nula. Lança uma execeção caso a
	 * descrição seja nula e interrompe a execução do programa.
	 * 
	 * @param descricao
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaDescricaoNula(String descricao) {
		if (descricao.isEmpty()) {
			throw new NullPointerException("ERRO! Descrição nula!");
		}
	}

}
