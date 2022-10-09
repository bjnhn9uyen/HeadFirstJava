package ch08_CastingObject;

import java.util.ArrayList;

import ch08_Abstract_Polymorphism.Animal;
import ch08_Abstract_Polymorphism.Cat;

public class CastingObject {

	public static void main(String[] args) {

		Animal a = new Cat();
		Object o = new Cat();

		// compile error! climb method must be in the Animal class and the Object class
//		a.climb();
//		o.climb();

		Cat cat1 = (Cat) a;
		Cat cat2 = (Cat) o;
		System.out.print("cat1: ");
		cat1.climb();
		System.out.print("cat2: ");
		cat2.climb();

		ArrayList<Object> catList = new ArrayList<Object>();
		catList.add(new Cat());

		// compile error! everything comes out of an ArrayList<Object> is a reference of type Object
//		Cat cat4 = catList.get(0);
		Object o2 = catList.get(0);

		// if we’re not sure it’s a Cat, use the instanceof operator to check to prevent exception at runtime
		if (o2 instanceof Cat) {
			Cat cat3 = (Cat) o2;
			System.out.print("cat3: ");
			cat3.climb();
		}

		// compile error! the return type of getObject method must be Object as we declared in the method
//		Cat aCat = getObject(cat1);
		Object o3 = getObject(cat1);

		if (o3 instanceof Cat) {
			Cat cat4 = (Cat) o3;
			System.out.print("cat4: ");
			cat4.climb();
		}

	}

	public static Object getObject(Object o) {
		return o;
	}

}
