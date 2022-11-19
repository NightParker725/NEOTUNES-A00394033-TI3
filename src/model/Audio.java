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
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getcover(){
		return cover;
	}
	public void setcover(String cover){
		this.cover = cover;
	}
	public double getduration(){
		return duration;
	}
	public void setduration(double duration){
		this.duration = duration;
	}
	public int getqReproduction(){
		return qReproduction;
	}
	public void setqReproduction(int qReproduction){
		this.qReproduction = qReproduction;
	}
}