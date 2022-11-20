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
	public void menu(){
	 	int q = 0, i = 0, j = 0, pos = 0, opt = 0, opt2 = 0; 
		String nickname = "", id = "", msg = "";
		double num = 0;
		do{
			System.out.println("WELCOME TO NEOTUNES, PLEASE SELECT THE opt YOU WANT TO USE: \n"
			+"-----------------------------------------------------------------------------.\n"
			+"1. Register user.\n"
			+"-----------------------------------------------------------------------------.\n"
			+"2. Register audio.\n"
			+"-----------------------------------------------------------------------------.\n"
			+"3. Modify or create a playlist. (--More options--)\n"
			+"-----------------------------------------------------------------------------.\n"
			+"4. Reproduce a song or a podcast.\n"
			+"-----------------------------------------------------------------------------.\n"
			+"5. Buy a song.\n"
			+"-----------------------------------------------------------------------------.\n"
			+"6. Generate a report. (not available)\n"
			+"-----------------------------------------------------------------------------.\n"
			+"7. Exit.\n"
			+"-----------------------------------------------------------------------------.");
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
						}while(q > i);
				break;
				case 3:
						i=0;
					do{
						System.out.println("Type your nickname: ");
						nickname = lector.nextLine();
						System.out.println("Type your id: ");
						id = lector.nextLine();
						if(neo.searchUser(nickname,id) == false){
							System.out.println("Cannot find user.");
						}
					} while(neo.searchUser(nickname,id) == false);
					System.out.println("Type the option you want to do: \n"
					+"-------------------------------------------------.\n"
					+"1. Create Playlist.\n"
					+"-------------------------------------------------.\n"
					+"2. Add content.\n"
					+"-------------------------------------------------.\n"
					+"3. Delete content.\n"
					+"-------------------------------------------------.\n"
					+"4. Share content.\n"
					+"-------------------------------------------------.\n");
					pos = lector.nextInt();
					lector.nextLine();
					switch(pos){
						case 1:
							registerPlaylist(nickname, id);
						break;
						case 2:
						 i = 0;
						 j = 0;
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
						 }while(q > i);
						break;
						case 3:
						 i = 0;
						 j = 0;
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
						 }while(q > i);
						break;
						case 4:
							msg = neo.showPlaylists(nickname);
							System.out.println(msg);
							System.out.println("Type the playlist (num) to modify");
							opt2 = lector.nextInt();
							lector.nextLine();
							String code = neo.shareId(nickname, opt2);
							System.out.println("Your code to share is: " + code);
						break;
					}
					
				break;
				case 4:
					i = 0;
					j = 0;
					System.out.println("Type your nickname: ");
					nickname = lector.nextLine();
					System.out.println("Type your id: ");
					id = lector.nextLine();
					if(neo.searchUser(nickname, id) == true){
						do{
							msg = neo.showAudios();
							System.out.println(msg);
							System.out.println("Choose the audio you want to reproduce: ");
							j = lector.nextInt();
							lector.nextLine();
							System.out.println(neo.reproduceSong(nickname, j) +"\n"
											+"---------------------------------------------------\n"
											+"	 /||  "+"|.  "+" ||.   _  "+"   "+" _  "+" _  "+"\n"
											+"  / ||  "+"| . "+" || . | | "+" . "+"| | "+"| | "+"\n"
											+"  . ||  "+"| / "+" || / |_| "+" . "+"|_| "+"|_| "+"\n"
											+"	 .||  "+"|/  "+" ||/ ----------------------------\n"
											+"---(1)--"+"(2)-"+"(3)------------------------------\n");
							System.out.println("Wanna reproduce another song: 1.yes 2.no");
							i = lector.nextInt();
							lector.nextLine();
						}while(i==1);
					}
					else{
						System.out.println("Cannot find user");
					}
				break;
				case 5:
					i = 0;
					j = 0;
					System.out.println("Type your nickname: ");
					nickname = lector.nextLine();
					System.out.println("Type your id: ");
					id = lector.nextLine();
					if(neo.searchUser(nickname, id) == true){
						msg = neo.showAudios();
						System.out.println(msg);
						System.out.println("Type the quantity of audios you want to buy: ");
						q = lector.nextInt();
						lector.nextLine();
						do{
							System.out.println("Choose the audio you want to buy: (Only Songs are available to purchase)");
							j = lector.nextInt();
							lector.nextLine();
							msg = neo.buySong(nickname, j);
							i++;
						}while(q > i);
					}
					else{
						System.out.println("Cannot find user");
					}
				break;
				case 6:
				
					System.out.println("Not available at the moment.");
				break;
				case 7:
					System.out.println("Thank you for using the App..");
				break;
				default:
					System.out.println("Error. Invalid opt.");
				break;
			}
			
		}
		while(opt!=7);
	}
	public void registerUser() {
		String id = "", nickname = "", name = "", msg = "", photo = "", mlpUser = "", mlsUser = "", mlp = "", mls = "";
		Calendar vinculationdate = Calendar.getInstance();
		double ptReproduced = 0, stReproduced = 0;
		int opt = 0, numvisualizations = 0;
		boolean  comprobant = false;
		System.out.println("Type the nickname: ");
		nickname = lector.nextLine();
		System.out.println("Type the id: ");
		id = lector.nextLine();
		System.out.println("Type the type of user to register: \n" + "1.Consumer \n" 
																  + "2.Producer");
		opt = lector.nextInt();
		lector.nextLine();
		switch(opt){
			case 1:
				do{
					System.out.println("Type the consumer to register: \n"
					+"-----------------------------------------------. \n"
					+"1.Estandar \n"
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
					System.out.println("Type the producer to register:\n"
					+"1.Artist \n"
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
		String msg = "",name = "", nickname = "", cover = "",description = "",album = "", id ="";
		int numvisualizations = 0,opt = 0,unitssold = 0, genre = 0;
		double value=0;
		boolean comprobant = false, exist = false;
		System.out.println("Type the nickname of the creator of the content: ");
		nickname = lector.nextLine();
		System.out.println("Type the id of the creator of the content: ");
		id = lector.nextLine();
		exist = neo.searchUser(nickname, id);
		if(exist == true){
			System.out.println("Type the name of the content: ");
			name = lector.nextLine();
			System.out.println("Upload the URL of the cover: ");
			cover = lector.nextLine();
			System.out.println("Type the duration: ");
			double duration= lector.nextInt();
			lector.nextLine();
				do{
						System.out.println("Type the type of content to register: \n"
						+"1.Song \n"
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
					+ "1.Rock\n"
					+ "2.Pop\n"
					+ "3.House\n"
					+ "4.Trap\n");
					genre = lector.nextInt();
					lector.nextLine();
					msg=neo.addContent(nickname,name,cover,duration,0,album,value,unitssold, genre);
				}
				if(opt==2){
					System.out.println("Type the description of the podcast: ");
					description= lector.nextLine();
					System.out.println("Type the podcast category: \n" 
					+ "1.Politics\n"
					+ "2.Entertaiment\n"
					+ "3.Fashion\n"
					+ "4.Videogames\n");
					genre = lector.nextInt();
					lector.nextLine();
					msg=neo.addContent(nickname,name,cover,duration,0,description,genre);
				}
			System.out.println(msg);
		}
		else{
			System.out.println("Cannot find user.");
		}
	}
	public void registerPlaylist(String nickname, String id){
		boolean exist = neo.searchUser(nickname, id);
		String name = "", msg = "Cannot create playlist";
		if (exist == true){
			System.out.println("Type the playlist name.");
			name = lector.nextLine();
			msg = neo.addPlaylist(nickname,name,0);
			System.out.println(msg);
		}
		else{
			System.out.println(msg);
		}
	}
}