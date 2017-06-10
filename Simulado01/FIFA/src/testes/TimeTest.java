package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.simulado1.Time;

public class TimeTest {

	private Time time;

	@Before
	public void criaTime() {
		time = new Time("Brasil");
		time.adicionaJogador("Romario", "123454545", 45.0);
		time.adicionaJogador("Carlos", "124454555", 25.0);
		time.adicionaJogador("Joao", "1278754454", 65.0);
		time.adicionaJogador("Pedrinho", "441245454", 15.0);
		time.adicionaJogador("José", "123456465", 75.0);
		time.adicionaJogador("Lucas", "14564654654", 55.0);
		time.adicionaJogador("Fernando", "17897984", 5.0);
		time.adicionaJogador("Ruan", "1231324546", 95.0);
		time.adicionaJogador("Matheus", "78799798", 105.0);
		time.adicionaJogador("Neymar", "879879745", 123.0);		
	}

	@Test
	public void testAdicionaJogador() {
		assertEquals(time.adicionaJogador("Vinicius", "12377878744", 145.0), true);
		assertEquals(time.adicionaJogador("Messi", "78979879845", 450.0), false);
	}

	@Test
	public void testListaJogador() {
		
		assertEquals(time.listaJogador("441245454"), "Pedrinho - 441245454 - 15.0");
		assertEquals(time.listaJogador("041245004"), "Jogador não encontrado!");
	}

	@Test
	public void testCalculaValor() {
	
		assertEquals(time.calculaValor() == 60.8, true);
		time.adicionaJogador("Vinicius", "12377878744", 343.5);
		assertEquals(time.calculaValor() == 86.5, true);
		
	}

	@Test
	public void testEqualsObject() {
		
		System.out.println(time.calculaValor());
		
		Time timeUm = new Time("França");
		timeUm.adicionaJogador("Bartolli", "1244444555", 608.0);
		
		assertEquals(time.equals(timeUm), false);

		
		Time timeDois = new Time("Argentina");
		
		timeDois.adicionaJogador("Maradona", "123454545", 450.0);
		timeDois.adicionaJogador("Carlinhos", "124454555", 50.0);
		timeDois.adicionaJogador("Joao", "1278754454", 108.0);
		timeDois.adicionaJogador("Mariano", "123454545", 450.0);
		timeDois.adicionaJogador("Augustos", "124454555", 50.0);
		timeDois.adicionaJogador("Joao", "1278754454", 108.0);
		
		assertEquals(time.equals(timeDois), false);
		
		
		Time timeTres = new Time("Brasil");
		timeTres.adicionaJogador("Romario", "123454545", 10.0);
		timeTres.adicionaJogador("Carlos", "124454555", 50.0);
		timeTres.adicionaJogador("Joao", "1278754454", 108.0);
		
		assertEquals(time.equals(timeTres), false);

		Time timeQuatro = new Time("Brasil");
		timeQuatro.adicionaJogador("Romario", "123454545", 10.2);
		timeQuatro.adicionaJogador("Carlos", "124454555", 50.0);
		timeQuatro.adicionaJogador("Joao", "1278754454", 103.0);
		timeQuatro.adicionaJogador("Thiago", "1278754454", 80.0);
		
		assertEquals(time.equals(timeQuatro), true);
		
	}

}
