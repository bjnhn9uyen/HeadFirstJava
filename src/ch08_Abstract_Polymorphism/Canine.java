package ch08_Abstract_Polymorphism;

public abstract class Canine extends Animal {

	@Override
	public void eat() {
		System.out.println("I eat meat");
	}

	@Override
	public void makeNoise() {
		System.out.println("Woof!");
	}

}
