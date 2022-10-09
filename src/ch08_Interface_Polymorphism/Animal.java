package ch08_Interface_Polymorphism;

public abstract class Animal {

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public abstract void eat();

	public abstract void makeNoise();

	public void sleep() {
		System.out.println("I'm sleeping");
	}

}
