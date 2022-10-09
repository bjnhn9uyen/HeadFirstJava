package ch05_WhileLoop_ForLoop;

class WhileLoop {

	public static void main(String[] args) {

		int i = 0;
		int j = 10;

		// while loop is good when we don’t know how many times to loop
		// and just want to keep going while some condition is true
		// but if we know how many times to loop, using for loop is cleaner
		while (++i < --j)
			System.out.println("Midpoint is: " + i);
	}

}
