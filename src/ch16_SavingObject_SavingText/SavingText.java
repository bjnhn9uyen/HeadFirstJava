package ch16_SavingObject_SavingText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavingText {

	public static void main(String[] args) {

		File path = new File("src/" + SavingObject.class.getPackageName() + "/gamesaves/Game.txt");

		String[] strings = { "50|Elf|bow|sword|dust", "200|Troll|bare hands|big ax",
										"120|Magician|spells|invisibility" };

		saveText(strings, path);
		List<String> listStr = readText(path);

		System.out.println(listStr);

	}

	// writing a text file
	static void saveText(String[] strings, File filePath) {
		try {
			// FileWriter is a connection stream, if the file doesn’t exist, it will be created automatically
			// you can write to a file using FileWriter alone by calling write(someString),
			// but Using buffers is much more efficient
			FileWriter fw = new FileWriter(filePath);
			// make a chain stream
			BufferedWriter writer = new BufferedWriter(fw);
			// if you do want to send data before the buffer is full, just call writer.ﬂush()
			for (String string : strings) {
				writer.write(string);
				writer.write("\n");
			}
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// reading from a text file
	static List<String> readText(File filePath) {
		List<String> listStr = new ArrayList<>();
		try {
			// FileReader is a connection stream that connects to a text file
			FileReader fr = new FileReader(filePath);
			// using BufferedReader as a chain stream to make the reading more efficient
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				listStr.add(line);
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return listStr;
	}

}
