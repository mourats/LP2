package lp2.lab03.execution;

/**
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Thiago Santos de Moura - 116210967
 */

public class Menu {
	
	private final String NL = System.lineSeparator();

	public String toString() {

		return "(C)adastrar Aluno" + NL + 
			   "(E)xibir Aluno" + NL + 
			   "(N)ovo Grupo" + NL + 
			   "(A)locar Aluno no Grupo e Imprimir Grupos" + NL + 
			   "(R)egistrar Resposta de Aluno" + NL +
			   "(I)mprimir Alunos que Responderam" + NL + 
			   "(O)ra, vamos fechar o programa!" + NL + NL +
			   "Opção> ";
	}
	
	public String toString2() {
		
		return "(A)locar Aluno ou (I)mprimir Grupo?";
	}
	
	public String matricula(){
		return "Matrícula: ";
	}
	
	public String nome(){
		return "Nome: ";
	}
	
	public String curso(){
		return "Curso: ";
	}
	
	public String grupo(){
		return "Grupo: ";
	}
	
}
