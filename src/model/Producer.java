package model;
import java.util.Calendar;
public class Producer extends User{
	//attributes
	private String name;
	private String photo;
	private int numvisualizations;
	//methods
		/**
	<br> Name: Producer
	<br> @param: String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations
	<br> @return: void
	<br> Process: creates the producer object
	*/
	public Producer(String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations){
		super(id,nickname,vinculationdate);
		this.name=name;
		this.photo=photo;
		this.numvisualizations=numvisualizations;
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
	<br> Name: getphoto
	<br> @param: void
	<br> @return: String photo
	<br> Process: gets photo
	*/
	public String getphoto(){
		return photo;
	}
		/**
	<br> Name: setphoto
	<br> @param: String photo
	<br> @return: void
	<br> Process: sets photo
	*/
	public void setphoto(String photo){
		this.photo = photo;
	}
	/**
	<br> Name: getnumvisualizations
	<br> @param: void
	<br> @return: int numvisualizations
	<br> Process: gets numvisualizations
	*/
	public int getnumvisualizations(){
		return numvisualizations;
	}
	/**
	<br> Name: setnumvisualizations
	<br> @param: int numvisualizations
	<br> @return: void
	<br> Process: sets numvisualizations
	*/
	public void setnumvisualizations(int numvisualizations){
		this.numvisualizations = numvisualizations;
	}
}