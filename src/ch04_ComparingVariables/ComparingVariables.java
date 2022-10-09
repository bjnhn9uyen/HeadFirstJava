package ch04_ComparingVariables;

class ComparingVariables {

	public static void main(String[] args) {

		int a = 3;
		byte b = 3;

		// compare two primitives
		System.out.println("a = b? " + (a == b));

		Foo f1 = new Foo();
		Foo f2 = f1;
		Foo f3 = new Foo();

		// see if two object references refer to the same object on the heap
		System.out.println("f1 = f2? " + (f1 == f2));
		System.out.println("f1 = f3? " + (f1 == f3));

		// see if two different objects are equal
		System.out.println("f1 and f3 are equal? " + f1.equals(f3));

		String str1 = "Hello!";
		String str2 = "Hello!";

		// compare two different String objects have the same characters
		System.out.println("str1 and str2 are equal? " + str1.equals(str2));

	}

}
