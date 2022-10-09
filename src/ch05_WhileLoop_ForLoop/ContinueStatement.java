package ch05_WhileLoop_ForLoop;

class ContinueStatement {

	public static void main(String[] args) {

		// use continue statement to break one iteration of the loop if a specified condition occurs
		// and continues with the next iteration of the loop
		System.out.println("display numbers from 0 to 10 (skip 6): ");
		for (int i = 1; i <= 10; ++i) {
			if (i == 6) {
				continue;
			}
			System.out.print(i + " ");
		}

	}

}
