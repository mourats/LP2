package lp2.lab03.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab03.entidades.Aluno;

public class AlunoTest {

	private Aluno alunoBasico;

	@SuppressWarnings("unused")
	private Aluno alunoInvalido;

	@Before
	public void criaAluno() {
		alunoBasico = new Aluno("116210967", "Thiago Santos", "Ciência da Computação");
	}

	@Test
	public void testToString() {

		String msg = "116210967 - Thiago Santos - Ciência da Computação";
		assertEquals(alunoBasico.toString(), msg);
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em uma
	 * matricula nula.
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testMatriculaNull() {
		alunoInvalido = new Aluno(null, "Thiago Santos", "Ciência da Computação");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um nome
	 * nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testNomeNull() {
		alunoInvalido = new Aluno("116210967", null, "Ciência da Computação");
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em um curso
	 * nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCursoNull() {
		alunoInvalido = new Aluno("116210967", "Thiago Santos", null);
	}

	/**
	 * Método resposável por certicar o lançamento de uma exceção em uma matricula
	 * composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMatriculaVazio() {
		alunoInvalido = new Aluno("     ", "Thiago Santos", "Ciência da Computação");
	}
	
	/**
	 * Método resposável por certicar o lançamento de uma exceção em um nome
	 * composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNomeVazio() {
		alunoInvalido = new Aluno("116210967", "     ", "Ciência da Computação");
	}
	
	/**
	 * Método resposável por certicar o lançamento de uma exceção em um curso
	 * composto por espaços.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCursoVazio() {
		alunoInvalido = new Aluno("116210967", "Thiago Santos", "      ");
	}

}
