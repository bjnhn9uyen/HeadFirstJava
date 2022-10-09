package ch05_WhileLoop_ForLoop;

class EnhancedForLoop {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };

		System.out.println("display an array using regular for loop:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");

		System.out.println("display an array using enhanced for loop:");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}
