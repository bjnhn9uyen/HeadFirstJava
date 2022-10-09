package ch10_StringManipulation;

import java.util.Arrays;

public class StringStuff {

	public static void main(String[] args) {

		String myString = "Hello";
		System.out.println("length: " + myString.length());
		System.out.println("character at index=" + 4 + ": " + myString.charAt(4));
		System.out.println("index of character 'e': " + myString.indexOf("e"));
		System.out.println("last index of character 'l': " + myString.lastIndexOf("l"));

		// concatenate the specified string to the end of the COPY of myString
		// Strings are immutable, after concatenating, the old of 'myString' just sit around wasting memory
		// if you have to do a lot of String manipulations (like concatenations, replacements, etc),
		// you can avoid the creation of unnecessary strings by using a StringBuilder
		System.out.println("concatenate: " + myString.concat(" World!"));
		System.out.println("replace all occurrences of ‘l’ by ‘2’: " + myString.replace('l', '2'));
		System.out.println("subtract string from index 0 to 2: " + myString.substring(0, 2));

		// the compareTo method returns 0 if two strings are identical, if two strings are different,
		// returns a positive integer or a negative integer depending on the index of letters in the alphabet
		System.out.println("“" + myString + "” vs. “Hello World!”: " + myString.compareTo("Hello World!"));

		String spaceString = "   Hello World!       ";
		System.out.println("remove leading and trailing white spaces: " + spaceString.trim());

		// the split() method takes the “\s” as a separator to break apart of the String into pieces
		myString = myString.concat(" I am a Java developer");
		String[] splitWords = myString.split("\s"); // “\s” means space
		// String[] splitWords = str.split(" "); // another way
		System.out.println(Arrays.asList(splitWords));

		StringBuilder sb = new StringBuilder();
		sb.append("Hello");
		System.out.println("\n" + sb);
		System.out.println(sb.insert(sb.length(), " World!"));
		System.out.println(sb.delete(5, 11)); // from index 5 to 11
		System.out.println(sb.reverse());

	}

}

/**
 * StringBuilder and StringBuffer are similar, the different is all the methods of StringBuffer class are
 * synchronized, so StringBuffer is suitable for multi-threaded apps. Therefore, StringBuilder's methods are
 * more efficient and faster than StringBuffer's methods because they don't have to work in the
 * synchronization. You should use the StringBuilder class instead of StringBuffer, unless your String
 * manipulations need to be thread-safe, which is not common.
 */
