package ch11_Comparable_Comparator_CollectionAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorTest {

	public static void main(String[] args) {

		ArrayList<String> myList = new ArrayList<>();
		myList.add("1");
		myList.add("2");
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("3");

		// Iterator allows you to iterate through items in a collection, also adds the ability to remove items
		Iterator<String> iterator = myList.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.print(element + " ");
		}
		System.out.println();

		// ListIterator interface extends Iterator interface
		// ListIterator has methods to traverse the list in either direction,
		// modify the list during iteration (like add, set, remove)
		ListIterator<String> listIterator = myList.listIterator();
		while (listIterator.hasNext()) {
			String element = listIterator.next();
			listIterator.set(element + "+");
		}

		System.out.print("reverse direction: ");
		while (listIterator.hasPrevious()) {
			String element = listIterator.previous();
			System.out.print(element + " ");
		}

	}

}
