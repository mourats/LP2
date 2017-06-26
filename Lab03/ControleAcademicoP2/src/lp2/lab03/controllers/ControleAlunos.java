package lp2.lab03.controllers;

import java.util.HashMap;

import lp2.lab03.entidades.Aluno;

public class ControleAlunos {

	private HashMap<String, Aluno> mapaMatriculaAlunos;

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
