package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import lp2.simulado1.Jogador;

public class JogadorTest {

	@Test
	public void testJogador() {
		Jogador jogador = new Jogador("Thiago", "11243569874", 12.0);
		
		assertEquals(jogador.getNome(), "Thiago");
		assertEquals(jogador.getCpf(), "11243569874");
		assertEquals(jogador.getSalario() == 12.0, true);
		
	}

	@Test
	public void testEqualsObject() {
		Jogador jogadorUm = new Jogador("Thiago", "11243569874", 12.0);
		Jogador jogadorDois = new Jogador("João", "54778879874", 10.0);
		Jogador jogadorTres = new Jogador("Carlos", "11243569874", 7.0);
		
		assertEquals(jogadorUm.equals(jogadorDois), false);
		assertEquals(jogadorUm.equals(jogadorTres), true);
		assertEquals(jogadorDois.equals(jogadorTres), false);
	}

	@Test
	public void testToString() {
		Jogador jogadorBasico = new Jogador("Thiago", "11243569874", 12.0);
		
		assertEquals(jogadorBasico.toString(), "Thiago - 11243569874 - 12.0");
	}

}
