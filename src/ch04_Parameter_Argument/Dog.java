package ch04_Parameter_Argument;

class Dog {

	int size;

	// method uses parameters (in this case, numOfBarks), parameters are nothing more than local variables
	// when we invoke this method, we pass arguments (values) to the corresponding parameters
	void bark(int numOfBarks) {

		while (numOfBarks > 0) {
			if (size > 60) {
				System.out.println("Wooof!");
			} else if (size > 20) {
				System.out.println("Ruff!");
			} else {
				System.out.println("Yip!");
			}
			numOfBarks = numOfBarks - 1;
		}

		// change the value of 'numOfBarks' (for testing value of x in DogTestDrive class)
		numOfBarks = 5;
	}
}
