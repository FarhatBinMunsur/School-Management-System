package controllers;

import java.lang.*;
import models.*;

public class SubjectController{
	
	public Subject[] getAllSubject(){
		
		String fileName="controllers/data/subjects.txt";
		FileIO fio=new FileIO();
		
		String[] values = fio.readFile(fileName);
		Subject [] subjects = new Subject[100]; 
		
		Subject s=new Subject();
		for(int i=0;i<values.length;i++){
			if(values[i]!=null){
				if(subjects[i]==null){
					subjects[i]=s.formSubject(values[i]);
				}
			}
		}
		return subjects;
		
		
	}
	
	public void  write(Subject[] subjects){
		String[] values =new String[100];
		
		for(int i=0;i<subjects.length;i++){
			if(subjects[i]!=null){
			if(values[i]==null){
				values[i]=subjects[i].toString();
			}
			}
		}
		String fileName="controllers/data/subjects.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,values);
	}
	
	public void insertSubject(Subject s){
		Subject[] subjects =this.getAllSubject();
		
		for(int i=0;i<subjects.length;i++){
			if(subjects[i]==null){
				subjects[i]=s;
				break;
			}
		}
		this.write(subjects);
	}
	
	public void updateSubject(Subject s){
		Subject[] subjects=this.getAllSubject();
		
		for(int i=0;i<subjects.length;i++){
			if(subjects[i]!=null){
				if(subjects[i].getSubjectID().equals(s.getSubjectID())){
					subjects[i]=s;
				}
			}
		}
		this.write(subjects);
	}
	public void deleteSubject(String subjectID){
		Subject[] subjects=this.getAllSubject();
		
		for(int i=0;i<subjects.length;i++){
			if(subjects[i]!=null){
				if(subjects[i].getSubjectID().equals(subjectID)){
					subjects[i]=null;
				}
			}
		}
		this.write(subjects);
	}
	
	public Subject searchSubject(String subjectID){
		Subject[] subjects=this.getAllSubject();
		
		for(int i=0;i<subjects.length;i++){
			if(subjects[i]!=null){
				if(subjects[i].getSubjectID().equals(subjectID)){
					return subjects[i];
				}
			}
		}
		return null;
	} 
}