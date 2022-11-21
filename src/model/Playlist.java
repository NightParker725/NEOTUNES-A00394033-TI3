package model;
import java.util.ArrayList;
public class Playlist{
	//attributes
	private String name;
	private int id;
	
	private ArrayList<Audio> audioSaved;
	//methods
	/** 
	<br> Name: Playlist
	<br> @param: String name, int id
	<br> @return: void
	<br> Process: creates the playlist object
	*/
	public Playlist(String name, int id){
		this.name = name;
		this.id = id;
		this.audioSaved = new ArrayList<Audio>();
	}
	/** 
	<br> Name: saveAudio
	<br> @param: Podcast pod
	<br> @return: void
	<br> Process: saves an audio type podcast in the playlist
	*/
	public void saveAudio(Podcast pod){
		audioSaved.add(pod);
	}
	/**
	<br> Name: saveAudio
	<br> @param: Song song
	<br> @return: void
	<br> Process: saves an audio type song in the playlist
	*/
	public void saveAudio(Song song){
		audioSaved.add(song);
	}
	/**
	<br> Name: removeContent
	<br> @param: int audio
	<br> @return: void
	<br> Process: removes an audio from the playlist
	*/
	public void removeContent(int audio){
		audio--;
		audioSaved.remove(audio);
	}
		/**
	<br> Name: showContent
	<br> @param: void
	<br> @return: String msg
	<br> Process: shows the content from the playlist
	*/
	public String showContent(){
		String msg = "Content:\n";
		String name = "";
		for(int i = 0; i < audioSaved.size(); i++){
			name = audioSaved.get(i).getname();
			msg = msg + (i+1) + " " + name + "\n";
		}
		return msg;
	}
		/**
	<br> Name: getContent
	<br> @param: int num
	<br> @return: Audio a
	<br> Process: gets a specific audio from the playlist
	*/
	public Audio getContent(int num){
		Audio a = (Audio) audioSaved.get(num);
		return a;
	}
		/**
	<br> Name: getContentSize
	<br> @param: int num
	<br> @return: int a
	<br> Process: gets the size of the playlist content
	*/
	public int getContentSize(int num){
		int a = audioSaved.size();
		return a;
	}
	//getters
		/**
	<br> Name: getname
	<br> @param: void
	<br> @return: String name
	<br> Process: gets name
	*/
	public String getname(){
		return name;
	}
		/**
	<br> Name: getid
	<br> @param: void
	<br> @return: String id
	<br> Process: gets id
	*/
	public int getid(){
		return id;
	}
	//setters
		/**
	<br> Name: setname
	<br> @param: String name
	<br> @return: void
	<br> Process: sets name
	*/
	public void setname(String name){
		this.name = name;
	}
	/**
	<br> Name: setid
	<br> @param: String id
	<br> @return: void
	<br> Process: sets id
	*/
	public void setid(int id){
		this.id = id;
	}
	
}