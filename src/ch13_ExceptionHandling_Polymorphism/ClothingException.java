package ch13_ExceptionHandling_Polymorphism;

public class ClothingException extends Exception {

	private static final long serialVersionUID = 6461490911992013864L;

	public ClothingException() {
		super();
		System.out.println("This is ClothingException!");
	}

}

// besides all Exceptions classes in Java API, you can create your own Exceptions
// in this case, we create an inheritance tree of ClothingException to demonstrate polymorphism in Exceptions
// to create a user-defined exception class, the class has to extend the Exception class
