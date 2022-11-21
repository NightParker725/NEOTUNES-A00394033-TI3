package model;
public class Podcast extends Audio {
	//attributes
	private String description;
	
	private PodcastCategory category;
	//methods
		/** 
	<br> Name: Podcast
	<br> @param: String name, String cover, double duration, int qReproduction, String description, int c
	<br> @return: void
	<br> Process: creates the podcasts object
	*/
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
		/** 
	<br> Name: getdescription
	<br> @param: void
	<br> @return: String description
	<br> Process: gets description
	*/
	public String getdescription(){
		return description;
	}
			/** 
	<br> Name: setdescription
	<br> @param: String description
	<br> @return: void
	<br> Process: sets description
	*/
	public void setdescription(String description){
		this.description = description;
	}
		/** 
	<br> Name: getcategory
	<br> @param: void
	<br> @return: PodcastCategory category
	<br> Process: gets category
	*/
	public PodcastCategory getcategory(){
		return category;
	}
		/** 
	<br> Name: setcategory
	<br> @param: PodcastCategory category
	<br> @return: void
	<br> Process: sets category
	*/
	public void setcategory(PodcastCategory category){
		this.category = category;
	}
}