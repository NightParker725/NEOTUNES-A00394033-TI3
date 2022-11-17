package model;
import java.util.ArrayList;
import java.util.Calendar; 
public class NeotunesController{
	//relations
	private ArrayList<Audio> audiocollection; 
	private ArrayList<User> users;
	//methods
	public NeotunesController(){
	 this.audiocollection= new ArrayList<Audio>();
	 this.users= new ArrayList<User>();
	}
	public String addUser(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate,int option){
		String message="";
		if(!searchUser(nickname,id)){
			if (option==1){
				 users.add(new Standard(id,nickname,ptReproduced,stReproduced,mlpUser,mlsUser,mlp,mls,vinculationdate,0,0));
			}
			else{
				 users.add(new Premium(id,nickname,ptReproduced,stReproduced,mlpUser,mlsUser,mlp,mls,vinculationdate));
			}
			message="The user was registered successfully.";
		}else{
			message="The user already exist.";
		}
		return message;
	}
	public String addUser(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate,int opt){
		String message="";
		if(!searchUser(nickname,id)){
			if (opt==1){
				 users.add(new Artist(id, nickname, vinculationdate, name, photo, numvisualizations));
			}else{
				 users.add(new CreatorContent(id, nickname, vinculationdate, name, photo, numvisualizations));
			}
			message="The user was registered successfully.";
		}else{
			message="The user already exist.";
		}
		return message;
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
	public String addContent(String name,String cover,double duration,int qReproduction,String album,double value,int unitssold){
		String message="";
			audiocollection.add(new Song(name,cover,duration,qReproduction,album,value,unitssold));
			message="The song was registered successfully.";
		return message;
	}
	public String addContent(String name,String cover,double duration,int qReproduction,String description){
		String message="";
			audiocollection.add(new Podcast(name,cover,duration,qReproduction,description));
			message="The podcast was registered successfully.";
		return message;
	}
}