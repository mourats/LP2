package lp2.lab02.agenda;

/**
 * Classe responsável pela interface com a usuário.
 * 
 * Laboratório de Programação 2 - Lab 02
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.Scanner;

public class Main {

	private static Scanner sc;
	final static String NL = System.lineSeparator();

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		Menu menu = new Menu();
		Agenda agenda = new Agenda();
		String op;

		do {
			System.out.println(menu.toString());
			op = sc.nextLine();

			switch (op) {
			case "C":

				int posicao = leituraPosicaoContato();
				if (Checks.verificaPosicaoInvalida(posicao)) {
					System.out.println("POSIÇÃO INVÁLIDA!" + NL);
					break;
				}

				String nome = lerNome();
				String sobrenome = lerSobrenome();
				String telefone = lerTelefone();
				cadastraContato(agenda, posicao, nome, sobrenome, telefone);
				break;

			case "L":

				System.out.println(agenda.listarContatos());
				break;

			case "E":

				int contato = leituraPosicaoContato();
				System.out.println(agenda.exibirContato(contato));
				break;

			case "S":
				break;

			default:
				posicaoInvalida(menu);
				break;
			}
		} while (!op.equals("S"));

		sc.close();

	}

	/**
	 * Método que solicita o cadastro de um novo contato atráves do objeto
	 * "agenda".
	 * 
	 * @param agenda
	 *            Objeto de agenda contendo seus atributos e métodos.
	 * @param posicao
	 *            Posição escolhida para ser cadastrada o novo contato.
	 * @param nome
	 *            Nome do contato.
	 * @param sobrenome
	 *            Sobrenome do contato.
	 * @param telefone
	 *            Telefone do contato.
	 */
	private static void cadastraContato(Agenda agenda, int posicao, String nome, String sobrenome, String telefone) {

		agenda.cadastrarContato(posicao, nome, sobrenome, telefone);
		System.out.println("CADASTRO REALIZADO!" + NL);
	}

	/**
	 * Método que faz a leitura do telefone.
	 * 
	 * @return Retorna o telefone lido.
	 */
	private static String lerTelefone() {
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		return telefone;
	}

	/**
	 * Método que faz a leitura do sobrenome.
	 * 
	 * @return Retorna o sobrenome lido.
	 */
	private static String lerSobrenome() {
		System.out.print("Sobrenome: ");
		String sobrenome = sc.nextLine();
		return sobrenome;
	}

	/**
	 * Métedo que faz a leitura do nome.
	 * 
	 * @return Retorna o nome lido.
	 */
	private static String lerNome() {
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		return nome;
	}

	/**
	 * Método que é chamado quando o usuário digita uma opção que não existe no
	 * menu apresentado, enviando uma mensagem e reapresentando o menu.
	 * 
	 * @param menu Objeto do Menu.
	 */
	private static void posicaoInvalida(Menu menu) {
		System.out.println("OPÇÃO INVÁLIDA!" + NL);
		menu.toString();
	}

	/**
	 * Método responsável pela leitura da posição do contato.
	 * 
	 * @return Retorna a posição lida.
	 */
	private static int leituraPosicaoContato() {

		System.out.println("Posição: ");
		int posicao = Integer.parseInt(sc.nextLine());
		return posicao;
	}
}
