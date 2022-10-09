package ch16_File_Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesNIO {

	public static void main(String[] args) {
		Path path = Paths.get("src", FilesNIO.class.getPackageName(), "filesaves");
		createFolder(path);
		createFile(path, "nio_text_file.txt");
	}

	static void createFolder(Path path) {
		if (!Files.exists(path)) {
			try {
				Files.createDirectory(path);
				System.out.println("folder has been created!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("folder already exists!");
		}
	}

	static void createFile(Path folderPath, String fileName) {
		Path path = Paths.get(folderPath.toString(), fileName);
		if (!Files.exists(path)) {
			try {
				Files.createFile(path);
				System.out.println("file has been created!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("file already exists!");
		}
	}

}

// java.io.File has been “replaced” by classes in the newer java.nio.file package
// for new code, using the java.nio.file package instead of the java.io.File class is recommended
