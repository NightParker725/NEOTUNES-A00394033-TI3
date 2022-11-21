package model;
import java.util.Calendar;
import java.util.ArrayList;
public class CreatorContent extends Producer {
	private ArrayList<Podcast> podcastCreated;
	//methods
		/** 
	<br> Name: CreatorContent
	<br> @param: String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations
	<br> @return: void
	<br> Process: creates the creatorContent object
	*/
	public CreatorContent(String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
		this.podcastCreated = new ArrayList<Podcast>();
	}
		/** 
	<br> Name: addSong
	<br> @param: String name,String cover,double duration,int qReproduction,String description,int category
	<br> @return: void
	<br> Process: adds a song to the creatorContent
	*/
	public void addSong(String name,String cover,double duration,int qReproduction,String description,int category){
		podcastCreated.add(new Podcast(name,cover,duration,qReproduction,description,category));
	}
}