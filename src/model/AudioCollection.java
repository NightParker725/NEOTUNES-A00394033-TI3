package model;
import java.util.*; 
import java.lang.Math;
public class AudioCollection{
	//relations
	private ArrayList<Audio> library; 
	private ArrayList<User> users;
	
	int[][] id = new int [5][5];
	//methods
		/** 
	<br> Name: AudioCollection
	<br> @param: void
	<br> @return: void
	<br> Process: creates the object audiocollection
	*/
	public AudioCollection(){
		this.library= new ArrayList<Audio>();
		this.users= new ArrayList<User>();
		makeMatrix(id);
	}
		/** 
	<br> Name: getRandomInt
	<br> @param: int min, int max
	<br> @return: int num
	<br> Process: creates a random number
	*/
	public int getRandomInt(int min, int max){
		int num = (int)(Math.random()*((max-min)+1))+min;
		return num;
	}
		/** 
	<br> Name: makeMatrix
	<br> @param: int[][] matrix
	<br> @return: void
	<br> Process: creates a random matrix
	*/
	public void makeMatrix(int[][] matrix){
		int min = 0, max = 9, num = 0;
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				num = getRandomInt(0,9);
				matrix[i][j] = num;
			}
		}
	}
		/** 
	<br> Name: buySong
	<br> @param: String nickname, int num
	<br> @return: String msg
	<br> Process: buys a song for the consumer user type
	*/
	public String buySong(String nickname, int num){
		String msg = "Cannot buy content.";
		String id = "";
		for(int i = 0; i < users.size(); i++){
			id = users.get(i).getid();
			if(users.get(i) instanceof Consumer && searchUser(nickname, id)){
				if(library.get(num) instanceof Song){
					Song s = (Song) library.get(num);
					if(users.get(i) instanceof Premium){
						Premium user = (Premium) users.get(i);
						double val = s.getvalue();
						msg = "The song cost: " + val + ", proceding with the purchase..";
						msg = msg + "\n" + user.buysong(s);
					}
					else{
						Standard user = (Standard) users.get(i);
						double val = s.getvalue();
						msg = "The song cost: " + val + ", proceding with the purchase..";
						msg = msg + "\n" + user.buysong(s);
					}
					
				}
			}
		}
		return msg;
	}
			/** 
	<br> Name: reproduceSong
	<br> @param: String nickname, int num
	<br> @return: String msg
	<br> Process: reproduce a song for the consumer user type
	*/
	public String reproduceSong(String nickname, int num){
		String msg = "Cannot reproduce content.";
		String msg2 = "";
		String id = "";
		for(int i = 0; i < users.size(); i++){
			id = users.get(i).getid();
			if(users.get(i) instanceof Consumer && searchUser(nickname, id)){
				if(library.get(num) instanceof Song){
					Song s = (Song) library.get(num);
					if(users.get(i) instanceof Premium){
						Premium user = (Premium) users.get(i);
						msg = "\n" + user.reproduction(s);
					}
					else{
						Standard user = (Standard) users.get(i);
						if(user.getStReproduced() % 2 == 0){
							msg2 = "Advertise: " + user.advertise() + ", Please wait ";
						}
						msg = msg2 + "\n" + user.reproduction(s);
					}
					
				}
				if(library.get(num) instanceof Podcast){
					Podcast p = (Podcast) library.get(num);
					if(users.get(i) instanceof Premium){
						Premium user = (Premium) users.get(i);
						msg = "\n" + user.reproduction(p);
					}
					else{
						Standard user = (Standard) users.get(i);
						msg2 = "Advertise: " + user.advertise() + ", Please wait ";
						msg = msg2 + "\n" + user.reproduction(p);
					}
					
				}
			}
		}
		return msg;
	}
			/** 
	<br> Name: addUser
	<br> @param: String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate,int option
	<br> @return: String msg
	<br> Process: creates a consumer user type of standard or premium
	*/
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
	/** 
	<br> Name: addUser
	<br> @param: String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate,int opt
	<br> @return: String msg
	<br> Process: creates a producer user type of artist or creatorcontent
	*/
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
	/** 
	<br> Name: searchUser
	<br> @param: String nickname,String id
	<br> @return: boolean exist
	<br> Process: searchs if the user exist in the data system saved
	*/
	public boolean searchUser(String nickname,String id){
		boolean exist= false; 
		for (int i=0; i<users.size() && !exist; i++){
				if(users.get(i).getnickname().equalsIgnoreCase(nickname) && users.get(i).getid().equalsIgnoreCase(id)){
					exist=true;
				}
		}
		return exist;
	}
	/** 
	<br> Name: addContent
	<br> @param: String nickname,String name,String cover,double duration,int qReproduction,String album,double value,int unitssold,int genre
	<br> @return: String msg
	<br> Process: creates an song type of audio
	*/
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
	/** 
	<br> Name: addContent
	<br> @param: String nickname,String name,String cover,double duration,int qReproduction,String description,int category
	<br> @return: String msg
	<br> Process: creates an podcast type of audio
	*/
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
	/** 
	<br> Name: addPlaylist
	<br> @param: String nickname,String name,String id
	<br> @return: String msg
	<br> Process: creates a playlist object
	*/
	//the id is 0 meanwhile.
	public String addPlaylist(String nickname,String name,int id){
		String msg ="Cannot create playlist. Invalid user.";
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				msg = user.addPlaylist(name,id);
			}
		}
		return msg;
	}
	/** 
	<br> Name: showPlaylists
	<br> @param: String nickname
	<br> @return: String msg
	<br> Process: shows the playlists created by the user
	*/
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
	/** 
	<br> Name: showAudios
	<br> @param: void
	<br> @return: String msg
	<br> Process: shows the audios that contains the library
	*/
	public String showAudios(){
		String msg = "";
		for(int i = 0; i < library.size(); i++){
			msg = msg + (i+1) + ". " + library.get(i).getname() + "\n";
		}
		return msg;
	}
	/** 
	<br> Name: addPlaylistContent
	<br> @param: int playlist,int pos,String nickname
	<br> @return: String msg
	<br> Process: adds audios to a playlist
	*/
	public String addPlaylistContent(int playlist,int pos,String nickname){
		pos--;
		playlist--;
		String msg = "Cannot add. Invalid user.";
			if(library.get(pos) instanceof Song){
				Song song= (Song) library.get(pos);	
				for(int i = 0; i < users.size(); i++){
					if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
						Consumer user = (Consumer) users.get(i);
						user.addPlaylistContent(playlist,song);
						msg = "Content added successfully.";
					}		
				}
			}
			else{
				Podcast pod = (Podcast) library.get(pos);
				for(int i = 0; i < users.size(); i++){
					if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
						Consumer user = (Consumer) users.get(i);
						user.addPlaylistContent(playlist,pod);
						msg = "Content added successfully.";
					}
				}
			}
		return msg;
	}
		/** 
	<br> Name: showPlaylistContent
	<br> @param: String nickname, int playlist
	<br> @return: String msg
	<br> Process: shows the content of a playlist
	*/
	public String showPlaylistContent(String nickname, int playlist){
		String msg = "Cannot show. Invalid user.";
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				msg = user.showPlaylistContent(playlist);
			}
		}
		return msg;
	}
		/** 
	<br> Name: removePlaylistContent
	<br> @param: int playlist,int pos,String nickname
	<br> @return: String msg
	<br> Process: removes audios from a playlist
	*/
	public String removePlaylistContent(int playlist,int pos,String nickname){
		pos--;
		playlist--;
		String msg = "Cannot remove. Invalid user.";
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				user.removePlaylistContent(playlist,pos);
				msg = "Content removed succesfully.";
			}
		}
		return msg;
	}
		/** 
	<br> Name: generateTId
	<br> @param: void
	<br> @return: String msg
	<br> Process: generates an id for a playlist of podcasts
	*/
	public String generateTId() {
        String code = "";
        for (int j = 0; j < id.length - 4; j++){
            code = code + Integer.toString(id[0][j]);
        }
        for (int i = 0; i < id.length; i++){
            code = code + Integer.toString(id[i][2]);
        }
        for (int i = id.length; i > 0; i--){
            code = code + Integer.toString(id[i - 1][3]);
        }
        for (int j = id.length - 2; j < id.length; j++ ){
            code = code + Integer.toString(id[0][j]);
        }
        return code;
    }
		/** 
	<br> Name: generateNId
	<br> @param: void
	<br> @return: String msg
	<br> Process: generates an id for a playlist of songs
	*/
	public String generateNId(){
        String code = "";
        for(int i = id[0].length - 1; i > -1; i--){
            code = code + Integer.toString(id[i][0]);
        }
		for(int i = 1; i < 5; i++){
            code = code + Integer.toString(id[i][i]);
        }
		for(int i = id[0].length - 1; i > -1; i--){
            code = code + Integer.toString(id[i][5]);
        }
        return code;
    }
		/** 
	<br> Name: generateChessId
	<br> @param: void
	<br> @return: String msg
	<br> Process: generates an id for a playlist of podcasts and songs
	*/
	public String generateChessId(){
        String code = "";
        for(int i = id.length - 1; i >= 0; i--){
			
            for(int j = id.length - 1; j >= 0 ; j--) {
                if (((i + j) % 2 != 0) && ((i + j) > 1)) {
                    code = code + Integer.toString(id[i][j]);
                }
            }
        }
        return code;
	}
		/** 
	<br> Name: shareId
	<br> @param: String nickname, int playlist
	<br> @return: String msg
	<br> Process: generates an id for a playlist of an user to share
	*/
    public String shareId(String nickname, int playlist){
		String msg = "Cannot share, Invalid user.";
		int counterP = 0, counterS = 0;
		for(int i = 0; i < users.size(); i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user = (Consumer) users.get(i);
				for(int j = 0; j < user.getPlaylistSize(playlist); j++){
					Playlist list = (Playlist) user.getPlaylist(playlist);
					if(list.getContent(i) instanceof Song){
						counterS++;
					}
					if(list.getContent(i) instanceof Podcast){
						counterP++;
					}
				}
				if(counterS == user.getPlaylistSize(playlist)){
					msg = generateNId();
				}
				if(counterP == user.getPlaylistSize(playlist)){
					msg = generateTId();
				}
				else{
					msg = generateChessId();
				}
			}
		}
		return msg;
	}
}