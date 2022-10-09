package ch11_Comparable_Comparator_CollectionAPI;

public class Song implements Comparable<Song> {

	private String title;
	private String artist;
	private int bpm;

	public Song(String title, String artist, int bpm) {
		this.title = title;
		this.artist = artist;
		this.bpm = bpm;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int getBpm() {
		return bpm;
	}

	// override it to print something more readable than the default unique identifier code
	@Override
	public String toString() {
		return title + ": " + artist;
	}

	@Override
	public int compareTo(Song s) {
		return title.compareTo(s.getTitle());
		// String already implements Comparable interface, it has an overridden compareTo method, too
	}

	@Override
	public int hashCode() {
		return title.hashCode(); // since String extends Object, it has an overridden hashCode method, too
	}

	@Override
	public boolean equals(Object aSong) {
		Song other = (Song) aSong;
		return title.equals(other.getTitle()); // String has an overridden equals method (from Object class)
	}

}
