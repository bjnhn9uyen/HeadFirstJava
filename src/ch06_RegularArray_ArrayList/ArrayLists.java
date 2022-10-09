package ch06_RegularArray_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

class ArrayLists {

	public static void main(String[] args) {

		// with a regular array, we must declare a size, but with ArrayList, no size required.
		ArrayList<Duck> ducks = new ArrayList<Duck>();
		// ArrayList holds objects, not primitives. Integer is a wrapper of primitive type 'int'.
		ArrayList<Integer> integerList = new ArrayList<Integer>();

		ducks.add(new Duck());
		ducks.get(0).setSize(10);
		System.out.println("duck’s size: " + ducks.get(0).getSize());
		ducks.get(0).quack();

		System.out.println("\nlength of integerList: " + integerList.size());
		for (int i = 0; i < 5; i++) {
			integerList.add(i);
		}
		System.out.println("length of integerList after add elements: " + integerList.size());
		System.out.println("elements in integerList: " + integerList);

		integerList.add(1, 5); // insert value 5 at index 1
		System.out.println("elements in integerList after insert value 5 at index 1: " + integerList);

		integerList.set(0, 10); // set value 10 at index 0
		System.out.println("elements in integerList after set value to 10 at index 0: " + integerList);

		System.out.println("\nelement has value 1 does exist in integerList? " + integerList.contains(1));
		System.out.println("first index of 1 in integerList: " + integerList.indexOf(1));
		System.out.println("last index of 3 in integerList: " + integerList.lastIndexOf(3));

		// convert an ArrayList to a regular array
		Object[] objArray = integerList.toArray();
		integerList.clear(); // clear all elements
		System.out.println("\nlength of integerList after clear: " + integerList.size());
		System.out.print("elements in objArray after convert from integerList: " + Arrays.toString(objArray));

		// cast Object[] to int[] (cast to smaller)
		int[] intArray = new int[objArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) objArray[i];
		}
		System.out.print("\nelements in intArray after cast from objArray: " + Arrays.toString(intArray));

		String[] strArr = { "AAA", "BBB", "CCC", "DDD" };
		// convert a regular array to an ArrayList
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strArr));
		System.out.println("\nelements in strList after convert from strArr: " + strList);
		strList.clear();

		// ArrayList is an ordered sequence of elements, it maintains the elements in insertion order
		strList.add("B");
		strList.add("C");
		strList.add("A");
		System.out.println("\n" + strList);

	}

}
