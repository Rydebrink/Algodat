package WordLadder;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Parser {

	HashSet<String> allWords;
	HashMap<String, HashSet<String>> neighbours;

	public Parser() {
	}

	public HashMap<String, HashSet<String>> readFile(String fileName) {
		File file = new File(fileName);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(0);
		}

		allWords = new HashSet<String>();
		while (scan.hasNext()) {
			allWords.add(scan.nextLine());
		}

		neighbours = new HashMap<String, HashSet<String>>();
		for (String s : allWords) {
			neighbours.put(s, findNeighbours(s));
		}
		return neighbours;
	}

	private HashSet<String> findNeighbours(String input) {
		HashSet<String> neighbours = new HashSet<String>();
		String word = input.substring(1);
		char[] compareChars = word.toCharArray();

		for (String s : allWords) {
			if(s.equals(input))	{
				continue;
			}
			StringBuffer sb = new StringBuffer(s);
			if (matches(sb, compareChars)) {
				neighbours.add(s);
			}
		}

		return neighbours;
	}

	private boolean matches(StringBuffer sb, char[] inputChars) {
		for (char c : inputChars) {
			int i = sb.indexOf(Character.toString(c));
			if (i > -1) {
				sb.deleteCharAt(i);
			} else {
				return false;
			}

		}
		return true;
	}

}
