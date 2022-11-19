package model;
public class Song extends Audio {
	//attributes
	private String album;
	private double value;
	private int unitsSold;
	private MusicGenre genre;
	//methods
	public Song(String name, String coverpage, double durationtime, int numberOfReproduction, String album, double value, int unitsSold, int g){
		super(name, coverpage, durationtime, numberOfReproduction);
		this.album = album;
		this.value = value;
		this.unitsSold = unitsSold;
		switch(g){
			case 1: genre = MusicGenre.ROCK;
			break;
			case 2: genre = MusicGenre.POP;
			break;
			case 3: genre = MusicGenre.HOUSE;
			break;
			case 4: genre = MusicGenre.TRAP;
			break;
		}
	}
	public String getalbum(){
		return album;
	}
	public void setalbum(String album){
		this.album = album;
	}
	public double getvalue(){
		return value;
	}
	public void setvalue(double value){
		this.value = value;
	}
	public int getunitsSold(){
		return unitsSold;
	}
	public void setunitsSold(int unitsSold){
		this.unitsSold = unitsSold;
	}
}