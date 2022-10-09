package ch03_Primitive_Reference;

class ArrayOfReferences {

	public static void main(String[] args) {
		Dog[] dogs = new Dog[7]; // we have an array of Dog references, but no actual Dog objects

		dogs[0] = new Dog();
		dogs[1] = new Dog();
		dogs[2] = new Dog();
		dogs[3] = new Dog();
		dogs[4] = new Dog();
		dogs[5] = new Dog();
		dogs[6] = new Dog();

		dogs[0].name = "Fido";
		System.out.println(dogs[0].name);
		dogs[0].bark();
	}

}
