package StableMariage;

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
			if (!line.isEmpty()) {
				if (line.charAt(0) != '#' && line.charAt(0) != 'n') {
					String[] array = line.split(" ");
					if (array.length == 2) {
						int id = Integer.parseInt(array[0]);
						if (id % 2 == 1) {
							StableMariage.men.add(new Man(id, array[1], null,
									new ArrayList<Person>(), false));
						} else {
							StableMariage.women.add(new Woman(id, array[1], null,
									new ArrayList<Person>(), false));
						}
					} else {

						setPreferenses(array, StableMariage.men, StableMariage.women);
					}
				}
			}
			line = br.readLine();
		}
	}
	private static void setPreferenses(String[] array, ArrayList<Man> men,
			ArrayList<Woman> women) {
		int colon = array[0].indexOf(':');
		String s = array[0].substring(0, colon);
		int id = Integer.parseInt(s);
		if (id % 2 == 1) {
			Man m = getMan(id, men);
			for (int i = 1; i < array.length; i++) {
				m.setPreferedWoman(getWoman(Integer.parseInt(array[i]), women));
			}
		} else {
			Woman w = getWoman(id, women);
			for (int i = 1; i < array.length; i++) {
				w.setPreferedMan(getMan(Integer.parseInt(array[i]), men));
			}
		}
	}

	private static Woman getWoman(int id, ArrayList<Woman> women) {
		for (Woman w : women) {
			if (w.getId() == id) {
				return w;
			}
		}
		return null;
	}

	private static Man getMan(int id, ArrayList<Man> men) {
		for (Man m : men) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}
}
