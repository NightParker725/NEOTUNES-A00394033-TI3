package model;
import java.util.Calendar;
public class Standard extends Consumer implements Buyable, Reproductionable{
	//attributes
	private int boughtsongs;
	private int albumscreated;
	//methods
	public Standard(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate, int boughtsongs, int albumscreated){
		super(id,nickname, ptReproduced, stReproduced, mlpUser, mlsUser, mlp, mls, vinculationdate);
		this.boughtsongs = boughtsongs;
		this.albumscreated = albumscreated;
	}
	public String buysong(){
		String msg = "the song has been bought.";
		return msg;
	}
	public String reproduction(){
		String msg = "You are listening: Example....";
		return msg;
	}
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
