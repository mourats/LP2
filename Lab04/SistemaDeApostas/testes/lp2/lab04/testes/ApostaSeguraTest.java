package lp2.lab04.testes;

/**
 * Classe responsável por realizar os testes na classe ApostaSegura.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab04p1.entidades.ApostaSegura;
import lp2.lab04p1.enums.Previsao;

public class ApostaSeguraTest {

	private ApostaSegura apostaSeguraUm;
	private ApostaSegura apostaSeguraDois;

	@Before
	public void criaApostaSeguraValor() {
		apostaSeguraUm = new ApostaSegura("Thiago", 15000, Previsao.VAI_ACONTECER, 1500);
	}

	@Before
	public void criaApostaSeguraTaxa() {
		apostaSeguraDois = new ApostaSegura("João", 12000, Previsao.NAO_VAI_ACONTECER, 0.1);
	}

	/**
	 * Método responsável por testar o método getValorSegurado, esperando o
	 * retorno correto do valor segurado da aposta.
	 */
	@Test
	public void testGetValorSegurado() {
		assertEquals(apostaSeguraUm.getValorSegurado(), 1500);
		assertEquals(apostaSeguraDois.getValorSegurado(), 1200);
	}

	/**
	 * Método responsável por testar a alteração de uma aposta segurada por
	 * valor para por taxa, verificando sua modificação no valor segurado.
	 */
	@Test
	public void testAlterarSeguroDouble() {
		assertEquals(apostaSeguraUm.getValorSegurado(), 1500);
		apostaSeguraUm.alterarSeguro(0.2);
		assertEquals(apostaSeguraUm.getValorSegurado(), 3000);
	}

	/**
	 * Método responsável por testar a alteração de uma aposta segurada por
	 * taxa para por valor, verificando sua modificação no valor segurado.
	 */
	@Test
	public void testAlterarSeguroInt() {
		assertEquals(apostaSeguraDois.getValorSegurado(), 1200);
		apostaSeguraDois.alterarSeguro(1000);
		assertEquals(apostaSeguraDois.getValorSegurado(), 1000);
	}

	@Test
	public void testToStringTaxa() {
		String msg = "João - R$ 120,00 - N VAI ACONTECER - ASSEGURADA (TAXA) - 10%";
		assertEquals(apostaSeguraDois.toString(), msg);
	}

	@Test
	public void testToStringValor() {
		String msg = "Thiago - R$ 150,00 - VAI ACONTECER - ASSEGURADA (VALOR) - R$ 15,00";
		assertEquals(apostaSeguraUm.toString(), msg);
	}

}
