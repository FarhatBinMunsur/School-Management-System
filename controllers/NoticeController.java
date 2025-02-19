package controllers;

import java.lang.*;
import models.*;

public class NoticeController{
	

	public Notice[] getAllNotice (){
		FileIO fio=new FileIO();
		String data[]=fio.readFile("controllers/data/notices.txt");
		
		Notice[] notices=new Notice[100];
		Notice n=new Notice();
		
		for(int i=0;i<notices.length;i++){
			if(data[i]!=null && notices[i]==null){
				notices[i]=n.formNotice(data[i]);
			}
		}
		return notices;
	}
	
	public void write(Notice[] notices){
		String data[]=new String [100];
		
		for(int i=0;i<notices.length;i++){
			if(notices[i]!=null){
				data[i]=notices[i].toStringNotice();
			}
		}
		
		FileIO fio=new FileIO();
		fio.writeFile("controllers/data/notices.txt",data,false);
	}
	
	public void insertNotice(Notice n ){
		
		Notice[] notices=this.getAllNotice();
		
		for(int i=0;i<notices.length;i++){
			if(notices[i]==null){
			notices[i]=n;
			break;
		}
		}
		this.write(notices);
	}
	
	
	public void deleteNotice(String noticeID){
		Notice[] notices=this.getAllNotice();
		
		for(int i=0;i<notices.length;i++){
			if(notices[i]!=null && notices[i].getNoticeID().equals(noticeID)){
				notices[i]=null;
				
			}
		}
		this.write(notices);
	}	
	
	public void updateNotice(Notice n){
		Notice[] notices=this.getAllNotice();
		
		for(int i=0;i<notices.length;i++){
			if(notices[i] != null && notices[i].getNoticeID().equals(n.getNoticeID())){
				notices[i]=n;
				
			}
		}
		this.write(notices);
	}
	
	public Notice searchNotice(String noticeID){
		Notice[] notices=this.getAllNotice();
		
		for(int i=0;i<notices.length;i++){
			if(notices[i]!=null && notices[i].getNoticeID().equals(noticeID)){
				return notices[i];
				
			}
		}
		return null;
	}
}