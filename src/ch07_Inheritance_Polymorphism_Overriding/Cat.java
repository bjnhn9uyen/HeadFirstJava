package ch07_Inheritance_Polymorphism_Overriding;

public class Cat extends Animal {

	// subclass can add new instance variables and methods of its own
	private String breed;

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	// no declaring @Override explicitly, it still works, but declaring @Override makes codes more clear
	@Override
	public void makeNoise() {
		System.out.println("Meow!");
		System.out.print("Cat does Animal's makeNoise() version: ");
		super.makeNoise();
	}

	@Override
	public void eat() {
		System.out.println("I'm eating fish");
	}

	public void climb() {
		System.out.println("I'm climbing");
	}

}
