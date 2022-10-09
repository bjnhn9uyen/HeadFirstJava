package ch11_Comparable_Comparator_CollectionAPI;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortingTestDrive {

	public static void main(String[] args) {

		// sort a list of String (String class already implements Comparable interface)
		List<String> songStrList = MockSongs.getSongStrings();
		System.out.println(songStrList);
		Collections.sort(songStrList);
		System.out.println(songStrList);

		// sort by title by implement Comparable interface in Song class
		List<Song> songList = MockSongs.getSongObjects();
		System.out.println("\n" + songList);
		Collections.sort(songList);
		System.out.println(songList);

		// sort by artist by implement Comparator interface in separate class (ArtistComparator class)
		ArtistComparator artistComparator = new ArtistComparator();
		songList.sort(artistComparator);
		System.out.println("\n" + songList);

		// using lambda expression, same result but much shorter, no need to create a custom Comparator class
		songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
		System.out.println("\n" + songList);
		songList.sort((one, two) -> one.getArtist().compareTo(two.getArtist()));
		System.out.println(songList);

		// using HashSet to prevent duplicate value (but no sort method)
		Set<Song> songSet = new HashSet<>(songList); // HashSet constructor takes a Collection as an argument
		System.out.println("\n" + songSet);
//		Collections.sort(songSet); // compile error! Collections.sort takes a List as argument, not a Set
//		songSet.sort(artistComparator); // compile error! Set interface doesn’t have sort method

		// using TreeSet to prevent duplicate value and keep the Song list sorted
		// by default, TreeSet will use Song’s compareTo() method (must implements Comparable)
		songSet = new TreeSet<>(songList);
		System.out.println("\n" + songSet);
		// pass in a lambda (represents a Comparator) to the TreeSet constructor to do the sort
		songSet = new TreeSet<>((one, two) -> one.getArtist().compareTo(two.getArtist())); // sort by artist
		songSet.addAll(songList);
		System.out.println(songSet);
		songSet = new TreeSet<>((one, two) -> one.getBpm() - two.getBpm()); // sort by bpm
		songSet.addAll(songList);
		System.out.println(songSet);
	}

}
