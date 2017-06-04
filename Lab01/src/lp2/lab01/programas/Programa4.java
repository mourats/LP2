package lp2.lab01.programas;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Thiago Santos de Moura - 116210967
 */


public class Programa4 {

	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int[] valores = new int[4];
		
		boolean guard = false;

		for (int i=0; i<=3; i++){
			valores[i] = sc.nextInt();
			System.out.println(valores[i]);
		}

		if (valores[0] < valores[1]){
			if (valores[1] < valores[2]){
				if(valores[2]< valores[3]){
					System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
					guard = true;
				}
			}
		}
		if (valores[3] < valores[2]){
			if (valores[2] < valores[1]){
				if(valores[1] < valores[0]){
					System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
					guard = true;
				}
			}
		}
		if(!guard){
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
	}
}

