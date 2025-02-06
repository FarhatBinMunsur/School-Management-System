package models;

import java.lang.*;

public class Notice{
	private String noticeID;
	private String notice;
	
	public Notice(){}
	
	public Notice(String noticeID,String notice){
		this.noticeID=noticeID;
		this.notice=notice;
		
	}
	
	public void setNoticeID(String noticeID){
		this.noticeID=noticeID;
	}
	
	public void setNotice(String notice){
		this.notice=notice;
		
	}
	
	public String getNoticeID(){
		return this.noticeID;
	}
	
	public String getNotice(){
		return this.notice;
	}
	
	public String toStringNotice(){
		String notice=this.noticeID+","+this.notice+"\n";
		return notice;
	}
	
	public Notice formNotice(String notice){
		String data[]=notice.split(",");
		
		Notice n=new Notice();
		
		n.setNoticeID(data[0]);
		n.setNotice(data[1]);
		
		return n;
		
	}
}