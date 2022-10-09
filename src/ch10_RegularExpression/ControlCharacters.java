package ch10_RegularExpression;

public class ControlCharacters {

	public static void main(String[] args) {

		System.out.println("<html>");
		System.out.println("\t<head>"); // ‘\t’ is tab character
		System.out.println("\t</head>");
		System.out.println("\t<body>");
		System.out.println("\t</body>");
		System.out.println("</html>");

		System.out.println();
		String string1 = "this is string1";
		String string2 = "this is string2";
		// requires 'Interpret ASCII control characters' enabled in console preferences
		System.out.println("backspace character: " + string1 + "\b");
		System.out.println("newline character: " + string1 + "\n" + string2); // newline
		System.out.println("carriage-return character:");
		// carriage-return moves the cursor's position to the beginning on the same line (clear string1)
		System.out.println(string1 + "\r" + string2);

	}

}
