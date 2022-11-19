package model; 
public enum Advertise{
	NIKE("Nike - Just do it.",3),
	MYMS("M&Ms - Melts in your mouth, not in your hands.",5),
	COCACOLA("Coca-Cola - Better than pepsi.",7),
	UBISOFT("Ubisoft - There is a bug encountered, and its not ours.",10);
	private String brand;
	private double duration;
	Advertise(String brand,double duration){
		this.brand = brand;
		this.duration = duration;
	}
	public  String getbrand(){
		return brand;
	}
	public double getduration(){
		return duration;
	}
}
