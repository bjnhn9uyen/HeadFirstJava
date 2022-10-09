package ch13_ExceptionHandling_Polymorphism;

public class ShirtException extends ClothingException {

	private static final long serialVersionUID = 8095770997219300750L;

	public ShirtException() {
		super();
		System.out.println("This is ShirtException!");
	}

}
