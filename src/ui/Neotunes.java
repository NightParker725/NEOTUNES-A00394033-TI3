package ui;
import java.util.Scanner;
import java.util.Calendar;
import model.*;
public class Neotunes{
    public static Scanner lector = new Scanner(System.in);
	//relations 
	private AudioCollection neo;
	//methods
	public Neotunes(){
		neo = new AudioCollection();
	}
    public static void main(String[] args) {
		Neotunes neot = new Neotunes();
        neot.menu();	
    }
	public void menu() {
	 	int q = 0, i = 0, j = 0, pos = 0, opt = 0, opt2 = 0; 
		String nickname = "", id = "", msg = "";
		double num = 0;
		do{
			System.out.println("WELCOME TO NEOTUNES, PLEASE SELECT THE opt YOU WANT TO USE: \n"
			+"1. Register user.\n"
			+"2. Register audio.\n"
			+"3. Modify or create a playlist. (More options)\n"
			+"4. Reproduce a song or a podcast. (not available)\n"
			+"5. Buy a song.(not available)\n"
			+"6. Generate a report. (not available)\n"
			+"7. Exit.");
			opt = lector.nextInt();
			lector.nextLine();
			switch (opt){
				case 1:
					registerUser();
				break;
				case 2:
					i=0;
					System.out.println("Type the quantity of audios to register: ");
					q = lector.nextInt();
					lector.nextLine();
						do{
							registercontent();
							i++;
						}while(q>=i);
				break;
				case 3:
						i=0;
					do{
						System.out.println("Type your nickname: ");
						nickname = lector.nextLine();
						System.out.println("Type your id: ");
						id = lector.nextLine();
						if(!neo.searchUser(nickname,id)){
							System.out.println("Cannot find user.");
						}
					}
					while(neo.searchUser(nickname,id));
					System.out.println("Type the option you want to do: \n"
					+"1. Create Playlist. \n"
					+"2. Add content. \n"
					+"3. Delete content. \n"
					+"4. Share content. \n");
					pos = lector.nextInt();
					lector.nextLine();
					switch(pos){
						case 1:
							registerPlaylist(nickname);
						break;
						case 2:
						 i=0;
						 msg = neo.showPlaylists(nickname);
						 System.out.println(msg);
						 System.out.println("Type the playlist (num) to modify");
						 opt2 = lector.nextInt();
						 lector.nextLine();
						 msg = neo.showAudios();
						 System.out.println(msg);
						 System.out.println("Type the quantity of the content to register in the playlist: ");
						 q = lector.nextInt();
						 lector.nextLine();
						 do{
							System.out.println("Type the audio (num) to register: ");
							j = lector.nextInt();
							lector.nextLine();
							neo.addPlaylistContent(opt2,j,nickname);
							i++;
						 }while(q >= i);
						break;
						case 3:
						 msg = neo.showPlaylists(nickname);
						 System.out.println(msg);
						 System.out.println("Type the playlists to modify: ");
						 opt2 = lector.nextInt();
						 lector.nextLine();
						 msg = neo.showPlaylistContent(nickname,opt2);
						 System.out.println(msg);
						 System.out.println("Type the quantity of the content to delete: ");
						 q = lector.nextInt();
						 lector.nextLine();
						 do{
							System.out.println("Type the audio (num) to delete: ");
							j = lector.nextInt();
							lector.nextLine();
							neo.removePlaylistContent(opt2,j,nickname);
							i++;
						 }while(q >= i);
						break;
						case 4: 
							System.out.println("coming soon.");
						break;
					}
					
				break;
				case 4:
					System.out.println("Not available at the moment.");
				break;
				case 5:
					System.out.println("Not available at the moment.");
				break;
				case 6:
					System.out.println("Not available at the moment.");
				break;
				case 7:
					System.out.println("Thank you for using the App.");
				break;
				default:
					System.out.println("Error. Invalid opt.");
				break;
			}
		}while(opt!=7);
	}
	public void registerUser() {
		String id = "", nickname = "", name = "", msg = "", photo = "", mlpUser = "", mlsUser = "", mlp = "", mls = "";
		Calendar vinculationdate = Calendar.getInstance();
		double ptReproduced = 0, stReproduced = 0;
		int opt = 0, numvisualizations = 0;
		boolean  comprobant = false;
		name = lector.nextLine();
		System.out.println("Type the nickname: ");
		nickname = lector.nextLine();
		System.out.println("Type the id: ");
		id = lector.nextLine();
		System.out.println("Type the type of user to register:/n" + "1.Consumer/n" + "2.Producer");
		opt = lector.nextInt();
		lector.nextLine();
		switch(opt){
			case 1:
				do{
					System.out.println("Type the consumer to register:/n"
					+"1.Estandar/n"
					+"2.Premium");
					opt = lector.nextInt();
					lector.nextLine();
					if(opt==1 || opt==2){
						comprobant=true;
					}
					else{
						System.out.println("Invalid opt");
					}
				}while(!comprobant);
				msg=neo.addUser(id,nickname,ptReproduced,stReproduced, mlpUser,mlsUser,mlp,mls,vinculationdate,opt);
			break;
			case 2:
				System.out.println("Type your name: ");
				name = lector.nextLine();
				System.out.println("Upload your profile picture: ");
				photo = lector.nextLine();
				do{
					System.out.println("Type the producer to register:/n"
					+"1.Artist/n"
					+"2.Creator content");
					opt = lector.nextInt();
					lector.nextLine();
					if(opt==1 || opt==2){
						comprobant=true;
					}
					else{
						System.out.println("Invalid opt");
					}
				}while(!comprobant);
				msg=neo.addUser(id,nickname,name,photo,numvisualizations,vinculationdate,opt);
			break;
		}
		System.out.println(msg);
	}
	public void registercontent(){
		String msg = "",name = "", nickname = "", cover = "",description = "",album = "";
		int numvisualizations = 0,opt = 0,unitssold = 0, genre = 0;
		double value=0;
		boolean comprobant = false;
		System.out.println("Type the nickname of the creator of the content: ");
		nickname = lector.nextLine();
		System.out.println("Type the name of the content: ");
		name = lector.nextLine();
		System.out.println("Upload the URL of the cover: ");
		cover = lector.nextLine();
		System.out.println("Type the duration: ");
		double duration= lector.nextInt();
		lector.nextLine();
			do{
					System.out.println("Type the type of content to register:/n"
					+"1.Song/n"
					+"2.Podcast");
					opt = lector.nextInt();
					lector.nextLine();
					if(opt==1 || opt==2){
						comprobant=true;
					}
					else{
						System.out.println("Invalid opt.");
					}
			}while(!comprobant);
			if(opt==1){
				System.out.println("Type the album: ");
				album= lector.nextLine();
				System.out.println("Type the album value: ");
				value= lector.nextDouble();
				lector.nextLine();
				System.out.println("Type the song genre: \n" 
				+ "1.Rock \n"
				+ "2.Pop \n"
				+ "3.House \n"
				+ "4.Trap \n");
				genre = lector.nextInt();
				lector.nextLine();
				msg=neo.addContent(nickname,name,cover,duration,0,album,value,unitssold, genre);
			}
			if(opt==2){
				System.out.println("Type the description of the podcast: ");
				description= lector.nextLine();
				System.out.println("Type the podcast category: \n" 
				+ "1.Politics \n"
				+ "2.Entertaiment \n"
				+ "3.Fashion \n"
				+ "4.Videogames \n");
				genre = lector.nextInt();
				lector.nextLine();
				msg=neo.addContent(nickname,name,cover,duration,0,description,genre);
			}
		System.out.println(msg);
	}
	public void registerPlaylist(String nickname){
		String name = "", msg = "";
		System.out.println("Type the playlist name.");
		name = lector.nextLine();
		msg = neo.addPlaylist(nickname,name,0);
	}
}