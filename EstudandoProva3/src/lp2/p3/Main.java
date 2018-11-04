package lp2.p3;

import java.util.Set;

public class Main {

	public static void main(String[] args) {


		LeiaCSV arquivo = new LeiaCSV();
		
		Set<Refeicao> cardapio = arquivo.lerArquivo();
		
		for(Refeicao refeicao: cardapio){
			System.out.println(refeicao);
		}
		
		arquivo.escreverArquivo("Suchi,14.56,1");
		
		System.out.println();
		
		for(Refeicao refeicao: cardapio){
			System.out.println(refeicao);
		}
		

	}

}
