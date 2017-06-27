package lp2.lab03.testes;

/**
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab03.controllers.ControleAlunosQueRespondemQuestoes;
import lp2.lab03.entidades.Aluno;

public class ControleAlunosQueRespondemQuestoesTest {

	private final String NL = System.lineSeparator();

	private ControleAlunosQueRespondemQuestoes controleAlunosQueRespondemQuestoes;
	private Aluno alunoUm, alunoDois;

	@Before
	public void criaControleAlunosQueRespondemQuestoes() {
		controleAlunosQueRespondemQuestoes = new ControleAlunosQueRespondemQuestoes();

		alunoUm = new Aluno("250", "Gabriel Reyes", "Computação");
		alunoDois = new Aluno("200", "Angela Ziegler", "Medicina");

	}

	@Test
	public void testImprimirListaAlunos() {
		assertEquals(controleAlunosQueRespondemQuestoes.imprimirListaAlunos(), "Nenhuma resposta registrada!" + NL);
		controleAlunosQueRespondemQuestoes.cadastrarAlunos(alunoUm);
		assertEquals(controleAlunosQueRespondemQuestoes.imprimirListaAlunos(),
				"Alunos: " + NL + "1. " + alunoUm.toString() + NL);
		controleAlunosQueRespondemQuestoes.cadastrarAlunos(alunoDois);
		assertEquals(controleAlunosQueRespondemQuestoes.imprimirListaAlunos(),
				"Alunos: " + NL + "1. " + alunoUm.toString() + NL + "2. " + alunoDois.toString() + NL);

	}

}
