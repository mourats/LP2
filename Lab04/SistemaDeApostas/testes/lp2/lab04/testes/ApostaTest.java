package lp2.lab04.testes;

/**
 * Classe responsável por realizar os testes na classe Aposta.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Test;

import lp2.lab04p1.entidades.Aposta;
import lp2.lab04p1.enums.Previsao;

public class ApostaTest {

	private Aposta apostaBasica;

	@Test
	public void testToString() {
		apostaBasica = new Aposta("Thiago", 15000, Previsao.VAI_ACONTECER);

		String msg = "Thiago - R$ 150,00 - VAI ACONTECER";
		assertEquals(apostaBasica.toString(), msg);
	}


}
