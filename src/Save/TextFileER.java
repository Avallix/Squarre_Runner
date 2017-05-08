package Save;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileER {

	private static String fileName = "";

	public TextFileER() {

	}

	public void fileNew(String name) throws IOException {
		fileName = name;
		try {
			File dir = new File("D:/School/Csc 117/Eclipse test workk/MapCreator/savesFiles");
			String nameHold = name;
			File fileLoca = new File(dir, nameHold);
			FileWriter file = new FileWriter(fileLoca);
			BufferedWriter bufferedWriter = new BufferedWriter(file);
			bufferedWriter.write("11");
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}

	}

	public int[] saveRetriver(String fileName) {
		String line = null;
		int location[] = new int[2];
		try {
			File dir = new File("D:/School/Csc 117/Eclipse test workk/MapCreator/savesFiles");
			String nameHold = fileName;
			File fileLoca = new File(dir, nameHold);
			FileReader filereader = new FileReader(fileLoca);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			line = bufferedReader.readLine();
			location[0] = Integer.parseInt(line.substring(0, 1));
			location[1] = Integer.parseInt(line.substring(1, 2));
			bufferedReader.close();
			return location;
		} catch (IOException ex) {
			System.out.println("Error reading to file '" + fileName + "'");
		}
		return null;
	}

	public void mapSaveOverwriter(String fileName, int x, int y) {

		try {
			File dir = new File("D:/School/Csc 117/Eclipse test workk/MapCreator/savesFiles");
			String nameHold = fileName;
			File fileLoca = new File(dir, nameHold);
			FileWriter filewriter = new FileWriter(fileLoca);
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			bufferedWriter.write(x + "" + y);
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}
	}

	public void saveDeleter(String fileName) {
		File dir = new File("D:/School/Csc 117/Eclipse test workk/MapCreator/savesFiles");
		String nameHold = fileName;
		File fileLoca = new File(dir, nameHold);
		fileLoca.delete();
	}

	public void listFiles() {
		File f = null;
		File[] paths;
		try {
			f = new File("D:/School/Csc 117/Eclipse test workk/MapCreator/savesFiles");
			paths = f.listFiles();
			for (File path : paths) {
				String str = path.getAbsolutePath();
				System.out.println(str.substring(58));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
