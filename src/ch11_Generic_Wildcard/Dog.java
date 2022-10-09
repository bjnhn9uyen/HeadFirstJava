package ch11_Generic_Wildcard;

public class Dog extends Animal {

	public void bark() {
		System.out.println("Woof!");
	}

	@Override
	public void eat() {
		System.out.println("I'm a dog. I like bones");
	}

}
