package model;
import java.util.Calendar;
public class User{
	//attributes
	private String id;
	private String nickname;
	private Calendar vinculationdate;
	//methods
		/**
	<br> Name: User
	<br> @param: String id, String nickname, Calendar vinculationdate
	<br> @return: void
	<br> Process: creates the user object
	*/
	public User(String id, String nickname, Calendar vinculationdate){
		this.id=id;
		this.nickname=nickname;
		this.vinculationdate=vinculationdate;
	}
		/**
	<br> Name: getid
	<br> @param: void
	<br> @return: String id
	<br> Process: gets id
	*/
	public String getid(){
		return id;
	}
	/**
	<br> Name: setid
	<br> @param: String id
	<br> @return: void
	<br> Process: sets id
	*/
	public void setid(String id){
		this.id = id;
	}
		/**
	<br> Name: getnickname
	<br> @param: void
	<br> @return: String nickname
	<br> Process: gets nickname
	*/
	public String getnickname(){
		return nickname;
	}
	/**
	<br> Name: setnickname
	<br> @param: String nickname
	<br> @return: void
	<br> Process: sets nickname
	*/
	public void setnickname(String nickname){
		this.nickname = nickname;
	}
		/**
	<br> Name: getvinculationdate
	<br> @param: void
	<br> @return: Calendar vinculationdate
	<br> Process: gets vinculationdate
	*/
	public Calendar getvinculationdate(){
		return vinculationdate;
	}
	/**
	<br> Name: setvinculationdate
	<br> @param: Calendar vinculationdate
	<br> @return: void
	<br> Process: sets vinculationdate
	*/
	public void setvinculationdate(Calendar vinculationdate){
		this.vinculationdate = vinculationdate;
	}
}