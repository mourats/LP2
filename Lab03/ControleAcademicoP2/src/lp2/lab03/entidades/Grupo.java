package lp2.lab03.entidades;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.HashSet;
import java.util.Set;

import lp2.lab03.util.Checks;

public class Grupo {

	private final String NL = System.lineSeparator();

	private String nome;

	private Set<Aluno> alunosGrupo;

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

	public boolean pertenceGrupo(Aluno aluno) {
		return alunosGrupo.contains(aluno);
	}

	@Override
	public String toString() {
		String retornoString = "";
		for (Aluno aluno : alunosGrupo) {
			retornoString += "* " + aluno + NL;
		}
		return retornoString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo ref = (Grupo) obj;

		if (ref.getNome().equalsIgnoreCase(this.nome))
			return true;

		return false;
	}

}
