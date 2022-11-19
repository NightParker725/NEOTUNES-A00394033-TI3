package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Standard extends Consumer implements Buyable, Reproductionable{
	//attributes
	private int boughtsongs;
	private int albumscreated;
	
	private ArrayList<Playlist> playlistsCreated;
	//methods
	public Standard(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate, int boughtsongs, int albumscreated){
		super(id,nickname, ptReproduced, stReproduced, mlpUser, mlsUser, mlp, mls, vinculationdate);
		this.boughtsongs = boughtsongs;
		this.albumscreated = albumscreated;
		this.playlistsCreated = new ArrayList<Playlist>();
	}
	public String buysong(){
		String msg = "the song has been bought.";
		return msg;
	}
	public String reproduction(){
		String msg = "You are listening: Example....";
		return msg;
	}
		public String addPlaylist(String name,int id){
		String msg = "The playlist was created succesfully.";
		playlistsCreated.add(new Playlist(name,id));
		return msg;
	}
	public void addPlaylistContent(int playlist,Song song){
		playlistsCreated.get(playlist).saveAudio(song);
	}
	public void addPlaylistContent(int playlist,Podcast newpodcast){
		playlistsCreated.get(playlist).saveAudio(newpodcast);
	}
	public String showPlaylists(){
		String msg = "", playlists = "";
		for(int i = 0 ; i < playlistsCreated.size(); i++){
			playlists = playlistsCreated.get(i).getname();
			msg = msg + i + " " + playlists + "\n";
		}
		return msg;
	}
	public String showPlaylistContent(int playlist){
		String msg = "";
		msg = playlistsCreated.get(playlist).showContent();
		return msg;
	}
	public void removePlaylistContent(int playlist,int num){
		playlistsCreated.get(playlist).removeContent(num);
	}
	//getters and setters
	public int getboughtsongs(){
		return boughtsongs;
	}
	public int getalbumscreated(){
		return albumscreated;
	}
	public void setalbumscreated(int albumscreated){
		this.albumscreated = albumscreated;
	}
	public void setboughtsongs(int boughtsongs){
		this.boughtsongs = boughtsongs;
	}
}
