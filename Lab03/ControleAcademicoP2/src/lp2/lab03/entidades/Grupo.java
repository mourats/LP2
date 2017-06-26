package lp2.lab03.entidades;

import java.util.HashSet;

import lp2.lab03.util.Checks;

public class Grupo {

	private final String NL = System.lineSeparator();

	private String nome;

	private HashSet<Aluno> alunosGrupo;

	public Grupo(String nome) {
		
		Checks.verificaNomeNulo(nome);
		Checks.verificaNomeVazio(nome);
		
		this.nome = nome;
		alunosGrupo = new HashSet<Aluno>();
	}

	public String getNome() {
		return nome;
	}

	public boolean adicionarAluno(Aluno aluno) {
		return alunosGrupo.add(aluno);
	}

	@Override
	public String toString() {
		String retornoString = "";
		for (Aluno aluno : alunosGrupo) {
			retornoString += "* " + aluno + NL;
		}
		return retornoString;

	}

}
