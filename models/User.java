package models;
import java.lang.*;

public class User{
	
	protected String userID;
	protected String userName;
	protected int age;
	protected String email;
	protected String phoneNo;
	protected int role;
	protected String password;
	protected String securityAns; //favourite game?
	
	public User(){}
	
	public User(String userID,int role,String password,String securityAns){
		this.userID=userID;
		this.role=role;
		this.password=password;
		this.securityAns=securityAns;
	}
	
	public void setUserID(String userID){
		this.userID=userID;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public void setPhoneNo(String phoneNo){
		this.phoneNo=phoneNo;
	}

	public void setRole(int role){
		this.role=role;
	}

	public void setPassword(String password){
		this.password=password;
	}
	
	public void setSecurityAns(String securityAns){
		this.securityAns=securityAns;
	}
	
	public String getUserID()
	{
		return this.userID;
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPhoneNo()
	{
		return this.phoneNo;
	}
	
	public int getRole()
	{
		return this.role;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getSecurityAns(){
		return this.securityAns;
	}
	
	public String toStringUser(){
		
		String str = this.userID+","+this.role+","+this.password+","+this.securityAns+"\n";
		return str;
	}
	
	public User formUser(String str){
		
		String data[]=str.split(",");
		
		User u=new User();
		
		u.setUserID(data[0]);
		u.setRole(Integer.parseInt(data[1]));
		u.setPassword(data[2]);
		u.setSecurityAns(data[3]);
		
		return u;
	}
}