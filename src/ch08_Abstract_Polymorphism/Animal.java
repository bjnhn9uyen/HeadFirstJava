package ch08_Abstract_Polymorphism;

// By marking the Animal class as abstract, the compiler will stop any code, anywhere, from ever creating an
// instance of Animal because it does not make sense. What does particularly an Animal object look like?
public abstract class Animal {

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// if you declare an abstract method, you MUST mark the class abstract as well
	public abstract void eat();

	public abstract void makeNoise();

	// we can mix both abstract and non-abstract methods in the abstract class (for inheritance)
	public void sleep() {
		System.out.println("I'm sleeping");
	}

}

/**
 * What’s the point of using an abstract class? The point is, you don’t have to worry about somebody making
 * objects of the abstract class, for that purpose, the FIRST concrete classes in the inheritance tree MUST
 * implement ALL abstract methods. That way, you can still have inheritance (just like regular superclass) and
 * polymorphism. You can still use that abstract type as a reference type, use it as a polymorphic argument or
 * return type, or to make a polymorphic array/ArrayList.
 */