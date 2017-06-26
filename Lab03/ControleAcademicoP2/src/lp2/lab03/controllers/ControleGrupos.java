package lp2.lab03.controllers;

import java.util.HashSet;

import lp2.lab03.entidades.Aluno;
import lp2.lab03.entidades.Grupo;

public class ControleGrupos {

	private HashSet<Grupo> conjuntoGrupos;

	public ControleGrupos() {
		conjuntoGrupos = new HashSet<Grupo>();
	}

	public void adicionaGrupo(String nome) {

		Grupo grupo = new Grupo(nome);
		this.conjuntoGrupos.add(grupo);
	}

	public boolean alocarAlunoGrupo(Aluno aluno, String nome) {

		for (Grupo grupo : conjuntoGrupos) {
			if (this.sameName(nome, grupo.getNome())) {
				grupo.adicionarAluno(aluno);
				return true;
			}
		}
		return false;

	}

	public String imprimeGrupo(String nome) {

		String grupoString = "";
		for (Grupo grupo : conjuntoGrupos) {
			if (this.sameName(nome, grupo.getNome()))
				grupoString = grupo.toString();
			break;
		}
		if (grupoString.isEmpty())
			return "Grupo vazio!";

		return grupoString;
	}

	public boolean existeGrupo(String nome) {

		for (Grupo grupo : conjuntoGrupos) {
			if (this.sameName(nome, grupo.getNome()))
				return true;
		}
		return false;

	}

	private boolean sameName(String nome1, String nome2) {

		if (nome1.equalsIgnoreCase(nome2))
			return true;
		else
			return false;
	}

}
