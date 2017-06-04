package lp2.lab01.programas;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Programa8 {

	private static Scanner sc;
	
	public static void main(String[] args) {


		sc = new Scanner(System.in);

		
		int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
		int media, acima = 0, abaixo = 0, quant = 0, total= 0;
		
		ArrayList<Integer> valores = new ArrayList<Integer>();
		
		while (true) {

			String linha[] = sc.nextLine().split(" ");

			if (linha[0].equals("-")){
				break;
			}

			valores.add(Integer.parseInt(linha[1]));
			total += valores.get(quant);

			if(valores.get(quant) > maior){
				maior  = valores.get(quant);
			}
			if(valores.get(quant) < menor){
				menor  = valores.get(quant);
			}
			quant++;
		}

		media = total/valores.size();

		for (int i = 0; i < valores.size(); i++) {
			if (valores.get(i) >= 700){
				acima++;
			}else{
				abaixo++;
			}	
		}
		
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);
		
	}
}

