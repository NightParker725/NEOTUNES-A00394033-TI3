package model;
public class Audio {
	//attributes
	private String name;
	private String cover;
	private double duration;
	private int qReproduction;
	//methods
		/** 
	<br> Name: Audio
	<br> @param: String name, String cover, double duration, int qReproduction
	<br> @return: void
	<br> Process: creates the object audio
	*/
	public Audio(String name, String cover, double duration, int qReproduction){
		this.name = name;
		this.cover = cover;
		this.duration = duration;
		this.qReproduction = qReproduction;
	}
	/** 
	<br> Name: getname
	<br> @param: void
	<br> @return: String name
	<br> Process: gets name
	*/
	public String getname(){
		return name;
	}
		/** 
	<br> Name: setname
	<br> @param: String name
	<br> @return: void
	<br> Process: sets name
	*/
	public void setname(String name){
		this.name = name;
	}
		/** 
	<br> Name: getcover
	<br> @param: void
	<br> @return: String cover
	<br> Process: gets cover
	*/
	public String getcover(){
		return cover;
	}
		/** 
	<br> Name: setcover
	<br> @param: String cover
	<br> @return: void
	<br> Process: sets cover
	*/
	public void setcover(String cover){
		this.cover = cover;
	}
		/** 
	<br> Name: getduration
	<br> @param: void
	<br> @return: double duration
	<br> Process: gets duration
	*/
	public double getduration(){
		return duration;
	}
		/** 
	<br> Name: setduration
	<br> @param: double duration
	<br> @return: void
	<br> Process: sets duration
	*/
	public void setduration(double duration){
		this.duration = duration;
	}
		/** 
	<br> Name: getqReproduction
	<br> @param: void
	<br> @return: int qReproduction
	<br> Process: gets qReproduction
	*/
	public int getqReproduction(){
		return qReproduction;
	}
		/** 
	<br> Name: setqReproduction
	<br> @param: int qReproduction
	<br> @return: void
	<br> Process: sets qReproduction
	*/
	public void setqReproduction(int qReproduction){
		this.qReproduction = qReproduction;
	}
}