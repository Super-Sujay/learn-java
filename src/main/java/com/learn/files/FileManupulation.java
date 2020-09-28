package com.learn.files;

import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.joining;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManupulation {

	public static void main(String[] args) {

		File file = new File(System.getProperty("user.dir") + "/src/main/resources/People.txt");

		boolean fileExists = file.exists();
		System.out.println("Does the file exists: " + fileExists);

		if (!fileExists)
			System.out.println("File does not exists.");

		long fileSize = file.length();
		System.out.println("Length of the file is: " + fileSize);

		String fileParent = file.getParent();
		System.out.println("The file parent is: " + fileParent);

		boolean isFileHidden = file.isHidden();
		System.out.println("Is the file hidden: " + isFileHidden);

		String fileLocation = file.toString();
		System.out.println("The location of the file: " + fileLocation);

		String filePath = System.getProperty("user.dir") + "/src/main/resources/People.txt";
		String fileContents;
		try {
			fileContents = Files.lines(get(filePath)).collect(joining("\n"));
		} catch (IOException e) {
			fileContents = e.getClass().getSimpleName();
		}

		System.out.println("Contents of the file:\n" + fileContents);

	}

}
