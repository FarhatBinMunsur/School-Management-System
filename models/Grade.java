package models;
import java.lang.*;
public class Grade{
	private String gradeID;
	private String studentID;
	private String subjectID;
	private String teacherID;
	
	public Grade(){}
	
	public Grade(String gradeID,String studentID,String subjectID,String teacherID){
		this.gradeID=gradeID;
		this.studentID=studentID;
		this.subjectID=subjectID;
		this.teacherID=teacherID;
	}
	
	public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }
	
	public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
	
    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
	
	public void setTeacherID(String teacherID){
		this.teacherID=teacherID;
	}
	
    
    public String getGradeID() {
        return this.gradeID;
    }   

    public String getStudentID() {
        return this.studentID;
    }

    public String getSubjectID() {
        return this.subjectID;
    }
	
	public String getTeacherID(){
		return this.teacherID;
	}
	
	public String toStringGrade(){
		String str=this.gradeID+","+this.studentID+","+this.subjectID+","+this.teacherID+"\n";
		return str;
	}
	
	public Grade formGrade(String str){
		String data[]=str.split(",");
		
		Grade g=new Grade();
		
		g.setGradeID(data[0]);
		g.setStudentID(data[1]);
		g.setSubjectID(data[2]);
		g.setTeacherID(data[3]);
		return g; 
	}
}
