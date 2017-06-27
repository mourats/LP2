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
import lp2.lab03.entidades.Grupo;

public class GrupoTest {

	@SuppressWarnings("unused")
	private Grupo grupoInvalido;
	
	private Grupo grupoBasico, grupoBasicoDois;
	
	private Aluno alunoUm, alunoDois, alunoTres;

	@Before
	public void criaGrupo() {
		grupoBasico = new Grupo("LP2");
		grupoBasicoDois = new Grupo("lp2");

		alunoUm = new Aluno("250", "Gabriel Reyes", "Computação");
		alunoDois = new Aluno("200", "Angela Ziegler", "Medicina");
		alunoTres = new Aluno("116", "Thiago Santos", "Computação");
	}

	@Test
	public void testAdicionarAluno() {

		assertEquals(grupoBasico.pertenceGrupo(alunoUm), false);
		grupoBasico.adicionarAluno(alunoUm);
		assertEquals(grupoBasico.pertenceGrupo(alunoUm), true);

		assertEquals(grupoBasico.pertenceGrupo(alunoDois), false);
		grupoBasico.adicionarAluno(alunoDois);
		assertEquals(grupoBasico.pertenceGrupo(alunoDois), true);

		assertEquals(grupoBasico.pertenceGrupo(alunoTres), false);
		grupoBasico.adicionarAluno(alunoTres);
		assertEquals(grupoBasico.pertenceGrupo(alunoTres), true);
		
		assertEquals(grupoBasico.equals(grupoBasicoDois), true);

	}
	
	@Test
	public void testEquals(){
		
		assertEquals(grupoBasico.equals(grupoBasicoDois), true);
		grupoBasico = new Grupo("Lista");
		assertEquals(grupoBasico.equals(grupoBasicoDois), false);
	}

	@Test
	public void testToString() {
		
		assertEquals(grupoBasico.toString(), "");
		
		grupoBasico.adicionarAluno(alunoUm);
		grupoBasico.adicionarAluno(alunoDois);
		grupoBasico.adicionarAluno(alunoTres);

		assertEquals(grupoBasico.toString().length() > 0, true);
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um nome
	 * nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testNomeNull() {
		grupoInvalido = new Grupo(null);
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um nome
	 * composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMatriculaVazio() {
		grupoInvalido = new Grupo("     ");
	}

}
