package model;
public class Song extends Audio {
	//attributes
	private String album;
	private double value;
	private int unitsSold;
	private MusicGenre genre;
	//methods
	/**
	<br> Name: Song
	<br> @param: String name, String coverpage, double durationtime, int numberOfReproduction, String album, double value, int unitsSold, int g
	<br> @return: void
	<br> Process: creates the Song object
	*/
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
	//getters and setters
	/**
	<br> Name: getalbum
	<br> @param: void
	<br> @return: String album
	<br> Process: gets album
	*/
	public String getalbum(){
		return album;
	}
	/**
	<br> Name: setalbum
	<br> @param: String album
	<br> @return: void
	<br> Process: sets album
	*/
	public void setalbum(String album){
		this.album = album;
	}
	/**
	<br> Name: getgenre
	<br> @param: void
	<br> @return: MusicGenre genre
	<br> Process: gets genre
	*/
	public MusicGenre getgenre(){
		return genre;
	}
	/**
	<br> Name: setgenre
	<br> @param: MusicGenre genre
	<br> @return: void
	<br> Process: sets genre
	*/
	public void setgenre(MusicGenre genre){
		this.genre = genre;
	}
	/**
	<br> Name: getvalue
	<br> @param: void
	<br> @return: double value
	<br> Process: gets value
	*/
	public double getvalue(){
		return value;
	}
	/**
	<br> Name: setvalue
	<br> @param: double value
	<br> @return: void
	<br> Process: sets value
	*/
	public void setvalue(double value){
		this.value = value;
	}
	/**
	<br> Name: getunitsSold
	<br> @param: void
	<br> @return: int unitsSold
	<br> Process: gets unitsSold
	*/
	public int getunitsSold(){
		return unitsSold;
	}
	/**
	<br> Name: setunitsSold
	<br> @param: int unitsSold
	<br> @return: void
	<br> Process: sets unitsSold
	*/
	public void setunitsSold(int unitsSold){
		this.unitsSold = unitsSold;
	}
}