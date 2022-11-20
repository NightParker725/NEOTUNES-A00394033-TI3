package model;
public class Podcast extends Audio {
	//attributes
	private String description;
	
	private PodcastCategory category;
	//methods
	public Podcast(String name, String cover, double duration, int qReproduction, String description, int c){
		super(name, cover, duration, qReproduction);
		this.description = description;
		switch(c){
			case 1: category = PodcastCategory.POLITICS;
			break;
			case 2: category = PodcastCategory.ENTERTAIMENT;
			break;
			case 3: category = PodcastCategory.FASHION;
			break;
			case 4: category = PodcastCategory.VIDEOGAMES;
			break;
		}
	}
	//getters and setters
	public String getdescription(){
		return description;
	}
	public void setdescription(String description){
		this.description = description;
	}
	public PodcastCategory getcategory(){
		return category;
	}
	public void setcategory(PodcastCategory category){
		this.category = category;
	}
}