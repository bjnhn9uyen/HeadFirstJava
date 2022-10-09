package ch10_StaticMethod_StaticVariable;

public class SongTestDrive {

	public static void main(String[] args) {
		Song s1 = new Song(true);
		Song s2 = new Song(false);
		s1.play();
		s2.play();
		Song.stop();
		System.out.println("How many instances of Song was created? " + Song.songCount);
//		Song.SONG_METHOD_COUNT = 3; // compile error! trying to change the value of constant
	}

}
