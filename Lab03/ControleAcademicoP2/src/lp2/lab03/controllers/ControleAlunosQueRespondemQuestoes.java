package lp2.lab03.controllers;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.ArrayList;
import java.util.List;

import lp2.lab03.entidades.Aluno;

public class ControleAlunosQueRespondemQuestoes {
	
	private final String NL = System.lineSeparator();

	private List<Aluno> alunosQueRespondemQuestoes;

	public ControleAlunosQueRespondemQuestoes() {
		alunosQueRespondemQuestoes = new ArrayList<Aluno>();
	}

	public void cadastrarAlunos(Aluno aluno) {
		alunosQueRespondemQuestoes.add(aluno);
	}

	public String imprimirListaAlunos() {
		
		if (alunosQueRespondemQuestoes.size() == 0)
			return "Nenhuma resposta registrada!" + NL;

		String retornoString = "Alunos: " + NL;
		for (int i = 0; i < alunosQueRespondemQuestoes.size(); i++) {
			retornoString += i+1 + ". " + alunosQueRespondemQuestoes.get(i).toString() + NL;
		}
		return retornoString;
	}
}
