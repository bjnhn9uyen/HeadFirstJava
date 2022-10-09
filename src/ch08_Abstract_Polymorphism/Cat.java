package ch08_Abstract_Polymorphism;

public class Cat extends Feline {

	@Override
	public void makeNoise() {
		System.out.println("Meow!");
	}

	public void climb() {
		System.out.println("I’m climbing");
	}

}
