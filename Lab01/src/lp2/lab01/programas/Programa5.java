package lp2.lab01.programas;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Thiago Santos de Moura - 116210967
 */


public class Programa5 {

	private static Scanner sc;

	
	public static void main(String[] args) {

		sc = new Scanner(System.in);

		String operacao = sc.nextLine();
		float num1, num2, resultado;
		
		
		if (operacao.equals("+")){
			num1 = Float.parseFloat(sc.nextLine());
			num2 = Float.parseFloat(sc.nextLine());
			resultado = num1+num2;
			System.out.println("RESULTADO: " + resultado);
		}else if (operacao.equals("-")){
			num1 = Float.parseFloat(sc.nextLine());
			num2 = Float.parseFloat(sc.nextLine());
			resultado = num1-num2;
			System.out.println("RESULTADO: " + resultado);
		}else if (operacao.equals("*")){
			num1 = Float.parseFloat(sc.nextLine());
			num2 = Float.parseFloat(sc.nextLine());
			resultado = num1*num2;
			System.out.println("RESULTADO: " +  resultado);
		}else if (operacao.equals("/")){
			num1 = Float.parseFloat(sc.nextLine());
			num2 = Float.parseFloat(sc.nextLine());
			if(num2 == 0.0){
				System.out.println("ERRO");
			}else{
				resultado = num1/num2;
				System.out.println("RESULTADO: " +  resultado);
			}
		}else{
			System.out.println("ENTRADA INVALIDA");
		}
	}
}
