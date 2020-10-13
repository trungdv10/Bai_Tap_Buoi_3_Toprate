package com.vnpt.media.ottplus.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CountUinqueWords {

	public static void main(String args[]) throws FileNotFoundException {

		File f = new File("F:/output.txt");
		
		List<String> arrString = new ArrayList<String>();
		
		HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();
		
		// using Scanner to read file
		try (Scanner input = new Scanner(f)) {
			int i = 0;
			
			// add every element into List String
			while (input.hasNext()) {
				String s = input.next();
				arrString.add(s);
			}
			
			// go through every element of List
			Iterator<String> itr = arrString.iterator();
			while (itr.hasNext()) {
				i++;
				listOfWords.put((String) itr.next(), i);
			}
		}
		
		// create Set for stored values of hashmap
		Set<Object> uniqueValues = new HashSet<Object>(listOfWords.values());

		System.out.println("The number of unique words: " + uniqueValues.size());

	}

}
