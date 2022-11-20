package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Premium extends Consumer implements Buyable, Reproductionable{
	private ArrayList<Playlist> playlistsCreated;
	private ArrayList<Song> purchasedSongs;
	//methods
	public Premium(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate){
		super(id,nickname, ptReproduced, stReproduced, mlpUser, mlsUser, mlp, mls, vinculationdate);
		this.playlistsCreated = new ArrayList<Playlist>();
		this.purchasedSongs = new ArrayList<Song>();
	}
	public String buysong(Song song){
		purchasedSongs.add(song);
		String msg = "The song has been bought.";
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
	public Playlist getPlaylist(int list){
		Playlist p = (Playlist) playlistsCreated.get(list);
		return p;
	}
	public int getPlaylistSize(int list){
		Playlist p = playlistsCreated.get(list);
		int q = p.getContentSize(list);
		return q;
	}
}