package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Premium extends Consumer implements Buyable, Reproductionable{
	private ArrayList<Playlist> playlistsCreated;
	private ArrayList<Song> purchasedSongs;
	//methods
	/**
	<br> Name: Premium
	<br> @param: String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate
	<br> @return: void
	<br> Process: creates the premium object
	*/
	public Premium(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate){
		super(id,nickname, ptReproduced, stReproduced, mlpUser, mlsUser, mlp, mls, vinculationdate);
		this.playlistsCreated = new ArrayList<Playlist>();
		this.purchasedSongs = new ArrayList<Song>();
	}
	/**
	<br> Name: buysong
	<br> @param: Song song
	<br> @return: String msg
	<br> Process: adds a song to the buyed songs
	*/
	public String buysong(Song song){
		purchasedSongs.add(song);
		String msg = "The song has been bought.";
		return msg;
	}
	/**
	<br> Name: reproduction
	<br> @param: Song song
	<br> @return: String msg
	<br> Process: reproduce a song
	*/
	public String reproduction(Song song){
		String msg = "You are listening: "+"      "+song.getname()+"\n"
		+"From the album: "+"            "+song.getalbum()+"\n"
		+"Genre: "+"                     "+song.getgenre()+"\n";
		return msg;
	}
		/**
	<br> Name: reproduction
	<br> @param: Podcast podcast
	<br> @return: String msg
	<br> Process: reproduce a podcast
	*/
	public String reproduction(Podcast podcast){
		String msg = "You are listening: "+"      "+podcast.getname()+"\n"
		+"Description: "+"               "+podcast.getdescription()+"\n"
		+"Category: "+"                  "+podcast.getcategory()+"\n";
		return msg;
	}
		/**
	<br> Name: addPlaylist
	<br> @param: String name, int id
	<br> @return: String msg
	<br> Process: add a playlist to a user consumer
	*/
	public String addPlaylist(String name,int id){
		String msg = "The playlist was created succesfully.";
		playlistsCreated.add(new Playlist(name,id));
		return msg;
	}
		/**
	<br> Name: addPlaylistContent
	<br> @param: int playlist, Song song
	<br> @return: void
	<br> Process: add a song content to a playlist
	*/
	public void addPlaylistContent(int playlist,Song song){
		playlistsCreated.get(playlist).saveAudio(song);
	}
	/**
	<br> Name: addPlaylistContent
	<br> @param: int playlist, Podcast podcast
	<br> @return: void
	<br> Process: add a podcast content to a playlist
	*/
	public void addPlaylistContent(int playlist,Podcast newpodcast){
		playlistsCreated.get(playlist).saveAudio(newpodcast);
	}
		/**
	<br> Name: showPlaylists
	<br> @param: void
	<br> @return: String msg
	<br> Process: Shows the created playlists 
	*/
	public String showPlaylists(){
		String msg = "", playlists = "";
		for(int i = 0 ; i < playlistsCreated.size(); i++){
			playlists = playlistsCreated.get(i).getname();
			msg = msg + (i+1) + " " + playlists + "\n";
		}
		return msg;
	}
		/**
	<br> Name: showPlaylistContent
	<br> @param: int playlist
	<br> @return: String msg
	<br> Process: shows the content in a playlist
	*/
	public String showPlaylistContent(int playlist){
		String msg = "";
		msg = playlistsCreated.get(playlist).showContent();
		return msg;
	}
		/**
	<br> Name: removePlaylistContent
	<br> @param: int playlist, int num
	<br> @return: void
	<br> Process: remove a content from a playlist
	*/
	public void removePlaylistContent(int playlist,int num){
		playlistsCreated.get(playlist).removeContent(num);
	}
		/**
	<br> Name: getPlaylist
	<br> @param: int list
	<br> @return: Playlist p
	<br> Process: gets a specific playlist
	*/
	public Playlist getPlaylist(int list){
		Playlist p = (Playlist) playlistsCreated.get(list);
		return p;
	}
		/**
	<br> Name: getPlaylistSize
	<br> @param: int list
	<br> @return: int q
	<br> Process: gets the size of a playlist
	*/
	public int getPlaylistSize(int list){
		Playlist p = playlistsCreated.get(list);
		int q = p.getContentSize(list);
		return q;
	}
}