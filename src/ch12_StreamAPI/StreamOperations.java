package ch12_StreamAPI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	private List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

	public static void main(String[] args) {
		StreamOperations streamOperation = new StreamOperations();
		streamOperation.limitWithCount();
		streamOperation.limitWithCollect();
		streamOperation.chainedOperations();
		streamOperation.sortingCaseInsensitive();
		streamOperation.filtering();
	}

	void limitWithCount() {
		Stream<String> stream = strings.stream(); // get the Stream from a source collection
		Stream<String> limit = stream.limit(4); // call zero or more intermediate operations on the Stream
		long result = limit.count(); // output the results with a terminal operation
		System.out.println("result = " + result);
	}

	void limitWithCollect() {
		Stream<String> stream = strings.stream();
		Stream<String> limit = stream.limit(4);
		List<String> result = limit.collect(Collectors.toList()); // terminal operation
		System.out.println("\nresult = " + result);

		result = strings.stream().limit(4).collect(Collectors.toList()); // chained Stream (pipeline)
		System.out.println("result = " + result);
	}

	void chainedOperations() {
		// natural order sorting (default): number < upper-case letters < lower-case letters (alphabetical)
		// after sorted using natural order, skip the first 3 elements of the stream
		List<String> result2 = strings.stream().sorted().skip(3).limit(4).collect(Collectors.toList());
		System.out.println("\nresult = " + result2);
	}

	void sortingCaseInsensitive() {
		List<String> result = strings.stream()
								.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
								.limit(4)
								.collect(Collectors.toList());
		System.out.println("\nresult = " + result);
	}

	void filtering() {
		List<String> result = strings.stream().filter(s -> s.length() < 4).collect(Collectors.toList());
		System.out.println("\nresult = " + result);

		List<String> coffees = List.of("Cappuccino",
								"Americano",
								"Espresso",
								"Cortado",
								"Mocha",
								"Cappuccino",
								"Flat White",
								"Latte");

		List<String> coffeesEndingWithO = coffees.stream()
								.filter(s -> s.endsWith("o"))
								.sorted()
								.distinct() // remove duplicate
								.collect(Collectors.toList());

		System.out.println("coffees ending with ‘o’: " + coffeesEndingWithO);
	}

}
