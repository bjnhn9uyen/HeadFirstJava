package ch05_WhileLoop_ForLoop;

class BreakStatement {

	public static void main(String[] args) {

		// use break statement to jump out of the loop
		System.out.print("display numbers (break at 6): ");
		for (int i = 1; i <= 10; ++i) {
			if (i == 6) {
				break;
			}
			System.out.print(i + " ");
		}

	}

}
