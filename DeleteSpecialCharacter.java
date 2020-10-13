package com.vnpt.media.ottplus.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeleteSpecialCharacter {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("F:/input.txt"); // create File object to read from
		try (Scanner scanner = new Scanner(file)) {
			try (PrintWriter writer = new PrintWriter("F:/output.txt")) {
				while (scanner.hasNextLine()) { // while there is a next line
					String line = scanner.nextLine();

					// do something with that line
					String newLine = "";

					// replace a character
					// 32 is space character
					// 65-90 is from "A" to "Z"
					// 97-122 is from "a" to "z"
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == 32 || line.charAt(i) >= 65 && line.charAt(i) <= 90
								|| line.charAt(i) >= 97 && line.charAt(i) <= 122) { // or anything other character you
																					// chose
							newLine += line.charAt(i);
						}
					}

					// print to another file.
					writer.println(newLine);
				}
			}
		}

	}

}
