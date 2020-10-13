package com.vnpt.media.ottplus.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class CountFreqWords {

	public static boolean ASC = true; // Ascending order
	public static boolean DESC = false; // descending order

	public HashMap<String, Integer> frequencies(String directory) {

		// Declare the HashMap
		Map<String, Integer> frequencies = new LinkedHashMap<String, Integer>();

		try {
			File file = new File("F:/output.txt"); // create File object to read from
			try (Scanner scanner = new Scanner(file)) {

				while (scanner.hasNextLine()) { // while there is a next line
					String line = scanner.nextLine();

					// Split the line into a String array to loop through
					String[] words = line.split(" ");

					
					// for loop goes through every word
					for (String word : words) {
						if (!word.isEmpty()) {
							Integer frequency = frequencies.get(word);

							if (frequency == null) {
								frequency = 0;
							}

							++frequency;
							frequencies.put(word, frequency);
						}
					}
				}
			}

			System.out.println(frequencies);

			// Catching the file not found error
			// and any other errors
		} catch (FileNotFoundException fnfe) {
			System.err.println("File not found.");
		} catch (Exception e) {
			System.err.print(e);
		}

		return (HashMap<String, Integer>) frequencies;
	}

	// method for show map
	public static void show(Map<String, Integer> listMap) {
		Set<String> keySet = listMap.keySet();
		for (String key : keySet) {
			System.out.println(key + " : " + listMap.get(key));
		}
	}

	
	// method for sort map as descending order
	private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order) {

		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (order) {
					return o1.getValue().compareTo(o2.getValue());
				} else {
					return o2.getValue().compareTo(o1.getValue());

				}
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
	
	// method for search top result
	public static void searchTopResults (Map<String, Integer> sortedMap, String inputString) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        inputString = inputString.toLowerCase();
        
		List<String> lKeys = new ArrayList<>(sortedMap.keySet());
        Iterator<String> itKey = lKeys.iterator();

        int i = 0;
        while (itKey.hasNext()) {
            String key = itKey.next();
            if (key.startsWith(inputString)) {
                result.put(key, sortedMap.get(key));
                i++;
                if (i == 5) break;
            }
        }
        System.out.println(i + " kết quả ");
        show(result);	
    }
	

	public static void main(String args[]) throws FileNotFoundException {

		CountFreqWords countFreq = new CountFreqWords();
		Map<String, Integer> listMap = countFreq.frequencies("F:/output");

		Map<String, Integer> sortedMapDesc = sortByComparator(listMap, DESC);
		show(sortedMapDesc);
		
		String strSearch;
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("\nNhập vào từ cần tìm kiếm, exit để thoát ");
			    strSearch = scanner.nextLine();
			    if (strSearch.equals("exit")) break;
			    System.out.println("Tìm kiếm : \"" + strSearch + "\"");
			    searchTopResults((Map<String, Integer>) sortedMapDesc, strSearch );
			}
		}
		
	}

}
