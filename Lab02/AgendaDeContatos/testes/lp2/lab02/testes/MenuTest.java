package lp2.lab02.testes;

/**
 * Classe teste responsável por realizar testes na classe Menu.
 * 
 * Laboratório de Programação 2 - Lab 02
 * @author Thiago Santos de Moura - 116210967
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lp2.lab02.agenda.Menu;

public class MenuTest {

	final String NL = System.lineSeparator();
	
	/**
	 * Método que testa a impressão correta do menu.
	 */
	@Test
	public void testToString() {
		Menu menu = new Menu();
		
		String msg = "(C)adastrar Contato"+ NL +"(L)istar Contatos"+ NL +
					 "(E)xibir Contato"+ NL +"(S)air"+ NL + NL +"Opção> ";
		
		assertEquals(menu.toString(), msg);
	}

}
