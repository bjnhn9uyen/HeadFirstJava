package ch02_Object_InstanceVariable_Method;

class Dog {

	// instance variables represent an object's states (the data)
	int size;
	String breed;
	String name;

	// methods (behaviors of an object) can read or write the values of the instance variables
	void bark() {
		size = 40;
		breed = "mixed";
		System.out.println(name + " says “Woof! Woof!”");
	}

	// if we create an instance of a class in its own body, although the compiler let this pass, 
	// but when we instantiate this object in main() method, it will be created countlessly,
	// we'll get StackOverflowError because the first instance will call this instance, 
	// and this instance will call its inside instance, and so on...
//	 Dog d = new Dog();

}
