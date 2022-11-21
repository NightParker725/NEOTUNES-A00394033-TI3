package model;
import java.util.Calendar;
import java.util.ArrayList;
import java.lang.Math;
public class Standard extends Consumer implements Buyable, Reproductionable{
	//attributes
	private int boughtsongs;
	private int albumscreated;
	
	private ArrayList<Song> purchasedSongs;
	private ArrayList<Playlist> playlistsCreated;
	//methods
		/**
	<br> Name: Standard
	<br> @param: String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate, int boughtsongs, int albumscreated
	<br> @return: void
	<br> Process: creates a Standard object
	*/
	public Standard(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate, int boughtsongs, int albumscreated){
		super(id,nickname, ptReproduced, stReproduced, mlpUser, mlsUser, mlp, mls, vinculationdate);
		this.boughtsongs = boughtsongs;
		this.albumscreated = albumscreated;
		this.playlistsCreated = new ArrayList<Playlist>();
		this.purchasedSongs = new ArrayList<Song>();
	}
		/**
	<br> Name: advertise
	<br> @param: void
	<br> @return: String msg
	<br> Process: makes an advertise to the standard user consumer
	*/
	public String advertise(){
		String msg = "";
		int num = 0;
		num =(int)Math.random()*4;
		switch(num){
			case 1:
				msg = Advertise.NIKE.getbrand();
			break;
			case 2:
				msg = Advertise.MYMS.getbrand();
			break;
			case 3:
				msg = Advertise.COCACOLA.getbrand();
			break;
			default:
				msg = Advertise.UBISOFT.getbrand();
			break;
		}
		return msg;
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
	public Playlist getPlaylist(int playlist){
		Playlist p = (Playlist) playlistsCreated.get(playlist);
		return p;
	}
		/**
	<br> Name: getPlaylistSize
	<br> @param: int list
	<br> @return: int q
	<br> Process: gets the size of a playlist
	*/
	public int getPlaylistSize(int list){
		Playlist p = (Playlist) playlistsCreated.get(list);
		int q = p.getContentSize(list);
		return q;
	}
	//getters and setters
		/**
	<br> Name: getboughtsongs
	<br> @param: void
	<br> @return: int boughtsongs
	<br> Process: gets boughtsongs
	*/
	public int getboughtsongs(){
		return boughtsongs;
	}
	/**
	<br> Name: getalbumscreated
	<br> @param: void
	<br> @return: int albumscreated
	<br> Process: gets albumscreated
	*/
	public int getalbumscreated(){
		return albumscreated;
	}
	/**
	<br> Name: setalbumscreated
	<br> @param: int albumscreated
	<br> @return: void
	<br> Process: sets albumscreated
	*/
	public void setalbumscreated(int albumscreated){
		this.albumscreated = albumscreated;
	}
		/**
	<br> Name: setboughtsongs
	<br> @param: int boughtsongs
	<br> @return: void
	<br> Process: sets boughtsongs
	*/
	public void setboughtsongs(int boughtsongs){
		this.boughtsongs = boughtsongs;
	}
}
