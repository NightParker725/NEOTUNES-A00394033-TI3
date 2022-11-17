package model;
public class Audio {
	//attributes
	private String name;
	private String cover;
	private double duration;
	private int qReproduction;
	//methods
	public Audio(String name, String cover, double duration, int qReproduction){
		this.name = name;
		this.cover = cover;
		this.duration = duration;
		this.qReproduction = qReproduction;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getCover(){
		return cover;
	}
	public void setCover(String cover){
		this.cover = cover;
	}
	public double getDuration(){
		return duration;
	}
	public void setDuration(double duration){
		this.duration = duration;
	}
	public int getQReproduction(){
		return qReproduction;
	}
	public void setQReproduction(int qReproduction){
		this.qReproduction = qReproduction;
	}
}