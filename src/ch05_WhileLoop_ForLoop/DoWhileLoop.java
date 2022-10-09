package ch05_WhileLoop_ForLoop;

import java.util.Scanner;

class DoWhileLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int odd;
		do {
			System.out.print("enter any odd number: ");
			odd = scanner.nextInt();
		} while ((odd % 2) == 0);
		scanner.close();
	}

}
