package ch03_Primitive_Reference;

class References {

	public static void main(String[] args) {

		// Dog is a reference type
		Dog dog1 = new Dog();

		dog1.name = "Fido";
		System.out.println(dog1.name);
		dog1.bark();

		// dog1 variable and dog2 variable refer to the same Dog
		Dog dog2 = dog1;
		dog2.bark();

		Dog dog3 = new Dog();
		dog3.bark();

		// dog1, dog2, and dog3 refer to the same Dog, dog3 variable no longer refers to its old Dog object,
		// and that Dog object is abandoned and eligible for Garbage Collection (GC)
		dog3 = dog1;

		Dog dog4 = new Dog();
		dog4.bark();

		// dog4 is a null reference, meaning it doesn’t refer to anything,
		// its Dog object is abandoned and eligible for GC
		dog4 = null;

		// dog4 is still a reference variable, and another Dog object can still be assigned to it
		dog4 = new Dog();
	}

}
