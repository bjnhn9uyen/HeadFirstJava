package ch11_Generic_Wildcard;

public class Cat extends Animal {

	public void meow() {
		System.out.print("Meow!");
	}

	@Override
	public void eat() {
		System.out.println("I'm a cat. I love fish");
	}

}
