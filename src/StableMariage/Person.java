package StableMariage;

import java.util.ArrayList;

public abstract class Person {
	protected String name;
	protected ArrayList<Person> preferences;
	protected boolean engaged;
	protected int id;

	public Person(int id, String name, ArrayList<Person> preferences, boolean engaged) {
		this.name = name;
		this.preferences = preferences;
		this.engaged = engaged;
		this.id=id;
		engaged = false;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
	
	public ArrayList getPreferenses(){
		return preferences;
	}
	
}
