package ch10_RegularExpression;

public class RegexString {

	public static void main(String[] args) {

		String str1 = "Hello World, Hello Java";
		String str2 = ""; // we'll use this empty string to remove a word or a line

		// remove the last word in a string
		String regex = "\\S+$"; // \\S means non-whitespace character; $ means from the end of a line
		System.out.println(str1.replaceAll(regex, str2));

		// remove all white spaces in a string
		regex = " ";
		System.out.println(str1.replaceAll(regex, str2));

		// remove characters except digits, commas, and dots
		str1 = "'zz11,235.00vnd'";
		regex = "[^\\d|,|\\.]"; // ^ : except; \d : digit from 0 to 9; | : and
		System.out.println(str1.replaceAll(regex, str2));

		// get a string inside the square brackets in another string
		str1 = "'Hello [javadev].'";
		regex = ".*\\[|].*";
		System.out.println(str1.replaceAll(regex, str2));

		// remove all characters except word characters (a-z A-Z 0-9) and spaces
		str1 = "12abcde$ddfd @abcd )der]*!#";
		regex = "[^\\w| ]"; // \w : word characters [a-zA-Z_0-9]
		System.out.println(str1.replaceAll(regex, str2));

		// learn more about regular expression in Java API
	}

}
