package ch04_Encapsulation;

class DogTestDrive {

	public static void main(String[] args) {

		Dog dog1 = new Dog();
		dog1.setSize(70);
		System.out.println("dog1’s size: " + dog1.getSize());
		dog1.bark();

		Dog dog2 = new Dog();
		dog2.setSize(8);
		System.out.println("dog2’s size: " + dog2.getSize());
		dog2.bark();

	}

}