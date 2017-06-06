package lp2.lab02.agenda;

/**
 * Classe responsável por encapsular os métodos relacionados com validações no programa.
 * 
 * Laboratório de Programação 2 - Lab 02
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
	 * Método que verifica se o sobrenome é nulo. Lança uma execeção caso o
	 * sobrenome seja nulo e interrompe a execução do programa.
	 * 
	 * @param sobrenome
	 *            Valor a ser válidado.
	 * 
	 */
	public static void verificaSobrenomeNulo(String sobrenome) {
		if (sobrenome.isEmpty()) {
			throw new NullPointerException("ERRO! Sobrenome nulo!");
		}
	}

	/**
	 * Método que verifica se o telefone é nulo. Lança uma execeção caso o
	 * telefone seja nulo e interrompe a execução do programa.
	 * 
	 * @param telefone
	 *            Valor a ser válidado.
	 * 
	 * 
	 */
	public static void verificaTelefoneNulo(String telefone) {
		if (telefone.isEmpty()) {
			throw new NullPointerException("ERRO! Telefone nulo!");
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
	 * Método que verifica se o sobrenome é uma string composta por espaços.
	 * Lança uma execeção caso o sobrenome seja composto por espaços e
	 * interrompe a execução do programa.
	 * 
	 * @param sobrenome
	 *            Valor a ser válidado.
	 */
	public static void verificaSobrenomeVazio(String sobrenome) {
		if (sobrenome.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Sobrenome composto por espaços!");
		}
	}

	/**
	 * Método que verifica se o telefone é uma string composta por espaços.
	 * Lança uma execeção caso o telefone seja composto por espaços e interrompe
	 * a execução do programa.
	 * 
	 * @param telefone
	 *            Valor a ser válidado.
	 */
	public static void verificaTelefoneVazio(String telefone) {
		if (telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("ERRO! Telefone composto por espaços!");
		}
	}

	/**
	 * Método que verifica se a posição fornecida pelo o usuário é válida.
	 * 
	 * @param posicao
	 *            Valor a ser válidado.
	 * @return Retorna true se a posição for um número entre 1 e 100. Retorna
	 *         false caso contrário.
	 */
	public static boolean verificaPosicaoInvalida(int posicao) {

		if (posicao <= 0 || posicao > 100) {
			return true;
		} else {
			return false;
		}
	}
}
