package ch12_Lambda_MethodReference;

import java.util.List;

public class ForEach {

	public static void main(String[] args) {

		// enhanced for loop
		List<String> colors = List.of("Red", "Blue", "Yellow");
		for (String color : colors) {
			System.out.println(color);
		}

		// using forEach can reduce accidental errors (reduce typing in details with regular for loop)
		colors = List.of("Red", "Blue", "Yellow");
		colors.forEach(color -> System.out.println(color)); // passing instructions into a method

		List<Integer> nums = List.of(1, 2, 3, 4, 5);
		nums.forEach(num -> System.out.println(num));

	}

}
