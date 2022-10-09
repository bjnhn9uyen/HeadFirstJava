package ch05_SwitchCase_TernaryOperator;

import java.util.Scanner;

class SwitchCaseEnum {

	enum seasons {
		spring, summer, fall, winter
	}

	public static void main(String[] args) {
		System.out.print("enter any season in a year : ");
		Scanner scanner = new Scanner(System.in);
		String season = scanner.next();
		switch (season) {
		case "spring":
			System.out.println("months of spring: 1, 2, 3");
			break;
		case "summer":
			System.out.println("months of summer: 4, 5, 6");
			break;
		case "fall":
			System.out.println("months of fall: 7, 8, 9");
			break;
		case "winter":
			System.out.println("months of winter: 10, 11, 12");
			break;
		default:
			System.out.println("“" + season + "”" + " not match any season");
		}
		scanner.close();
	}

}
