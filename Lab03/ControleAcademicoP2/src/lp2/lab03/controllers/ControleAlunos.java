package lp2.lab03.controllers;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.HashMap;
import java.util.Map;

import lp2.lab03.entidades.Aluno;

public class ControleAlunos {

	private Map<String, Aluno> mapaMatriculaAlunos;

	public ControleAlunos() {
		mapaMatriculaAlunos = new HashMap<>();
	}

	public void adicionaAluno(String matricula, String nome, String curso) {
		
		Aluno aluno = new Aluno(matricula, nome, curso);
		mapaMatriculaAlunos.put(matricula, aluno);

	}

	public boolean existeAluno(String matricula) {
		return this.mapaMatriculaAlunos.containsKey(matricula);
	}


	public Aluno recuperaAluno(String matricula) {
		return this.mapaMatriculaAlunos.get(matricula);
	}
}
