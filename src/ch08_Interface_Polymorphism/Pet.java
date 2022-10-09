package ch08_Interface_Polymorphism;

public interface Pet {

	// Abstract classes can’t be instantiated, and they can have instance variables for inheritance.
	// Interfaces can’t be instantiated too, but they don’t have any instance variables,
	// they can have constants declared IMPLICITLY with ‘public static final’.
	// The only way to access interface’s variables from outside is to make them ‘public static’.
	// The reason interface’s variables becoming ‘final’ is to prevent different implementations accidentally
	// changing the value of variables which could affect the behavior of the other implementations
	String TYPE = "Pet"; // constant's name should be in all caps - naming convention
	// public static final String TYPE = "Pet"; // declare explicitly

	// interface methods are implicitly public and abstract, typing in ‘public’ and ‘abstract’ is optional
	// in interfaces, methods with a body exist only for static methods and default methods
	public abstract void beFriendly();

	public abstract void play();

}

/**
 * What does an interface REALLY buy you? Allowing classes in different inheritance trees to implement a
 * common interface and use the interface as a polymorphic type. A class is allowed to extend only one
 * superclass, but it can implement multiple interfaces. That for classes, but with interfaces, an interface
 * can extend multiple interface.
 */