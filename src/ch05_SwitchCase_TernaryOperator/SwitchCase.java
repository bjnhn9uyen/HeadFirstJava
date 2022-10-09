package ch05_SwitchCase_TernaryOperator;

import java.util.Scanner;

class SwitchCase {

	public static void main(String[] args) {
		System.out.println("summation/subtraction/multiplication/division of two numbers");
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter first number: ");
		int a = scanner.nextInt();
		System.out.print("enter second number: ");
		int b = scanner.nextInt();
		System.out.println("press 1: summation ");
		System.out.println("press 2: subtraction ");
		System.out.println("press 3: multiplication ");
		System.out.println("press 4: division ");
		System.out.print("your choice is : ");
		int operator = scanner.nextInt();
		switch (operator) {
		case 1:
			System.out.println(a + " + " + b + " = " + (a + b));
			break;
		case 2:
			System.out.println(a + " - " + b + " = " + (a - b));
			break;
		case 3:
			System.out.println(a + " * " + b + " = " + (a * b));
			break;
		case 4:
			System.out.println(a + " / " + b + " = " + ((float) a / b));
			break;
		default:
			System.out.println("the key just pressed is not valid");
		}
		scanner.close();
	}

}
