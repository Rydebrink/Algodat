package StableMariage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StableMariage {

	public static ArrayList<Man> men = new ArrayList<Man>();
	public static ArrayList<Woman> women = new ArrayList<Woman>();

	public static void main(String[] args) throws IOException {

		Parser parser = new Parser();
		parser.generateLists(args[0]);

		while (!men.isEmpty() && !allMenEngaged()) {
			for (Man m : men) {
				while (!m.engaged) {
					Woman w = m.getPreferedWoman();
					if (!w.engaged) {
						w.setPartner(m);
						m.setPartner(w);
					} else if (w.prefers(m)) {
						w.setPartner(m);
						m.setPartner(w);
					}
				}
			}
		}

		for (Man m : men) {
			System.out.println( m.getName()+ " -- " +m.getPartner().getName());
		}
	}

	private static boolean allMenEngaged() {
		for (Man m : men) {
			if (!m.engaged) {
				return false;
			}
		}
		return true;
	}

}
