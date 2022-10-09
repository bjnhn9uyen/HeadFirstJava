package ch12_Lambda_MethodReference;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Jukebox {

	public static void main(String[] args) {

		List<Song> songs = MockSongs.getSongs();

		// search for songs that its genre has the word “Rock”
		List<Song> rockSongs = songs.stream()
								.filter(song -> song.getGenre().contains("Rock"))
								.collect(Collectors.toList());
		System.out.println(rockSongs);

		// list of all the genres of the songs that have been played
		List<String> genres = songs.stream().map(song -> song.getGenre()).collect(Collectors.toList());
		System.out.println("\n" + genres);

		// list of all the genres of the songs that have been played but no duplicate genres
		List<String> genresNoDuplicate = songs.stream()
								.map(song -> song.getGenre())
								.distinct()
								.collect(Collectors.toList());
		System.out.println("\n" + genresNoDuplicate);

		// create a list of all the artists that have covered a specific song, excluding the original artists
		String songTitle = "With a Little Help from My Friends";
		List<String> result = songs.stream()
								.filter(song -> song.getTitle().equals(songTitle))
								.map(song -> song.getArtist())
								.filter(artist -> !artist.equals("The Beatles"))
								.collect(Collectors.toList());
		System.out.println("\n" + result);

		// create a map with keys are genres, each genre has value is a number of songs of that genre
		Map<String, Long> genreCount = songs.stream()
								.map(song -> song.getGenre())
								.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("\n" + genreCount);

		// find top 5 most played songs using method reference
		List<String> topFive = songs.stream()
								.sorted(Comparator.comparingInt(Song::getTimesPlayed))
								.map(song -> song.getTitle())
								.limit(5)
								.collect(Collectors.toList());
		System.out.println("\n" + topFive);
	}

}