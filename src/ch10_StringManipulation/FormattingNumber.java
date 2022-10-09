package ch10_StringManipulation;

public class FormattingNumber {

	public static void main(String[] args) {

		String s1 = String.format("%,d", 1000000000);
		System.out.println(s1);

		String s2 = String.format("I have %.2f bugs to fix.", 476578.09876);
		System.out.println(s2);

		int one = 20456654;
		double two = 100567890.248907;
		String s3 = String.format("The rank is %,d out of %,.2f", one, two);
		System.out.println(s3);

	}

}
