package model;
import java.util.Calendar;
public class  Consumer extends User{
	//attributes
	private double stReproduced;
	private double ptReproduced;
	private String mlpUser;
	private String mlsUser;
	private String mlp;
	private String mls;
	//methods
	public Consumer(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate){
		super(id,nickname,vinculationdate);
		this.ptReproduced=ptReproduced;
		this.stReproduced=stReproduced;
		this.mlpUser=mlpUser;
		this.mlsUser=mlsUser;
		this.mlp=mlp;
		this.mls=mls;
	}
	public double getStReproduced(){
		return stReproduced;
	}	
	public void setStReproduced(double stReproduced){
		this.stReproduced = stReproduced;
	}
	public double getPtReproduced(){
		return ptReproduced;
	}
	public void setPtReproduced(double ptReproduced){
		this.ptReproduced = ptReproduced;
	}
	public String getMlpUser(){
		return mlpUser;
	}
	public void setMlpUser(String mlpUser){
		this.mlpUser = mlpUser;
	}
	public String getMlsUser(){
		return mlsUser;
	}
	
	public void setMlsUser(String mlsUser){
		this.mlsUser = mlsUser;
	}
	public String getMlp(){
		return mlp;
	}
	public void setMlp(String mlp){
		this.mlp = mlp;
	}
	public String getMls(){
		return mls;
	}
	public void setMls(String mls){
		this.mls = mls;
	}
}