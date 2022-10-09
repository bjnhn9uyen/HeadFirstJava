package ch06_RegularArray_ArrayList;

import java.util.Arrays;

class RegularArrays {

	public static void main(String[] args) {

		int[] array1 = new int[5]; // declare an empty array of integer numbers
		int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // declare an array literal of integer numbers
		int[] array3 = new int[] { 5, 6, 7, 8, 9 }; // another way to declare an array literal
		Duck[] array4 = new Duck[3]; // declare an empty array of Duck object references
		int[][] twoDimArr = { { 0, 1, 2 }, { 0, 1, 2 } }; // declare two dimensional array literal

		// add elements to array1
		for (int i = 0; i < array1.length; i++) {
			array1[i] = i;
		}

		System.out.println("content of array1 represented by string: " + Arrays.toString(array1));
		System.out.println("content of array2 represented by string: " + Arrays.toString(array2));
		System.out.println("content of array3 represented by string: " + Arrays.toString(array3));

		// copy 3 elements start at index 0 from arr1 to arr3 start at index 0
		System.arraycopy(array1, 0, array3, 0, 3);
		System.out.println("\narray3 after copied from array1: " + Arrays.toString(array3));

		System.out.println();
		for (int i = 0; i < array4.length; i++) {
			array4[i] = new Duck();
			array4[i].setSize(10 + i);
			System.out.print("duck " + i + " with size " + array4[i].getSize() + ": ");
			array4[i].quack();
		}

		System.out.println("\ncontent of twoDimArr:");
		for (int i = 0; i < 2; i++) {
			if (i >= 1) {
				System.out.println();
			}
			for (int j = 0; j < 3; j++) {
				System.out.print(twoDimArr[i][j] + " ");
			}
		}

	}

}
