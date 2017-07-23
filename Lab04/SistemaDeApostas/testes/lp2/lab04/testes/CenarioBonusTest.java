package lp2.lab04.testes;

/**
 * Classe responsável por realizar os testes na classe CenarioBonus.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.lab04p1.controllers.Cenario;
import lp2.lab04p1.controllers.CenarioBonus;

public class CenarioBonusTest {

	private Cenario cenarioBonus;

	/**
	 * Método responsável por criar um cenário para os testes.
	 */
	@Before
	public void criaCenarioBonus() {
		cenarioBonus = new CenarioBonus("Amanhã vou achar 50 conto!", 5500);
	}

	/**
	 * Método responsável por testar o toString do CenárioBonus, com sua
	 * modificação do bonus.
	 */
	@Test
	public void testToString() {
		String msg = "Amanhã vou achar 50 conto! - Nao finalizado - R$ 55,00";
		assertEquals(cenarioBonus.toString(), msg);
	}

	/**
	 * Método responsável por testar implementação do bonus valor total
	 * arrecadado.
	 */
	@Test
	public void testGetValorTotalArrecadadoPerdedoresModificado() {

		assertEquals(cenarioBonus.getValorTotalArrecadadoPerdedoresPadrao(), 0);
		assertEquals(cenarioBonus.getValorTotalArrecadadoPerdedoresModificado(), 5500);
	}

}
