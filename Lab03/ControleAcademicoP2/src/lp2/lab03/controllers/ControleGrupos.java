package lp2.lab03.controllers;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import java.util.HashSet;
import java.util.Set;

import lp2.lab03.entidades.Aluno;
import lp2.lab03.entidades.Grupo;

public class ControleGrupos {

	private Set<Grupo> conjuntoGrupos;
	private final String NL = System.lineSeparator();

	public ControleGrupos() {
		conjuntoGrupos = new HashSet<Grupo>();
	}

	public void adicionaGrupo(String nome) {

		Grupo grupo = new Grupo(nome);
		this.conjuntoGrupos.add(grupo);
	}

	public boolean alocarAlunoGrupo(Aluno aluno, String nome) {
		
		Grupo grupoRef = new Grupo(nome);

		for (Grupo grupo : conjuntoGrupos) {
			if (grupo.equals(grupoRef)) {
				grupo.adicionarAluno(aluno);
				return true;
			}
		}
		return false;

	}

	public String imprimeGrupo(String nome) {

		String grupoString = "";
		Grupo grupoRef = new Grupo(nome);
		
		for (Grupo grupo : conjuntoGrupos) {

			if (grupo.equals(grupoRef)) {
				if(grupo.toString().isEmpty())
					grupoString = "Grupo vazio!";
				else
					grupoString += "Alunos do grupo " + grupo.getNome() + ":" + NL + grupo.toString();
				break;
			}
		}

		return grupoString;
	}

	public boolean existeGrupo(String nome) {
		
		Grupo grupoRef = new Grupo(nome);
		
		for (Grupo grupo: conjuntoGrupos){
			if(grupo.equals(grupoRef))
				return true;
		}
		return false;
	}

}
