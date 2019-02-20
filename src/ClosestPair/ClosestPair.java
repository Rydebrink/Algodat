package ClosestPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClosestPair {

	public static ArrayList<Point> allPoints = new ArrayList<Point>();

	public static void main(String[] args) {
		// n
		parse(args[0]);
		ClosestDistanceFinder solver = new ClosestDistanceFinder();
		// n*log(n)²
		Pair closestPair = solver.closestPair(allPoints);
		System.out.print(allPoints.size() + " ");
		System.out.print(closestPair.getDistance());
		System.out.print(" [" +closestPair.getP1()+ "--" +closestPair.getP2()+ "]");
		System.out.println();
	}

	private static void parse(String fileName) {
		File file = new File(fileName);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found, program closed");
			System.exit(0);
		}
		String name = scan.next();
		while (!name.equals("1") && !name.equals("0")) {
			name = scan.next();
		}
		// n
		while (scan.hasNext()) {
			String curX = scan.next();
			String curY = scan.next();
			allPoints.add(new Point(name, curX, curY));
			if (scan.hasNext()) {
				name = scan.next();
			}
			if (name.equals("EOF")) {
				break;
			}
		}
	}
}
