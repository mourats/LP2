package lp2.lab03.testes;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab03.controllers.ControleGrupos;
import lp2.lab03.entidades.Aluno;
import lp2.lab03.entidades.Grupo;

public class ControleGruposTest {

	private final String NL = System.lineSeparator();

	private ControleGrupos controleGrupos;
	private Grupo grupoUm, grupoDois;
	private Aluno alunoUm, alunoDois;

	@Before
	public void criaControleGrupos() {
		controleGrupos = new ControleGrupos();
		grupoUm = new Grupo("Coleções");
		grupoDois = new Grupo("Mapas");

		alunoUm = new Aluno("250", "Gabriel Reyes", "Computação");
		alunoDois = new Aluno("200", "Angela Ziegler", "Medicina");
	}

	@Test
	public void testAdicionaGrupo() {

		assertEquals(controleGrupos.existeGrupo(grupoUm.getNome()), false);
		controleGrupos.adicionaGrupo(grupoUm.getNome());
		assertEquals(controleGrupos.existeGrupo(grupoUm.getNome()), true);

		assertEquals(controleGrupos.existeGrupo(grupoDois.getNome()), false);
		controleGrupos.adicionaGrupo(grupoDois.getNome());
		assertEquals(controleGrupos.existeGrupo(grupoDois.getNome()), true);

	}

	@Test
	public void testExisteGrupo() {
		controleGrupos.adicionaGrupo(grupoUm.getNome());
		controleGrupos.adicionaGrupo(grupoDois.getNome());

		assertEquals(controleGrupos.existeGrupo(grupoUm.getNome().toUpperCase()), true);
		assertEquals(controleGrupos.existeGrupo(grupoDois.getNome().toUpperCase()), true);
	}

	@Test
	public void testAlocarAlunoGrupo() {

		controleGrupos.adicionaGrupo(grupoUm.getNome());
		controleGrupos.adicionaGrupo(grupoDois.getNome());

		assertEquals(controleGrupos.imprimeGrupo(grupoUm.getNome()), "Grupo vazio!");
		controleGrupos.alocarAlunoGrupo(alunoUm, grupoUm.getNome());
		assertEquals(controleGrupos.imprimeGrupo(grupoUm.getNome()),
				"Alunos do grupo " + grupoUm.getNome() + ":" + NL + "* " + alunoUm.toString() + NL);

		assertEquals(controleGrupos.imprimeGrupo(grupoDois.getNome()), "Grupo vazio!");
		controleGrupos.alocarAlunoGrupo(alunoDois, grupoDois.getNome());
		assertEquals(controleGrupos.imprimeGrupo(grupoDois.getNome()),
				"Alunos do grupo " + grupoDois.getNome() + ":" + NL + "* " + alunoDois.toString() + NL);
	}

}
