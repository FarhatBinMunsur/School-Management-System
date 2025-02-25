package controllers;
import java.lang.*;
import models.*;

public class SectionController{
	public void insertSection(Section sc){
		Section [] sections=this.getAllSection();
		
		for(int i=0;i<sections.length;i++){
			if(sections[i]==null){
				sections[i]=sc;
				break;
			}
		}
		this.write(sections);
	}
	
	public Section[] getAllSection(){
		
		String fileName="controllers/data/sections.txt";
		FileIO fio= new FileIO();
		String data[]=fio.readFile(fileName);
		
		if (data == null || data.length == 0) {
			return new Section[0]; // Return an empty array instead of null
		}
	
		Section[] sections = new Section[data.length]; // Create array with exact size
	
		for(int i=0;i<data.length;i++){

			if(data[i]!=null ){
				if(sections[i]==null){
				Section sc= new Section();
				sections[i]=sc.formSection(data[i]);
				}
			}
		}
		return sections;
		
	}
	
	public void write(Section[] sections){
		
		String data[] =new String[100];
		
		for(int i=0;i<data.length;i++){
			if(sections[i]!=null){
				data[i]=sections[i].toStringSection();
			}
			
		}
		String fileName="controllers/data/sections.txt";
		FileIO fio =new FileIO();
		fio.writeFile(fileName,data,false);
	}
	
	public void deleteSection(String sectionId){
		
		Section sections[]=this.getAllSection();
		for(int i=0;i<sections.length;i++){
			if(sections[i]!=null){
				if(sections[i].getSectionID().equals(sectionId)){
					sections[i]=null;
				}
			}
		}
		this.write(sections);
	}
	
	public Section searchSection(String sectionId){
		
		Section sections[]=this.getAllSection();
		for(int i=0;i<sections.length;i++){
			if(sections[i]!=null){
				if(sections[i].getSectionID().equals(sectionId)){
					return sections[i];
				}
			}
		}
		return null;
	}
	
	public void updateSection(Section s){
		
		Section[] sections=this.getAllSection();
		for(int i=0;i<sections.length;i++){
			if(sections[i]!=null){
				if(sections[i].getSectionID().equals(s.getSectionID())){
					sections[i]=s;
				}
			}
		}
		this.write(sections);
	}
}