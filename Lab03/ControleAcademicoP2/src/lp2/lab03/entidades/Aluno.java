package lp2.lab03.entidades;

import lp2.lab03.util.Checks;

public class Aluno {
	
	private String matricula;
	
	private String nome;
	
	private String curso;
	
	public Aluno(String matricula, String nome, String curso){
		
		Checks.verificaMatriculaNula(matricula);
		Checks.verificaMatriculaVazia(matricula);
		Checks.verificaNomeNulo(nome);
		Checks.verificaNomeVazio(nome);
		Checks.verificaCursoNulo(curso);
		Checks.verificaCursoVazio(curso);

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}

	// Implementar equals e hashcode
}
