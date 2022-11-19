package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Artist extends Producer {
	private ArrayList<Song> songsCreated;
	//methods
	public Artist(String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
		this.songsCreated = new ArrayList<Song>();
	}
	public void addSong(String name,String cover,double duration,int qReproduction,String album,double value,int unitsSold, int g){
		songsCreated.add(new Song(name,cover,duration,qReproduction,album,value,unitsSold,g));
	}
}