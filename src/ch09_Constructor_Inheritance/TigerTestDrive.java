package ch09_Constructor_Inheritance;

public class TigerTestDrive {

	public static void main(String[] args) {

		Tiger t1 = new Tiger(); // call super("Jiba")
		System.out.println("tiger1: " + t1.name + " " + t1.getSize());

		Tiger t2 = new Tiger(30); // call this(), including the call to super("Jiba")
		System.out.println("tiger2: " + t2.name + " " + t2.getSize());

	}

}
