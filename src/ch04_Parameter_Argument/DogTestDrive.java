package ch04_Parameter_Argument;

class DogTestDrive {

	public static void main(String[] args) {

		Dog one = new Dog();
		one.size = 70;
		Dog two = new Dog();
		two.size = 10;
		Dog three = new Dog();
		three.size = 40;

		// call bark method and pass it an argument
		one.bark(2);
		two.bark(3);
		three.bark(2);

		int x = 3;
		// if you pass a reference to an object into a method, you’re passing a copy of the remote control
		three.bark(x);
		System.out.println("value of x after the copy of it passed to the method: " + x);
		// the value of x doesn’t change after we changed the value of the argument (the copy of x)
		// inside the bark method in Dog class
	}

}
