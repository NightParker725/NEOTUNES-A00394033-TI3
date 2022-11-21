package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Artist extends Producer {
	private ArrayList<Song> songsCreated;
	//methods
	/** 
	<br> Name: Artist
	<br> @param: String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations
	<br> @return: void
	<br> Process: creates the Artist object
	*/
	public Artist(String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
		this.songsCreated = new ArrayList<Song>();
	}
	/** 
	<br> Name: addSong
	<br> @param: String name,String cover,double duration,int qReproduction,String album,double value,int unitsSold, int g
	<br> @return: void
	<br> Process: adds a song to the artist
	*/
	public void addSong(String name,String cover,double duration,int qReproduction,String album,double value,int unitsSold, int g){
		songsCreated.add(new Song(name,cover,duration,qReproduction,album,value,unitsSold,g));
	}
}