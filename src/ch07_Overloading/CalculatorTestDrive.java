package ch07_Overloading;

public class CalculatorTestDrive {

	public static void main(String[] args) {

		Calculator c = new Calculator();
		c.add(1, 2);
		int sum = c.add(1, 2, 3);
		System.out.println("a + b + c = " + sum);

	}

}
