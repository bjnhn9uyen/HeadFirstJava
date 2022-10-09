package ch16_SavingObject_SavingText;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SavingObject {

	public static void main(String[] args) {

		File path = new File("src/" + SavingObject.class.getPackageName() + "/gamesaves/Game.ser");

		// create three character objects
		GameCharacter ch1 = new GameCharacter(50, "Elf", new String[] { "bow", "sword", "dust" }, 100);
		GameCharacter ch2 = new GameCharacter(200, "Troll", new String[] { "bare hands", "big ax" }, 100);
		GameCharacter ch3 = new GameCharacter(80, "Magician", new String[] { "spells", "invisibility" }, 100);

		serializeCharacters(new GameCharacter[] { ch1, ch2, ch3 }, path); // serialization
		List<GameCharacter> characters = deserializeCharacters(path); // deserialization

		// check to see if it worked
		characters.forEach(character -> {
			System.out.println("Character " + character.getType() + "’s power: " + character.getPower());
			System.out.println("Character " + character.getType() + "’s weapons: " + character.getWeapons());
			// check transient instance variables
			System.out.println("Character " + character.getType() + "’s health: " + character.gethealth());
		});

	}

	// here are the process of serializing (saving) an object
	static void serializeCharacters(GameCharacter[] characters, File filePath) {
		try {
			// make a connection stream object, if the file doesn’t exist, it will be created automatically
			FileOutputStream fileStream = new FileOutputStream(filePath);
			// chain stream can’t directly connect to a file, it must be chained to a connection stream object
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			// serialize objects
			for (int i = 0; i < characters.length; i++) {
				os.writeObject(characters[i]);
			}
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// deserialization is a lot like serialization in reverse
	static List<GameCharacter> deserializeCharacters(File filePath) {
		List<GameCharacter> listCharacter = new ArrayList<>();
		try {
			// if the file doesn’t exist, you’ll get an exception
			FileInputStream fileStream = new FileInputStream(filePath);
			// make a chain stream, and chain it to a connection stream
			ObjectInputStream is = new ObjectInputStream(fileStream);
			// each time you say readObject(), you get the next object in the stream
			while (true) {
				try {
					Object o = is.readObject();
					listCharacter.add((GameCharacter) o);
				} catch (EOFException e) {
					break;
				}
			}
			is.close();
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return listCharacter;
	}

}
