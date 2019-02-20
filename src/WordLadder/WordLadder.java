package WordLadder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WordLadder {
	public static void main(String[] args) {

		String inputFileName = args[1];
		File file = new File(inputFileName);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}

		Parser parser = new Parser();
		HashMap<String, HashSet<String>> neighbours = parser.readFile(args[0]);

		while (scan.hasNext()) {
			String s = scan.nextLine();
			String[] inputWords = s.split(" ");
			String current = inputWords[0];
			String goal = inputWords[1];
			boolean found = false;
			if (current.equals(goal)) {
				System.out.println(0);
				found=true;
			}
			HashSet<String> visited = new HashSet<String>();
			HashSet<String> visiting = new HashSet<String>();
			HashSet<String> next = new HashSet<String>();

			visiting = (HashSet<String>) neighbours.get(current).clone();

			visited.add(current);
			int amountOfSteps = 0;
			while (!visiting.isEmpty()&&!found) {
				amountOfSteps++;
				for (String s1 : visiting) {
					if (s1.equals(goal)) {
						System.out.println(amountOfSteps);
						found = true;
					}

					next.addAll(neighbours.get(s1));
				}
				if(found)	{
					break;
				}
				visited.addAll(visiting);
				visiting = (HashSet<String>) next.clone();
				next = new HashSet<String>();
				visiting.removeAll(visited);
			}
			if(!found)	 {
				System.out.println(-1);
			}
		}
	}
}
