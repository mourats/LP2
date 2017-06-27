package lp2.lab03.controllers;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

public class ControleSistema {

	private ControleAlunos controleAlunos;
	private ControleGrupos controleGrupos;
	private ControleAlunosQueRespondemQuestoes controleAlunosQueRespondemQuestoes;

	public ControleSistema() {
		controleAlunos = new ControleAlunos();
		controleGrupos = new ControleGrupos();
		controleAlunosQueRespondemQuestoes = new ControleAlunosQueRespondemQuestoes();

	}

	public boolean cadastrarAluno(String matricula, String nome, String curso) {

		if (controleAlunos.existeAluno(matricula))
			return false;

		controleAlunos.adicionaAluno(matricula, nome, curso);
		return true;
	}

	public String exibirAluno(String matricula) {

		if (controleAlunos.existeAluno(matricula))
			return "Aluno: " + controleAlunos.recuperaAluno(matricula).toString();
		else
			return "Aluno não cadastrado.";

	}

	public boolean novoGrupo(String nome) {

		if (controleGrupos.existeGrupo(nome))
			return false;

		controleGrupos.adicionaGrupo(nome);
		return true;
	}

	public String alocarAluno(String matricula, String grupo) {

		if (!controleAlunos.existeAluno(matricula))
			return "Aluno não cadastrado.";
		
		if (!controleGrupos.existeGrupo(grupo))
			return "Grupo não cadastrado.";

		controleGrupos.alocarAlunoGrupo(controleAlunos.recuperaAluno(matricula), grupo);
		return "ALUNO ALOCADO!";

	}

	public String imprimirGrupo(String nome) {
		
		if (!controleGrupos.existeGrupo(nome))
			return "Grupo não cadastrado.";
		
		return controleGrupos.imprimeGrupo(nome);
	}

	public boolean cadastrarAlunoQueRespondeQuestao(String matricula) {

		if (!controleAlunos.existeAluno(matricula))
			return false;

		controleAlunosQueRespondemQuestoes.cadastrarAlunos(controleAlunos.recuperaAluno(matricula));
		return true;
	}

	public String imprimirAlunosQueRespondemQuestoes() {
		return controleAlunosQueRespondemQuestoes.imprimirListaAlunos();
	}

}
