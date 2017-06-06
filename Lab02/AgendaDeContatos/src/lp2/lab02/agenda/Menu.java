package lp2.lab02.agenda;

/**
 * Classe criada para organizar e melhorar a modificação da listagem do menu.
 * 
 * Laboratório de Programação 2 - Lab 02
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Menu {

	final String NL = System.lineSeparator();

	public String toString() {

		return "(C)adastrar Contato" + NL + "(L)istar Contatos" + NL +
				"(E)xibir Contato" + NL + "(S)air" + NL + NL + "Opção> ";

	}
}
