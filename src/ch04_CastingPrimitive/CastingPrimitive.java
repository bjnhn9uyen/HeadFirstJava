package ch04_CastingPrimitive;

public class CastingPrimitive {

	public static void main(String[] args) {

		long y = 45; // long range from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (size 64 bit)
//		int x = y; // won’t compile because we can’t shove a big thing directly into a small thing
		int x = (int) y; // int range from -2,147,483,648 to 2,147,483,647 (size 32 bit)
		System.out.println("x: " + x);
		short s = (short) y;
		System.out.println("s: " + s); // short range from -32,768 to 32,767 (size 16 bit)
		byte b = (byte) y;
		System.out.println("b: " + b); // byte range from -128 to 127 (size 8 bit)

		// from a smaller type to the bigger type, we just need to assign directly
		long yy = b;
		System.out.println("yy: " + yy);

		double d = 123.45;
//		float f = d; // won’t compile because double is bigger an float
		float f = (float) d;
		System.out.println("f: " + f);
		int z = (int) f;
		System.out.println("z: " + z);

	}

}
