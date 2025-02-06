package controllers;

import java.lang.*;
import models.*;

public class GradeController{
	public void insertGrade(Grade g){
		Grade[] grades=this.getAllGrade();
		for(int i=0;i<grades.length;i++){
			if(grades[i]==null){
				grades[i]=g;
				break;
			}
		}
		this.write(grades);
	}
	public void updateGrade(Grade g){
		Grade [] grades=this.getAllGrade();
		for(int i=0;i<grades.length;i++){
			if(grades[i]!=null){
				if(g.getGradeID().equals(grades[i].getGradeID()))
				{
					grades[i]=g;
				}
				
			}
		}
		this.write(grades);
	}
	
	public void deleteGrade(String gradeID ,String studentID, String subjectID){
		Grade[] grades=this.getAllGrade();
		for(int i=0;i<grades.length;i++){
			if(grades[i]!=null){
				if(grades[i].getGradeID().equals(gradeID ) &&  grades[i].getStudentID().equals(studentID) && 
                grades[i].getSubjectID().equals(subjectID)){
					grades[i]=null;
				}
			}
		}
		this.write(grades);
	}
	
	public Grade searchGrade(String gradeID){
		Grade[] grades =this.getAllGrade();
		
		for(int i=0;i<grades.length;i++){
			if(grades[i]!=null){
				if(grades[i].getGradeID().equals(gradeID)){
					return grades[i];
				}
			}
		}
		return null;	
	}
	
	public Grade[] getAllGrade(){
		String fileName="Controllers/data/grades.txt";
		
		FileIO fio=new FileIO();
		String values[]= fio.readFile(fileName);
		
		Grade grades[]=new Grade[100];
		Grade g=new Grade();
		
		for(int i=0;i<values.length;i++){
			if(values[i]!=null){
				if(grades[i]==null){
					grades[i]=g.formGrade(values[i]);
				}
			}
		}
		return grades;
	}
	
	public void write(Grade [] grade){
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++){
			if(grade[i]!=null){
				data[i]=grade[i].toStringGrade();
			}
		}
		String fileName="Controllers/data/grades.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);
	}
}