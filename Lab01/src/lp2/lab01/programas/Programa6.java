package lp2.lab01.programas;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Programa6 {

	private static Scanner sc;
 
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		String linha[] = sc.nextLine().split(" ");
		
		int[] valores = new int[linha.length];

		int soma = 0;
		float media;
		String linha_resultado = "";
		
		for (int i = 0; i < linha.length; i++) {
			valores[i] = Integer.parseInt(linha[i]);
			soma += valores[i];
		}
		
		
		media = soma/valores.length;
		
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] > media){
				linha_resultado += linha[i] + " ";
			}
		}
		
		System.out.println(linha_resultado);
		
	}
}
