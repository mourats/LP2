package lp2.lab03.execution;

import java.util.Scanner;

import lp2.lab03.controllers.ControleSistema;

public class Main {

	private static Scanner sc;
	final static String NL = System.lineSeparator();

	public static void main(String[] args) {

		ControleSistema controleSistema = new ControleSistema();

		sc = new Scanner(System.in);
		Menu menu = new Menu();
		String op;

		do {
			System.out.println(menu.toString());
			op = sc.nextLine();

			switch (op) {
			case "C":
				cadastrarNovoAluno(controleSistema, menu);
				break;

			case "E":
				exibirAlunoSolicitado(controleSistema, menu);
				break;

			case "N":
				criarNovoGrupo(controleSistema, menu);
				break;

			case "A":
				System.out.println(menu.toString2());
				op = sc.nextLine();
				if (op.equals("A")) {
					alocarAlunoEmGrupo(controleSistema, menu);

				} else if (op.equals("I")) {
					imprimirGrupo(controleSistema, menu);

				} else {
					System.out.println("Opção inválida!" + NL);
				}
				break;

			case "R":
				registrarAlunoQueRespondeu(controleSistema);
				break;

			case "I":
				imprimirAlunosQueResponderam(controleSistema);
				break;

			case "O":
				break;

			default:
				System.out.println("Opção inválida!" + NL);
				break;
			}
		} while (!op.equals("O"));

		sc.close();

	}

	private static void imprimirAlunosQueResponderam(ControleSistema controleSistema) {
		System.out.println(controleSistema.imprimirAlunosQueRespondemQuestoes());
	}

	private static void registrarAlunoQueRespondeu(ControleSistema controleSistema) {
		String matricula;
		System.out.println("Matrícula: ");
		matricula = sc.nextLine();
		if (controleSistema.cadastrarAlunoQueRespondeQuestao(matricula))
			System.out.println("ALUNO REGISTRADO!" + NL);
		else
			System.out.println("Aluno não cadastrado." + NL);
	}

	private static void imprimirGrupo(ControleSistema controleSistema, Menu menu) {
		String grupo;
		System.out.println(menu.grupo());
		grupo = sc.nextLine();
		System.out.println(controleSistema.imprimirGrupo(grupo) + NL);
	}

	private static void alocarAlunoEmGrupo(ControleSistema controleSistema, Menu menu) {
		String matricula;
		String grupo;
		System.out.println(menu.matricula());
		matricula = sc.nextLine();
		System.out.println(menu.grupo());
		grupo = sc.nextLine();
		System.out.println(controleSistema.alocarAluno(matricula, grupo) + NL);
	}

	private static void criarNovoGrupo(ControleSistema controleSistema, Menu menu) {
		String grupo;
		System.out.println(menu.grupo());
		grupo = sc.nextLine();
		if (controleSistema.novoGrupo(grupo))
			System.out.println("CADASTRO REALIZADO!" + NL);
		else
			System.out.println("GRUPO JÁ CADASTRADA!" + NL);
	}

	private static void exibirAlunoSolicitado(ControleSistema controleSistema, Menu menu) {
		String matricula;
		System.out.println(menu.matricula());
		matricula = sc.nextLine();
		System.out.println(controleSistema.exibirAluno(matricula) + NL);
	}

	private static void cadastrarNovoAluno(ControleSistema controleSistema, Menu menu) {
		String matricula;
		String nome;
		String curso;
		System.out.println(menu.matricula());
		matricula = sc.nextLine();
		System.out.println(menu.nome());
		nome = sc.nextLine();
		System.out.println(menu.curso());
		curso = sc.nextLine();
		if (controleSistema.cadastrarAluno(matricula, nome, curso))
			System.out.println("CADASTRO REALIZADO!" + NL);
		else
			System.out.println("MATRÍCULA JÁ CADASTRADA!" + NL);
	}

}
