package com.yash.movie_booking.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.yash.movie_booking.exception.FileIsEmptyException;

public class FileUtil {

	public void writeToFile(String object, String nameOfFile) {
		BufferedWriter writer = null;
		File fileName = new File("src\\main\\resources\\" + nameOfFile + ".txt");
		if (!fileName.exists()) {
			try {
				fileName.createNewFile();
			} catch (IOException iOException) {
				iOException.printStackTrace();
			}

		} else {

			try {
				writer = new BufferedWriter(new FileWriter(fileName, true));
				writer.write(object);
				writer.close();
			} catch (IOException iOException) {
				iOException.printStackTrace();
			}

		}
	}

	public boolean checkEmptyFile(String nameOfFile) {
		boolean isFileEmpty = false;
		String fileName = "src\\main\\resources\\" + nameOfFile + ".txt";
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			if (bufferedReader.readLine() == null) {
				isFileEmpty = true;
				try {
					throw new FileIsEmptyException("File is empty");
				} catch (FileIsEmptyException e) {
					e.printStackTrace();
				}
			} else {
				readFromFile(nameOfFile);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return isFileEmpty;
	}

	public static void readFromFile(String nameOfFile) {
		String fileName = "src\\main\\resources\\" + nameOfFile + ".txt";
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

	public boolean getStringInFile(String wordToSearch, String nameOfFile) {
		File file = new File("src\\main\\resources\\" + nameOfFile + ".txt");
		boolean isWordFound = false;
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				final String lineFromFile = scanner.nextLine();
				if (lineFromFile.contains(wordToSearch)) {
					isWordFound = true;
					System.out.println("I found " + wordToSearch + " in file " + file.getName());
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return isWordFound;
	}

}
