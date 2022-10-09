package ch13_ExceptionHandling_Polymorphism;

public class PantsException extends ClothingException {

	private static final long serialVersionUID = 590612400199840965L;

	public PantsException() {
		super();
		System.out.println("This is PantsException!");
	}

}
