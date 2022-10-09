package ch07_Inheritance_Polymorphism_Overriding;

import java.util.ArrayList;
import java.util.Arrays;

public class AnimalTestDrive {

	public static void main(String[] args) {

		Cat cat = new Cat();
		cat.setSize(10);
		System.out.println("cat's size: " + cat.getSize());
		cat.setBreed("Ragdoll");
		System.out.println("I'm a " + cat.getBreed() + " cat");
		cat.sleep();
		cat.climb();
		cat.eat();
		cat.makeNoise();

		System.out.println();
		Dog dog = new Dog();
		dog.sleep();
		dog.eat();
		dog.makeNoise();

		System.out.println();
		Tiger tiger = new Tiger();
		tiger.sleep();
		tiger.eat();
		tiger.makeNoise();

		System.out.println();
		Lion lion = new Lion();
		lion.sleep();
		lion.eat();
		lion.makeNoise();

		System.out.println("\npolymorphic array:");
		Animal[] animals = new Animal[4];
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Tiger();
		animals[3] = new Lion();
		for (Animal animal : animals) {
			animal.makeNoise();
		}

		System.out.println("\npolymorphic ArrayList:");
		ArrayList<Animal> animalList = new ArrayList<Animal>(Arrays.asList(animals));
		for (Animal animal : animalList) {
			animal.makeNoise();
		}

		System.out.println("\npolymorphic argument:");
		vetGivesShot(new Dog());
		vetGivesShot(new Cat());

		System.out.println("\npolymorphic return type:");
		Animal a = getObject();
		a.makeNoise();
	}

	private static void vetGivesShot(Animal a) {
		a.makeNoise();
	}

	private static Animal getObject() {
		return new Dog();
//		return new Cat();
//		return new Tiger();
//		return new Lion();
	}

}
