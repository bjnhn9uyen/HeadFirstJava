package ch11_Comparable_Comparator_CollectionAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiableCollection {

	public static void main(String[] args) {
		System.out.println(createAListOldSchool());
		System.out.println(createAListOfStrings());
		System.out.println(createAListOfSongs());
		System.out.println(createASet());
		System.out.println(createAMap());
		System.out.println(createAMapOfSameTypes());
		System.out.println(createAMapOfEntries());
	}

	public static List<String> createAListOldSchool() {
		List<String> songs = new ArrayList<>();
		songs.add("somersault");
		songs.add("cassidy");
		songs.add("$10");
		return Collections.unmodifiableList(songs);
	}

	// using “Convenience Factory Methods of Collections”
	public static List<String> createAListOfStrings() {
		return List.of("somersault", "cassidy", "$10");
	}

	public static List<Song> createAListOfSongs() {
		return List.of(new Song("somersault", "zero 7", 147),
						new Song("cassidy", "grateful dead", 158),
						new Song("$10", "hitchhiker", 140));
	}

	public static Set<Song> createASet() {
		return Set.of(new Song("somersault", "zero 7", 147),
						new Song("cassidy", "grateful dead", 158),
						new Song("$10", "hitchhiker", 140));
	}

	public static Map<String, Integer> createAMap() {
		return Map.of("Kathy", 42, "Bert", 343, "Skyler", 420);
	}

	public static Map<String, String> createAMapOfSameTypes() {
		return Map.of("Riley", "Supersports", "Brooklyn", "Camera World", "Jay", "Homecase");
	}

	public static Map<String, String> createAMapOfEntries() {
		return Map.ofEntries(Map.entry("Riley", "Supersports"),
								Map.entry("Brooklyn", "Camera World"),
								Map.entry("Jay", "Homecase"));
	}

}
