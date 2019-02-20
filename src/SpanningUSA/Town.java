package SpanningUSA;

import java.util.ArrayList;

public class Town {
	private String name;
	private ArrayList<Town> connectedTo;

	public Town(String name, ArrayList<Town> conectedTo) {
		this.name = name;
		this.connectedTo = conectedTo;
	}

	public boolean connected(Town t) {
		for (Town town : connectedTo) {
			if (!t.connectedTo.contains(town)) {
				return false;
			}
		}
		return true;
	}
	
	public String getName(){
		return name;
	}

	public void connectTowns(Town t) {
		connectedTo.add(t);
		t.connectedTo.add(this);
		for (Town town : t.connectedTo) {
			if (!connectedTo.contains(town)) {
				connectedTo.add(town);
			}
		}
		for (Town tt : connectedTo) {
			tt.connectedTo = connectedTo;
		}
	}
}
