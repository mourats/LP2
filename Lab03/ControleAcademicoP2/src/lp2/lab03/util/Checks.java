package lp2.lab03.util;

/**
 * Classe responsável por encapsular os métodos relacionados com validações no programa.
 * 
 * Laboratório de Programação 2 - Lab 03
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Checks {

	/**
	 * Método que verifica se o nome é nulo. Lança uma execeção caso o nome seja
	 * nulo e interrompe a execução do programa.
	 * 
	 * @param nome
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaNomeNulo(String nome) {
		if (nome.isEmpty()) {
			throw new NullPointerException("ERRO! Nome nulo!");
		}
	}

	/**
	 * Método que verifica se a matrícula é nula. Lança uma execeção caso a
	 * matrícula seja nula e interrompe a execução do programa.
	 * 
	 * @param matricula
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaMatriculaNula(String matricula) {
		if (matricula.isEmpty()) {
			throw new NullPointerException("ERRO! Matrícula nula!");
		}
	}

	/**
	 * Método que verifica se o curso é nulo. Lança uma execeção caso o
	 * curso seja nulo e interrompe a execução do programa.
	 * 
	 * @param curso
	 *            Valor a ser válidado.
	 * 
	 * 
	 */
	public static void verificaCursoNulo(String curso) {
		if (curso.isEmpty()) {
			throw new NullPointerException("ERRO! Curso nulo!");
		}
	}

	/**
	 * Método que verifica se o nome é uma string composta por espaços. Lança
	 * uma execeção caso o nome seja composto por espaços e interrompe a
	 * execução do programa.
	 * 
	 * @param nome
	 *            Valor a ser válidado.
	 */
	public static void verificaNomeVazio(String nome) {
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Nome composto por espaços!");
		}
	}

	/**
	 * Método que verifica se a matrícula é uma string composta por espaços.
	 * Lança uma execeção caso a matrícula seja composta por espaços e
	 * interrompe a execução do programa.
	 * 
	 * @param matricula
	 *            Valor a ser válidado.
	 */
	public static void verificaMatriculaVazia(String matricula) {
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Matrícula composta por espaços!");
		}
	}

	/**
	 * Método que verifica se o curso é uma string composta por espaços.
	 * Lança uma execeção caso o curso seja composto por espaços e interrompe
	 * a execução do programa.
	 * 
	 * @param curso
	 *            Valor a ser válidado.
	 */
	public static void verificaCursoVazio(String curso) {
		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Curso composto por espaços!");
		}
	}

}
