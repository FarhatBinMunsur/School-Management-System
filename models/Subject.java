package models;
import java.lang.*;

public class Subject{
	private String subjectID;
	private String subjectName;
	
	public Subject(){
		
	}
	
	public Subject(String subjectID,String subjectName){
		this.subjectID=subjectID;
		this.subjectName=subjectName;

	}
	


    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
	

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
	
	public String getSubjectID() {
        return this.subjectID;
    }
	
    public String getSubjectName() {
        return this.subjectName;
    }
	
	public String toString(){
		String str=this.subjectID+","+this.subjectName+"\n";
		return str;
	}
	
	public Subject formSubject(String str){
		String data[] =str.split(",");
		
		Subject s=new Subject();
		
		s.setSubjectID(data[0]);
		s.setSubjectName(data[1]);
		
		return s;
	}
}
