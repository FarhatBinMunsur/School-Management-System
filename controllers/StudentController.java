package controllers;
import java.lang.*;
import models.*;

public class StudentController{
	public void insertStudent(Student s){
		Student[] students = this.getAllStudent();
		
		for(int i=0;i<students.length;i++){
			if(students[i]==null){
				students[i]=s;
				break;
			}
		}
		this.write(students);
	}
	
	public void deleteStudent(String userID){
		Student[] students=this.getAllStudent();
		for(int i=0;i<students.length;i++){
		if(students[i]!=null){
			if(students[i].getUserID().equals(userID)){
				students[i]=null;
			}
		}
		}
		this.write(students);
	}
	
	public void updateStudent(Student s){
		Student[] students=this.getAllStudent();
		for(int i=0;i<students.length;i++){
			if(students[i]!=null){
				if(students[i].getUserID().equals(s.getUserID())){
					students[i]=s;
				}
			}
		}
		this.write(students);
	}
	public Student searchStudent(String userID){
		
		Student[] students=this.getAllStudent();
		for(int i=0;i<students.length;i++){
		if(students[i]!=null){
			if(students[i].getUserID().equals(userID)){
				return students[i];
			}
		}
		}
		return null;
	}	
	
	public Student[] getAllStudent(){
		String fileName="controllers/data/students.txt";
		FileIO fio=new FileIO();
		
		String data[] =fio.readFile(fileName);
		Student[] students=new Student[100];
		Student s=new Student();
		
		for(int i=0;i<data.length;i++){
			if(data[i]!=null){
				if(students[i]==null){
					students[i]=s.formStudent(data[i]);
				}
			}
		}
		return students;
	}
	
	public void write(Student [] students){
		String data[]=new String[100];
		for(int i=0;i<data.length;i++){
			if(students[i]!=null){
				data[i]=students[i].toStringStudent();
			}
		}
		String fileName="controllers/data/students.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);
	}
}