package ch05_SwitchCase_TernaryOperator;

import java.util.Scanner;

class TernaryOperator {

	public static void main(String[] args) {

		int a, b, c, max;
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter a: ");
		a = scanner.nextInt();
		System.out.print("enter b: ");
		b = scanner.nextInt();
		System.out.print("enter c: ");
		c = scanner.nextInt();
		// use ternary operator to find the max value of three numbers
		max = (a > c) ? (a > b ? a : b) : (b > c ? b : c);
		System.out.println("max is : " + max);
		scanner.close();

	}

}
