package model;
import java.util.ArrayList;
public class Playlist{
	//attributes
	private String name;
	private int id;
	
	private ArrayList<Audio> audioSaved;
	//methods
	public Playlist(String name, int id){
		this.name = name;
		this.id = id;
		this.audioSaved = new ArrayList<Audio>();
	}
	public void saveAudio(Podcast pod){
		audioSaved.add(pod);
	}
	public void saveAudio(Song song){
		audioSaved.add(song);
	}
	public void removeContent(int audio){
		audioSaved.remove(audio);
	}
	public String showContent(){
		String msg = "Content:/n";
		String name = "";
		for(int i = 0; i < audioSaved.size(); i++){
			name = audioSaved.get(i).getname();
			msg = msg + i + " " + name + "/n";
		}
		return msg;
	}
	public Audio getContent(int num){
		Audio a = (Audio) audioSaved.get(num);
		return a;
	}
	public int getContentSize(int num){
		int a = audioSaved.size();
		return a;
	}
	//getters
	public String getname(){
		return name;
	}
	public int getid(){
		return id;
	}
	//setters
	public void setname(String name){
		this.name = name;
	}
	public void setid(int id){
		this.id = id;
	}
	
}