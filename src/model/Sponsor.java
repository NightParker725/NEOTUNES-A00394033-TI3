package model; 
public enum Sponsor{
	PEPSI(("Better than cocacola"))
	,COCACOLA(("Better than pepsi"))
	,EA(("Set the game"))
	,UBISOFT(("There is a bug encountered"));
	
	private String brand;
	Sponsor(String brand){
		this.brand=brand;
	}
	public  String getbrand(){
		return brand;
	}
}
