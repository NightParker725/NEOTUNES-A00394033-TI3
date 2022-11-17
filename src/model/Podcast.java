package model;
public class Podcast extends Audio {
	//attributes
	private String description;
	//methods
	public Podcast(String name, String cover, double duration, int qReproduction, String description){
		super(name, cover, duration, qReproduction);
		this.description = description;
	}
	public String getdescription(){
		return description;
	}
	public void setdescription(String description){
		this.description = description;
	}
}