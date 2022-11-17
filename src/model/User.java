package model;
import java.util.Calendar;
public class  User{
	//attributes
	private String id;
	private String nickname;
	private Calendar vinculationdate;
	//methods
	public User(String id, String nickname, Calendar vinculationdate){
		this.id=id;
		this.nickname=nickname;
		this.vinculationdate=vinculationdate;
	}
	public String getid(){
		return id;
	}
	
	public void setid(String id){
		this.id = id;
	}
	public String getnickname(){
		return nickname;
	}
	
	public void setnickname(String nickname){
		this.nickname = nickname;
	}
	public Calendar getvinculationdate(){
		return vinculationdate;
	}
	
	public void setvinculationdate(Calendar vinculationdate){
		this.vinculationdate = vinculationdate;
	}
}