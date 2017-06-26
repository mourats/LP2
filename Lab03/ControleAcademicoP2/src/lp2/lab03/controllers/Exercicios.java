package lp2.lab03.controllers;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.ArrayList;

import lp2.lab03.entidades.Aluno;

public class Exercicios {
	
	private final String NL = System.lineSeparator();

	private ArrayList<Aluno> alunosQuestoes;

	public Exercicios() {
		alunosQuestoes = new ArrayList<Aluno>();
	}

	public void cadastrarAlunos(Aluno aluno) {
		alunosQuestoes.add(aluno);
	}

	public String imprimirListaAlunos() {
		
		if (alunosQuestoes.size() == 0)
			return "Nenhuma resposta registrada!" + NL;

		String retornoString = "Alunos: " + NL;
		for (int i = 0; i < alunosQuestoes.size(); i++) {
			retornoString += i+1 + ". " + alunosQuestoes.get(i).toString() + NL;
		}
		return retornoString;
	}
}
