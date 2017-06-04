package lp2.lab01.programas;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Programa7{

	private static Scanner sc;

	public static void main(String[] args) {

		boolean guard = false;
		sc = new Scanner(System.in);

		while (true) {

			String linha[] = sc.nextLine().split(" ");

			if (linha[0].equals("wally")){
				break;
			}

			for (int i = linha.length-1; i >= 0; i--) {
				if(linha[i].length() == 5){
					System.out.println(linha[i]);
					guard = true;
					break;
				}
			}	

			if(!guard){
				System.out.println("?");
			}
			guard = false;
		}

	}
}
