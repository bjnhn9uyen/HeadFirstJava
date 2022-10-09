package ch03_Primitive_Reference;

class Primitives {

	public static void main(String[] args) {
		// Primitive declarations with assignments is called literal values
		boolean b = false;
		char c = 'A'; // unlike String, char literal value must be enclosed in single quotes
		byte by = 1;
		short s = 1;
		int i = 1;
		long l = 1;
		float f = 10.9f; // Java thinks anything with a floating point is a double, unless we add an ‘f’.
		double d = 20.9;
		System.out.println("boolean variable: " + b);
		System.out.println("char variable: " + c);
		System.out.println("byte variable: " + by);
		System.out.println("short variable: " + s);
		System.out.println("int variable: " + i);
		System.out.println("long variable: " + l);
		System.out.println("float variable: " + f);
		System.out.println("double variable: " + d);
	}

}
