package models;
import java.lang.*;
public class Section{
	private String sectionID;
	private int studentCount;
	private String teacherID;
	private String subjectID;
	
	
	public Section(){}
	
	public Section(String sectionID,int studentCount,String teacherID,String subjectID){
		this.sectionID=sectionID;
		this.studentCount=studentCount;
		this.teacherID=teacherID;
		this.subjectID=subjectID;
	}
	public void setSectionID(String sectionID) {
        this.sectionID = sectionID;
    }
	
	public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
	
    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
	
	public void setSubjectID(String subjectID){
		this.subjectID=subjectID;
	}
	
    public String getSectionID() {
        return this.sectionID;
    }   

    public int getStudentCount() {
        return this.studentCount;
    }

    public String getTeacherID() {
        return this.teacherID;
    }
	
	public String getSubjectID(){
		return this.subjectID;
	}
	
	public String toStringSection(){
		String str = this.sectionID+","+this.studentCount+","+this.teacherID+","+this.subjectID+"\n";
		return str;
	}
	
	public Section formSection(String str){
		String data[]=str.split(",");
		
		Section s=new Section();
		
		s.setSectionID(data[0]);
		s.setStudentCount(Integer.parseInt(data[1]));
		s.setTeacherID(data[2]);
		s.setSubjectID(data[3]);
		return s;
	}
	
	
	
	
	
	
}