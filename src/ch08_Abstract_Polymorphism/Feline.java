package ch08_Abstract_Polymorphism;

public abstract class Feline extends Animal {

	@Override
	public void eat() {
		System.out.println("I eat meat and fish");
	}

	@Override
	public void makeNoise() {
		System.out.println("Roar!");
	}

}
