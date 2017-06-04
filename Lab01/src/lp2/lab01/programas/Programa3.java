package lp2.lab01.programas;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Programa3 {

	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		float num1, num2, media;
		boolean guard;
		
		num1 = Float.parseFloat(sc.nextLine());
		num2 = Float.parseFloat(sc.nextLine());
		media = (num1+num2)/2;
		
		if (media >= 7.0){
			guard = true;
		}else{
			guard = false;
		}
		
		System.out.println("pass: " + guard + "!");
	}
}

