package ch03_Primitive_Reference;

class ArrayOfPrimitives {

	public static void main(String[] args) {
		int[] nums = new int[7];

		nums[0] = 6;
		nums[1] = 19;
		nums[2] = 44;
		nums[3] = 42;
		nums[4] = 10;
		nums[5] = 20;
		nums[6] = 1;

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
