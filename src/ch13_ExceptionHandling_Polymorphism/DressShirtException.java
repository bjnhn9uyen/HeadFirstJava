package ch13_ExceptionHandling_Polymorphism;

public class DressShirtException extends ShirtException {

	private static final long serialVersionUID = 895273296054008414L;

	public DressShirtException() {
		super();
		System.out.println("This is DressShirtException!");
	}

}
