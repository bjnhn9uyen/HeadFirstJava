package ch10_StaticMethod_StaticVariable;

public class Song {

	String title;
	boolean replay;

	static int songCount; // static variables live in a class, not in an object

	static final int SONG_METHOD_COUNT = 2; // constant value can’t be changed once it has been assigned

	public Song(boolean replay) {
		this.replay = replay;
		songCount++; // every time an instance of Song is created, songCount increases by 1
	}

	// Instance variable value affects the behavior of the non-static method play().
	// You need an instance of Song to call this method, because the Song object is created with
	// different value of its instance variables (in this case, ‘replay’ can be true or false).
	// That way, when you call this method on an instance of Song, the method uses the value of
	// instance variables of Song object to decide how the behavior should be.
	// In other words, non-static method depends on instance variable values
	public void play() {
		if (replay == true) {
			System.out.println("play the song twice!");
		} else {
			System.out.println("play the song once!");
		}
	}

	// static methods is good for utility methods that doen’t depend on instance variables
	public static void stop() {
		// System.out.println("the title of the song: " + title); // compile error! Which Song? Whose 'title'?
		// play();// compile error! Which Song? Whose 'replay'?
		System.out.println("stop the song now!");
	}

}
