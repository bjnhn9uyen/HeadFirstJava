package ch12_Lambda_MethodReference;

import java.util.List;
import java.util.Optional;

public class OptionalWrapper {

	private static List<Song> songs = MockSongs.getSongs();

	public static void main(String[] args) {
		findASongByArtist("The Beatles");
		findASongByArtist("The Beach Boys");
	}

	static void findASongByArtist(String artist) {
		Optional<Song> result = songs.stream().filter(song -> song.getArtist().equals(artist)).findFirst();
		if (result.isPresent()) {
			System.out.println(result.get().getTitle());
		} else {
			System.out.println("No songs found by: " + artist);
		}
	}
}