package StableMariage;

import java.util.ArrayList;

public class Woman extends Person {
	private Man partner;
	
	public Woman(int id, String name, Man partner, ArrayList<Person> preferences,
			boolean engaged) {
		super(id, name, preferences, engaged);
		this.partner=partner;
	}

	public boolean prefers(Man m) {
		if(preferences.indexOf(partner)>preferences.indexOf(m)){
			partner.engaged=false;
			return true;
		}
		return false;
	}
	
	public void setPartner(Man m){
		partner = m;
		engaged =true;
	}
	
	public Man getPartner(){
		return partner;
	}
	
	public void setPreferedMan(Man m){
		preferences.add(m);
	}

}
