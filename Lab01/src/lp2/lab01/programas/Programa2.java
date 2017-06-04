package lp2.lab01.programas;

import java.util.Scanner;

public class Programa2 {
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("dobro: " + 2*num +", triplo: " + 3*num);


	}
}