package ch08_Interface_Polymorphism;

public class Cat extends Feline implements Pet {

	@Override
	public void makeNoise() {
		System.out.println("Meow!");
	}

	@Override
	public void beFriendly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

}
