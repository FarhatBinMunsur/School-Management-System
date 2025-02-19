package controllers;
import java.lang.*;
import models.*;

public class TeacherController {
	public void insertTeacher(Teacher t){
		Teacher teacher[]=this.getAllTeacher();
		
		for(int i=0;i<teacher.length;i++){
			if(teacher[i]==null){
				teacher[i]=t;
				break;
			}
		}
		this.write(teacher);
	}
	
	public void updateTeacher(Teacher t){
		Teacher teachers[]=this.getAllTeacher();
		
		for(int i=0;i<teachers.length;i++){
			if(teachers[i]!=null){
				if(teachers[i].getUserID().equals(t.getUserID())){
					teachers[i]=t;
				}
			}
		}
		this.write(teachers);
	}
	
	public void deleteTeacher(String userID){
		Teacher teacher[]=this.getAllTeacher();
		
		for(int i=0;i<teacher.length;i++){
			if(teacher[i]!=null){
				if(teacher[i].getUserID().equals(userID)){
					teacher[i]=null;
				}
			}
		}
		this.write(teacher);
		
	}
	public Teacher searchTeacher(String userID){
		Teacher teacher[]=this.getAllTeacher();
		
		for(int i=0;i<teacher.length;i++){
			if(teacher[i]!=null){
				if(teacher[i].getUserID().equals(userID)){
					return teacher[i];
				}
			}
		}
		return null;
	}
	
	public Teacher[] getAllTeacher(){
	
	String fileName="controllers/data/teachers.txt";
	FileIO fio =new FileIO();
	String values[] =fio.readFile(fileName);

	Teacher teachers[] =new Teacher[100];
	Teacher t=new Teacher();
	
	
	for(int i=0;i<values.length;i++){
		if(values[i]!=null){
			if(teachers[i]==null){
				teachers[i]=t.formTeacher(values[i]);
			}
		}
	}
	return teachers;		//returns array
	}
	
	
	public void write(Teacher[] teacher){
		
		String data[] =new String[100];
		
		for(int i=0;i<data.length;i++){
			if(teacher[i]!=null){
				data[i]=teacher[i].toStringTeacher();
			}
		}
		
		String fileName="controllers/data/teachers.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data,false);	
	}
}
