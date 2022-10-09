package ch11_Generic_Wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalTestDrive {

	public static void main(String[] args) {

		System.out.println("---regular array---");
		Animal[] animals = { new Dog(), new Cat(), new Dog() };
		Dog[] dogs = { new Dog(), new Dog(), new Dog() };
		takeAnimalArray(animals);
		takeAnimalArray(dogs); // runtime error! (if we change an element of array to a Cat in the method)

		System.out.println("\n---Generic List---");
		List<Animal> animalList = new ArrayList<>(Arrays.asList(animals));
		List<Dog> dogList = List.of(new Dog(), new Dog());
		takeAnimalList(animalList);
		// takeAnimalList(dogList); // compile error! (prevent runtime error trying to add a Cat to the List)

		System.out.println("\n---Wildcard List---");
		takeAnimalListWildcard(animalList);
		takeAnimalListWildcard(dogList);

	}

	static void takeAnimalArray(Animal[] animals) { // polymorphic array
		for (Animal a : animals) {
			a.eat();
		}
		// animals[0] = new Cat();// runtime error! (if we pass a Dog array as method argument)
	}

	static void takeAnimalList(List<Animal> animalList) {
		for (Animal a : animalList) {
			a.eat();
		}
		// the compiler will stop you if you try to pass a Dog List as the method argument
		animalList.add(new Cat());
	}

	static void takeAnimalListWildcard(List<? extends Animal> animalList) { // polymorphic collection types
		// static <T extends Animal> void takeAnimalList(List<T> animalList) { // using generic type parameter
		for (Animal a : animalList) {
			a.eat();
		}
		// When you use a wildcard in your method argument, the compiler will STOP you from doing anything
		// that could hurt the list referenced by the method parameter.
		// You can still invoke methods on the elements in the list, but you cannot add elements to the list.
		// That way, you can take advantage of polymorphism by using polymorphic collection types as arguments
		// animalList.add(new Cat()); // compile error
	}

}
