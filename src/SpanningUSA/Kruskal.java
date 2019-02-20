package SpanningUSA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {

	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	public static HashMap<String,Town> towns = new HashMap<String,Town>();

	public static void main(String[] args) throws IOException {
		Parser parser = new Parser();
		parser.generateLists(args[0]);
		ArrayList<Town> townsVisited = new ArrayList<Town>();
		int i = 0;
		int totalDistance = 0;
		Collections.sort(edges);

		// Lägg till start-staden
		while (i <= edges.size() - 1) {
			Edge e = edges.get(i);
			Town t1 = e.town1();
			Town t2 = e.town2();
			if (!townsVisited.contains(t1) && !townsVisited.contains(t2)) {
				townsVisited.add(t1);
				townsVisited.add(t2);
				t1.connectTowns(t2);
				totalDistance += e.distance();

			} else if (!townsVisited.contains(t1) && townsVisited.contains(t2)) {
				t1.connectTowns(t2);
				townsVisited.add(t1);
				totalDistance += e.distance();

			} else if (!townsVisited.contains(t2) && townsVisited.contains(t1)) {
				t1.connectTowns(t2);
				townsVisited.add(t2);
				totalDistance += e.distance();

			} else if (townsVisited.contains(t1) && townsVisited.contains(t2)) {
				if (!t1.connected(t2)) {
					t1.connectTowns(t2);
					totalDistance += e.distance();
				}

			}

			i++;
		}
		System.out.println("Total Distance: " + totalDistance);
	}
}