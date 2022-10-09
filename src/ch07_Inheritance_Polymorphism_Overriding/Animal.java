package ch07_Inheritance_Polymorphism_Overriding;

public class Animal {

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void eat() {
		System.out.println("I eating meat");
	}

	public final void sleep() {
		System.out.println("I'm sleeping");
	}

	public void makeNoise() {
		System.out.println("Roar!");
	}

}