package model;
import java.util.Calendar;
public class  Premium extends Consumer implements Buyable, Reproductionable{
	//methods
	public Premium(String id,String nickname,double ptReproduced,double stReproduced,String mlpUser,String mlsUser,String mlp,String mls,Calendar vinculationdate){
		super(id,nickname, ptReproduced, stReproduced, mlpUser, mlsUser, mlp, mls, vinculationdate);
	}
	public String buysong(){
		String msg = "the song has been bought.";
		return msg;
	}
	public String reproduction(){
		String msg = "You are listening: Example....";
		return msg;
	}
	
}