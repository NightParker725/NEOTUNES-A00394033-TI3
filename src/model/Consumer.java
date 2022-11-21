package model;
import java.util.Calendar;
public abstract class  Consumer extends User{
	//attributes
	private double stReproduced;
	private double ptReproduced;
	private String mlpUser;
	private String mlsUser;
	private String mlp;
	private String mls;
	//methods
	/** 
	<br> Name: Consumer
	<br> @param: String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate
	<br> @return: void
	<br> Process: creates the Consumer
	*/
	public Consumer(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate){
		super(id,nickname,vinculationdate);
		this.ptReproduced=ptReproduced;
		this.stReproduced=stReproduced;
		this.mlpUser=mlpUser;
		this.mlsUser=mlsUser;
		this.mlp=mlp;
		this.mls=mls;
	}
	//getters and setters
		/** 
	<br> Name: getStReproduced
	<br> @param: void
	<br> @return: double stReproduced
	<br> Process: gets stReproduced
	*/
	public double getStReproduced(){
		return stReproduced;
	}	
	/** 
	<br> Name: setStReproduced
	<br> @param: double stReproduced
	<br> @return: void
	<br> Process: sets setStReproduced
	*/
	public void setStReproduced(double stReproduced){
		this.stReproduced = stReproduced;
	}
	/** 
	<br> Name: getPtReproduced
	<br> @param:  void
	<br> @return: double ptReproduced
	<br> Process: gets ptReproduced
	*/
	public double getPtReproduced(){
		return ptReproduced;
	}
		/** 
	<br> Name: setPtReproduced
	<br> @param: double ptReproduced
	<br> @return: void
	<br> Process: sets ptReproduced
	*/
	public void setPtReproduced(double ptReproduced){
		this.ptReproduced = ptReproduced;
	}
		/** 
	<br> Name: getMlpUser
	<br> @param: void
	<br> @return: String mlpUser
	<br> Process: gets mlpUser
	*/
	public String getMlpUser(){
		return mlpUser;
	}
		/** 
	<br> Name: setMlpUser
	<br> @param: String mlpUser
	<br> @return: void
	<br> Process: sets mlpUser
	*/
	public void setMlpUser(String mlpUser){
		this.mlpUser = mlpUser;
	}
		/** 
	<br> Name: getMlsUser
	<br> @param: void
	<br> @return: String mlsUser
	<br> Process: gets mlsUser
	*/
	public String getMlsUser(){
		return mlsUser;
	}
		/** 
	<br> Name: setMlsUser
	<br> @param: String mlsUser
	<br> @return: void
	<br> Process: sets mlsUser
	*/
	public void setMlsUser(String mlsUser){
		this.mlsUser = mlsUser;
	}
		/** 
	<br> Name: getMlp
	<br> @param: void
	<br> @return: String mlp
	<br> Process: gets mlp
	*/
	public String getMlp(){
		return mlp;
	}
		/** 
	<br> Name: setMlp
	<br> @param: String mlp
	<br> @return: void
	<br> Process: sets mlp
	*/
	public void setMlp(String mlp){
		this.mlp = mlp;
	}
		/** 
	<br> Name: getMls
	<br> @param: void
	<br> @return: String mls
	<br> Process: get mls
	*/
	public String getMls(){
		return mls;
	}
		/** 
	<br> Name: setMls
	<br> @param: String mls
	<br> @return: void
	<br> Process: sets mls
	*/
	public void setMls(String mls){
		this.mls = mls;
	}
	public abstract String addPlaylist(String name,int id);
	public abstract String showPlaylists();
	public abstract void addPlaylistContent(int playlist,Song song);
	public abstract void addPlaylistContent(int playlist,Podcast pod);
	public abstract String showPlaylistContent(int playlist);
	public abstract void removePlaylistContent(int playlist,int num);
	public abstract Playlist getPlaylist(int playlist);
	public abstract int getPlaylistSize(int playlist);
}