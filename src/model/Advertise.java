package model; 
public enum Advertise{
	NIKE("Nike - Just do it.",3),
	MYMS("M&Ms - Melts in your mouth, not in your hands.",5),
	COCACOLA("Coca-Cola - Better than pepsi.",7),
	UBISOFT("Ubisoft - There is a bug encountered, and its not ours.",10);
	private String brand;
	private double duration;
		/** 
	<br> Name: Advertise
	<br> @param: void
	<br> @return: void
	<br> Process: creates the Advertise object
	*/
	Advertise(String brand,double duration){
		this.brand = brand;
		this.duration = duration;
	}
		/** 
	<br> Name: getbrand
	<br> @param: void
	<br> @return: String brand
	<br> Process: gets brand
	*/
	public  String getbrand(){
		return brand;
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
}
