package SpanningUSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	public Parser() throws IOException {
	}

	public void generateLists(String filepath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line = br.readLine();
		while (line != null) {
			line = line.replaceAll("\"", "");
			String[] array = line.split("--| \\[");

			if (array.length > 1) {
				array[2] = array[2].substring(0, array[2].length() - 1);
				Town t1 = Kruskal.towns.get(array[0]);
				Town t2 = Kruskal.towns.get(array[1]);
				int distance = Integer.parseInt(array[2]);
				Edge e = new Edge(t1, t2, distance);
				Kruskal.edges.add(e);
			} else {
				line = line.trim();	
//				line = line.substring(0, line.length()-1);
				Town t = new Town(line, new ArrayList<Town>());
				Kruskal.towns.put(line, new Town(array[0], new ArrayList<Town>()));
			}

			line = br.readLine();
		}
		br.close();
	}
}