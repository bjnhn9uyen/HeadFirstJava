package ch07_Inheritance_Polymorphism_Overriding;

public class Dog extends Animal {

	@Override
	public void makeNoise() {
		System.out.println("Woof! Woof!");
	}

}
