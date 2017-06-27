package lp2.lab03.testes;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab03.entidades.Aluno;
import lp2.lab03.controllers.ControleAlunos;

public class ControleAlunosTest {

	private ControleAlunos controleAlunos;
	private Aluno alunoUm, alunoDois, alunoTres;

	@Before
	public void criaControleAlunos() {
		controleAlunos = new ControleAlunos();

		alunoUm = new Aluno("250", "Gabriel Reyes", "Computação");
		alunoDois = new Aluno("200", "Angela Ziegler", "Medicina");
		alunoTres = new Aluno("116", "Thiago Santos", "Computação");

	}

	@Test
	public void testAdicionaAluno() {

		assertEquals(controleAlunos.existeAluno(alunoUm.getMatricula()), false);
		controleAlunos.adicionaAluno(alunoUm.getMatricula(), alunoUm.getNome(), alunoUm.getCurso());
		assertEquals(controleAlunos.existeAluno(alunoUm.getMatricula()), true);

		assertEquals(controleAlunos.existeAluno(alunoDois.getMatricula()), false);
		controleAlunos.adicionaAluno(alunoDois.getMatricula(), alunoDois.getNome(), alunoDois.getCurso());
		assertEquals(controleAlunos.existeAluno(alunoDois.getMatricula()), true);

		assertEquals(controleAlunos.existeAluno(alunoTres.getMatricula()), false);
		controleAlunos.adicionaAluno(alunoTres.getMatricula(), alunoTres.getNome(), alunoTres.getCurso());
		assertEquals(controleAlunos.existeAluno(alunoTres.getMatricula()), true);

	}

	@Test
	public void testRecuperaAluno() {
		controleAlunos.adicionaAluno(alunoUm.getMatricula(), alunoUm.getNome(), alunoUm.getCurso());
		controleAlunos.adicionaAluno(alunoDois.getMatricula(), alunoDois.getNome(), alunoDois.getCurso());
		controleAlunos.adicionaAluno(alunoTres.getMatricula(), alunoTres.getNome(), alunoTres.getCurso());

		assertEquals(controleAlunos.recuperaAluno(alunoUm.getMatricula()), alunoUm);
		assertEquals(controleAlunos.recuperaAluno(alunoDois.getMatricula()), alunoDois);
		assertEquals(controleAlunos.recuperaAluno(alunoTres.getMatricula()), alunoTres);

	}

}
