package ch07_Overloading;

public class Calculator {

	void add(int a, int b) {
		System.out.println("a + b = " + (a + b));
	}

	// overloading lets us make multiple versions of a method with the same name but different argument lists
	// the return types can be different as long as the argument lists are different
	// overloading has nothing to do with inheritance and polymorphism
	int add(int a, int b, int c) {
		return a + b + c;
	}

}
