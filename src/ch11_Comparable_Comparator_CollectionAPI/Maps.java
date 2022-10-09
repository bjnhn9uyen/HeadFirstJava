package ch11_Comparable_Comparator_CollectionAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {

	public static void main(String[] args) {

		HashMap<String, Integer> scoresHash = new HashMap<>();

		// use 'put' instead of 'add', you can have duplicate values, but not duplicate keys
		scoresHash.put("Kathy", 42);
		scoresHash.put("Bert", 343);
		scoresHash.put("Skyler", 420);

		// when you print a Map, it uses braces { } instead of the brackets [ ] when you print Lists and Sets
		System.out.println("HashMap: " + scoresHash);

		// the get() method takes a key, and returns the value (in this case, an Integer)
		System.out.println(scoresHash.get("Bert"));

		System.out.println("\nAll the keys of HashMap:");
		for (String key : scoresHash.keySet()) {
			System.out.println(key);
		}

		System.out.println("\nAll the values of HashMap:");
		for (Integer value : scoresHash.values()) {
			System.out.println(value);
		}

		// Map.Entry objects are valid only for the duration of the iteration
		System.out.println("\nAll the entries of HashMap:");
		for (Map.Entry<String, Integer> entry : scoresHash.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}

		// the Set interface has HashSet and TreeSet with ONE type parameter,
		// similarly, the Map interface has HashMap and TreeMap with TWO type parameters.
		// And similar to TreeSet, the TreeMap stores KEYS in sorted order (ascending)
		TreeMap<String, Integer> scoresTree = new TreeMap<>();
		scoresTree.putAll(scoresHash);

		System.out.println("\nTreeMap: " + scoresTree);
		System.out.println(scoresHash.get("Skyler"));

	}

}
