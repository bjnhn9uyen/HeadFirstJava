package ch09_Constructor_Inheritance;

public class Tiger extends Animal {

	private int size;

	// constructor runs before the object can be assigned to a reference
	// the best place to put initialization code is in the constructor
	// if the superclass constructor has arguments, you can pass arguments into the super() call
	public Tiger() {
		super("Jiba"); // explicitly call superclass constructor (must be first statement in the constructor)
		this.size = 25; // default size
	}

	// this() (no-arg) calls the overloaded constructor with no-arg (in this case, Tiger()) in the same class
	// you can say this() or super() only within a constructor
	// every constructor can have a call to super() or this() but NEVER both
	public Tiger(int size) {
		this();
		if (size > 0) {
			this.size = size;
		} else {
			this.size = 25;
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if (size > 0) {
			this.size = size;
		} else {
			this.size = 25;
		}
	}

}

/**
 * The keyword ‘this’ used with the dot operator in a method or constructor is to avoid conflicting name
 * between instance variables and local variables (or arguments). You can also use ‘this.’ to call a method of
 * the current class. You use ‘this.’ to refer to a method or an instance variable of the CURRENT class, and
 * you use ‘super.’ to refer to a method or an instance variable of the SUPPER class. This helps the JVM knows
 * whose method/instance variable to call.
 */
