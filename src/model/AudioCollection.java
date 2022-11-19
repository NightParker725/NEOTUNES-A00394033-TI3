package model;
import java.util.ArrayList;
import java.util.Calendar; 
public class AudioCollection{
	//relations
	private ArrayList<Audio> library; 
	private ArrayList<User> users;
	//methods
	public AudioCollection(){
	 this.library= new ArrayList<Audio>();
	 this.users= new ArrayList<User>();
	}
	public String addUser(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate,int option){
		String msg = "";
		if(!searchUser(nickname,id)){
			if (option==1){
				 users.add(new Standard(id,nickname,ptReproduced,stReproduced,mlpUser,mlsUser,mlp,mls,vinculationdate,0,0));
			}
			else{
				 users.add(new Premium(id,nickname,ptReproduced,stReproduced,mlpUser,mlsUser,mlp,mls,vinculationdate));
			}
			msg = "The user was registered successfully.";
		}else{
			msg = "The user already exist.";
		}
		return msg;
	}
	public String addUser(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate,int opt){
		String msg = "";
		if(!searchUser(nickname,id)){
			if (opt==1){
				 users.add(new Artist(id, nickname, vinculationdate, name, photo, numvisualizations));
			}else{
				 users.add(new CreatorContent(id, nickname, vinculationdate, name, photo, numvisualizations));
			}
			msg = "The user was registered successfully.";
		}else{
			msg = "The user already exist.";
		}
		return msg;
	}
	public boolean searchUser(String nickname,String id){
	boolean exist= false; 
	for (int i=0; i<users.size() && !exist; i++){
			if(users.get(i).getnickname().equalsIgnoreCase(nickname) && users.get(i).getid().equalsIgnoreCase(id)){
				exist=true;
			}
	}
	return exist;
	}
	public String addContent(String nickname,String name,String cover,double duration,int qReproduction,String album,double value,int unitssold,int genre){
		String msg = "Cannot register content";
		String id = "";
		for(int i = 0; i<users.size(); i++){
			id = users.get(i).getid();
			if(users.get(i) instanceof Artist && searchUser(nickname, id)){
				Artist user = (Artist)users.get(i);
				library.add(new Song(name,cover,duration,qReproduction,album,value,unitssold,genre));
				user.addSong(name,cover,duration,qReproduction,album,value,unitssold,genre);
				msg = "The song was registered successfully.";
			}
		}
		return msg;
	}
	public String addContent(String nickname,String name,String cover,double duration,int qReproduction,String description,int category){
		String msg = "Cannot register content";
		String id = "";
		for(int i = 0; i<users.size(); i++){
			id = users.get(i).getid();
			if(users.get(i) instanceof CreatorContent && searchUser(nickname, id)){
				CreatorContent user = (CreatorContent)users.get(i);
				library.add(new Podcast(name,cover,duration,qReproduction,description,category));
				user.addSong(name,cover,duration,qReproduction,description,category);
				msg = "The Podcast was registered successfully.";
			}
		}
		return msg;
	}
	//the id is 0 meanwhile.
	public String addPlaylist(String nickname,String name,int id){
		String msg ="Cannot create playlist.";
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				msg = user.addPlaylist(name,id);
			}
		}
		return msg;
	}
	public String showPlaylists(String nickname){
		String msg = "";
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				msg = user.showPlaylists();
			}		
		}
		return msg;
	}
	public String showAudios(){
		String msg = "";
		for(int i = 0; i < library.size(); i++){
			msg = msg + i + library.get(i).getname() + "\n";
		}
		return msg;
	}
	public String addPlaylistContent(int playlist,int pos,String nickname){
		String msg="Content added successfully.";
		if(library.get(pos)!=null){
			if(library.get(pos) instanceof Song){
				Song song= (Song) library.get(pos);	
				for(int i = 0; i < users.size(); i++){
					if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
						Consumer user = (Consumer) users.get(i);
						user.addPlaylistContent(playlist,song);
					}		
				}
			}
			else{
				Podcast pod = (Podcast) library.get(pos);
				for(int i = 0; i < users.size(); i++){
					if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
						Consumer user = (Consumer) users.get(i);
						user.addPlaylistContent(playlist,pod);
					}
				}
			}
		}
		return msg;
	}
	public String showPlaylistContent(String nickname, int playlist){
		String msg = "";
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				msg = user.showPlaylistContent(playlist);
			}
		}
		return msg;
	}
	public String removePlaylistContent(int playlist,int pos,String nickname){
		String msg = "Content removed succesfully.";
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				user.removePlaylistContent(playlist,pos);
			}
		}
		return msg;
	}
}