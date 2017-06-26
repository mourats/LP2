package lp2.lab03.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab03.controllers.ControleSistema;

public class ControleSistemaTest {

	private ControleSistema controleSistema;

	@Before
	public void criaControleSistema() {
		controleSistema = new ControleSistema();
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
		fail("Not yet implemented");
	}

	@Test
	public void testNovoGrupo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlocarAluno() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirGrupo() {
		fail("Not yet implemented");
	}

	@Test
	public void testCadastrarAlunoQueRespondeQuestao() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirAlunosQueRespondemQuestoes() {
		fail("Not yet implemented");
	}

}
