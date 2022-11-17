package model;
import java.util.Calendar;
public class Artist extends Producer {
	//methods
	public Artist(String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
	}
}