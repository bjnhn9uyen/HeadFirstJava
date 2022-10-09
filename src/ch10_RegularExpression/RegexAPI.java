package ch10_RegularExpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexAPI {

	// you can use java.util.regex API for working with regular expressions
	// there’re two classes in the regex API that are primarily used, Pattern class and Matcher class
	public static void main(String[] args) {

		// check whether the input string is a positive integer or not
		Pattern pattern = Pattern.compile(".*[0-9].*");
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter a number: ");
		String str = scanner.nextLine();
		System.out.println("string is a positive number? " + pattern.matcher(str).matches());

		// check whether the input string is an email address or not
		pattern = Pattern.compile("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		System.out.print("enter an email address: ");
		str = scanner.nextLine();
		System.out.println("string is an email address? " + pattern.matcher(str).matches());
		scanner.close();

		// capturing groups
		pattern = Pattern.compile("((X)(Y(Z)))");
		Matcher matcher = pattern.matcher("((X)(Y(Z)))");
		System.out.println("group count: " + matcher.groupCount());

		// defines a capturing group matching two words in a row,
		// ‘\\1’ re-apply the same capturing group at the end
		pattern = Pattern.compile("(\\w\\w)\\1");
		matcher = pattern.matcher("This is a class"); // not duplicate
		System.out.println("duplicate? " + matcher.find());
		matcher = pattern.matcher("Thisis a class"); // duplicate because 'isis' in "Thisis"
		System.out.println("duplicate? " + matcher.find());

		// check whether a string contains another string or not
		String string1 = "abc123def";
		String string2 = "abc";
		String string3 = "xyz";

		pattern = Pattern.compile(".*" + string2 + ".*");
		matcher = pattern.matcher(string1);
		System.out.println("does string1 contains string2 ? " + matcher.matches()); // true

		pattern = Pattern.compile(string2);
		matcher = pattern.matcher(string1);
		System.out.println("does string1 contains string2 ? " + matcher.matches()); // false

		pattern = Pattern.compile(".*" + string3 + ".*");
		matcher = pattern.matcher(string1);
		System.out.println("does string1 contains string3 ? " + matcher.matches()); // false

	}

}