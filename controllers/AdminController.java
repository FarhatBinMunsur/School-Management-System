package controllers;

import java.lang.*;
import models.*;

public class AdminController {
	public void insertAdmin(Admin a){
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++){
			if(admins[i]==null){
				admins[i]=a;
				break;
			}
		}
		this.write(admins);
	}
	
	public void updateAdmin(Admin a){
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++){
			if(admins[i]!=null){
				if(admins[i].getUserID().equals(a.getUserID())){
					admins[i]=a;
				}
			}
		}
		this.write(admins);
	}
	
	public void deleteAdmin(String userID){
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++){
			if(admins[i]!=null){
				if(admins[i].getUserID().equals(userID)){
					admins[i]=null;
				}
			}
		}
		this.write(admins);
	}
	public Admin searchAdmin(String userID){
		
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++){
			
			if(admins[i]!=null){
				if(admins[i].getUserID().equals(userID)){
					return admins[i];
				}
			}
		}
		return null;
	}
	
	public Admin[] getAllAdmin(){
		String fileName="controllers/data/admins.txt";
		
		FileIO fio=new FileIO();
		
		String data[]=fio.readFile(fileName);
		Admin admins[]=new Admin[100];
		Admin a=new Admin();
		
		for(int i=0;i<data.length;i++){
			if(data[i]!=null){
				if(admins[i]==null){
				admins[i]=a.formAdmin(data[i]);
				}
			}
		}
		return admins;
	}
	
	public void write(Admin[] admins){
		
		String data[] =new String[100];
		
		for(int i=0;i<data.length;i++){
			if(admins[i]!=null){
				data[i]=admins[i].toStringAdmin();
				
			}
			
		}
		
		String fileName="controllers/data/admins.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);

		
	}
}
