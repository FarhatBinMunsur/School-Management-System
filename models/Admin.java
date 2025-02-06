package models;
import java.lang.*;

public class Admin extends User{
	
	private String adminType;
	public Admin(){
		super();
	}
	
	public Admin(String userID,String userName,int age,String email,String phoneNo,int role,String password,String securityAns,String adminType){
		super(userID,role,password,securityAns);
		this.userName=userName;
		this.age=age;
		this.email=email;
		this.phoneNo=phoneNo;
		this.adminType=adminType;
	}
	
	public void setAdminType(String adminType){
		this.adminType=adminType;
	}
	
	public String getAdminType(){
		return this.adminType;
	}
	
	public String toStringAdmin(){
		String str=this.userID+","+this.userName+","+this.age+","+this.email+","+this.phoneNo+","+this.adminType+"\n";
		return str;
	}
	
	public Admin formAdmin(String str){
		
		String data[]=str.split(",");
		
		Admin adm=new Admin();
		
		adm.setUserID(data[0]);
		adm.setUserName(data[1]);
		adm.setAge(Integer.parseInt(data[2]));
		adm.setEmail(data[3]);
		adm.setPhoneNo(data[4]);
		adm.setAdminType(data[5]);
		
		return adm;
		}

}