package ch13_ExceptionHandling;

public class ExceptionHandling {

	// the method that throws an exception has to declare that it might throw the exception
	void doRiskyThing() throws Exception {
		// if the random() method returns a value that is less than 5, you failed! And vice versa, you win!
		int randNum = (int) (Math.random() * 10);
		System.out.println(randNum);
		if (randNum < 5) {
			throw new Exception();
		}
	}

	public static void main(String[] args) {

		// put the risky thing in a ‘try’ block, and make a ‘catch’ block for what to do if
		// the exceptional situation happens (an Exception object is thrown by calling to doRiskyThing method)
		try {
			new ExceptionHandling().doRiskyThing();
			// if the call to doRiskyThing() throws an exception, the rest of the try block will not run
			System.out.println("win!");
			return;
		} catch (Exception e) {
			System.out.println("bad luck!");
			// if you can’t recover from the exception, at LEAST get a stack trace using the printStackTrace()
			e.printStackTrace(); // Exception is an object, what you catch is an object
			return;
		} finally {
			System.out.println("reset!");
			// A finally block is where you put code that must run regardless of an exception.
			// Without finally block, you have to put the reset code in both the try and the catch because,
			// You can put all your important cleanup code in one place instead of duplicating it. 
			// If the try or catch block has a return statement, the finally block will still run, 
			// and the flow jumps to the finally, then back to the return
		}

		// without return statements, this code will continue to run regardless of an exception
		// System.out.println("continue!");
	}

}
