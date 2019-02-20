package StableMariage;

import java.util.ArrayList;

public class Man extends Person {
	private Woman partner;

	public Man(int id, String name, Woman partner, ArrayList<Person> preferences,
			boolean engaged) {
		super(id, name, preferences, engaged);
		this.partner=partner;
	}


	public Woman getPreferedWoman() {
		Woman w = (Woman) preferences.get(0);
		preferences.remove(0);
		return w;
	}
	
	public void setPreferedWoman(Woman w){
		preferences.add(w);
	}
	
	public void setPartner( Woman w){
		partner=w;
		engaged = true;
	}


	public Person getPartner() {
		return partner;
	}
}
