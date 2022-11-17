package ui;
import java.util.Scanner;
import java.util.Calendar;
import model.*;
public class NeotunesApp {
    public static Scanner lector = new Scanner(System.in);
	//relations 
	private NeotunesController neo;
	//methods
	public NeotunesApp(){
		neo = new NeotunesController();
	}
    public static void main(String[] args) {
		NeotunesApp neot = new NeotunesApp();
        neot.menu();	
    }
	public void menu() {
	 	int q = 0, i = 0, opt = 0; 
		do{
			System.out.println("WELCOME TO NEOTUNES, PLEASE SELECT THE opt YOU WANT TO USE: \n"
			+"1. Register user.\n"
			+"2. Register audio.\n"
			+"3. Modify or create a playlist (Not available.)\n"
			+"4. Reproduce a song or a podcast.\n"
			+"5. Buy a song.\n"
			+"6. Generate a report.\n"
			+"7. Exit.");
			opt = lector.nextInt();
			lector.nextLine();
			switch (opt){
				case 1:
					i=0;
					System.out.println("Type the quantity of users to register: ");
					q= lector.nextInt();
					lector.nextLine();
					do{
						registerUser();
						i++;
					}while(q>=i);
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
						System.out.println("Not available at the moment.");
					/* System.out.println("Type the playlists to modify.");
					q = lector.nextInt();
					lector.nextLine();
						do{
							
							i++;
						}while(q>=i);
					*/
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
		String id = "", nickname = "", name = "", message = "", photo = "", mlpUser = "", mlsUser = "", mlp = "", mls = "";
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
				message=neo.addUser(id,nickname,ptReproduced,stReproduced, mlpUser,mlsUser,mlp,mls,vinculationdate,opt);
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
				message=neo.addUser(id,nickname,name,photo,numvisualizations,vinculationdate,opt);
			break;
		}
		System.out.println(message);
	}
	public void registercontent(){
		String message = "",name = "", cover = "",description = "",album = "";
		int numvisualizations = 0,opt = 0,unitssold = 0;
		double value=0;
		boolean comprobant = false;
		System.out.println("Type the name of the audio: ");
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
				message=neo.addContent(name,cover,duration,0,album,value,unitssold);
			}
			if(opt==2){
				System.out.println("Type the description of the podcast: ");
				description= lector.nextLine();
				message=neo.addContent(name,cover,duration,0,description);
			}
		System.out.println(message);
	}
}