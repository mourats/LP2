package lp2.lab03.testes;

/**
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab03.controllers.ControleSistema;
import lp2.lab03.entidades.Aluno;

public class ControleSistemaTest {

	private final String NL = System.lineSeparator();
	
	private ControleSistema controleSistema;
	private Aluno alunoUm, alunoDois;

	@Before
	public void criaControleSistema() {
		controleSistema = new ControleSistema();
		alunoUm = new Aluno("116210967", "Thiago Santos", "Ciência da Computação");
		alunoDois = new Aluno("444545454", "Márcio Santos", "Mecânica");

	}

	@Test
	public void testCadastrarAluno() {

		assertEquals(controleSistema.cadastrarAluno("116210967", "Thiago Santos", "Ciência da Computação"), true);
		assertEquals(controleSistema.cadastrarAluno("200458413", "Angela Ziegler", "Medicina"), true);

		assertEquals(controleSistema.cadastrarAluno("116210967", "Márcio Santos", "Mecânica"), false);
		assertEquals(controleSistema.cadastrarAluno("200458413", "José Pereira", "Administração"), false);

	}

	@Test
	public void testExibirAluno() {

		assertEquals(controleSistema.exibirAluno("116210967"), "Aluno não cadastrado.");
		assertEquals(controleSistema.cadastrarAluno("116210967", "Thiago Santos", "Ciência da Computação"), true);
		assertEquals(controleSistema.exibirAluno("116210967"), "Aluno: " + alunoUm.toString());

		assertEquals(controleSistema.exibirAluno("444545454"), "Aluno não cadastrado.");
		assertEquals(controleSistema.cadastrarAluno("444545454", "Márcio Santos", "Mecânica"), true);
		assertEquals(controleSistema.exibirAluno("444545454"), "Aluno: " + alunoDois.toString());
	}

	@Test
	public void testNovoGrupo() {

		assertEquals(controleSistema.novoGrupo("Mapas"), true);
		assertEquals(controleSistema.novoGrupo("Mapas"), false);
	}

	@Test
	public void testAlocarAluno() {

		assertEquals(controleSistema.alocarAluno("116210967", "Mapas"), "Aluno não cadastrado.");
		controleSistema.cadastrarAluno("116210967", "Thiago Santos", "Ciência da Computação");

		assertEquals(controleSistema.alocarAluno("116210967", "Mapas"), "Grupo não cadastrado.");
		controleSistema.novoGrupo("Mapas");

		assertEquals(controleSistema.alocarAluno("116210967", "Mapas"), "ALUNO ALOCADO!");

	}

	@Test
	public void testImprimirGrupo() {

		assertEquals(controleSistema.imprimirGrupo("Mapas"), "Grupo não cadastrado.");
		controleSistema.novoGrupo("Mapas");
		assertEquals(controleSistema.imprimirGrupo("Mapas"), "Grupo vazio!");

		controleSistema.cadastrarAluno("116210967", "Thiago Santos", "Ciência da Computação");
		controleSistema.alocarAluno("116210967", "Mapas");

		assertEquals(controleSistema.imprimirGrupo("Mapas"),
				"Alunos do grupo Mapas:" + NL + "* " + alunoUm.toString() + NL);

	}

	@Test
	public void testCadastrarAlunoQueRespondeQuestao() {
		
		assertEquals(controleSistema.cadastrarAlunoQueRespondeQuestao("116210967"), false);
		controleSistema.cadastrarAluno("116210967", "Thiago Santos", "Ciência da Computação");
		assertEquals(controleSistema.cadastrarAlunoQueRespondeQuestao("116210967"), true);
	}
}
