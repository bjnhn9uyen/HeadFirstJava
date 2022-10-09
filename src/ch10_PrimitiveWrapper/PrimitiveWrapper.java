package ch10_PrimitiveWrapper;

import java.util.ArrayList;

public class PrimitiveWrapper {

	public static void main(String[] args) {

		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>(); // ArrayList holds only objects

		int num1 = 3;
		listOfNumbers.add(num1); // wrap 'int' type into Integer type, then add to the list (auto-boxing)
		int num2 = listOfNumbers.get(0); // unwrap Integer type to int type (auto-boxing)
		System.out.println("num2: " + num2);

		// converting a String to a primitive value using parse methods
		int x = Integer.parseInt("2"); // it works only if the String represents a digit (“0”,”1”,”2.1”, etc.)
		int y = Integer.valueOf("2"); // same as parse method
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		double d = Double.parseDouble("420.24");
		System.out.println("d: " + d);
		boolean b = Boolean.parseBoolean("True"); // ignore case of characters
		System.out.println("b: " + b);

		// converting a primitive number into a String
		float floatNum = 42.5f;
		String floatStr1 = "" + floatNum; // concatenating String
		System.out.println(floatStr1);
		String floatStr2 = Float.toString(floatNum); // using static method toString()
		System.out.println(floatStr2);

	}

}
