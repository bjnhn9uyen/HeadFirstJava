package ch05_WhileLoop_ForLoop;

class UnaryOperator {

	public static void main(String[] args) {

		int x = 0;

		++x; // pre-increment operator
		System.out.println("++x = " + x);
		--x; // pre-decrement operator
		System.out.println("--x = " + x);

		x++; // post-increment operator
		System.out.println("x++ = " + x);
		x--; // post-decrement operator
		System.out.println("x-- = " + x);

		x = 0;
		int y = ++x; // first, increases x by 1, and then use this new value of x
		System.out.println("y = " + y);

		x = 0;
		y = x++; // y gets the value of x and then x is increased
		System.out.println("y = " + y);

	}

}
