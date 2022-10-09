package ch16_File_Files;

import java.io.File;
import java.io.IOException;

public class FileIO {

	public static void main(String[] args) {
		String path = "src/" + FileIO.class.getPackageName() + "/filesaves/";
		createFolder(path);
		File file = createFile(path);
		renameFile(file, path + "renamed_file.txt");
//		deleteFile(new File(path + "renamed_file.txt"));
		displayAllFiles(new File("."));
		displayAllFilesWithExtension(new File("."), "xml");
		displayAllSubFolders(new File("src"));
	}

	static void createFolder(String path) {
		File folder = new File(path);
		System.out.println("folder created? " + folder.mkdir()); // false if folder already exists
	}

	static File createFile(String path) {
		File file = new File(path + "text_file.txt");
		try {
			System.out.println("file created? " + file.createNewFile()); // false if file already exists
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("file exists? " + file.exists());
		System.out.println(path + "text_file.txt is a file? " + file.isFile());
		System.out.println("relative direction: " + file.getPath());
		System.out.println("absolute direction: " + file.getAbsolutePath());
		return file;
	}

	static void renameFile(File file, String newName) {
		File renamedFile = new File(newName);
		System.out.println("file renamed? " + file.renameTo(renamedFile));
	}

	static void deleteFile(File file) {
		System.out.println("file deleted? " + file.delete());
	}

	static void displayAllFiles(File folder) {
		String[] names = folder.list();
		for (String name : names) {
			File path = new File(folder.getPath() + "/" + name);
			if (path.isFile()) {
				System.out.println(path);
			}
		}
	}

	static void displayAllFilesWithExtension(File folder, String ext) {
		String[] names = folder.list();
		for (String name : names) {
			if (name.endsWith(ext)) {
				System.out.println(name);
			}
		}
	}

	static void displayAllSubFolders(File folder) {
		String[] names = folder.list();
		for (String name : names) {
			File dir = new File(folder.getPath() + "/" + name);
			if (dir.isDirectory()) {
				System.out.println(dir.getName());
			}
		}
	}

}
