package ch13_ExceptionHandling_Polymorphism;

public class TeeShirtException extends ShirtException {

	private static final long serialVersionUID = 2232038764199859448L;

	public TeeShirtException() {
		super();
		System.out.println("This is TeeShirtException!");
	}

}
